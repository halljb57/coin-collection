package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/18/13
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoadShowDenominationSeries
{
    // ****************************************************** PRIVATE PROPERTIES
    private int denominationsId = 0;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************* PUBLIC PROPERTIES
    public void setDenominationId(int item)
    {
        this.denominationsId = item;
    }

    // ************************************ DELETE DENOMINATIONS_ID FROM SHOW DENOMINATIONS
    public void deleteByDenominationId()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_denomination_series WHERE denominations_id > 0;");
            int count = ps.executeUpdate();
            //System.out.println("From deleteRow Java - denominations_id " + denominationsId);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            updateDenominationId();
        }
    }

    // ******* COPY DENOMINATIONS_ID FROM DENOMINATIONS AND PASTE IT IN SHOW DENOMINATIONS
    public void updateDenominationId()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO show_denomination_series SELECT * FROM denomination_series WHERE denominations_id = ?");
            ps.setInt(1, denominationsId);
            ps.executeUpdate();
            //System.out.println("From updateRowNumber Java - denominations_id " + denominationsId);
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
