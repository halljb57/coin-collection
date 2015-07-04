package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.ShowCoinAttributesTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by joseph on 8/1/2014.
 */
public class ShowCoinAttributesTableService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public Collection<ShowCoinAttributesTable> findAll()
    {
        Collection<ShowCoinAttributesTable> coinAttributesList = new ArrayList<>();
        try
        {
            conn = DBConnection.getInstance().connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM showCoinAttributesTable");
            while (rs.next())
            {
                coinAttributesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.getInstance().close(conn);
        }
        return coinAttributesList;
    }

    // ******************************************************************************************
    public Collection<String> findColumnOrder()
    {
        Collection<String> coinAttributesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM showCoinAttributesTable");
            while (rs.next())
            {
                coinAttributesList.add(String.valueOf(rs.getString("column_Order")));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coinAttributesList;
    }

    // ******************************************************************************************
    public Collection<String> findColumnHeader()
    {
        Collection<String> coinAttributesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM showCoinAttributesTable");
            while (rs.next())
            {
                coinAttributesList.add(String.valueOf(rs.getString("column_Header")));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coinAttributesList;
    }

    // ******************************************************************************************
    public void deleteAllTrue()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM showCoinAttributesTable WHERE selected != false ");
            int count = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            DBConnection.close(conn);
            updateTable();
        }
    }

    private void updateTable()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO showCoinAttributesTable SELECT * FROM coinAttributesTable WHERE selected = ?");
            ps.setBoolean(1, true);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }

    // ******************************************************************************************
    public ShowCoinAttributesTable create(ShowCoinAttributesTable showCoinAttributesTable)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO showCoinAttributesTable (" +
                    "column_Order, column_Header, selected) VALUES (?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, showCoinAttributesTable.getColumn_Order());
            ps.setString(2, showCoinAttributesTable.getColumn_Header());
            ps.setBoolean(3, showCoinAttributesTable.getSelected());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            showCoinAttributesTable.setTable_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Saved!!! ");
        }
        return showCoinAttributesTable;
    }

    // ******************************************************************************************
    public ShowCoinAttributesTable update(ShowCoinAttributesTable showCoinAttributesTable)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE showCoinAttributesTable SET column_Order=?, column_Header=?, selected=? WHERE table_Id=?");
            ps.setString(1, showCoinAttributesTable.getColumn_Order());
            ps.setString(2, showCoinAttributesTable.getColumn_Header());
            ps.setBoolean(3, showCoinAttributesTable.getSelected());

            ps.setInt(4, showCoinAttributesTable.getTable_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
//            System.out.println("\n" + "Data Updated Table_Id " + showCoinAttributesTable.getCoin_Attributes_Id());
        }
        return showCoinAttributesTable;
    }

    // ******************************************************************************************
    public boolean remove(ShowCoinAttributesTable showCoinAttributesTable)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM showCoinAttributesTable WHERE coin_Attributes_Id=?");
            ps.setInt(1, showCoinAttributesTable.getTable_Id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Deleted Table_Id " + showCoinAttributesTable.getTable_Id());
        }
    }

    // ******************************************************************************************

    // ******************************************************************************************
    protected ShowCoinAttributesTable processRow(ResultSet rs) throws SQLException
    {
        ShowCoinAttributesTable showCoinAttributesTable = new ShowCoinAttributesTable();
        showCoinAttributesTable.setTable_Id(rs.getInt("table_Id"));
        showCoinAttributesTable.setColumn_Order(rs.getString("column_Order"));
        showCoinAttributesTable.setColumn_Header(rs.getString("column_Header"));
        showCoinAttributesTable.setSelected(rs.getBoolean("selected"));

        return showCoinAttributesTable;
    }

    public ShowCoinAttributesTable persist(ShowCoinAttributesTable showCoinAttributesTable)
    {
        return null;
    }
}
