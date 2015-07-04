package net.downthehall.ui.coinattributes.coinAttributesView;

import net.downthehall.business.model.vo.CoinAttributes;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 7/30/2014.
 */
public interface CoinAttributesListView extends MVPView
{
    void setCoinAttributesList(Collection<CoinAttributes> coinattributes);

    void showSelectedCoinAttributeDetails();

    void editNewCoinAttribute(CoinAttributes coinAttributes);

    void addCoinAttributeToList(CoinAttributes coinAttributes);

    void selectCoinAttribute(CoinAttributes coinAttributes);

    void editSelectedCoinAttribute();

    void cancelEditing();
}
