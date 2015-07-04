package net.downthehall.ui.splitPanels.horizontalRight;

import net.downthehall.ui.coinattributes.coinAttributesView.CoinAttributesListView;
import net.downthehall.ui.coinattributes.showCoinAttributesView.ShowCoinAttributesListView;
import net.downthehall.ui.coins.coinsView.CoinsListView;
import net.downthehall.ui.coins.showCoinsView.ShowCoinsListView;
import net.downthehall.ui.tabbedPanel.createPanel.CreatePanelView;
import net.downthehall.ui.tabbedPanel.detailPanel.DetailPanelView;
import net.downthehall.ui.tabbedPanel.editPanel.*;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/26/2014.
 * List presenter is the presenter for TopLeftView. EJBs and other resources should
 * mainly be accessed in the presenter and results are pushed to the view
 * implementation through it's API.
 */
@SuppressWarnings("serial")
@ViewInterface(RightView.class)
public class RightPresenter extends AbstractMVPPresenter<RightView>
{
    public static final String COINS_LIST_VIEW = "rightPresenter_coinsListView";
    public static final String SHOW_COINS_LIST_VIEW = "rightPresenter_showCoinsListView";
    public static final String COIN_ATTRIBUTES_LIST_VIEW = "rightPresenter_coinAttributesListView";
    public static final String SHOW_COIN_ATTRIBUTES_LIST_VIEW = "rightPresenter_showCoinAttributesListView";
    public static final String CREATE_TAB_PANEL = "rightPresenter_createTabPanel";
    public static final String SHOW_EDIT_TAB_PANEL = "rightPresenter_showEditTabPanel";
    public static final String DETAIL_TAB_PANEL = "rightPresenter_detailTabPanel";

    // ******************************************************************************************
    @Inject
    private Instance<EditTabPanel> editTabPanels;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForms;

    // ********************************************************************************** Top View
    /* This is also set in the CoinAttributesPresenter to load the data for the component */
    protected void coinAttributesListView(
            @Observes @CDIEvent(COIN_ATTRIBUTES_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalTopView(CoinAttributesListView.class);
    }

    /* This is also set in the ShowCoinAttributesPresenter to load the data for the component */
    protected void showCoinAttributesListView(
            @Observes @CDIEvent(SHOW_COIN_ATTRIBUTES_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalTopView(ShowCoinAttributesListView.class);
    }

    /* This is also set in the CoinsPresenter to load the data for the component */
    protected void coinsListView(
            @Observes @CDIEvent(COINS_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalTopView(CoinsListView.class);
    }

    /* This is also set in the ShowCoinsPresenter to load the data for the component */
    protected void showCoinsListView(
            @Observes @CDIEvent(SHOW_COINS_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalTopView(ShowCoinsListView.class);
    }

    // ********************************************************************************** Bottom View
    protected void detailTabPanel(
            @Observes @CDIEvent(DETAIL_TAB_PANEL) final ParameterDTO parameters)
    {
        view.setVerticalBottomView(DetailPanelView.class);
    }

    protected void creatTabPanel(
            @Observes @CDIEvent(CREATE_TAB_PANEL) final ParameterDTO parameters)
    {
        view.setVerticalBottomView(CreatePanelView.class);
    }

    protected void showEditTabPanel(
            @Observes @CDIEvent(SHOW_EDIT_TAB_PANEL) final ParameterDTO parameters)
    {
        view.setVerticalBottomView(EditPanelView.class);
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {
        // NOP
    }
}
