package net.downthehall.ui.coinattributes.showCoinAttributesView;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.ShowCoinAttributes;
import net.downthehall.ui.Toolbar;
import net.downthehall.ui.coinattributes.CoinAttributesContainer;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditPanelPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditTabPanel;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.TableProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by joseph on 7/30/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class ShowCoinAttributesTableView extends ViewComponent
{
    public static final Action EDIT_ACTION = new Action("Edit");
    public static final Action DELETE_ACTION = new Action("Delete");

    @Inject
    @TableProperties(nullSelectionAllowed = false,
                     pageLength = 11,
                     sizeFull = true,
                     immediate = true,
                     columnCollapsingAllowed = true,
                     columnReorderingAllowed = true,
                     selectable = true)
    private Table caTable;
    @Inject
    private Instance<EditTabPanel> editTabPanels;
    @Inject
    private Instance<Toolbar> toolbars;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;
    Collection<ShowCoinAttributes> coinattribute;

    // **********************************************************************************
    public void init()
    {
        buildCoinsTable();
        initColumns();
    }

    private Table buildCoinsTable()
    {
        setCompositionRoot(layout);
        layout.addComponent(caTable);

        // ****************************************************************************** Action Handle
        caTable.addActionHandler(new Action.Handler()
        {
            @Override
            public Action[] getActions(Object target, Object sender)
            {
                return new Action[] {EDIT_ACTION, DELETE_ACTION};
            }

            @Override
            public void handleAction(Action action, Object sender, Object target)
            {
                if (action == EDIT_ACTION)
                {
                    Notification.show("You Selected " + target);
                }
                else if (action ==DELETE_ACTION)
                {
                    Notification.show("You Selected " + target);
                }
            }
        });

        // ****************************************************************************** Change Listener
        caTable.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                final ShowCoinAttributes coinAttributes = (ShowCoinAttributes) event.getProperty().getValue();

                if (coinAttributes != null)
                {
                    String s = "caTable";
                    toolbars.get().editCoinBtn.setEnabled(true);
                    toolbars.get().addCoinBtn.setEnabled(false);
                    fireViewEvent(RightPresenter.SHOW_EDIT_TAB_PANEL, null);
                    fireViewEvent(ShowCoinAttributesPresenter.SHOW_COIN_ATTRIBUTE_SELECTED, coinAttributes);
                    fireViewEvent(EditPanelPresenter.SET_TABLE_NAME, s);
                    fireViewEvent(EditPanelPresenter.SET_READ_ONLY_TRUE, null);
                    fireViewEvent(EditPanelPresenter.SET_MAIN_TAB, null);
                    fireViewEvent(EditPanelPresenter.DISABLE_EDIT_PANEL_BUTTONS, null);
                    fireViewEvent(EditPanelPresenter.POPUP_DATE_FIELD_DISABLED, null);
                }
            }
        });

        return caTable;
    }

    private void initColumns()
    {
        caTable.removeAllItems();

        caTable.setColumnCollapsed("Catalog Type", true);

        caTable.setContainerDataSource(new BeanItemContainer<>(ShowCoinAttributes.class));
        caTable.setVisibleColumns(CoinAttributesContainer.NATURAL_COL_ORDER);
        caTable.setColumnHeaders(CoinAttributesContainer.COL_HEADERS_ENGLISH);

    }

    // **********************************************************************************
    /**
     * Add entire Collection of beans to container. Data from database.
     * @param coinattribute
     */
    public void setShowCoinattributesList(final Collection<ShowCoinAttributes> coinattribute)
    {
        this.coinattribute = coinattribute;
        caTable.removeAllItems();
        // Instantiate empty container, with columns defined by my class’ JavaBean fields.
        BeanContainer<UUID, ShowCoinAttributes> container = new BeanContainer<>(ShowCoinAttributes.class);
        try
        {
            // Indicate which field in Bean serves as the unique identifier.
            container.setBeanIdProperty(ShowCoinAttributes.class.getDeclaredField("coin_Attributes_Id").getName());
            // Add entire Collection of beans to container. Data from database.
            for (ShowCoinAttributes coinAttributes : coinattribute)
            {
                caTable.addItem(coinAttributes);
            }
            caTable.sort();
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }


        /*caTable.removeAllItems();

        for (final ShowCoinAttributes coinattributes : coinattribute)
        {
            caTable.addItem(coinattributes);
        }
        caTable.sort();*/
    }

    public Item getSelectedItem()
    {
        return caTable.getItem(caTable.getValue());
    }

    public void setValue(final ShowCoinAttributes coinAttributes)
    {
        caTable.setValue(coinAttributes);
    }

    public void addShowCoinAttributeToList(ShowCoinAttributes showCoinAttributes)
    {
        caTable.addItem(showCoinAttributes);
        caTable.sort();
    }
}
