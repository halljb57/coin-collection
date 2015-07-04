package net.downthehall.ui.coins.coinsView;

import com.vaadin.data.Item;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.Coins;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 9/19/2014.
 */
@SuppressWarnings("serial")
public class CoinsListViewImpl extends AbstractMVPView implements CoinsListView
{
    @Inject
    private Instance<CoinsTableView> tableViews;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        tableViews.get().init();
        layout.addComponent(tableViews.get());
    }

    // **********************************************************************************
    @Override
    public void setCoinsList(Collection<Coins> coins)
    {
        tableViews.get().setCoinsList(coins);
    }

    @Override
    public void showSelectedCoinDetails()
    {
        final Item item = tableViews.get().getSelectedItem();
    }

    @Override
    public void editNewCoin(final Coins coins)
    {
        tableViews.get().setValue(null);
    }

    @Override
    public void addCoinToList(Coins coins)
    {
        tableViews.get().addCoinToList(coins);
    }

    @Override
    public void selectCoin(Coins coins)
    {
        tableViews.get().setValue(coins);
    }

    @Override
    public void editSelectedCoin()
    {

    }

    @Override
    public void cancelEditing()
    {

    }

    @Override
    public void enter()
    {
        super.enter();
    }
}
