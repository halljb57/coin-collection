package net.downthehall.ui.tabbedPanel.createPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import net.downthehall.business.model.vo.CoinAttributes;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.FormLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.GridLayoutProperties;

import javax.inject.Inject;

/**
 * Created by joseph on 8/2/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class ItemDetailForm extends ViewComponent
{
    @PropertyId("coin_Attributes_Id")
    private TextField coinAttributesId;
    @PropertyId("collection_Id")
    private TextField collectionId;
    @PropertyId("country")
    private TextField country;
    @PropertyId("current_Value")
    private TextField currentValue;
    @PropertyId("mintage_For_Circulation")
    private TextField mintageForCirculation;
    @PropertyId("mintage_Of_Proofs")
    private TextField mintageOfProofs;
    @PropertyId("quantity")
    private TextField quantity;
    @PropertyId("denomination")
    private TextField denomination;
    @PropertyId("mint_Year")
    private TextField mintYear;
    @PropertyId("denomination_Series")
    private TextField denominationSeries;
    @Inject
    @FormLayoutProperties(margin = true)
    private FormLayout leftForm, rightForm;
    @Inject
    @GridLayoutProperties(columns = 2)
    private GridLayout gridLayout;

    // Initialize Class
    public void init()
    {
        buildGridLayout();
    }

    // Initialize Build-HorizontalLayout
    private GridLayout buildGridLayout()
    {
        setCompositionRoot(gridLayout);
        setSizeFull();

        leftForm = buildLeftForm();
        rightForm = buildRightForm();

        gridLayout.addComponent(leftForm, 0, 0);
        gridLayout.addComponent(rightForm, 1, 0);

        return gridLayout;
    }

    // Initialize Build-Left-Form
    private FormLayout buildLeftForm()
    {
        coinAttributesId = new TextField();
        collectionId = new TextField("Collection");
        country = new TextField("Country");
        denomination = new TextField("Denomination");
        mintageForCirculation = new TextField("Mintage For Circulation");
        mintageOfProofs = new TextField("Mintage Of Proofs");

        leftForm.addComponent(collectionId);
        leftForm.addComponent(country);
        leftForm.addComponent(denomination);
        leftForm.addComponent(mintageForCirculation);
        leftForm.addComponent(mintageOfProofs);

        return leftForm;
    }

    // Initialize Build-Right-Form
    private FormLayout buildRightForm()
    {
        mintYear = new TextField("Mint Year");
        currentValue = new TextField("Current Value");
        quantity = new TextField("quantity");
        denominationSeries = new TextField("Denomination Series");

        rightForm.addComponent(mintYear);
        rightForm.addComponent(currentValue);
        rightForm.addComponent(quantity);
        rightForm.addComponent(denominationSeries);

        return rightForm;
    }

    // **********************************************************************************
    public void setItemDataSource(final Item newDataSource)
    {
        if (newDataSource != null)
        {
            FieldGroup fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);

            CoinAttributes coinAttributes = new CoinAttributes();
            coinAttributes.setCoin_Attributes_Id(Integer.parseInt(coinAttributesId.getValue()));
            coinAttributes.setCollection_Id(Integer.parseInt(collectionId.getValue()));
            coinAttributes.setCountry(country.getValue());
            coinAttributes.setDenomination(denomination.getValue());
            coinAttributes.setMintage_For_Circulation(Integer.parseInt(mintageForCirculation.getValue()));
            coinAttributes.setMintage_Of_Proofs(Integer.parseInt(mintageOfProofs.getValue()));
            coinAttributes.setMint_Year(mintYear.getValue());
            coinAttributes.setCurrent_Value(currentValue.getValue());
            coinAttributes.setQuantity(Integer.parseInt(quantity.getValue()));
            coinAttributes.setDenomination_Series(denominationSeries.getValue());
        }
    }

    /*private CoinAttributes loadCoinAttributes(ShowCoinAttributes showCoinAttributes)
    {
        CoinAttributes coinattributes = new CoinAttributes();
        coinattributes.setCoin_Attributes_Id(showCoinAttributes.getCoin_Attributes_Id());
        coinattributes.setCatalog_Type(showCoinAttributes.getCatalog_Type());
        coinattributes.setCollection_Id(showCoinAttributes.getCollection_Id());
        coinattributes.setComposition(showCoinAttributes.getComposition());
        coinattributes.setCountry(showCoinAttributes.getCountry());
        coinattributes.setCurrent_Value(showCoinAttributes.getCurrent_Value());
        coinattributes.setDenomination(showCoinAttributes.getDenomination());
        coinattributes.setDenomination_Series(showCoinAttributes.getDenomination_Series());
        coinattributes.setDesigner(showCoinAttributes.getDesigner());
        coinattributes.setDiameter(showCoinAttributes.getDiameter());
        coinattributes.setEdge(showCoinAttributes.getEdge());
        coinattributes.setGrade(showCoinAttributes.getGrade());
        coinattributes.setGrade_By(showCoinAttributes.getGrade_By());
        coinattributes.setMetal_Content(showCoinAttributes.getMetal_Content());
        coinattributes.setMint(showCoinAttributes.getMint());
        coinattributes.setMint_Mark(showCoinAttributes.getMint_Mark());
        coinattributes.setMint_Year(showCoinAttributes.getMint_Year());
        coinattributes.setMintage_For_Circulation(showCoinAttributes.getMintage_For_Circulation());
        coinattributes.setMintage_Of_Proofs(showCoinAttributes.getMintage_Of_Proofs());
        coinattributes.setPurchase_Date(showCoinAttributes.getPurchase_Date());
        coinattributes.setPurchase_From(showCoinAttributes.getPurchase_From());
        coinattributes.setPurchase_Price(showCoinAttributes.getPurchase_Price());
        coinattributes.setSerial_Number(showCoinAttributes.getSerial_Number());
        coinattributes.setSold_Date(showCoinAttributes.getSold_Date());
        coinattributes.setSold_Price(showCoinAttributes.getSold_Price());
        coinattributes.setSold_To(showCoinAttributes.getSold_To());
        coinattributes.setThickness(showCoinAttributes.getThickness());
        coinattributes.setNotes(showCoinAttributes.getNotes());
        coinattributes.setWeight(showCoinAttributes.getWeight());
        coinattributes.setQuality(showCoinAttributes.getQuality());
        return coinattributes;
    }*/

    // **********************************************************************************
    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

        leftForm.setReadOnly(readOnly);
        rightForm.setReadOnly(readOnly);
    }
}
