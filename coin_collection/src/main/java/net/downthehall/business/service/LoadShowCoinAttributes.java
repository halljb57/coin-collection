package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/18/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoadShowCoinAttributes
{
    // ****************************************************** PRIVATE PROPERTIES
    private int collectionId;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************* PUBLIC PROPERTIES
    public void setCollectionId(int item)
    {
        this.collectionId = item;
    }

    // ************************************ DELETE COLLECTION_ID FROM SHOW_COIN_ATTRIBUTES
    public void deleteByCollection_Id()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_coin_attributes WHERE collection_id > 0;");
            int count = ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            updateCollection_Id();
        }
    }

    // ******* COPY COLLECTION_ID FROM COIN_ATTRIBUTES AND PASTE IT IN SHOW_COIN_ATTRIBUTES
    public void updateCollection_Id()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO show_coin_attributes SELECT * FROM coin_attributes WHERE collection_id = ?");
            ps.setInt(1, collectionId);
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
