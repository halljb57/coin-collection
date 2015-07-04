package net.downthehall.ui.coinattributes.showCoinAttributesView;

import com.vaadin.ui.Notification;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.model.vo.ShowCoinAttributes;
import net.downthehall.business.service.ShowCoinAttributesService;
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
@ViewInterface(ShowCoinAttributesListView.class)
public class ShowCoinAttributesPresenter extends AbstractMVPPresenter<ShowCoinAttributesListView>
{
    // CDI MVP includes a built-in CDI event qualifier @CDIEvent which
    // uses a String (method identifier) as it's member
    public static final String SHOW_COIN_ATTRIBUTE_SELECTED = "ShowCoinAttributesPresenter_ShowCoinAttributeSelected";
    public static final String EDIT_SHOW_COIN_ATTRIBUTE = "ShowCoinAttributesPresenter_editShowCoinAttribute";
    public static final String SAVE_SHOW_COIN_ATTRIBUTE = "ShowCoinAttributesPresenter_saveShowCoinAttribute";
    public static final String CANCEL_EDIT = "ShowCoinAttributesPresenter_cancelEdit";
    // **********************************************************************************
    @Inject
    private ShowCoinAttributesService service;

    // **********************************************************************************
    /*
     * This method observes events with a ParameterDTO as the parameter type and
     * COIN_ATTRIBUTE_SELECTED as the @CDIEvent value
     */
    protected void coinAttributeSelected(
            @Observes @CDIEvent(SHOW_COIN_ATTRIBUTE_SELECTED) final ParameterDTO parameters)
    {
        view.showSelectedShowCoinAttributeDetails();
    }

    protected void editCoinAttribute(
            @Observes @CDIEvent(EDIT_SHOW_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        view.editSelectedShowCoinAttribute();
    }

    /*
     * This method nicely demonstrates how the control logic over views can be
     * handled in presenters: If the person isn't persistent yet, the view is
     * told to add the newly persisted person to the navigation tree. Otherwise
     * the view is only told to set the person selected.
     */
    protected void saveShowCoinAttribute(
            @Observes @CDIEvent(SAVE_SHOW_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        ShowCoinAttributes showCoinAttributes = parameters.getPrimaryParameter(ShowCoinAttributes.class);
        CoinAttributes coinAttributes = parameters.getPrimaryParameter(CoinAttributes.class);

        Notification.show("Save Show Coin Attribute");
        if (coinAttributes.isPersistent())
        {
            service.update(showCoinAttributes);
        }
        else
        {
            showCoinAttributes = service.create(showCoinAttributes);
            view.addShowCoinAttributeToList(showCoinAttributes);
        }
        view.selectShowCoinAttribute(showCoinAttributes);
    }

    protected void cancel(
            @Observes @CDIEvent(CANCEL_EDIT) final ParameterDTO parameters)
    {
        view.cancelEditing();
    }

    // ********************************************************************************************
    /* This is also set in the RightPresenter to load the list component */
    protected void showCoinAttributesListView(
            @Observes @CDIEvent(RightPresenter.SHOW_COIN_ATTRIBUTES_LIST_VIEW) final ParameterDTO parameters)
    {
        if (service.findAll().size() <= 0)
        {
            view.setShowCoinAttributesList(service.findAll());
            Notification.show("From ShowCoinAttributesPresenter Count = " + service.findAll().size(),
                              Notification.Type.WARNING_MESSAGE);
        }
        else
        {
            view.setShowCoinAttributesList(service.findAll());
        }

    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
