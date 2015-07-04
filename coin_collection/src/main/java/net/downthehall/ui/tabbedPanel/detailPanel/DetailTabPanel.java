package net.downthehall.ui.tabbedPanel.detailPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.ui.*;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.ui.Toolbar;
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
public class DetailTabPanel extends ViewComponent
{
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForm;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<TestForm> testForms;
    @Inject
    private Instance<Toolbar> toolbars;
    @Inject
    @ButtonProperties(caption = "Save")
    private Button saveButton;
    @Inject
    @ButtonProperties(caption = "Edit")
    private Button editButton;
    @Inject
    @TabSheetProperties(height = "440px")
    private TabSheet tabSheet;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout verticalLayout;
    @Inject
    @HorizontalLayoutProperties(spacing = true)
    private HorizontalLayout horizontalLayout;

    private Item item;

    // Initialize Class
    public void init()
    {
        buildVerticalLayout();
    }

    // Initialize Build-VerticalLayout
    private VerticalLayout buildVerticalLayout()
    {
        tabSheet = buildTabSheet();
        verticalLayout.addComponent(tabSheet);
        horizontalLayout = buildHorizontalLayout();
        verticalLayout.addComponent(horizontalLayout);
        setCompositionRoot(verticalLayout);

        return verticalLayout;
    }

    // Initialize Build-HorizontalLayout
    private HorizontalLayout buildHorizontalLayout()
    {
        saveButton = buildSaveButton();
        editButton = buildEditButton();
//        horizontalLayout.addComponent(saveButton);
//        horizontalLayout.addComponent(editButton);

        return horizontalLayout;
    }

    // Initialize Build-Save-Button
    private Button buildSaveButton()
    {
        saveButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                Notification.show("Save Form");
//                fireViewEvent(CoinAttributesPresenter.SAVE_COIN_ATTRIBUTE, null);
            }
        });

        return saveButton;
    }

    // **********************************************************************************
    private CoinAttributes getItemPerson()
    {
        System.out.println("Data Source getItemPerson " + item);
//        return ((BeanItem<CoinAttributes>) item).getBean();
        return null;
    }

    public void setItemDataSource(Item newDataSource)
    {
        item = newDataSource;
//            System.out.println("Data Source setItemDataSource " + item);
    }
    // **********************************************************************************

    // Initialize Build-Edit-Button
    private Button buildEditButton()
    {
        editButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                Notification.show("Edit Form");
//                fireViewEvent(RightPresenter.SET_TABLE_NAME, null);
            }
        });

        return editButton;
    }

    // Initialize Build-Tab-Sheet
    private TabSheet buildTabSheet()
    {
        // Tab 1 content
        VerticalLayout l1 = new VerticalLayout();
        l1.setMargin(true);
        itemDetailForms.get().init();
        l1.addComponent(itemDetailForms.get());
        l1.addComponent(new Label("Detail Tab Panel"));
        l1.addComponent(new Label("This is Item Detail tab"));
        // Tab 2 content
        VerticalLayout l2 = new VerticalLayout();
        l2.setMargin(true);
        moreDetailForms.get().init();
        l2.addComponent(moreDetailForms.get());
        l2.addComponent(new Label("This is More Detail tab."));
        // Tab 3 content
        VerticalLayout l3 = new VerticalLayout();
        l3.setMargin(true);
        l3.addComponent(new Label("This is Custom Detail tab."));
        // Tab 4 content
        VerticalLayout l4 = new VerticalLayout();
        l4.setMargin(true);
        buyAndSellForm.get().init();
        l4.addComponent(buyAndSellForm.get());
        l4.addComponent(new Label("This is Buy and Sell tab."));
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

        // ******************************************************************************
        tabSheet.addTab(l1, "Item Detail");
        tabSheet.addTab(l2, "More Detail");
        tabSheet.addTab(l3, "Custom Detail");
        tabSheet.addTab(l4, "Buy and Sell");
        tabSheet.addTab(l5, "Estate Planning");
        tabSheet.addTab(l6, "Notes");
        tabSheet.addTab(l7, "Pictures");

        return tabSheet;
    }
}
