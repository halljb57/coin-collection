package net.downthehall.ui.coins.coinsView;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import net.downthehall.business.model.vo.Coins;
import net.downthehall.ui.coins.CoinsContainer;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.TableProperties;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 9/19/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class CoinsTableView extends ViewComponent
{
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
        buildCoinsTable();
        initColumns();
    }

    private Table buildCoinsTable()
    {
        setCompositionRoot(coinsTable);
        coinsTable.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                final Coins coins = (Coins) event.getProperty().getValue();
                if (coins != null)
                {
                    Notification.show("Denominations_Id - " + String.valueOf(coins.getDenominations_Id()));
                }
            }
        });

        return coinsTable;
    }

    private void initColumns()
    {
        coinsTable.setContainerDataSource(new BeanItemContainer<>(Coins.class));
        coinsTable.setVisibleColumns(CoinsContainer.NATURAL_COL_ORDER);
        coinsTable.setColumnHeaders(CoinsContainer.COL_HEADERS_ENGLISH);
    }

    // **********************************************************************************
    public void setCoinsList(final Collection<Coins> coins)
    {
        coinsTable.removeAllItems();
        for (final Coins coin : coins)
        {
            coinsTable.addItem(coin);
        }
        coinsTable.sort();
    }

    public void setValue(final Coins coins)
    {
        coinsTable.setValue(coins);
    }

    public Item getSelectedItem()
    {
        return coinsTable.getItem(coinsTable.getValue());
    }

    public void addCoinToList(final Coins coins)
    {
        coinsTable.addItem(coins);
        coinsTable.sort();
    }
}
