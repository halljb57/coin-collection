package net.downthehall.ui.coinattributes.coinAttributesView;

import com.vaadin.data.Item;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.misc.CoinAttributesService;
import net.downthehall.ui.tabbedPanel.editPanel.BuyAndSellForm;
import net.downthehall.ui.tabbedPanel.editPanel.ItemDetailForm;
import net.downthehall.ui.tabbedPanel.editPanel.MoreDetailForm;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.MVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 7/30/2014.
 * CoinAttributesListViewImpl is the implementation of CoinAttributesListView and receives
 * the calls from TopRight.
 */
@SuppressWarnings("serial")
public class CoinAttributesListViewImpl extends AbstractMVPView implements CoinAttributesListView
{
    /*
     * Instance<CoinAttributesTableView> is used here so the tableViews and XXXXX won't
     * be injected until needed (Lazy initialization). They are both @UIScoped
     * so tableViews.get() will always return the same instance (for the current
     * UI).
     */
    @Inject
    private CoinAttributesService service;
    @Inject
    private Instance<CoinAttributesTableView> tableViews;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForm;
    @Inject
    private Instance<MVPView> views;

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
    public void setCoinAttributesList(Collection<CoinAttributes> coinattributes)
    {
        tableViews.get().setCoinattributesList(coinattributes);
    }

    @Override
    public void showSelectedCoinAttributeDetails()
    {
        final Item item = tableViews.get().getSelectedItem();

        itemDetailForms.get().setItemDataSource(item);
        moreDetailForms.get().setItemDataSource(item);
        buyAndSellForm.get().setItemDataSource(item);
        itemDetailForms.get().setReadOnly(true);
        moreDetailForms.get().setReadOnly(true);
        buyAndSellForm.get().setReadOnly(true);
    }

    @Override
    public void editNewCoinAttribute(final CoinAttributes coinAttributes)
    {
        tableViews.get().setValue(null);
        itemDetailForms.get().editNewCoinAttribute(coinAttributes);
        moreDetailForms.get().editNewCoinAttribute(coinAttributes);
        buyAndSellForm.get().editNewCoinAttribute(coinAttributes);
    }

    @Override
    public void addCoinAttributeToList(final CoinAttributes coinAttributes)
    {
        tableViews.get().addCoinAttributeToList(coinAttributes);
    }

    @Override
    public void selectCoinAttribute(final CoinAttributes coinAttributes)
    {
        tableViews.get().setValue(coinAttributes);
    }

    @Override
    public void editSelectedCoinAttribute()
    {
        itemDetailForms.get().setReadOnly(false);
        moreDetailForms.get().setReadOnly(false);
        buyAndSellForm.get().setReadOnly(false);
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
