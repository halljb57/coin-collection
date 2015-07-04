package net.downthehall.ui.accordionPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CollectionNames;
import net.downthehall.ui.tabbedPanel.editPanel.EditPanelPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ListSelectProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/9/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class AccordionCollectionList extends ViewComponent
{
    @Inject
    private Instance<AccordionPanelView> accordionPanelViews;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;
    @Inject
    @ListSelectProperties(sizeFull = true, nullSelectionAllowed = false, immediate = true)
    private ListSelect listSelect;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
//        newTread();
        setCompositionRoot(layout);
        layout.addComponent(listSelect);
        layout.setExpandRatio(listSelect, 1);

        buildCollectionNameList();
    }

    private void newTread()
    {
        new Thread()
        {
            public void run()
            {
                setCompositionRoot(layout);
                layout.addComponent(listSelect);
                layout.setExpandRatio(listSelect, 1);

                buildCollectionNameList();
            }
        }.start();
    }

    // Initialize ListSelect Component
    private ListSelect buildCollectionNameList()
    {
        listSelect.setContainerDataSource(new BeanItemContainer<>(CollectionNames.class));

        listSelect.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                try
                {
                    int countryId = (int) getSelectedItem().getItemProperty("country_Id").getValue();
                    String collectionName = (String) getSelectedItem().getItemProperty("collection_Name").getValue();

                    if (countryId <= 0)
                    {
                        System.out.println("From AccordionCollectionList Country ID = " + countryId);
                        Notification.show("From AccordionCollectionList No Country Associated",
                                          Notification.Type.ERROR_MESSAGE);
                    }
                    else
                    {
                        listSelect.markAsDirty();
                        listSelect.commit();
//                    fireViewEvent(AccordionPresenter.REFRESH_COLLECTION_LIST, null);
//                    fireViewEvent(AccordionPresenter.REFRESH_DENOMINATION_LIST, null);
                        fireViewEvent(AccordionPresenter.LOAD_SHOW_DENOMINATION, countryId);
                        fireViewEvent(EditPanelPresenter.SET_COLLECTION_NAME, collectionName);
                        fireViewEvent(EditPanelPresenter.SET_COUNTRY_NAME, countryId);
                    }
                } catch (NullPointerException e)
                {
                }

            }
        });

        return listSelect;
    }

    // **********************************************************************************
    public void gotData()
    {
        fireViewEvent(AccordionPresenter.REFRESH_COLLECTION_LIST, null);
        fireViewEvent(AccordionPresenter.REFRESH_DENOMINATION_LIST, null);
        fireViewEvent(AccordionPresenter.SET_DENOMINATION_TAB, null);
    }

    // **********************************************************************************
    public void setCollectionNameList(Collection<CollectionNames> collectionName)
    {
        // Set the caption mode to read the caption directly
        // from the 'collectionNames' property of the item
        listSelect.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        listSelect.setItemCaptionPropertyId("collection_Name");

        // Add all collectionNames to the list
        for (CollectionNames names : collectionName)
        {
//            String collectionNames = names.getCollection_Name();
//            int collectionId = names.getCollection_Id();

            listSelect.addItem(names);
        }
    }

    public void setValue(CollectionNames collectionNames)
    {
        listSelect.setValue(collectionNames);
    }

    public Item getSelectedItem()
    {
        return listSelect.getItem(listSelect.getValue());
    }

    public void addCollectionNameToList(CollectionNames collectionNames)
    {
        listSelect.addItem(collectionNames);
    }

    public void refreshCollectionList()
    {
        listSelect.setContainerDataSource(new BeanItemContainer<>(CollectionNames.class));
    }
}
