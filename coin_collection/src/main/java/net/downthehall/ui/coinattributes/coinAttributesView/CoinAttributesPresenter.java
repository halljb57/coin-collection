package net.downthehall.ui.coinattributes.coinAttributesView;

import com.vaadin.ui.Notification;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.CoinAttributesService;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created by joseph on 7/30/2014.
 */
@SuppressWarnings("serial")
@ViewInterface(CoinAttributesListView.class)
public class CoinAttributesPresenter extends AbstractMVPPresenter<CoinAttributesListView>
{
    // CDI MVP includes a built-in CDI event qualifier @CDIEvent which
    // uses a String (method identifier) as it's member
    public static final String COIN_ATTRIBUTE_SELECTED = "list_presenter_coin_attribute_selected";
    public static final String EDIT_COIN_ATTRIBUTE = "list_presenter_edit_coin_attribute";
    public static final String SAVE_COIN_ATTRIBUTE = "list_presenter_save_coin_attribute";
    public static final String CANCEL_EDIT = "list_presenter_cancel_edit";

    // ********************************************************************************************
    @Inject
    private CoinAttributesService service;

    // ********************************************************************************************
    /*
     * This method observes events with a ParameterDTO as the parameter type and
     * COIN_ATTRIBUTE_SELECTED as the @CDIEvent value
     */
    protected void coinAttributeSelected(
            @Observes @CDIEvent(COIN_ATTRIBUTE_SELECTED) final ParameterDTO parameters)
    {
        view.showSelectedCoinAttributeDetails();
    }

    protected void editCoinAttribute(
            @Observes @CDIEvent(EDIT_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        view.editSelectedCoinAttribute();
    }

    /*
     * This method nicely demonstrates how the control logic over views can be
     * handled in presenters: If the person isn't persistent yet, the view is
     * told to add the newly persisted person to the navigation tree. Otherwise
     * the view is only told to set the person selected.
     */
    protected void saveCoinAttribute(
            @Observes @CDIEvent(SAVE_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        CoinAttributes coinAttributes = parameters.getPrimaryParameter(CoinAttributes.class);

        Notification.show("From CoinAttributesPresenter ", Notification.Type.TRAY_NOTIFICATION);
//        System.out.println("From CoinAttributesPresenter " + coinattributes.getCountry());
//        service.update(coinattributes);
        /*if (coinattributes.isPersistent())
        {
            service.update(coinattributes);
        }
        else
        {
            coinattributes = service.persist(coinattributes);
            view.addCoinAttributeToList(coinattributes);
        }
        view.selectCoinAttribute(coinattributes);*/
    }

    protected void cancel(
            @Observes @CDIEvent(CANCEL_EDIT) final ParameterDTO parameters)
    {
        view.cancelEditing();
    }

    // ********************************************************************************************
    /* This is also set in the RightPresenter to load the table component */
    protected void coinAttributesListView(
            @Observes @CDIEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW) final ParameterDTO parameters)
    {
        view.setCoinAttributesList(service.findAll());
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
