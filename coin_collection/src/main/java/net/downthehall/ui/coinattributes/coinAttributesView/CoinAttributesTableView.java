package net.downthehall.ui.coinattributes.coinAttributesView;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.ui.coinattributes.CoinAttributesContainer;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.TableProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 7/30/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class CoinAttributesTableView extends ViewComponent
{
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
    @VerticalLayoutProperties
    private VerticalLayout layout;
    private Item selectedItem;

    // **********************************************************************************
    public void init()
    {
        buildCoinsTable();
        initColumns();
    }

    private Table buildCoinsTable()
    {
        setCompositionRoot(caTable);

        caTable.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                final CoinAttributes coinAttributes = (CoinAttributes) event.getProperty().getValue();
                if (coinAttributes != null)
                {
//                    fireViewEvent(RightPresenter.SET_TABLE_NAME, null);
                    fireViewEvent(CoinAttributesPresenter.COIN_ATTRIBUTE_SELECTED, coinAttributes);
                }
            }
        });
        setReadOnly(true);

        return caTable;
    }

    private void initColumns()
    {
        caTable.setContainerDataSource(new BeanItemContainer<CoinAttributes>(CoinAttributes.class));
        caTable.setVisibleColumns(CoinAttributesContainer.NATURAL_COL_ORDER);
        caTable.setColumnCollapsed("catalog_Type", true);
        caTable.setColumnCollapsed("collection_Id", true);
        caTable.setColumnHeaders(CoinAttributesContainer.COL_HEADERS_ENGLISH);
    }

    // **********************************************************************************
    public void setCoinattributesList(final Collection<CoinAttributes> coinattribute)
    {
        caTable.removeAllItems();
        for (final CoinAttributes coinattributes : coinattribute)
        {
            caTable.addItem(coinattributes);
        }
        caTable.sort();
    }

    public void setValue(final CoinAttributes coinAttributes)
    {
        caTable.setValue(coinAttributes);
    }

    public Item getSelectedItem()
    {
        return caTable.getItem(caTable.getValue());
    }

    public void addCoinAttributeToList(final CoinAttributes coinAttributes)
    {
        caTable.addItem(coinAttributes);
        caTable.sort();
    }

    // **********************************************************************************
    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);
        caTable.setReadOnly(readOnly);
    }
}
