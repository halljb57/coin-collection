package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.CountryNames;

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
public class CountryNamesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<CountryNames> findAll()
    {
        List<CountryNames> countryNamesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM country_names");
            while (rs.next())
            {
                countryNamesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return countryNamesList;
    }

    // ******************************************************************************************
    public List<String> findByName()
    {
        List<String> countryNamesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM country_names");
            while (rs.next())
            {
                countryNamesList.add(rs.getString("country"));
                System.out.println("Name ID is " + rs.getInt("country_Id"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return countryNamesList;
    }

    // ******************************************************************************************

    /**
     * Get a list of condition objects
     *
     * @return countryList
     */
    public List<String> findCountry()
    {
        List<String> countryList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT country FROM coin_attributes");
            while (rs.next())
            {
                countryList.add(rs.getString("country"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return countryList;
    }

    // ******************************************************************************************
    public CountryNames create(CountryNames countryNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO country_names (country) VALUES (?)",
                                       new String[]{"ID"});
            ps.setString(1, countryNames.getCountry());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            countryNames.setCountry_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return countryNames;
    }

    // ******************************************************************************************
    public CountryNames update(CountryNames countryNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("UPDATE country_names SET country=? WHERE country_Id=?");
            ps.setString(1, countryNames.getCountry());

            ps.setInt(2, countryNames.getCountry_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return countryNames;
    }

    // ******************************************************************************************
    public boolean remove(CountryNames countryNames)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM country_names WHERE country_Id=?");
            ps.setInt(1, countryNames.getCountry_Id());
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
    protected CountryNames processRow(ResultSet rs) throws SQLException
    {
        CountryNames countryNames = new CountryNames();
        countryNames.setCountry_Id(rs.getInt("country_Id"));
        countryNames.setCountry(rs.getString("country"));
        return countryNames;
    }
}
