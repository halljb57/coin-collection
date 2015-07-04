package net.downthehall.ui.coinattributes;

import com.vaadin.data.util.BeanItemContainer;
import net.downthehall.business.model.vo.CoinAttributes;

import java.io.Serializable;

/**
 * Created by joseph on 8/6/2014.
 */
public class CoinAttributesContainer extends BeanItemContainer<CoinAttributes> implements Serializable
{
    /**
     * Natural property order for CoinAttributes bean. Used in tables and forms.
     */
    /*CoinAttributes.Fields.coin_Attributes_Id.name(),*/
    public static final Object[] NATURAL_COL_ORDER = new Object[]{
            CoinAttributes.Fields.catalog_Type.name(),
            CoinAttributes.Fields.collection_Id.name(),
            CoinAttributes.Fields.composition.name(),
            CoinAttributes.Fields.country.name(),
            CoinAttributes.Fields.current_Value.name(),
            CoinAttributes.Fields.denomination.name(),
            CoinAttributes.Fields.denomination_Series.name(),
            CoinAttributes.Fields.designer.name(),
            CoinAttributes.Fields.diameter.name(),
            CoinAttributes.Fields.edge.name(),
            CoinAttributes.Fields.grade.name(),
            CoinAttributes.Fields.grade_By.name(),
            CoinAttributes.Fields.metal_Content.name(),
            CoinAttributes.Fields.mint.name(),
            CoinAttributes.Fields.mint_Mark.name(),
            CoinAttributes.Fields.mint_Year.name(),
            CoinAttributes.Fields.mintage_For_Circulation.name(),
            CoinAttributes.Fields.mintage_Of_Proofs.name(),
            CoinAttributes.Fields.purchase_Date.name(),
            CoinAttributes.Fields.purchase_From.name(),
            CoinAttributes.Fields.purchase_Price.name(),
            CoinAttributes.Fields.quantity.name(),
            CoinAttributes.Fields.serial_Number.name(),
            CoinAttributes.Fields.sold_Date.name(),
            CoinAttributes.Fields.sold_Price.name(),
            CoinAttributes.Fields.sold_To.name(),
            CoinAttributes.Fields.thickness.name(),
            CoinAttributes.Fields.notes.name(),
            CoinAttributes.Fields.weight.name(),
            CoinAttributes.Fields.quality.name()
    };
    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    /*Coin Attributes Id*/
    public static final String[] COL_HEADERS_ENGLISH = new String[]{
            "Catalog Type", "Collection Id", "Composition", "Country",
            "Current Value", "Denomination", "Denomination Series", "Designer", "Diameter",
            "Edge", "Grade", "Grade By", "Metal Content", "Mint", "Mint Mark",
            "Mint Year", "Mintage For Circulation", "Mintage Of Proofs", "Purchase Date",
            "Purchase From", "Purchase Price", "Quantity", "Serial Number",
            "Sold Date", "Sold Price", "Sold To", "Thickness",
            "Notes", "Weight", "Quality"};
    private static final long serialVersionUID = 7308844922963416385L;

    public CoinAttributesContainer(Class<? super CoinAttributes> type) throws IllegalArgumentException
    {
        super(type);
    }
}
