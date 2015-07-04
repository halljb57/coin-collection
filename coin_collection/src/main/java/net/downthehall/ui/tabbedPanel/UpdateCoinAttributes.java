package net.downthehall.ui.tabbedPanel;

import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.CoinAttributesService;
import net.downthehall.util.ConvertStringAndNumber;

/**
 * Created by joseph on 8/8/2014.
 */
public class UpdateCoinAttributes
{
    private static UpdateCoinAttributes instance = null;
    private int _mintageForCirculation;
    private int _mintageOfProofs;
    private ConvertStringAndNumber convert;

    protected UpdateCoinAttributes()
    {
        // Exists only to defeat instantiation.
    }
    public static UpdateCoinAttributes getInstance()
    {
        if(instance == null)
        {
            instance = new UpdateCoinAttributes();
        }
        return instance;
    }

    private CoinAttributes coinAttributes = new CoinAttributes();
    private CoinAttributesService service = new CoinAttributesService();

    private String coinAttributesId;
    private TextField collectionId;
    private TextField country;
    private TextField currentValue;
    private TextField mintageForCirculation;
    private TextField mintageOfProofs;
    private TextField quantity;
    private TextField denomination;
    private TextField mintYear;
    private TextField denominationSeries;
    private String grade;
    private String gradeBy;
    private String serialNumber;
    private String quality;
    private String catalogType;
    private TextField metalContent;
    private TextField mintMark;
    private TextField mint;
    private TextField diameter;
    private TextField weight;
    private TextField thickness;
    private TextField composition;
    private TextField edge;
    private TextField designer;
    private TextArea notes;
    private String soldDate;
    private TextField soldTo;
    private TextField soldPrice;
    private TextField purchaseFrom;
    private String purchaseDate;
    private TextField purchasePrice;

    public void updateItemDetail(String coinAttributesId, TextField collectionId, TextField country,
                                 TextField denomination, TextField mintageForCirculation,
                                 TextField mintageOfProofs, TextField currentValue,  TextField quantity,
                                 TextField mintYear, TextField denominationSeries)
    {
        this.coinAttributesId = coinAttributesId;
        this.collectionId = collectionId;
        this.country = country;
        this.currentValue = currentValue;
        this.mintageForCirculation = mintageForCirculation;
        this.mintageOfProofs = mintageOfProofs;
        this.quantity = quantity;
        this.denomination = denomination;
        this.mintYear = mintYear;
        this.denominationSeries = denominationSeries;
    }

    public void updateMoreDetail(String grade, String gradeBy, String serialNumber, String quality,
                                 String catalogType, TextField metalContent, TextField mintMark,
                                 TextField mint, TextField diameter, TextField weight, TextField thickness,
                                 TextField composition, TextField edge, TextField designer, TextArea notes)
    {
        this.grade = grade;
        this.gradeBy = gradeBy;
        this.serialNumber = serialNumber;
        this.quality = quality;
        this.catalogType = catalogType;
        this.metalContent = metalContent;
        this.mintMark = mintMark;
        this.mint = mint;
        this.diameter = diameter;
        this.weight = weight;
        this.thickness = thickness;
        this.composition = composition;
        this.edge = edge;
        this.designer = designer;
        this.notes = notes;
    }

    public void updateBuyAndSell(TextField soldTo, TextField soldPrice,
                                 TextField purchaseFrom, TextField purchasePrice)
    {
        this.soldTo = soldTo;
        this.soldPrice = soldPrice;
        this.purchaseFrom = purchaseFrom;
        this.purchasePrice = purchasePrice;
    }

    public void update()
    {
        numberFormat();
        changeData();
        service.update(coinAttributes);
    }

    public void delete()
    {
        numberFormat();
        changeData();
        service.remove(coinAttributes);
    }

    private void changeData()
    {
        try
        {
        coinAttributes.setCoin_Attributes_Id(Integer.parseInt(coinAttributesId));
        coinAttributes.setCollection_Id(Integer.parseInt(collectionId.getValue()));
        coinAttributes.setCountry(country.getValue());
        coinAttributes.setDenomination(denomination.getValue());
        coinAttributes.setMintage_For_Circulation(_mintageForCirculation);
        coinAttributes.setMintage_Of_Proofs(_mintageOfProofs);
        coinAttributes.setMint_Year(mintYear.getValue());
        coinAttributes.setCurrent_Value(currentValue.getValue());
        coinAttributes.setQuantity(Integer.parseInt(quantity.getValue()));
        coinAttributes.setDenomination_Series(denominationSeries.getValue());
        coinAttributes.setGrade(grade);
        coinAttributes.setGrade_By(gradeBy);
        coinAttributes.setSerial_Number(serialNumber);
        coinAttributes.setQuality(quality);
        coinAttributes.setMetal_Content(metalContent.getValue());
        coinAttributes.setMint_Mark(mintMark.getValue());
        coinAttributes.setMint(mint.getValue());
        coinAttributes.setCatalog_Type(catalogType);
        coinAttributes.setDiameter(diameter.getValue());
        coinAttributes.setWeight(weight.getValue());
        coinAttributes.setThickness(thickness.getValue());
        coinAttributes.setComposition(composition.getValue());
        coinAttributes.setEdge(edge.getValue());
        coinAttributes.setDesigner(designer.getValue());
        coinAttributes.setNotes(notes.getValue());
        coinAttributes.setSold_Date(soldDate);
        coinAttributes.setSold_Price(soldPrice.getValue());
        coinAttributes.setSold_To(soldTo.getValue());
        coinAttributes.setPurchase_Date(purchaseDate);
        coinAttributes.setPurchase_From(purchaseFrom.getValue());
        coinAttributes.setPurchase_Price(purchasePrice.getValue());
        }
        catch (NullPointerException e)
        {}
    }

    private void numberFormat()
    {
        convert = new ConvertStringAndNumber();
        convert.setCharString(mintageForCirculation.getValue());
        set_mintageForCirculation(convert.removeSpecialCharacters());

        convert = new ConvertStringAndNumber();
        convert.setCharString(mintageOfProofs.getValue());
        set_mintageOfProofs(convert.removeSpecialCharacters());
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public void setGradeBy(String gradeBy)
    {
        this.gradeBy = gradeBy;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public void setQuality(String quality)
    {
        this.quality = quality;
    }

    public void setCatalogType(String catalogType)
    {
        this.catalogType = catalogType;
    }

    public void set_mintageForCirculation(int _mintageForCirculation)
    {
        this._mintageForCirculation = _mintageForCirculation;
    }

    public void set_mintageOfProofs(int _mintageOfProofs)
    {
        this._mintageOfProofs = _mintageOfProofs;
    }

    public void setSoldDate(String soldDate)
    {
        this.soldDate = soldDate;
    }

    public void setPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }
}
