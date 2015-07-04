package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by joseph on 5/17/2014.
 */
public class FindByName
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    // *********************************************************************** USER INPUT
    private String tableName = null; // Table Name
    private String columnId = null; // Column ID Name
    private String columnName = null; // Column Name

    // ******************************************************************************************
    public Collection<String> findByName()
    {
        Collection<String> list = new ArrayList<String>();
        try
        {
            conn = DBConnection.getInstance().connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT " + columnName + " FROM " + tableName + " ");
            while (rs.next())
            {
                list.add(rs.getString(columnName));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.getInstance().close(conn);
        }
        return list;
    }
    // ************************************************************** GETTERS AND SETTERS
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public void setColumnId(String columnId)
    {
        this.columnId = columnId;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
}
