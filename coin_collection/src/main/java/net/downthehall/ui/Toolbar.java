package net.downthehall.ui;

import com.vaadin.cdi.UIScoped;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import net.downthehall.ui.accordionPanel.AccordionPresenter;
import net.downthehall.ui.popUpWindows.NewCollection;
import net.downthehall.ui.splitPanels.horizontalLeft.LeftPresenter;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditPanelPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditTabPanel;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ButtonProperties;
import org.vaadin.addon.cdiproperties.annotation.HorizontalLayoutProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/26/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class Toolbar extends ViewComponent
{
    @Inject
    private Instance<EditTabPanel> editTabPanels;

    @Inject
    @ButtonProperties(caption = "New Collection")
    private Button newCollectionBtn;
    @Inject
    @ButtonProperties(caption = "Add Coin")
    public Button addCoinBtn;
    @Inject
    @ButtonProperties(caption = "Edit Coin")
    public Button editCoinBtn;

    @Inject
    @HorizontalLayoutProperties(sizeUndefined = true)
    private HorizontalLayout horizontalLayout;

    // **********************************************************************************
    @PostConstruct
    public void init()
    {
        setSizeUndefined();
        buildHorizontalLayout();
    }

    private HorizontalLayout buildHorizontalLayout()
    {
        setCompositionRoot(horizontalLayout);
        horizontalLayout.setStyleName("toolbar");

        newCollectionBtn = buildNewCollectionButton();
        addCoinBtn = buildAddCoinButton();
        editCoinBtn = buildEditCoinButton();

        horizontalLayout.addComponent(addCoinBtn);
        horizontalLayout.addComponent(newCollectionBtn);
        horizontalLayout.addComponent(editCoinBtn);

        return horizontalLayout;
    }

    /**
     * New Collection Button
     * @return newCollectionBtn
     */
    private Button buildNewCollectionButton()
    {
        newCollectionBtn.setIcon(new ThemeResource("icons/32/document-add.png"));
        newCollectionBtn.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                getUI().addWindow(new NewCollection());
            }
        });
        return newCollectionBtn;
    }

    /**
     * AddCoin Button
     * @return addCoinBtn
     */
    private Button buildAddCoinButton()
    {
        addCoinBtn.setIcon(new ThemeResource("icons/32/folder-add.png"));
        addCoinBtn.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                addCoinBtn.setEnabled(false);
                fireViewEvent(LeftPresenter.ACCORDION_LIST_VIEW, null);
                fireViewEvent(AccordionPresenter.SET_COLLECTION_TAB, null);
                fireViewEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW, null);
                fireViewEvent(EditPanelPresenter.CANCEL_EDITING, null);
                fireViewEvent(EditPanelPresenter.DISABLE_EDIT_PANEL_BUTTONS, null);
                fireViewEvent(RightPresenter.DETAIL_TAB_PANEL, null);
            }
        });
        return addCoinBtn;
    }

    /**
     * Edit Coin Button
     * @return editCoinBtn
     */
    private Button buildEditCoinButton()
    {
        editCoinBtn.setEnabled(false);
        editCoinBtn.setIcon(new ThemeResource("icons/32/folder-add.png"));
        editCoinBtn.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                editCoinBtn.setEnabled(false);
                addCoinBtn.setEnabled(false);
                fireViewEvent(EditPanelPresenter.SET_READ_ONLY_FALSE, null);
                fireViewEvent(EditPanelPresenter.ENABLE_EDIT_PANEL_BUTTONS, null);
                fireViewEvent(EditPanelPresenter.POPUP_DATE_FIELD_ENABLED, null);
            }
        });
        return editCoinBtn;
    }


}
