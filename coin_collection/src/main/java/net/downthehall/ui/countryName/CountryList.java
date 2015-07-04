package net.downthehall.ui.countryName;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CountryNames;
import net.downthehall.ui.Buttonbar;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ListSelectProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;
import testClasses.DatePopupExample;
import testClasses.DatePopupInputPromptExample;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/4/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class CountryList extends ViewComponent
{
    @Inject
    private Instance<Buttonbar> buttonbars;
    @Inject
    @ListSelectProperties(sizeFull = true, nullSelectionAllowed = false, immediate = true)
    private ListSelect listSelect;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout verticalLayout;
    @Inject
    private Instance<DatePopupInputPromptExample> datePopupInputPromptExamples;
    @Inject
    private Instance<DatePopupExample> datePopupExamples;

    private String countryName;
    private int countryId;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        buildVerticalLayout();
    }

    // Initialize BuildVerticalLayout
    private VerticalLayout buildVerticalLayout()
    {
        setCompositionRoot(verticalLayout);
        listSelect = buildListSelect();

//        verticalLayout.addComponent(datePopupInputPromptExamples.get());
//        verticalLayout.addComponent(datePopupExamples.get());
        verticalLayout.addComponent(listSelect);
        verticalLayout.addComponent(buttonbars.get());

        return verticalLayout;
    }

    // Initialize ListSelect Component
    private ListSelect buildListSelect()
    {
        listSelect.setContainerDataSource(new BeanItemContainer<CountryNames>(CountryNames.class));

        listSelect.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                String coinAttributes = String.valueOf(event.getProperty().getValue());
                Notification
                        .show("From CountryList Item Selected ", coinAttributes, Notification.Type.TRAY_NOTIFICATION);

                System.out.println("From CountryList Item Selected getValue() " + coinAttributes);
//                fireViewEvent(RightPresenter.SHOW_COIN_ATTRIBUTES_LIST_VIEW, null);
//                fireViewEvent(RightPresenter.CREATE_TAB_PANEL, null);
            }
        });

        return listSelect;
    }

    // **********************************************************************************
    public void setCountryList(Collection<CountryNames> countryNames)
    {
        // Set the caption mode to read the caption directly
        // from the 'country' property of the item
        listSelect.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        listSelect.setItemCaptionPropertyId("country");

        // Add all countryNames country to the drop-down
        for (CountryNames names : countryNames)
        {
            countryName = names.getCountry();
            countryId = names.getCountry_Id();

            listSelect.addItem(names);
        }
    }

    public void setValue(CountryNames countryNames)
    {
        listSelect.setValue(countryNames);
    }

    public Item getSelectedItem()
    {
        return listSelect.getItem(listSelect.getValue());
    }

    public void addCountryToList(CountryNames countryNames)
    {
        listSelect.addItem(countryNames);
    }
}
