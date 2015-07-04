package net.downthehall.ui.tabbedPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.ui.tabbedPanel.detailPanel.BuyAndSellForm;
import net.downthehall.ui.tabbedPanel.detailPanel.ItemDetailForm;
import net.downthehall.ui.tabbedPanel.detailPanel.MoreDetailForm;
import org.vaadin.addon.cdimvp.ViewComponent;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/12/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class MainTabPanel extends ViewComponent
{
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForm;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    private TabSheet tabSheet;

    public void init()
    {
        // Tab 1 content
        VerticalLayout l1 = new VerticalLayout();
        l1.setMargin(true);
//        l1.addComponent(new Label("This is Item Detail tab"));
        itemDetailForms.get().init();
        l1.addComponent(itemDetailForms.get());
        // Tab 2 content
        VerticalLayout l2 = new VerticalLayout();
        l2.setMargin(true);
        l2.addComponent(new Label("This is More Detail tab."));
        moreDetailForms.get().init();
        l2.addComponent(moreDetailForms.get());
        // Tab 3 content
        VerticalLayout l3 = new VerticalLayout();
        l3.setMargin(true);
        l3.addComponent(new Label("This is Custom Detail tab."));
        // Tab 4 content
        VerticalLayout l4 = new VerticalLayout();
        l4.setMargin(true);
//        l4.addComponent(new Label("This is Buy and Sell tab."));
        buyAndSellForm.get().init();
        l4.addComponent(buyAndSellForm.get());
        // Tab 5 content
        VerticalLayout l5 = new VerticalLayout();
        l5.setMargin(true);
        l5.addComponent(new Label("This is Estate Planning tab."));
        // Tab 6 content
        VerticalLayout l6 = new VerticalLayout();
        l6.setMargin(true);
        l6.addComponent(new Label("This is Notes tab."));
        // Tab 7 content
        VerticalLayout l7 = new VerticalLayout();
        l7.setMargin(true);
        l7.addComponent(new Label("This is Pictures tab."));

        tabSheet = new TabSheet();
        tabSheet.setHeight("380px");
//        tabSheet.setWidth("400px");

        tabSheet.addTab(l1, "Item Detail");
        tabSheet.addTab(l2, "More Detail");
        tabSheet.addTab(l3, "Custom Detail");
        tabSheet.addTab(l4, "Buy and Sell");
        tabSheet.addTab(l5, "Estate Planning");
        tabSheet.addTab(l6, "Notes");
        tabSheet.addTab(l7, "Pictures");

        setCompositionRoot(tabSheet);
    }
}
