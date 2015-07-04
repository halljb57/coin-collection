package net.downthehall.ui.coins.showCoinsView;

import net.downthehall.business.model.vo.ShowCoins;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 9/19/2014.
 */
public interface ShowCoinsListView extends MVPView
{
    void setCoinsList(Collection<ShowCoins> ShowCoins);

    void showSelectedCoinDetails();

    void editNewCoin(ShowCoins ShowCoins);

    void addCoinToList(ShowCoins ShowCoins);

    void selectCoin(ShowCoins ShowCoins);

    void editSelectedCoin();

    void cancelEditing();
}
