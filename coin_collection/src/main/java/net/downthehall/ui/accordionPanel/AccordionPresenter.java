package net.downthehall.ui.accordionPanel;

import com.vaadin.ui.Notification;
import net.downthehall.business.service.*;
import net.downthehall.ui.splitPanels.horizontalLeft.LeftPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditTabPanel;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/26/2014.
 * List presenter is the presenter for AccordionView. EJBs and other resources should
 * mainly be accessed in the presenter and results are pushed to the view
 * implementation through it's API.
 */
@SuppressWarnings("serial")
@ViewInterface(AccordionView.class)
public class AccordionPresenter extends AbstractMVPPresenter<AccordionView>
{
    public static final String LOAD_SHOW_DENOMINATION = "Load Show Denomination";
    public static final String LOAD_SHOW_DENOMINATION_SERIES = "Load Show Denomination Series";
    public static final String REFRESH_DENOMINATION_LIST = "Refresh Denomination List";
    public static final String REFRESH_DENOMINATION_SERIES_LIST = "Refresh Denomination Series List";
    public static final String REFRESH_COLLECTION_LIST = "Refresh Collection List";
    public static final String SET_COLLECTION_TAB = "Set Collection Tab";
    public static final String SET_DENOMINATION_TAB = "Set Denomination Tab";
    public static final String SET_DENOMINATION_SERIES_TAB = "Set Denomination Series Tab";
    public static final String DISABLE_DENOMINATION_SERIES_LIST = "Disable Denomination Series List";

    // ********************************************************************************** Injected Classes
    @Inject
    private Instance<AccordionCollectionList> accordionCollectionLists;
    @Inject
    private Instance<AccordionPanelView> accordionPanelViews;
    @Inject
    private Instance<AccordionDenominationSeriesList> accordionDenominationSeriesLists;
    @Inject
    private Instance<EditTabPanel> editTabPanels;
    // ********************************************************************************** Injected Services
    @Inject
    private ShowDenominationsSeriesService showDenominationsSeriesService;
    @Inject
    private LoadShowDenominations loadShowDenominations;
    @Inject
    private LoadShowDenominationSeries loadShowDenominationSeries;
    @Inject
    private CollectionNamesService service;
    @Inject
    private ShowDenominationsService showDenominationsService;
    @Inject
    private LoadShowServices loadShowServices;
    @Inject
    private ShowCoinsService showCoinsService;

    // ********************************************************************************** Set Data To Views
    protected void loadShowDenominationSeries(
            @Observes @CDIEvent(LOAD_SHOW_DENOMINATION_SERIES) final ParameterDTO parameters)
    {
        int id = (int) parameters.getPrimaryParameter();
        loadShowServices.setId(id); // Your item ID
        loadShowServices.setColumnId("denominations_Id"); // Column ID Name
        loadShowServices.setMainTableName("denomination_series"); // Main Table Name
        loadShowServices.setShowTableName("show_denomination_series"); // Show Table Name
        loadShowServices.deleteTable_Id();

        view.setDenominationSeriesList(showDenominationsSeriesService.findAll());
    }

    protected void loadShowDenomination(
            @Observes @CDIEvent(LOAD_SHOW_DENOMINATION) final ParameterDTO parameters)
    {
        int id = (int) parameters.getPrimaryParameter();
        loadShowServices.setId(id); // Your item ID
        loadShowServices.setColumnId("country_id"); // Column ID Name
        loadShowServices.setMainTableName("denominations"); // Main Table Name
        loadShowServices.setShowTableName("show_denominations"); // Show Table Name
        loadShowServices.deleteTable_Id();

        if (showDenominationsService.findAll().size() <= 0)
        {
            Notification.show("From AccordionPresenter Count = " + showDenominationsService.findAll().size(),
                              Notification.Type.WARNING_MESSAGE);
        }
        else
        {
            accordionCollectionLists.get().gotData();
            view.setDenominationsList(showDenominationsService.findAll());
        }
    }

    /* This is also set in the LeftPresenter to load the list component */
    protected void collectionListView(
            @Observes @CDIEvent(LeftPresenter.COLLECTION_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setCollectionNameList(service.findAll());
    }

    /* This is also set in the LeftPresenter to load the list component */
    protected void accordionListView(
            @Observes @CDIEvent(LeftPresenter.ACCORDION_LIST_VIEW) final ParameterDTO parameters)
    {
//        view.setVerticalTopView(AccordionView.class);
    }

    // ********************************************************************************** Refresh List
    protected void refreshDenominationList(
            @Observes @CDIEvent(REFRESH_DENOMINATION_LIST) final ParameterDTO parameters)
    {
        view.refreshDenominationsList(null);
    }

    protected void refreshDenominationSeriesList(
            @Observes @CDIEvent(REFRESH_DENOMINATION_SERIES_LIST) final ParameterDTO parameters)
    {
        view.refreshDenominationSeriesList(null);
    }

    protected void refreshCollectionList(
            @Observes @CDIEvent(REFRESH_COLLECTION_LIST) final ParameterDTO parameters)
    {
        view.refreshCollectionList(null);
    }

    // ********************************************************************************** Set Visible Tab
    protected void setCollectionTab(
            @Observes @CDIEvent(SET_COLLECTION_TAB) final ParameterDTO parameters)
    {
        view.setCollectionTab();
    }

    protected void setDenominationTab(
            @Observes @CDIEvent(SET_DENOMINATION_TAB) final ParameterDTO parameters)
    {
        view.setDenominationTab();
    }

    protected void setDenominationSeriesTab(
            @Observes @CDIEvent(SET_DENOMINATION_SERIES_TAB) final ParameterDTO parameters)
    {
        view.setDenominationSeriesTab();
    }

    protected void disableDenominationSeriesList(
            @Observes @CDIEvent(DISABLE_DENOMINATION_SERIES_LIST) final ParameterDTO parameters)
    {
        accordionDenominationSeriesLists.get().listSelect.setEnabled(false);
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {
        // NOP
    }
}
