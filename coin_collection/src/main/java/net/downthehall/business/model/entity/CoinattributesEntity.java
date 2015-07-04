package net.downthehall.business.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by joseph on 7/30/2014.
 */
@Entity
@javax.persistence.Table(name = "coinattributes", schema = "", catalog = "coincollection")
public class CoinattributesEntity
{
    private int coinAttributesId;
    private String catalogType;
    private Integer collectionId;
    private String composition;
    private String country;
    private String currentValue;
    private String denomination;
    private String denominationSeries;
    private String designer;
    private String diameter;
    private String edge;
    private String grade;
    private String gradeBy;
    private String metalContent;
    private String mint;
    private String mintMark;
    private String mintYear;
    private Integer mintageForCirculation;
    private Integer mintageOfProofs;
    private String purchaseDate;
    private String purchaseFrom;
    private String purchasePrice;
    private Integer quantity;
    private String serialNumber;
    private String soldDate;
    private String soldPrice;
    private String soldTo;
    private String thickness;
    private String notes;
    private String weight;
    private String quality;

    @Id
    @javax.persistence.Column(name = "COIN_ATTRIBUTES_ID", nullable = false, insertable = true, updatable = true)
    public int getCoinAttributesId()
    {
        return coinAttributesId;
    }

    public void setCoinAttributesId(int coinAttributesId)
    {
        this.coinAttributesId = coinAttributesId;
    }

    @Basic
    @javax.persistence.Column(name = "CATALOG_TYPE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCatalogType()
    {
        return catalogType;
    }

    public void setCatalogType(String catalogType)
    {
        this.catalogType = catalogType;
    }

    @Basic
    @javax.persistence.Column(name = "COLLECTION_ID", nullable = true, insertable = true, updatable = true)
    public Integer getCollectionId()
    {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId)
    {
        this.collectionId = collectionId;
    }

    @Basic
    @javax.persistence.Column(name = "COMPOSITION", nullable = true, insertable = true, updatable = true, length = 50)
    public String getComposition()
    {
        return composition;
    }

    public void setComposition(String composition)
    {
        this.composition = composition;
    }

    @Basic
    @javax.persistence.Column(name = "COUNTRY", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Basic
    @javax.persistence.Column(name = "CURRENT_VALUE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCurrentValue()
    {
        return currentValue;
    }

    public void setCurrentValue(String currentValue)
    {
        this.currentValue = currentValue;
    }

    @Basic
    @javax.persistence.Column(name = "DENOMINATION", nullable = true, insertable = true, updatable = true, length = 50)
    public String getDenomination()
    {
        return denomination;
    }

    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }

    @Basic
    @javax.persistence.Column(name = "DENOMINATION_SERIES", nullable = true, insertable = true, updatable = true,
                              length = 50)
    public String getDenominationSeries()
    {
        return denominationSeries;
    }

    public void setDenominationSeries(String denominationSeries)
    {
        this.denominationSeries = denominationSeries;
    }

    @Basic
    @javax.persistence.Column(name = "DESIGNER", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDesigner()
    {
        return designer;
    }

    public void setDesigner(String designer)
    {
        this.designer = designer;
    }

    @Basic
    @javax.persistence.Column(name = "DIAMETER", nullable = true, insertable = true, updatable = true, length = 50)
    public String getDiameter()
    {
        return diameter;
    }

    public void setDiameter(String diameter)
    {
        this.diameter = diameter;
    }

    @Basic
    @javax.persistence.Column(name = "EDGE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getEdge()
    {
        return edge;
    }

    public void setEdge(String edge)
    {
        this.edge = edge;
    }

    @Basic
    @javax.persistence.Column(name = "GRADE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    @Basic
    @javax.persistence.Column(name = "GRADE_BY", nullable = true, insertable = true, updatable = true, length = 50)
    public String getGradeBy()
    {
        return gradeBy;
    }

    public void setGradeBy(String gradeBy)
    {
        this.gradeBy = gradeBy;
    }

    @Basic
    @javax.persistence.Column(name = "METAL_CONTENT", nullable = true, insertable = true, updatable = true, length = 50)
    public String getMetalContent()
    {
        return metalContent;
    }

    public void setMetalContent(String metalContent)
    {
        this.metalContent = metalContent;
    }

    @Basic
    @javax.persistence.Column(name = "MINT", nullable = true, insertable = true, updatable = true, length = 50)
    public String getMint()
    {
        return mint;
    }

    public void setMint(String mint)
    {
        this.mint = mint;
    }

    @Basic
    @javax.persistence.Column(name = "MINT_MARK", nullable = true, insertable = true, updatable = true, length = 50)
    public String getMintMark()
    {
        return mintMark;
    }

    public void setMintMark(String mintMark)
    {
        this.mintMark = mintMark;
    }

    @Basic
    @javax.persistence.Column(name = "MINT_YEAR", nullable = true, insertable = true, updatable = true, length = 50)
    public String getMintYear()
    {
        return mintYear;
    }

    public void setMintYear(String mintYear)
    {
        this.mintYear = mintYear;
    }

    @Basic
    @javax.persistence.Column(name = "MINTAGE_FOR_CIRCULATION", nullable = true, insertable = true, updatable = true)
    public Integer getMintageForCirculation()
    {
        return mintageForCirculation;
    }

    public void setMintageForCirculation(Integer mintageForCirculation)
    {
        this.mintageForCirculation = mintageForCirculation;
    }

    @Basic
    @javax.persistence.Column(name = "MINTAGE_OF_PROOFS", nullable = true, insertable = true, updatable = true)
    public Integer getMintageOfProofs()
    {
        return mintageOfProofs;
    }

    public void setMintageOfProofs(Integer mintageOfProofs)
    {
        this.mintageOfProofs = mintageOfProofs;
    }

    @Basic
    @javax.persistence.Column(name = "PURCHASE_DATE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @javax.persistence.Column(name = "PURCHASE_FROM", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPurchaseFrom()
    {
        return purchaseFrom;
    }

    public void setPurchaseFrom(String purchaseFrom)
    {
        this.purchaseFrom = purchaseFrom;
    }

    @Basic
    @javax.persistence.Column(name = "PURCHASE_PRICE", nullable = true, insertable = true, updatable = true,
                              length = 50)
    public String getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    @Basic
    @javax.persistence.Column(name = "QUANTITY", nullable = true, insertable = true, updatable = true)
    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    @Basic
    @javax.persistence.Column(name = "SERIAL_NUMBER", nullable = true, insertable = true, updatable = true, length = 50)
    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    @Basic
    @javax.persistence.Column(name = "SOLD_DATE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getSoldDate()
    {
        return soldDate;
    }

    public void setSoldDate(String soldDate)
    {
        this.soldDate = soldDate;
    }

    @Basic
    @javax.persistence.Column(name = "SOLD_PRICE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getSoldPrice()
    {
        return soldPrice;
    }

    public void setSoldPrice(String soldPrice)
    {
        this.soldPrice = soldPrice;
    }

    @Basic
    @javax.persistence.Column(name = "SOLD_TO", nullable = true, insertable = true, updatable = true, length = 50)
    public String getSoldTo()
    {
        return soldTo;
    }

    public void setSoldTo(String soldTo)
    {
        this.soldTo = soldTo;
    }

    @Basic
    @javax.persistence.Column(name = "THICKNESS", nullable = true, insertable = true, updatable = true, length = 50)
    public String getThickness()
    {
        return thickness;
    }

    public void setThickness(String thickness)
    {
        this.thickness = thickness;
    }

    @Basic
    @javax.persistence.Column(name = "NOTES", nullable = true, insertable = true, updatable = true, length = 255)
    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    @Basic
    @javax.persistence.Column(name = "WEIGHT", nullable = true, insertable = true, updatable = true, length = 50)
    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    @Basic
    @javax.persistence.Column(name = "QUALITY", nullable = true, insertable = true, updatable = true, length = 50)
    public String getQuality()
    {
        return quality;
    }

    public void setQuality(String quality)
    {
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinattributesEntity that = (CoinattributesEntity) o;

        if (coinAttributesId != that.coinAttributesId) return false;
        if (catalogType != null ? !catalogType.equals(that.catalogType) : that.catalogType != null) return false;
        if (collectionId != null ? !collectionId.equals(that.collectionId) : that.collectionId != null) return false;
        if (composition != null ? !composition.equals(that.composition) : that.composition != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (currentValue != null ? !currentValue.equals(that.currentValue) : that.currentValue != null) return false;
        if (denomination != null ? !denomination.equals(that.denomination) : that.denomination != null) return false;
        if (denominationSeries != null ? !denominationSeries.equals(that.denominationSeries) :
            that.denominationSeries != null)
        {
            return false;
        }
        if (designer != null ? !designer.equals(that.designer) : that.designer != null) return false;
        if (diameter != null ? !diameter.equals(that.diameter) : that.diameter != null) return false;
        if (edge != null ? !edge.equals(that.edge) : that.edge != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (gradeBy != null ? !gradeBy.equals(that.gradeBy) : that.gradeBy != null) return false;
        if (metalContent != null ? !metalContent.equals(that.metalContent) : that.metalContent != null) return false;
        if (mint != null ? !mint.equals(that.mint) : that.mint != null) return false;
        if (mintMark != null ? !mintMark.equals(that.mintMark) : that.mintMark != null) return false;
        if (mintYear != null ? !mintYear.equals(that.mintYear) : that.mintYear != null) return false;
        if (mintageForCirculation != null ? !mintageForCirculation.equals(that.mintageForCirculation) :
            that.mintageForCirculation != null)
        {
            return false;
        }
        if (mintageOfProofs != null ? !mintageOfProofs.equals(that.mintageOfProofs) : that.mintageOfProofs != null)
        {
            return false;
        }
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;
        if (purchaseFrom != null ? !purchaseFrom.equals(that.purchaseFrom) : that.purchaseFrom != null) return false;
        if (purchasePrice != null ? !purchasePrice.equals(that.purchasePrice) : that.purchasePrice != null)
        {
            return false;
        }
        if (quality != null ? !quality.equals(that.quality) : that.quality != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (soldDate != null ? !soldDate.equals(that.soldDate) : that.soldDate != null) return false;
        if (soldPrice != null ? !soldPrice.equals(that.soldPrice) : that.soldPrice != null) return false;
        if (soldTo != null ? !soldTo.equals(that.soldTo) : that.soldTo != null) return false;
        if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    // **********************************************************************************

    @Override
    public int hashCode()
    {
        int result = coinAttributesId;
        result = 31 * result + (catalogType != null ? catalogType.hashCode() : 0);
        result = 31 * result + (collectionId != null ? collectionId.hashCode() : 0);
        result = 31 * result + (composition != null ? composition.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (currentValue != null ? currentValue.hashCode() : 0);
        result = 31 * result + (denomination != null ? denomination.hashCode() : 0);
        result = 31 * result + (denominationSeries != null ? denominationSeries.hashCode() : 0);
        result = 31 * result + (designer != null ? designer.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (edge != null ? edge.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (gradeBy != null ? gradeBy.hashCode() : 0);
        result = 31 * result + (metalContent != null ? metalContent.hashCode() : 0);
        result = 31 * result + (mint != null ? mint.hashCode() : 0);
        result = 31 * result + (mintMark != null ? mintMark.hashCode() : 0);
        result = 31 * result + (mintYear != null ? mintYear.hashCode() : 0);
        result = 31 * result + (mintageForCirculation != null ? mintageForCirculation.hashCode() : 0);
        result = 31 * result + (mintageOfProofs != null ? mintageOfProofs.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (purchaseFrom != null ? purchaseFrom.hashCode() : 0);
        result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (soldDate != null ? soldDate.hashCode() : 0);
        result = 31 * result + (soldPrice != null ? soldPrice.hashCode() : 0);
        result = 31 * result + (soldTo != null ? soldTo.hashCode() : 0);
        result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        return result;
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        coin_Attributes_Id, catalog_Type, collection_Id, composition, country,
        current_Value, denomination, denomination_Series, designer, diameter,
        edge, grade, grade_By, metal_Content, mint, mint_Mark, mint_Year,
        mintage_For_Circulation, mintage_Of_Proofs, purchase_Date, purchase_From,
        purchase_Price, quantity, serial_Number, sold_Date, sold_Price, sold_To,
        thickness, notes, weight, quality
    }
}
