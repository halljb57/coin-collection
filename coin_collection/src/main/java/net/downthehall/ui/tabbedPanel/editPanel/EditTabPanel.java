package net.downthehall.ui.tabbedPanel.editPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.downthehall.business.model.vo.ShowCoinAttributes;
import net.downthehall.business.model.vo.ShowCoins;
import net.downthehall.ui.Toolbar;
import net.downthehall.ui.collectionName.CollectionNameList;
import net.downthehall.ui.collectionName.CollectionNamePresenter;
import net.downthehall.ui.splitPanels.horizontalLeft.LeftPresenter;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ButtonProperties;
import org.vaadin.addon.cdiproperties.annotation.HorizontalLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.TabSheetProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/12/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class EditTabPanel extends ViewComponent
{
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForm;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<Toolbar> toolbars;
    @Inject
    private Instance<CollectionNameList> collectionNameLists;
    @Inject
    @ButtonProperties(caption = "Save")
    protected Button saveBtn;
    @Inject
    @ButtonProperties(caption = "Delete")
    protected Button deleteBtn;
    @Inject
    @ButtonProperties(caption = "Cancel")
    protected Button cancelBtn;
    @Inject
    @TabSheetProperties(height = "440px")
    private TabSheet tabSheet;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout verticalLayout;
    @Inject
    @VerticalLayoutProperties(margin = true)
    private VerticalLayout l1, l2, l3, l4, l5, l6, l7;
    @Inject
    @HorizontalLayoutProperties(spacing = true)
    private HorizontalLayout horizontalLayout;
    private String tableName;
    private TabSheet.Tab t1, t2, t3, t4, t5, t6, t7;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        buildVerticalLayout();
        tabSheet.setSelectedTab(l1);
    }

    // Initialize buildVerticalLayout
    private VerticalLayout buildVerticalLayout()
    {
        tabSheet = buildTabSheet();
        verticalLayout.addComponent(tabSheet);
        horizontalLayout = buildHorizontalLayout();
        verticalLayout.addComponent(horizontalLayout);
        setCompositionRoot(verticalLayout);
        return verticalLayout;
    }

    // Initialize buildHorizontalLayout
    private HorizontalLayout buildHorizontalLayout()
    {
        saveBtn = buildSaveButton();
        deleteBtn = buildDeleteButton();
        cancelBtn = buildCancelButton();
        saveBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        cancelBtn.setEnabled(false);
        horizontalLayout.addComponent(saveBtn);
        horizontalLayout.addComponent(deleteBtn);
        horizontalLayout.addComponent(cancelBtn);
        return horizontalLayout;
    }

    // Initialize buildSaveButton
    private Button buildSaveButton()
    {
        saveBtn.setImmediate(true);
        saveBtn.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                toolbars.get().addCoinBtn.setEnabled(true);
                String s = "coinsTable";
                if (getTableName() == s)
                {
                    fireViewEvent(EditPanelPresenter.SAVE_COIN_ATTRIBUTE, getItemShowCoins());
                }
                else
                {
                    fireViewEvent(EditPanelPresenter.UPDATE_COIN_ATTRIBUTE, getItemShowCoinAttribute());
                }
                changeLayout();
            }
        });
        return saveBtn;
    }

    // Initialize buildDeleteButton
    private Button buildDeleteButton()
    {
        deleteBtn.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                fireViewEvent(EditPanelPresenter.DELETE_COIN_ATTRIBUTE, getItemShowCoinAttribute());
                changeLayout();
            }
        });
        return deleteBtn;
    }

    // Initialize buildCancelButton
    private Button buildCancelButton()
    {
        cancelBtn.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                toolbars.get().addCoinBtn.setEnabled(true);
        fireViewEvent(EditPanelPresenter.CANCEL_EDITING, null);
        changeLayout();
            }
        });
        return cancelBtn;
    }

    private void changeLayout()
    {
        fireViewEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW, null);
        fireViewEvent(RightPresenter.DETAIL_TAB_PANEL, null);
        fireViewEvent(CollectionNamePresenter.REFRESH_COLLECTION_LIST_VIEW, null);
        fireViewEvent(LeftPresenter.COLLECTION_LIST_VIEW, null);
    }

    // **********************************************************************************
    private ShowCoinAttributes getItemShowCoinAttribute()
    {
        return ((BeanItem<ShowCoinAttributes>) itemDetailForms.get().getNewDataSource()).getBean();
    }

    private ShowCoins getItemShowCoins()
    {
        return ((BeanItem<ShowCoins>) itemDetailForms.get().getNewDataSource()).getBean();
    }

    public void setItemDataSource(Item newDataSource)
    {
        Item item = newDataSource;
//            System.out.println("Data Source setItemDataSource " + item);
    }
    // **********************************************************************************

    // Initialize buildTabSheet
    private TabSheet buildTabSheet()
    {
        // Tab 1 content
        itemDetailForms.get().init();
        l1.addComponent(itemDetailForms.get());
        l1.addComponent(new Label("Edit Tab Panel"));
        // Tab 2 content
        moreDetailForms.get().init();
        l2.addComponent(moreDetailForms.get());
        l2.addComponent(new Label("Edit Tab Panel"));
        // Tab 3 content
        l3.addComponent(new Label("Edit Tab Panel"));
        // Tab 4 content
        buyAndSellForm.get().init();
        l4.addComponent(buyAndSellForm.get());
        l4.addComponent(new Label("Edit Tab Panel"));
        // Tab 5 content
        l5.addComponent(new Label("Edit Tab Panel"));
        // Tab 6 content
        l6.addComponent(new Label("Edit Tab Panel"));
        // Tab 7 content
        l7.addComponent(new Label("Edit Tab Panel"));

        // ******************************************************************************
        t1 = tabSheet.addTab(l1, "Item Detail");
        t2 = tabSheet.addTab(l2, "More Detail");
        t3 = tabSheet.addTab(l3, "Custom Detail");
        t4 = tabSheet.addTab(l4, "Buy and Sell");
        t5 = tabSheet.addTab(l5, "Estate Planning");
        t6 = tabSheet.addTab(l6, "Notes");
        t7 = tabSheet.addTab(l7, "Pictures");

        return tabSheet;
    }

    public String getTableName()
    {
        return tableName;
    }

    protected void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public void setMainTab()
    {
        tabSheet.setSelectedTab(l1);
    }
}
