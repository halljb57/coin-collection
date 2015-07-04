package net.downthehall.business.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowDenominations
{
    private int denominations_Id;
    private String denomination;
    private int country_Id;

    public ShowDenominations()
    {
    }

    public ShowDenominations(int denominations_Id, String denomination, int country_Id)
    {
        this.denominations_Id = denominations_Id;
        this.denomination = denomination;
        this.country_Id = country_Id;
    }

    public int getDenominations_Id()
    {
        return denominations_Id;
    }

    public void setDenominations_Id(int denominations_Id)
    {
        this.denominations_Id = denominations_Id;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }

    public int getCountry_Id()
    {
        return country_Id;
    }

    public void setCountry_Id(int country_Id)
    {
        this.country_Id = country_Id;
    }
}
