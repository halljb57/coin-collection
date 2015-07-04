package net.downthehall.ui.tabbedPanel;

import com.vaadin.ui.TextField;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.CoinAttributesService;

/**
 * Created by joseph on 8/8/2014.
 */
public class SaveCoinAttributes
{
    private static SaveCoinAttributes instance = null;
    protected SaveCoinAttributes()
    {
        // Exists only to defeat instantiation.
    }
    public static SaveCoinAttributes getInstance()
    {
        if(instance == null)
        {
            instance = new SaveCoinAttributes();
        }
        return instance;
    }

    // **********************************************************************************
    private CoinAttributes coinAttributes = new CoinAttributes();
    private CoinAttributesService service = new CoinAttributesService();

    // **********************************************************************************
    private TextField collectionId;
    private TextField country;
    private TextField currentValue;
    private String mintageForCirculation;
    private String mintageOfProofs;
    private TextField quantity;
    private TextField denomination;
    private String mintYear;
    private TextField denominationSeries;
    private String grade;
    private String gradeBy;
    private String serialNumber;
    private String quality;
    private String catalogType;
    private String metalContent;
    private String mintMark;
    private TextField mint;
    private String diameter;
    private String weight;
    private TextField thickness;
    private TextField composition;
    private String edge;
    private TextField designer;
    private String notes;
    private String soldDate;
    private TextField soldTo;
    private TextField soldPrice;
    private TextField purchaseFrom;
    private String purchaseDate;
    private TextField purchasePrice;

    // **********************************************************************************
    public void saveItemDetail(TextField country, TextField denomination, String mintageForCirculation,
                               String mintageOfProofs, String mintYear, TextField denominationSeries)
    {
        this.country = country;
        this.mintageForCirculation = mintageForCirculation;
        this.mintageOfProofs = mintageOfProofs;
        this.denomination = denomination;
        this.mintYear = mintYear;
        this.denominationSeries = denominationSeries;
    }

    public void saveMoreDetail(String grade, String gradeBy, String serialNumber, String quality,
                                 String catalogType, String metalContent, String mintMark,
                                 String diameter, String weight, String edge, String notes)
    {
        this.grade = grade;
        this.gradeBy = gradeBy;
        this.serialNumber = serialNumber;
        this.quality = quality;
        this.catalogType = catalogType;
        this.metalContent = metalContent;
        this.mintMark = mintMark;
        this.diameter = diameter;
        this.weight = weight;
        this.edge = edge;
        this.notes = notes;
    }

    public void saveBuyAndSell(TextField soldTo, TextField soldPrice,
                                 TextField purchaseFrom, TextField purchasePrice)
    {
        this.soldTo = soldTo;
        this.soldPrice = soldPrice;
        this.purchaseFrom = purchaseFrom;
        this.purchasePrice = purchasePrice;
    }

    // **********************************************************************************
    public void save()
    {
        try
        {
            coinAttributes.setCollection_Id(Integer.parseInt(collectionId.getValue()));
            coinAttributes.setCountry(country.getValue());
            coinAttributes.setDenomination(denomination.getValue());
            coinAttributes.setMintage_For_Circulation(Integer.parseInt(mintageForCirculation));
            coinAttributes.setMintage_Of_Proofs(Integer.parseInt(mintageOfProofs));
            coinAttributes.setMint_Year(mintYear);
            coinAttributes.setCurrent_Value(currentValue.getValue());
            coinAttributes.setQuantity(Integer.parseInt(quantity.getValue()));
            coinAttributes.setDenomination_Series(denominationSeries.getValue());
            coinAttributes.setGrade(grade);
            coinAttributes.setGrade_By(gradeBy);
            coinAttributes.setSerial_Number(serialNumber);
            coinAttributes.setQuality(quality);
            coinAttributes.setMetal_Content(metalContent);
            coinAttributes.setMint_Mark(mintMark);
            coinAttributes.setMint(mint.getValue());
            coinAttributes.setCatalog_Type(catalogType);
            coinAttributes.setDiameter(diameter);
            coinAttributes.setWeight(weight);
            coinAttributes.setThickness(thickness.getValue());
            coinAttributes.setComposition(composition.getValue());
            coinAttributes.setEdge(edge);
            coinAttributes.setDesigner(designer.getValue());
            coinAttributes.setNotes(notes);
            coinAttributes.setSold_Date(soldDate);
            coinAttributes.setSold_Price(soldPrice.getValue());
            coinAttributes.setSold_To(soldTo.getValue());
            coinAttributes.setPurchase_Date(purchaseDate);
            coinAttributes.setPurchase_From(purchaseFrom.getValue());
            coinAttributes.setPurchase_Price(purchasePrice.getValue());
        }
        catch (NullPointerException e)
        {
        }

        service.create(coinAttributes);
    }

    public void setMintageForCirculation(String mintageForCirculation)
    {
        this.mintageForCirculation = mintageForCirculation;
    }

    public void setMintageOfProofs(String mintageOfProofs)
    {
        this.mintageOfProofs = mintageOfProofs;
    }

    public void setMintYear(String mintYear)
    {
        this.mintYear = mintYear;
    }

    public void setMintMark(String mintMark)
    {
        this.mintMark = mintMark;
    }

    public void setDiameter(String diameter)
    {
        this.diameter = diameter;
    }

    public void setMetalContent(String metalContent)
    {
        this.metalContent = metalContent;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public void setEdge(String edge)
    {
        this.edge = edge;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
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

    public void setCollectionId(TextField collectionId)
    {
        this.collectionId = collectionId;
    }

    public void setCountry(TextField country)
    {
        this.country = country;
    }

    public void setCurrentValue(TextField currentValue)
    {
        this.currentValue = currentValue;
    }

    public void setQuantity(TextField quantity)
    {
        this.quantity = quantity;
    }

    public void setDenomination(TextField denomination)
    {
        this.denomination = denomination;
    }

    public void setDenominationSeries(TextField denominationSeries)
    {
        this.denominationSeries = denominationSeries;
    }

    public void setMint(TextField mint)
    {
        this.mint = mint;
    }

    public void setThickness(TextField thickness)
    {
        this.thickness = thickness;
    }

    public void setComposition(TextField composition)
    {
        this.composition = composition;
    }

    public void setDesigner(TextField designer)
    {
        this.designer = designer;
    }

    public void setSoldDate(String soldDate)
    {
        this.soldDate = soldDate;
    }

    public void setSoldTo(TextField soldTo)
    {
        this.soldTo = soldTo;
    }

    public void setSoldPrice(TextField soldPrice)
    {
        this.soldPrice = soldPrice;
    }

    public void setPurchaseFrom(TextField purchaseFrom)
    {
        this.purchaseFrom = purchaseFrom;
    }

    public void setPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(TextField purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
}
