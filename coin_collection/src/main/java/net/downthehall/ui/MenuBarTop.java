package net.downthehall.ui;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.ui.collectionName.CollectionNamePresenter;
import net.downthehall.ui.splitPanels.horizontalLeft.LeftPresenter;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.MenuBarProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by joseph on 10/1/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class MenuBarTop extends ViewComponent
{
    @Inject
    @MenuBarProperties(widthValue = 100.0f, widthUnits = Unit.PERCENTAGE)
    private MenuBar menuBar;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;

    // **********************************************************************************
    @PostConstruct
    public void init()
    {
        setCompositionRoot(layout);

        menuBar = buildMenuBar();
        layout.addComponent(menuBar);
    }

    private MenuBar buildMenuBar()
    {
        // Save reference to individual items so we can add sub-menu items to
        // them
        // ****************************************************************************** File MenuItem
        final MenuBar.MenuItem file = menuBar.addItem("File", null);
        final MenuBar.MenuItem newItem = file.addItem("New", null);
        file.addItem("Open file...", menuCommand);
        file.addSeparator();

        newItem.addItem("File", menuCommand);
        newItem.addItem("Folder", menuCommand);
        newItem.addItem("Project...", menuCommand);

        file.addItem("New Collection", menuCommand);
        file.addItem("New Coin", menuCommand);
        file.addItem("Delete Coin", menuCommand);
        file.addSeparator();
        file.addItem("Exit", menuCommand);

        // ****************************************************************************** Edit MenuItem
        final MenuBar.MenuItem edit = menuBar.addItem("Edit", null);
        edit.addItem("Undo", menuCommand);
        edit.addItem("Redo", menuCommand).setEnabled(false);
        edit.addSeparator();

        edit.addItem("Cut", menuCommand);
        edit.addItem("Copy", menuCommand);
        edit.addItem("Paste", menuCommand);

        edit.addSeparator();
        edit.addItem("Move", menuCommand);
        edit.addItem("Edit Coin", menuCommand);
        edit.addItem("Cancel", menuCommand);
        edit.addSeparator();

        final MenuBar.MenuItem find = edit.addItem("Find/Replace", menuCommand);

        // Actions can be added inline as well, of course
        /*find.addItem("Google Search", new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                getWindow().open(new ExternalResource("http://www.google.com"));
            }
        });*/
        find.addSeparator();
        find.addItem("Find/Replace...", menuCommand);
        find.addItem("Find Next", menuCommand);
        find.addItem("Find Previous", menuCommand);

        // ****************************************************************************** View MenuItem
        final MenuBar.MenuItem view = menuBar.addItem("View", null);
        view.addItem("Show/Hide Status Bar", menuCommand);
        view.addItem("Customize Toolbar...", menuCommand);
        view.addSeparator();

        view.addItem("Actual Size", menuCommand);
        view.addItem("Zoom In", menuCommand);
        view.addItem("Zoom Out", menuCommand);

        return menuBar;
    }

    // ******************************************************************************
    private final MenuBar.Command menuCommand = new MenuBar.Command()
    {
        @Override
        public void menuSelected(MenuBar.MenuItem selectedItem)
        {
            String s = selectedItem.getText();

            switch (s)
            {
                case "New Collection":
                    Notification.show("Action New Collection", Notification.Type.TRAY_NOTIFICATION);
                    break;
                case "New Coin":
                    Notification.show("Action New Coin", Notification.Type.TRAY_NOTIFICATION);
                    break;
                case "Delete Coin":
                    Notification.show("Action Delete Coin", Notification.Type.TRAY_NOTIFICATION);
                    break;
                case "Exit":
                    Notification.show("Action Exit", Notification.Type.TRAY_NOTIFICATION);
                    break;
                case "Cancel":
//                    fireViewEvent(EditPanelPresenter.CANCEL_EDITING, null);
                    fireViewEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW, null);
                    fireViewEvent(RightPresenter.DETAIL_TAB_PANEL, null);
                    fireViewEvent(CollectionNamePresenter.REFRESH_COLLECTION_LIST_VIEW, null);
                    fireViewEvent(LeftPresenter.COLLECTION_LIST_VIEW, null);
                    break;
            }
        }
    };
}
