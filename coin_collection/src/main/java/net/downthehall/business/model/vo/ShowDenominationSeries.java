package net.downthehall.business.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowDenominationSeries
{
    private int denomination_Series_Id;
    private String denomination_Series;
    private int denominations_Id;

    public ShowDenominationSeries()
    {
    }

    public ShowDenominationSeries(int denomination_Series_Id, String denomination_Series, int denominations_Id)
    {
        this.denomination_Series_Id = denomination_Series_Id;
        this.denomination_Series = denomination_Series;
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

    public String getDenomination_Series()
    {
        return denomination_Series;
    }

    public void setDenomination_Series(String denomination_Series)
    {
        this.denomination_Series = denomination_Series;
    }

    public int getDenominations_Id()
    {
        return denominations_Id;
    }

    public void setDenominations_Id(int denominations_Id)
    {
        this.denominations_Id = denominations_Id;
    }
}
