package net.downthehall.ui.coins.showCoinsView;

import net.downthehall.business.service.LoadShowServices;
import net.downthehall.business.service.ShowCoinsService;
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
@ViewInterface(ShowCoinsListView.class)
public class ShowCoinsPresenter extends AbstractMVPPresenter<ShowCoinsListView>
{
    public static final String SHOW_COINS_SELECTED = "showCoinsPresenter_showSelectedCoinDetails";

    // ********************************************************************************************
    @Inject
    private ShowCoinsService showCoinsService;
    @Inject
    private LoadShowServices loadShowServices;

    // ********************************************************************************************
    /*
     * This method observes events with a ParameterDTO as the parameter type and
     * COIN_ATTRIBUTE_SELECTED as the @CDIEvent value
     */
    protected void showSelectedCoinDetails(
            @Observes @CDIEvent(SHOW_COINS_SELECTED) final ParameterDTO parameters)
    {
        view.showSelectedCoinDetails();
    }

    /* This is also set in the RightPresenter to load the table component */
    protected void coinsListView(
            @Observes @CDIEvent(RightPresenter.SHOW_COINS_LIST_VIEW) final ParameterDTO parameters)
    {
        int id = (int) parameters.getPrimaryParameter();
        loadShowServices.setId(id); // Your item ID
        loadShowServices.setColumnId("Denomination_Series_Id"); // Column ID Name
        loadShowServices.setMainTableName("coins"); // Main Table Name
        loadShowServices.setShowTableName("show_coins"); // Show Table Name
        loadShowServices.deleteTable_Id();

        view.setCoinsList(showCoinsService.findAll());
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
