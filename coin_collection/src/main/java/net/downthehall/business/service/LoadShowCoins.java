package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/18/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoadShowCoins
{
    // ****************************************************** PRIVATE PROPERTIES
    private int denominationsId;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************* PUBLIC PROPERTIES
    public void setDenominationId(int item)
    {
        this.denominationsId = item;
        System.out.println("From LoadShowCoins denominationsId " + denominationsId);
    }

    // ************************************ DELETE DENOMINATIONS_ID FROM SHOW_COINS
    public void deleteByDenominationId()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_coins WHERE denominations_id > 0;");
            int count = ps.executeUpdate();
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

    // ******* COPY DENOMINATIONS_ID FROM COINS AND PASTE IT IN SHOW_COINS
    public void updateDenominationId()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO show_coins SELECT * FROM coins WHERE denominations_id = ?");
            ps.setInt(1, denominationsId);
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
