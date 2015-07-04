package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created by joseph on 5/15/2014.
 */
public class LoadShowServices
{
    // ****************************************************** PRIVATE PROPERTIES
    private int id = 0; // Your item ID
    private String columnId = null; // Column ID Name
    private String mainTableName = null; // Main Table Name
    private String showTableName = null; // Show Table Name
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    // ************************************ DELETE TABLE_ID FROM SHOW_TABLE
    public void deleteTable_Id()
    {
//        System.out.println("\n" + "From LoadShowServices ");
//        System.out.println("mainTableName " + mainTableName);
//        System.out.println("showTableName " + showTableName);
//        System.out.println("id " + id);
//        System.out.println("columnId " + columnId);

    try
    {

        conn = DBConnection.getInstance().connect();
            ps = conn.prepareStatement("DELETE FROM "+ showTableName +" WHERE "+ columnId +" > 0;");
            int count = ps.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            DBConnection.getInstance().close(conn);
            UpDateTableId();
        }
    }
    // ******* COPY TABLE_ID FROM MAIN TABLE AND PASTE IT IN SHOW_TABLE
    private void UpDateTableId()
    {
        try
        {
            conn = DBConnection.getInstance().connect();
            ps = conn.prepareStatement("INSERT INTO "+ showTableName +" SELECT * FROM "+mainTableName+" WHERE "+ columnId +" = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            DBConnection.getInstance().close(conn);
        }
    }
    // ******************************************************* SETTERS

    /**
     * User variable
     * @param item
     */
    public void setId(int item)
    {
        this.id = item;
//        System.out.println("From LoadShowServices id " + id);
    }

    /**
     * Set column to the database table
     * @param item
     */
    public void setColumnId(String item)
    {
        this.columnId = item;
//        System.out.println("From LoadShowServices id " + id);
    }
    /**
     * Set database table name
     * @param item
     */
    public void setMainTableName(String item)
    {
        this.mainTableName = item;
//        System.out.println("From LoadShowServices mainTableName " + mainTableName);
    }
    /**
     * Set database table name
     * @param item
     */
    public void setShowTableName(String item)
    {
        this.showTableName = item;
//        System.out.println("From LoadShowServices showTableName " + showTableName);
    }

}
