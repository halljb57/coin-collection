package net.downthehall.business.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowCoins
{
    private int coin_Id;
    private String mint_Year;
    private int mintage_For_Circulation;
    private int mintage_Of_Proofs;
    private int denominations_Id;
    private int denomination_Series_Id;
    private String mint_Mark;
    private String designer;
    private String diameter;
    private String metal_Content;
    private String weight;
    private String edge;
    private String notes;

    public ShowCoins()
    {
    }

    public ShowCoins(int coin_Id, String mint_Year, int mintage_For_Circulation, int mintage_Of_Proofs,
                     int denominations_Id, int denomination_Series_Id, String mint_Mark, String designer,
                     String diameter, String metal_Content, String weight, String edge, String notes)
    {
        this.coin_Id = coin_Id;
        this.mint_Year = mint_Year;
        this.mintage_For_Circulation = mintage_For_Circulation;
        this.mintage_Of_Proofs = mintage_Of_Proofs;
        this.denominations_Id = denominations_Id;
        this.denomination_Series_Id = denomination_Series_Id;
        this.mint_Mark = mint_Mark;
        this.designer = designer;
        this.diameter = diameter;
        this.metal_Content = metal_Content;
        this.weight = weight;
        this.edge = edge;
        this.notes = notes;
    }

    // **********************************************************************************
    public boolean isPersistent()
    {
        return coin_Id != 0;
    }

    // **********************************************************************************
    public int getCoin_Id()
    {
        return coin_Id;
    }

    public void setCoin_Id(int coin_Id)
    {
        this.coin_Id = coin_Id;
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

    public int getDenominations_Id()
    {
        return denominations_Id;
    }

    public void setDenominations_Id(int denominations_Id)
    {
        this.denominations_Id = denominations_Id;
    }

    public int getDenomination_Series_Id()
    {
        return denomination_Series_Id;
    }

    public void setDenomination_Series_Id(int denomination_Series_Id)
    {
        this.denomination_Series_Id = denomination_Series_Id;
    }

    public String getMint_Mark()
    {
        return mint_Mark;
    }

    public void setMint_Mark(String mint_Mark)
    {
        this.mint_Mark = mint_Mark;
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

    public String getMetal_Content()
    {
        return metal_Content;
    }

    public void setMetal_Content(String metal_Content)
    {
        this.metal_Content = metal_Content;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getEdge()
    {
        return edge;
    }

    public void setEdge(String edge)
    {
        this.edge = edge;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    @Override
    public String toString()
    {
        return "ShowCoins{" +
               "coin_Id=" + coin_Id +
               ", mint_Year='" + mint_Year + '\'' +
               ", mintage_For_Circulation=" + mintage_For_Circulation +
               ", mintage_Of_Proofs=" + mintage_Of_Proofs +
               ", denominations_Id=" + denominations_Id +
               ", denomination_Series_Id=" + denomination_Series_Id +
               ", mint_Mark='" + mint_Mark + '\'' +
               ", designer='" + designer + '\'' +
               ", diameter='" + diameter + '\'' +
               ", metal_Content='" + metal_Content + '\'' +
               ", weight='" + weight + '\'' +
               ", edge='" + edge + '\'' +
               ", notes='" + notes + '\'' +
               '}';
    }

    // **********************************************************************************
    // Fields are listed here for type-safety
    public enum Fields
    {
        coin_Id, mint_Year, mintage_For_Circulation, mintage_Of_Proofs,
        denominations_Id, denomination_Series_Id, mint_Mark, designer, diameter,
        metal_Content, weight, edge, notes
    }
}
