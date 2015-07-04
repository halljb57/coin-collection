package net.downthehall.ui.splitPanels.horizontalLeft;

import net.downthehall.ui.accordionPanel.AccordionView;
import net.downthehall.ui.collectionName.CollectionNameView;
import net.downthehall.ui.countryName.CountryNameView;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;

/**
 * Created by joseph on 7/26/2014.
 * List presenter is the presenter for TopLeftView. EJBs and other resources should
 * mainly be accessed in the presenter and results are pushed to the view
 * implementation through it's API.
 */
@SuppressWarnings("serial")
@ViewInterface(LeftView.class)
public class LeftPresenter extends AbstractMVPPresenter<LeftView>
{
    public static final String COLLECTION_LIST_VIEW = "left_presenter_collection_list_view";
    public static final String COUNTRY_LIST_VIEW = "left_presenter_country_list_view";
    public static final String ACCORDION_LIST_VIEW = "left_presenter_accordion_list_view";
    public static final String SHOW_COIN_ATTRIBUTES_LIST_VIEW = "left_presenter_show_coin_attributes_list_view";

    // ********************************************************************************** Top View
    /* This is also set in the CollectionNamePresenter to load the data in the list */
    protected void collectionListView(
            @Observes @CDIEvent(COLLECTION_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalTopView(CollectionNameView.class);
    }

    /* This is also set in the AccordionPresenter to load the list data */
    protected void accordionListView(
            @Observes @CDIEvent(ACCORDION_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalTopView(AccordionView.class);
    }

    // ********************************************************************************** Bottom View
    /* This is also set in the CountryNamePresenter to load the list data */
    protected void countryListView(
            @Observes @CDIEvent(COUNTRY_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setVerticalBottomView(CountryNameView.class);
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {
        // NOP
    }
}
