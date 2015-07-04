package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowCoinAttributes implements Serializable
{
    private static final long serialVersionUID = 8380537492219057024L;

    int coin_Attributes_Id;
    String catalog_Type;
    int collection_Id;
    String composition;
    String country;
    String current_Value;
    String denomination;
    String denomination_Series;
    String designer;
    String diameter;
    String edge;
    String grade;
    String grade_By;
    String metal_Content;
    String mint;
    String mint_Mark;
    String mint_Year;
    int mintage_For_Circulation;
    int mintage_Of_Proofs;
    String purchase_Date;
    String purchase_From;
    String purchase_Price;
    int quantity;
    String serial_Number;
    String sold_Date;
    String sold_Price;
    String sold_To;
    String thickness;
    String notes;
    String weight;
    String quality;

    public ShowCoinAttributes()
    {
    }

    public ShowCoinAttributes(int coin_Attributes_Id, String catalog_Type, int collection_Id, String composition,
                              String country, String current_Value, String denomination, String denomination_Series,
                              String designer, String diameter, String edge, String grade, String grade_By,
                              String metal_Content, String mint, String mint_Mark, String mint_Year,
                              int mintage_For_Circulation, int mintage_Of_Proofs, String purchase_Date,
                              String purchase_From, String purchase_Price, int quantity, String serial_Number,
                              String sold_Date, String sold_Price, String sold_To, String thickness, String notes,
                              String weight, String quality)
    {
        this.coin_Attributes_Id = coin_Attributes_Id;
        this.catalog_Type = catalog_Type;
        this.collection_Id = collection_Id;
        this.composition = composition;
        this.country = country;
        this.current_Value = current_Value;
        this.denomination = denomination;
        this.denomination_Series = denomination_Series;
        this.designer = designer;
        this.diameter = diameter;
        this.edge = edge;
        this.grade = grade;
        this.grade_By = grade_By;
        this.metal_Content = metal_Content;
        this.mint = mint;
        this.mint_Mark = mint_Mark;
        this.mint_Year = mint_Year;
        this.mintage_For_Circulation = mintage_For_Circulation;
        this.mintage_Of_Proofs = mintage_Of_Proofs;
        this.purchase_Date = purchase_Date;
        this.purchase_From = purchase_From;
        this.purchase_Price = purchase_Price;
        this.quantity = quantity;
        this.serial_Number = serial_Number;
        this.sold_Date = sold_Date;
        this.sold_Price = sold_Price;
        this.sold_To = sold_To;
        this.thickness = thickness;
        this.notes = notes;
        this.weight = weight;
        this.quality = quality;
    }

    public boolean isPersistent()
    {
        return coin_Attributes_Id != 0;
    }
    // **********************************************************************************

    public int getCoin_Attributes_Id()
    {
        return coin_Attributes_Id;
    }

    public void setCoin_Attributes_Id(int coin_Attributes_Id)
    {
        this.coin_Attributes_Id = coin_Attributes_Id;
    }

    public String getCatalog_Type()
    {
        return catalog_Type;
    }

    public void setCatalog_Type(String catalog_Type)
    {
        this.catalog_Type = catalog_Type;
    }

    public int getCollection_Id()
    {
        return collection_Id;
    }

    public void setCollection_Id(int collection_Id)
    {
        this.collection_Id = collection_Id;
    }

    public String getComposition()
    {
        return composition;
    }

    public void setComposition(String composition)
    {
        this.composition = composition;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCurrent_Value()
    {
        return current_Value;
    }

    public void setCurrent_Value(String current_Value)
    {
        this.current_Value = current_Value;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }

    public String getDenomination_Series()
    {
        return denomination_Series;
    }

    public void setDenomination_Series(String denomination_Series)
    {
        this.denomination_Series = denomination_Series;
    }

    public String getDesigner()
    {
        return designer;
    }

    public void setDesigner(String designer)
    {
        this.designer = designer;
    }

    public String getDiameter()
    {
        return diameter;
    }

    public void setDiameter(String diameter)
    {
        this.diameter = diameter;
    }

    public String getEdge()
    {
        return edge;
    }

    public void setEdge(String edge)
    {
        this.edge = edge;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade_By()
    {
        return grade_By;
    }

    public void setGrade_By(String grade_By)
    {
        this.grade_By = grade_By;
    }

    public String getMetal_Content()
    {
        return metal_Content;
    }

    public void setMetal_Content(String metal_Content)
    {
        this.metal_Content = metal_Content;
    }

    public String getMint()
    {
        return mint;
    }

    public void setMint(String mint)
    {
        this.mint = mint;
    }

    public String getMint_Mark()
    {
        return mint_Mark;
    }

    public void setMint_Mark(String mint_Mark)
    {
        this.mint_Mark = mint_Mark;
    }

    public String getMint_Year()
    {
        return mint_Year;
    }

    public void setMint_Year(String mint_Year)
    {
        this.mint_Year = mint_Year;
    }

    public int getMintage_For_Circulation()
    {
        return mintage_For_Circulation;
    }

    public void setMintage_For_Circulation(int mintage_For_Circulation)
    {
        this.mintage_For_Circulation = mintage_For_Circulation;
    }

    public int getMintage_Of_Proofs()
    {
        return mintage_Of_Proofs;
    }

    public void setMintage_Of_Proofs(int mintage_Of_Proofs)
    {
        this.mintage_Of_Proofs = mintage_Of_Proofs;
    }

    public String getPurchase_Date()
    {
        return purchase_Date;
    }

    public void setPurchase_Date(String purchase_Date)
    {
        this.purchase_Date = purchase_Date;
    }

    public String getPurchase_From()
    {
        return purchase_From;
    }

    public void setPurchase_From(String purchase_From)
    {
        this.purchase_From = purchase_From;
    }

    public String getPurchase_Price()
    {
        return purchase_Price;
    }

    public void setPurchase_Price(String purchase_Price)
    {
        this.purchase_Price = purchase_Price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getSerial_Number()
    {
        return serial_Number;
    }

    public void setSerial_Number(String serial_Number)
    {
        this.serial_Number = serial_Number;
    }

    public String getSold_Date()
    {
        return sold_Date;
    }

    public void setSold_Date(String sold_Date)
    {
        this.sold_Date = sold_Date;
    }

    public String getSold_Price()
    {
        return sold_Price;
    }

    public void setSold_Price(String sold_Price)
    {
        this.sold_Price = sold_Price;
    }

    public String getSold_To()
    {
        return sold_To;
    }

    public void setSold_To(String sold_To)
    {
        this.sold_To = sold_To;
    }

    public String getThickness()
    {
        return thickness;
    }

    public void setThickness(String thickness)
    {
        this.thickness = thickness;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getQuality()
    {
        return quality;
    }

    public void setQuality(String quality)
    {
        this.quality = quality;
    }

    @Override
    public String toString()
    {
        return "ShowCoinAttributes{" +
               "coin_Attributes_Id=" + coin_Attributes_Id +
               ", catalog_Type='" + catalog_Type + '\'' +
               ", collection_Id=" + collection_Id +
               ", composition='" + composition + '\'' +
               ", country='" + country + '\'' +
               ", current_Value='" + current_Value + '\'' +
               ", denomination='" + denomination + '\'' +
               ", denomination_Series='" + denomination_Series + '\'' +
               ", designer='" + designer + '\'' +
               ", diameter='" + diameter + '\'' +
               ", edge='" + edge + '\'' +
               ", grade='" + grade + '\'' +
               ", grade_By='" + grade_By + '\'' +
               ", metal_Content='" + metal_Content + '\'' +
               ", mint='" + mint + '\'' +
               ", mint_Mark='" + mint_Mark + '\'' +
               ", mint_Year='" + mint_Year + '\'' +
               ", mintage_For_Circulation=" + mintage_For_Circulation +
               ", mintage_Of_Proofs=" + mintage_Of_Proofs +
               ", purchase_Date='" + purchase_Date + '\'' +
               ", purchase_From='" + purchase_From + '\'' +
               ", purchase_Price='" + purchase_Price + '\'' +
               ", quantity=" + quantity +
               ", serial_Number='" + serial_Number + '\'' +
               ", sold_Date='" + sold_Date + '\'' +
               ", sold_Price='" + sold_Price + '\'' +
               ", sold_To='" + sold_To + '\'' +
               ", thickness='" + thickness + '\'' +
               ", notes='" + notes + '\'' +
               ", weight='" + weight + '\'' +
               ", quality='" + quality + '\'' +
               '}';
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
