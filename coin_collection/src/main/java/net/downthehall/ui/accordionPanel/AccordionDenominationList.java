package net.downthehall.ui.accordionPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.Denominations;
import net.downthehall.business.model.vo.ShowDenominations;
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
public class AccordionDenominationList extends ViewComponent
{
    @Inject
    private Instance<AccordionPanelView> accordionPanelViews;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;
    @Inject
    @ListSelectProperties(sizeFull = true, nullSelectionAllowed = false, immediate = true)
    private ListSelect listSelect;

    private String denominations;
    private int denominationsId;

    // ******************************************************************************************
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
        listSelect.setContainerDataSource(new BeanItemContainer<>(ShowDenominations.class));

        listSelect.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                try
                {
                    int denominations_Id = (int) getSelectedItem().getItemProperty("denominations_Id").getValue();
                    String denomination = (String) getSelectedItem().getItemProperty("denomination").getValue();

                    listSelect.markAsDirty();
                    listSelect.commit();
                    fireViewEvent(AccordionPresenter.REFRESH_DENOMINATION_LIST, null);
                    fireViewEvent(AccordionPresenter.SET_DENOMINATION_SERIES_TAB, null);
                    fireViewEvent(AccordionPresenter.LOAD_SHOW_DENOMINATION_SERIES, denominations_Id);
                    fireViewEvent(EditPanelPresenter.SET_DENOMINATION_NAME, denomination);
                } catch (NullPointerException e)
                {
                }
            }
        });

        return listSelect;
    }

    // ******************************************************************************************
    public void setDenominationsList(Collection<ShowDenominations> showDenomination)
    {
        // Set the caption mode to read the caption directly
        // from the 'denominations' property of the item
        listSelect.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        listSelect.setItemCaptionPropertyId("denomination");

        // Add all denominations to the list
        for (ShowDenominations names : showDenomination)
        {
            denominations = names.getDenomination();
            denominationsId = names.getDenominations_Id();

            listSelect.addItem(names);
        }
    }

    public void setValue(Denominations denominations)
    {
        listSelect.setValue(denominations);
    }

    public Item getSelectedItem()
    {
        return listSelect.getItem(listSelect.getValue());
    }

    public void addCollectionNameToList(Denominations denominations)
    {
        listSelect.addItem(denominations);
    }

    public void refreshDenominationsList()
    {
        listSelect.setContainerDataSource(new BeanItemContainer<>(ShowDenominations.class));
    }
}
