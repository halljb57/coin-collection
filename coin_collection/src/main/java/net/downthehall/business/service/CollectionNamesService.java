package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.CollectionNames;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionNamesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    private String collectionName;

    // ******************************************************************************************
    public List<CollectionNames> findAll()
    {
        List<CollectionNames> collectionNamesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM collection_names");
            while (rs.next())
            {
                collectionNamesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return collectionNamesList;
    }

    // ******************************************************************************************
    public String findIdByName()
    {
        int newID;
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM collection_names WHERE collection_Name = ?");
            ps.setString(1, getCollectionName());
            rs = ps.executeQuery();
            rs.next();
            newID = rs.getInt("collection_Id");
            System.out.println("collection_ID " + rs.getInt("collection_Id"));
            //System.out.println("collection_Names " + rs.getString("collection_Name"));
//            CoinAttributesModel.getInstance().setCollectionId(String.valueOf(rs.getInt("collection_Id")));
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return String.valueOf(newID);
    }

    // ******************************************************************************************

    /**
     * Get a list of condition objects
     *
     * @return countryList
     */
    public List<String> findCollection()
    {
        List<String> collectionList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT collection_Name FROM collection_names");
            while (rs.next())
            {
                collectionList.add(rs.getString("collection_Name"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return collectionList;
    }

    // ******************************************************************************************
    public CollectionNames create(CollectionNames collectionNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO collection_names (" +
                    "collection_Name, country_Id, comments, date_Created) " +
                    "VALUES (?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, collectionNames.getCollection_Name());
            ps.setInt(2, collectionNames.getCountry_Id());
            ps.setString(3, collectionNames.getComments());
            ps.setString(4, collectionNames.getDate_Created());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            collectionNames.setCollection_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("Saving now");
        }
        return collectionNames;
    }

    // ******************************************************************************************
    public CollectionNames update(CollectionNames collectionNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE collection_names SET collection_Name=?, country_Id=?, comments=?, date_Created=?" +
                    "WHERE collection_Id=?");
            ps.setString(1, collectionNames.getCollection_Name());
            ps.setInt(2, collectionNames.getCountry_Id());
            ps.setString(3, collectionNames.getComments());
            ps.setString(4, collectionNames.getDate_Created());

            ps.setInt(5, collectionNames.getCollection_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return collectionNames;
    }

    // ******************************************************************************************
    public boolean remove(CollectionNames collectionNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM collection_names WHERE collection_Id=?");
            ps.setInt(1, collectionNames.getCollection_Id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }

    // ******************************************************************************************
    protected CollectionNames processRow(ResultSet rs) throws SQLException
    {
        CollectionNames collectionNames = new CollectionNames();
        collectionNames.setCollection_Id(rs.getInt("collection_Id"));
        collectionNames.setCollection_Name(rs.getString("collection_Name"));
        collectionNames.setCountry_Id(rs.getInt("country_Id"));
        collectionNames.setComments(rs.getString("comments"));
        collectionNames.setDate_Created(rs.getString("date_Created"));
        return collectionNames;
    }

    public String getCollectionName()
    {
        return collectionName;
    }

    public void setCollectionName(String collectionName)
    {
        this.collectionName = collectionName;
    }
}
