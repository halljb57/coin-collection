package net.downthehall.ui.countryName;

import net.downthehall.business.service.CountryNamesService;
import net.downthehall.ui.splitPanels.horizontalLeft.LeftPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created by joseph on 8/9/2014.
 */
@SuppressWarnings("serial")
@AbstractMVPPresenter.ViewInterface(CountryNameView.class)
public class CountryNamePresenter extends AbstractMVPPresenter<CountryNameView>
{
    @Inject
    private CountryNamesService service;

    // **********************************************************************************
    /* This is also set in the LeftPresenter to load the list component */
    protected void countryListView(
            @Observes @CDIEvent(LeftPresenter.COUNTRY_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setCountryList(service.findAll());
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {
        System.out.println("From CountryNamePresenter");
//        Notification.show("From CountryNamePresenter");
    }
}
