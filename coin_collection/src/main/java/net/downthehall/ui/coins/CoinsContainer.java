package net.downthehall.ui.coins;

import com.vaadin.data.util.BeanItemContainer;
import net.downthehall.business.model.vo.Coins;

import java.io.Serializable;

/**
 * Created by joseph on 9/19/2014.
 */
public class CoinsContainer extends BeanItemContainer<Coins> implements Serializable
{
    /**
     * Natural property order for Coins bean. Used in tables and forms.
     */
    public static final Object[] NATURAL_COL_ORDER = new Object[]{
            Coins.Fields.mint_Year.name(),
            Coins.Fields.mintage_For_Circulation.name(),
            Coins.Fields.mintage_Of_Proofs.name(),
            Coins.Fields.mint_Mark.name(),
            Coins.Fields.designer.name(),
            Coins.Fields.diameter.name(),
            Coins.Fields.metal_Content.name(),
            Coins.Fields.weight.name(),
            Coins.Fields.edge.name(),
            Coins.Fields.notes.name(),

            /* Coins.Fields.coin_Id.name(),
            Coins.Fields.mint_Year.name(),
            Coins.Fields.mintage_For_Circulation.name(),
            Coins.Fields.mintage_Of_Proofs.name(),
            Coins.Fields.denominations_Id.name(),
            Coins.Fields.denomination_Series_Id.name(),
            Coins.Fields.mint_Mark.name(),
            Coins.Fields.designer.name(),
            Coins.Fields.diameter.name(),
            Coins.Fields.metal_Content.name(),
            Coins.Fields.weight.name(),
            Coins.Fields.edge.name(),
            Coins.Fields.notes.name(), */
    };
    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static final String[] COL_HEADERS_ENGLISH = new String[]{
            "Mint Year", "Mintage For Circulation", "Mintage Of Proofs",
            "Mint Mark", "Designer",  "Diameter", "Metal Content", "Weight",
            "Edge", "Notes"

            /* "Coin Id", "Mint Year", "Mintage For Circulation", "Mintage Of Proofs",
            "Denominations Id", "Denomination Series Id", "Mint Mark", "Designer",
            "Diameter", "Metal Content", "Weight", "Edge", "Notes" */
    };
    private static final long serialVersionUID = -224949705284684128L;

    public CoinsContainer(Class<? super Coins> type) throws IllegalArgumentException
    {
        super(type);
    }
}
