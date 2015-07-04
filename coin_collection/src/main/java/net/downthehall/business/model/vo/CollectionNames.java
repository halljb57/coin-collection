package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionNames implements Serializable
{
    private static final long serialVersionUID = -3311655072265078399L;

    int collection_Id;
    String collection_Name;
    int country_Id;
    String comments;
    String date_Created;

    public CollectionNames(int collection_Id, String collection_Name, int country_Id, String comments,
                           String date_Created)
    {
        this.collection_Id = collection_Id;
        this.collection_Name = collection_Name;
        this.country_Id = country_Id;
        this.comments = comments;
        this.date_Created = date_Created;
    }

    public CollectionNames()
    {
    }

    public int getCollection_Id()
    {
        return collection_Id;
    }

    public void setCollection_Id(int collection_Id)
    {
        this.collection_Id = collection_Id;
    }

    public String getCollection_Name()
    {
        return collection_Name;
    }

    public void setCollection_Name(String collection_Name)
    {
        this.collection_Name = collection_Name;
    }

    public int getCountry_Id()
    {
        return country_Id;
    }

    public void setCountry_Id(int country_Id)
    {
        this.country_Id = country_Id;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public String getDate_Created()
    {
        return date_Created;
    }

    public void setDate_Created(String date_Created)
    {
        this.date_Created = date_Created;
    }

    @Override
    public String toString()
    {
        return "CollectionNames{" +
               "collection_Id=" + collection_Id +
               ", collection_Name='" + collection_Name + '\'' +
               ", country_Id=" + country_Id +
               ", comments='" + comments + '\'' +
               ", date_Created='" + date_Created + '\'' +
               '}';
    }
}
