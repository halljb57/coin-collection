package net.downthehall.ui.coinattributes.showCoinAttributesView;

import net.downthehall.business.model.vo.ShowCoinAttributes;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 7/30/2014.
 */
public interface ShowCoinAttributesListView extends MVPView
{
    void setShowCoinAttributesList(Collection<ShowCoinAttributes> coinAttributes);

    void showSelectedShowCoinAttributeDetails();

    void editNewCoinAttribute(ShowCoinAttributes showCoinAttributes);

    void addShowCoinAttributeToList(ShowCoinAttributes showCoinAttributes);

    void selectShowCoinAttribute(ShowCoinAttributes showCoinAttributes);

    void editSelectedShowCoinAttribute();

    void cancelEditing();
}
