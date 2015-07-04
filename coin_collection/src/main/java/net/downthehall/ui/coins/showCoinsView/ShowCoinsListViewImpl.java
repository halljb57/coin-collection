package net.downthehall.ui.coins.showCoinsView;

import com.vaadin.data.Item;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.ShowCoins;
import net.downthehall.ui.tabbedPanel.editPanel.BuyAndSellForm;
import net.downthehall.ui.tabbedPanel.editPanel.ItemDetailForm;
import net.downthehall.ui.tabbedPanel.editPanel.MoreDetailForm;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 9/19/2014.
 */
@SuppressWarnings("serial")
public class ShowCoinsListViewImpl extends AbstractMVPView implements ShowCoinsListView
{
    /*
     * Instance<ShowCoinsTableView> is used here so the tableViews and XXXXX won't
     * be injected until needed (Lazy initialization). They are both @UIScoped
     * so tableViews.get() will always return the same instance (for the current
     * UI).
     */
    @Inject
    private Instance<ShowCoinsTableView> tableViews;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForm;

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
    public void setCoinsList(Collection<ShowCoins> showCoins)
    {
        tableViews.get().setCoinsList(showCoins);
    }

    @Override
    public void showSelectedCoinDetails()
    {
        final Item item = tableViews.get().getSelectedItem();

        itemDetailForms.get().setItemDataSource(item);
        moreDetailForms.get().setItemDataSource(item);
        buyAndSellForm.get().setItemDataSource(item);

    }

    @Override
    public void editNewCoin(final ShowCoins showCoins)
    {
        tableViews.get().setValue(null);
    }

    @Override
    public void addCoinToList(ShowCoins showCoins)
    {
        tableViews.get().addCoinToList(showCoins);
    }

    @Override
    public void selectCoin(ShowCoins showCoins)
    {
        tableViews.get().setValue(showCoins);
        itemDetailForms.get().setReadOnly(true);
        moreDetailForms.get().setReadOnly(true);
        buyAndSellForm.get().setReadOnly(true);
    }

    @Override
    public void editSelectedCoin()
    {

    }

    @Override
    public void cancelEditing()
    {

    }

    // **********************************************************************************
    @Override
    public void enter()
    {
        super.enter();
    }
}
