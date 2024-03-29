package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountryNames implements Serializable
{
    private static final long serialVersionUID = -8697558710484736376L;
    int country_Id;
    String country;

    public CountryNames(int country_Id, String country)
    {
        this.country_Id = country_Id;
        this.country = country;
    }

    public CountryNames()
    {

    }

    public int getCountry_Id()
    {
        return country_Id;
    }

    public void setCountry_Id(int country_Id)
    {
        this.country_Id = country_Id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "CountryNames{" +
               "country_Id=" + country_Id +
               ", country='" + country + '\'' +
               '}';
    }
}
