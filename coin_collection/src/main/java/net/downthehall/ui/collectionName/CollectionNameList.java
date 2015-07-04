package net.downthehall.ui.collectionName;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CollectionNames;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditPanelPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ListSelectProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/9/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class CollectionNameList extends ViewComponent
{
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;
    @Inject
    @ListSelectProperties(sizeFull = true, nullSelectionAllowed = false, immediate = true)
    private ListSelect listSelect;

    private String collectionNames;
    private int collectionId;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        setCompositionRoot(layout);
        layout.addComponent(listSelect);
        layout.setExpandRatio(listSelect, 1);

        buildCollectionNameList();
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
                int collectionId = (int) getSelectedItem().getItemProperty("collection_Id").getValue();

                listSelect.markAsDirty();
                listSelect.commit();
                fireViewEvent(EditPanelPresenter.SET_READ_ONLY_FALSE, null);
                fireViewEvent(EditPanelPresenter.CANCEL_EDITING, null);
                fireViewEvent(CollectionNamePresenter.LOAD_SHOW_COIN_ATTRIBUTES, collectionId);
                fireViewEvent(RightPresenter.SHOW_COIN_ATTRIBUTES_LIST_VIEW, null);
                fireViewEvent(RightPresenter.DETAIL_TAB_PANEL, null);
                }
                catch (NullPointerException e)
                {
                }
            }
        });

        return listSelect;
    }

    // **********************************************************************************
    public void setCollectionNameList(Collection<CollectionNames> collectionName)
    {
        // Set the caption mode to read the caption directly
        // from the 'collectionNames' property of the item
        listSelect.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        listSelect.setItemCaptionPropertyId("collection_Name");
        if (collectionName != null)
        {
            // Add all collectionNames to the list
            for (CollectionNames names : collectionName)
            {
                collectionNames = names.getCollection_Name();
                collectionId = names.getCollection_Id();

                listSelect.addItem(names);
            }
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

    public void refreshList()
    {
        listSelect.setContainerDataSource(new BeanItemContainer<>(CollectionNames.class));
    }
}
