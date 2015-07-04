package net.downthehall.business.service;


import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/18/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoadShowDenominations
{
    // ****************************************************** PRIVATE PROPERTIES
    private int countryId = 0;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************* PUBLIC PROPERTIES

    public void setCountryId(int item)
    {
        this.countryId = item;
//        System.out.println("From LoadShowDenominations CountryId: " + countryId);
    }

    // ************************************ DELETE COUNTRY_ID FROM SHOW DENOMINATIONS
    public void deleteByCountryId()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_denominations WHERE country_id > 0;");
            int count = ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            updateCountryId();
        }
    }

    // ******* COPY COUNTRY_ID FROM DENOMINATIONS AND PASTE IT IN SHOW DENOMINATIONS
    public void updateCountryId()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO show_denominations SELECT * FROM denominations WHERE country_id = ?");
            ps.setInt(1, countryId);
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }
}
