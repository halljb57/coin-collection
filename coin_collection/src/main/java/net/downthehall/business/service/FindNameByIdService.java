package net.downthehall.business.service;


import net.downthehall.business.db.DBConnection;

import java.sql.*;

/**
 * Created by joseph on 5/16/2014.
 */
public class FindNameByIdService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    // *********************************************************************** USER INPUT
    private int id; // Your Variable
    private String tableName;
    private String columnId;
    private String columnName;
    private String newName; // Your Variable
    // ******************************************************************************************
    public void findNameById()
    {
        try
        {
            conn = DBConnection.getInstance().connect();
            ps = conn.prepareStatement("SELECT * FROM "+tableName+" WHERE "+columnId+" = ?");
            ps.setInt(1, id);// Your Variable
            rs = ps.executeQuery();

            rs.next();

            setNewName(rs.getString(columnName));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            DBConnection.getInstance().close(conn);

//            System.out.println("\n" + "From FindNameByIdService ");
//            System.out.println("tableName " + tableName);
//            System.out.println("columnId " + columnId);
//            System.out.println("columnName " + columnName);
//            System.out.println("newName " + newName);
//            System.out.println("collection Id " + id);
        }
    }
    // ************************************************************** GETTERS AND SETTERS
    public void setId(int item)
    {
        this.id = item;
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
