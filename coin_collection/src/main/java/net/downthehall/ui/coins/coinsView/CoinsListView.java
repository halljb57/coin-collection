package net.downthehall.ui.coins.coinsView;

import net.downthehall.business.model.vo.Coins;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 9/19/2014.
 */
public interface CoinsListView extends MVPView
{
    void setCoinsList(Collection<Coins> coins);

    void showSelectedCoinDetails();

    void editNewCoin(Coins coins);

    void addCoinToList(Coins coins);

    void selectCoin(Coins coins);

    void editSelectedCoin();

    void cancelEditing();
}
