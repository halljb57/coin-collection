package net.downthehall.ui.collectionName;

import net.downthehall.business.service.CollectionNamesService;
import net.downthehall.business.service.LoadShowCoinAttributes;
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
@AbstractMVPPresenter.ViewInterface(CollectionNameView.class)
public class CollectionNamePresenter extends AbstractMVPPresenter<CollectionNameView>
{
    public static final String COLLECTION_NAME_SELECTED = "collectionNamePresenter_collection_name_selected";
    public static final String CANCEL_EDIT = "collectionNamePresenter_cancel_edit";
    public static final String REFRESH_COLLECTION_LIST_VIEW = "collectionNamePresenter_refresh_collection_list_view";
    public static final String LOAD_SHOW_COIN_ATTRIBUTES = "collectionNamePresenter_load_showCoinAttributes";

    // **********************************************************************************
    @Inject
    private CollectionNamesService service;
    @Inject
    private LoadShowCoinAttributes loadShowCoinAttributes;

    // ********************************************************************************************
    /*
     * This method observes events with a ParameterDTO as the parameter type and
     * COIN_ATTRIBUTE_SELECTED as the @CDIEvent value LoadShowCoinAttributes
     */
    protected void coinAttributeSelected(
            @Observes @CDIEvent(COLLECTION_NAME_SELECTED) final ParameterDTO parameters)
    {
        view.showCollectionNameDetails();
    }

    /* This is also set in the LeftPresenter to load the list component */
    protected void collectionListView(
            @Observes @CDIEvent(LeftPresenter.COLLECTION_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setCollectionNameList(service.findAll());
    }

    protected void cancel(
            @Observes @CDIEvent(CANCEL_EDIT) final ParameterDTO parameters)
    {
        view.cancelEditing();
    }

    protected void refreshCollectionListView(
            @Observes @CDIEvent(REFRESH_COLLECTION_LIST_VIEW) final ParameterDTO parameters)
    {
        view.refreshCollectionListView(null);
    }

    // ********************************************************************************************
    protected void loadShowCoinAttributes(
            @Observes @CDIEvent(LOAD_SHOW_COIN_ATTRIBUTES) final ParameterDTO parameters)
    {
        loadShowCoinAttributes.setCollectionId(Integer.parseInt(parameters.getPrimaryParameter().toString()));
        loadShowCoinAttributes.deleteByCollection_Id();
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
