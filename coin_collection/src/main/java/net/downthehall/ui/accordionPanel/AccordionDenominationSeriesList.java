package net.downthehall.ui.accordionPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.DenominationSeries;
import net.downthehall.business.model.vo.ShowDenominationSeries;
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
public class AccordionDenominationSeriesList extends ViewComponent
{
    @Inject
    @ListSelectProperties(sizeFull = true, nullSelectionAllowed = false, immediate = true)
    protected ListSelect listSelect;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;
    private String denominationSeries;
    private int denominationSeriesId;

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
        listSelect.setContainerDataSource(new BeanItemContainer<>(ShowDenominationSeries.class));

        listSelect.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                try
                {
                    int denominationSeries_Id =
                            (int) getSelectedItem().getItemProperty("denomination_Series_Id").getValue();
                    String denomination_Series =
                            (String) getSelectedItem().getItemProperty("denomination_Series").getValue();

                    listSelect.markAsDirty();
                    listSelect.commit();

                    fireViewEvent(RightPresenter.SHOW_COINS_LIST_VIEW, denominationSeries_Id);
                    fireViewEvent(EditPanelPresenter.SET_DENOMINATION_SERIES_NAME, denomination_Series);
                } catch (NullPointerException e)
                {
                }
            }
        });

        return listSelect;
    }

    // ******************************************************************************************
    public void setDenominationSeriesList(Collection<ShowDenominationSeries> showDenominationSeries)
    {
        // Set the caption mode to read the caption directly
        // from the 'denominationSeries' property of the item
        listSelect.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        listSelect.setItemCaptionPropertyId("denomination_Series");

        // Add all denominationSeries to the list
        for (ShowDenominationSeries names : showDenominationSeries)
        {
            listSelect.addItem(names);

            denominationSeries = names.getDenomination_Series();
            denominationSeriesId = names.getDenomination_Series_Id();
        }
    }

    public void setValue(DenominationSeries denominationSeries)
    {
        listSelect.setValue(denominationSeries);
    }

    public Item getSelectedItem()
    {
        return listSelect.getItem(listSelect.getValue());
    }

    public void addCollectionNameToList(DenominationSeries denominationSeries)
    {
        listSelect.addItem(denominationSeries);
    }

    public void refreshDenominationSeriesList()
    {
        listSelect.setContainerDataSource(new BeanItemContainer<>(ShowDenominationSeries.class));
    }
}
