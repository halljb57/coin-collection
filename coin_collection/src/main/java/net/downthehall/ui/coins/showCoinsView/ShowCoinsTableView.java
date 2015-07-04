package net.downthehall.ui.coins.showCoinsView;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.ShowCoins;
import net.downthehall.ui.coins.CoinsContainer;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import net.downthehall.ui.tabbedPanel.editPanel.EditPanelPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.TableProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 9/19/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class ShowCoinsTableView extends ViewComponent
{
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout layout;
    private FormLayout fl = new FormLayout();
    private TextField tf = new TextField("Date search:");
    @Inject
    @TableProperties(nullSelectionAllowed = false, pageLength = 11,
                     sizeFull = true,
                     immediate = true,
                     columnCollapsingAllowed = true,
                     columnReorderingAllowed = true,
                     selectable = true)
    private Table coinsTable;

    // **********************************************************************************
    public void init()
    {
        buildVerticalLayout();
        initColumns();
    }

    private VerticalLayout buildVerticalLayout()
    {
        setCompositionRoot(layout);

        tf = buildTextField();
        coinsTable = buildCoinsTable();

        layout.addComponent(fl);
        fl.addComponent(tf);
        layout.addComponent(coinsTable);

        return layout;
    }

    private TextField buildTextField()
    {
        tf.setSizeFull();

        // Filter table according to typed input
        tf.addTextChangeListener(new FieldEvents.TextChangeListener()
        {
            SimpleStringFilter filter = null;

            @Override
            public void textChange(FieldEvents.TextChangeEvent event)
            {
                Container.Filterable f = (Container.Filterable) coinsTable.getContainerDataSource();

                // Remove old filter
                if (filter != null)
                {
                    f.removeContainerFilter(filter);
                }
                // Set new filter for the "mint_Year" column
                filter = new SimpleStringFilter("mint_Year", event.getText(), true, false);

                f.addContainerFilter(filter);
            }

        });

        return tf;
    }

    private Table buildCoinsTable()
    {

        coinsTable.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                final ShowCoins showCoins = (ShowCoins) event.getProperty().getValue();
                if (showCoins != null)
                {
                    String s = "coinsTable";
                    fireViewEvent(RightPresenter.SHOW_EDIT_TAB_PANEL, null);
                    fireViewEvent(ShowCoinsPresenter.SHOW_COINS_SELECTED, null);
                    fireViewEvent(EditPanelPresenter.SET_TABLE_NAME, s);
                    fireViewEvent(EditPanelPresenter.SET_MAIN_TAB, null);
                    fireViewEvent(EditPanelPresenter.POPUP_DATE_FIELD_ENABLED, null);
//                    fireViewEvent(AccordionPresenter.DISABLE_DENOMINATION_SERIES_LIST, null);
                }
            }
        });

        return coinsTable;
    }

    private void initColumns()
    {
        coinsTable.removeAllItems();
        coinsTable.setContainerDataSource(new BeanItemContainer<>(ShowCoins.class));
        coinsTable.setVisibleColumns(CoinsContainer.NATURAL_COL_ORDER);
        coinsTable.setColumnHeaders(CoinsContainer.COL_HEADERS_ENGLISH);
    }

    // **********************************************************************************

    /**
     * Add entire Collection of beans to container. Data from database.
     * @param showCoins
     */
    public void setCoinsList(final Collection<ShowCoins> showCoins)
    {
        coinsTable.removeAllItems();
        for (final ShowCoins coin : showCoins)
        {
            coinsTable.addItem(coin);
        }
        coinsTable.sort();
    }

    public void setValue(final ShowCoins showCoins)
    {
        coinsTable.setValue(showCoins);
    }

    public Item getSelectedItem()
    {
        return coinsTable.getItem(coinsTable.getValue());
    }

    public void addCoinToList(final ShowCoins showCoins)
    {
        coinsTable.addItem(showCoins);
        coinsTable.sort();
    }
}
