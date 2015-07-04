package net.downthehall.ui.coinattributes.showCoinAttributesView;

import com.vaadin.data.Item;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.ShowCoinAttributes;
import net.downthehall.business.service.ShowCoinAttributesService;
import net.downthehall.ui.tabbedPanel.editPanel.BuyAndSellForm;
import net.downthehall.ui.tabbedPanel.editPanel.EditTabPanel;
import net.downthehall.ui.tabbedPanel.editPanel.ItemDetailForm;
import net.downthehall.ui.tabbedPanel.editPanel.MoreDetailForm;
import org.vaadin.addon.cdimvp.AbstractMVPView;

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
public class ShowCoinAttributesListViewImpl extends AbstractMVPView implements ShowCoinAttributesListView
{
    /*
     * Instance<ShowCoinAttributesTableView> is used here so the tableViews and XXXXX won't
     * be injected until needed (Lazy initialization). They are both @UIScoped
     * so tableViews.get() will always return the same instance (for the current
     * UI).
     */
    @Inject
    private ShowCoinAttributesService service;
    @Inject
    private Instance<ShowCoinAttributesTableView> tableViews;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForm;
    @Inject
    private Instance<EditTabPanel> editTabPanels;
//    @Inject
//    private Instance<MVPView> views;

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
    public void setShowCoinAttributesList(Collection<ShowCoinAttributes> showCoinAttributes)
    {
        tableViews.get().setShowCoinattributesList(showCoinAttributes);
    }

    @Override
    public void showSelectedShowCoinAttributeDetails()
    {
        Item item = tableViews.get().getSelectedItem();

        editTabPanels.get().setItemDataSource(item);

        itemDetailForms.get().setItemDataSource(item);
        moreDetailForms.get().setItemDataSource(item);
        buyAndSellForm.get().setItemDataSource(item);
    }

    @Override
    public void editNewCoinAttribute(ShowCoinAttributes showCoinAttributes)
    {
        tableViews.get().setValue(null);
    }

    @Override
    public void addShowCoinAttributeToList(ShowCoinAttributes showCoinAttributes)
    {
        tableViews.get().addShowCoinAttributeToList(showCoinAttributes);
    }

    @Override
    public void selectShowCoinAttribute(ShowCoinAttributes showCoinAttributes)
    {
        tableViews.get().setValue(showCoinAttributes);
    }

    @Override
    public void editSelectedShowCoinAttribute()
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
