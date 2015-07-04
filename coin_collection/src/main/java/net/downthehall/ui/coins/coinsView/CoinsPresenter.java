package net.downthehall.ui.coins.coinsView;

import net.downthehall.business.service.CoinsService;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created by joseph on 9/19/2014.
 */
@SuppressWarnings("serial")
@ViewInterface(CoinsListView.class)
public class CoinsPresenter extends AbstractMVPPresenter<CoinsListView>
{
    @Inject
    private CoinsService service;

    // ********************************************************************************************
    /* This is also set in the RightPresenter to load the table component */
    protected void coinsListView(
            @Observes @CDIEvent(RightPresenter.COINS_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setCoinsList(service.findAll());
        System.out.println("Number of coinsService records: " + service.findAll().size());
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
