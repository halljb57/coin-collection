package net.downthehall.business.service;


import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created by joseph on 5/16/2014.
 */
public class FindIdByNameService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    // *********************************************************************** USER INPUT
    private int id;
    private String tableName;
    private String columnId;
    private String columnName;
    private String newName; // Your Variable

    // ******************************************************************************************
    public void findIdByName()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE " + columnName + " = ?");
            ps.setString(1, newName);// Your Variable
            rs = ps.executeQuery();

            rs.next();
            setId(rs.getInt(columnId));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            DBConnection.getInstance().close(conn);

//            System.out.println("\n" + "From FindIdByNameService ");
//            System.out.println("tableName " + tableName);
//            System.out.println("columnId " + columnId);
//            System.out.println("columnName " + columnName);
//            System.out.println("newName " + newName);
//            System.out.println("collection Id " + getId());
        }
    }

    // ************************************************************** GETTERS AND SETTERS
    public void setId(int item)
    {
        this.id = item;
    }

    public int getId()
    {
        return id;
    }

    public void setColumnId(String item)
    {
        this.columnId = item;
    }

    public void setTableName(String item)
    {
        this.tableName = item;
    }

    public void setColumnName(String item)
    {
        this.columnName = item;
    }

    public String getNewName()
    {
        return newName;
    }

    public void setNewName(String newName)
    {
        this.newName = newName;
    }

}
