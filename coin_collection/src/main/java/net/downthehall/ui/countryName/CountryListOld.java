package net.downthehall.ui.countryName;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Property;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.service.CountryNamesService;
import net.downthehall.ui.Buttonbar;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ListSelectProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 8/4/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class CountryListOld extends ViewComponent
{
    @Inject
    private Instance<Buttonbar> buttonbars;
    @Inject
    @ListSelectProperties(sizeFull = true, nullSelectionAllowed = false, immediate = true)
    private ListSelect listSelect;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout verticalLayout;
    private CountryNamesService service = new CountryNamesService();

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

        verticalLayout.addComponent(listSelect);
        verticalLayout.addComponent(buttonbars.get());

        return verticalLayout;
    }

    // Initialize ListSelect Component
    private ListSelect buildListSelect()
    {
        listSelect.addItems(service.findCountry());

        listSelect.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                final String coinAttributes = String.valueOf(event.getProperty().getValue());
                Notification.show("Item Selected ", coinAttributes, Notification.Type.TRAY_NOTIFICATION);

                fireViewEvent(RightPresenter.SHOW_COIN_ATTRIBUTES_LIST_VIEW, null);
                fireViewEvent(RightPresenter.CREATE_TAB_PANEL, null);
            }
        });

        return listSelect;
    }
}
