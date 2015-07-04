package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.CoinAttributesTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by joseph on 8/1/2014.
 */
public class CoinAttributesTableService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public Collection<CoinAttributesTable> findAll()
    {
        Collection<CoinAttributesTable> coinAttributesList = new ArrayList<>();
        try
        {
            conn = DBConnection.getInstance().connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coinAttributesTable");
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
    public Collection<String> findByName()
    {
        Collection<String> coinAttributesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT selected FROM coinAttributesTable");
            while (rs.next())
            {
                coinAttributesList.add(String.valueOf(rs.getBoolean("selected")));
                //coinAttributesList.add(rs.getString("coinAttributesId"));
                //coinAttributesList.add(rs.getString("country"));
//                System.out.println("Name " + rs.getString("column_Header"));
                /*if (rs.getBoolean("selected") != false)
                {
                    System.out.println("This is true " + rs.getBoolean("selected"));
//                    coinAttributesList.add(String.valueOf(rs.getBoolean("selected")));
                }
                else
                {
//                    System.out.println("This is false " + rs.getBoolean("selected"));
//                    coinAttributesList.add(String.valueOf(rs.getBoolean("selected")));
                }*/
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
    public CoinAttributesTable create(CoinAttributesTable coinAttributesTable)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO coinAttributesTable (" +
                    "column_Order, column_Header, selected) VALUES (?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, coinAttributesTable.getColumn_Order());
            ps.setString(2, coinAttributesTable.getColumn_Header());
            ps.setBoolean(3, coinAttributesTable.getSelected());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            coinAttributesTable.setTable_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Saved!!! ");
        }
        return coinAttributesTable;
    }

    // ******************************************************************************************
    public CoinAttributesTable update(CoinAttributesTable coinAttributesTable)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE coinAttributesTable SET column_Order=?, column_Header=?, selected=? WHERE table_Id=?");
            ps.setString(1, coinAttributesTable.getColumn_Order());
            ps.setString(2, coinAttributesTable.getColumn_Header());
            ps.setBoolean(3, coinAttributesTable.getSelected());

            ps.setInt(4, coinAttributesTable.getTable_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
//            System.out.println("\n" + "Data Updated Table_Id " + coinAttributesTable.getCoin_Attributes_Id());
        }
        return coinAttributesTable;
    }

    // ******************************************************************************************
    public boolean remove(CoinAttributesTable coinAttributesTable)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM coinAttributesTable WHERE coin_Attributes_Id=?");
            ps.setInt(1, coinAttributesTable.getTable_Id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Deleted Table_Id " + coinAttributesTable.getTable_Id());
        }
    }

    // ******************************************************************************************

    // ******************************************************************************************
    protected CoinAttributesTable processRow(ResultSet rs) throws SQLException
    {
        CoinAttributesTable coinAttributesTable = new CoinAttributesTable();
        coinAttributesTable.setTable_Id(rs.getInt("table_Id"));
        coinAttributesTable.setColumn_Order(rs.getString("column_Order"));
        coinAttributesTable.setColumn_Header(rs.getString("column_Header"));
        coinAttributesTable.setSelected(rs.getBoolean("selected"));

        return coinAttributesTable;
    }

    public CoinAttributesTable persist(CoinAttributesTable coinAttributesTable)
    {
        return null;
    }
}
