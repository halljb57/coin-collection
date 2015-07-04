package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.Coins;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<Coins> findAll()
    {
        List<Coins> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coins");
            while (rs.next())
            {
                coinsList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coinsList;
    }

    // ******************************************************************************************
    public List<String> findByName()
    {
        List<String> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coins");
            while (rs.next())
            {
                coinsList.add(rs.getString("country"));
                System.out.println("Name ID is " + rs.getInt("country_Id"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coinsList;
    }

    // ******************************************************************************************
    public Coins create(Coins coins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO coins (" +
                    "mint_Year, mintage_For_Circulation, mintage_Of_Proofs, denominations_Id, " +
                    "denomination_Series_Id, mint_Mark, designer, " +
                    "diameter, metal_Content, weight, edge, notes) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, coins.getMint_Year());
            ps.setInt(2, coins.getMintage_For_Circulation());
            ps.setInt(3, coins.getMintage_Of_Proofs());
            ps.setInt(4, coins.getDenominations_Id());
            ps.setInt(5, coins.getDenomination_Series_Id());
            ps.setString(6, coins.getMint_Mark());
            ps.setString(7, coins.getDesigner());
            ps.setString(8, coins.getDiameter());
            ps.setString(9, coins.getMetal_Content());
            ps.setString(10, coins.getWeight());
            ps.setString(11, coins.getEdge());
            ps.setString(12, coins.getNotes());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            coins.setCoin_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coins;
    }

    // ******************************************************************************************
    public Coins update(Coins coins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE coins SET mint_Year=?, mintage_For_Circulation=?, mintage_Of_Proofs=?, " +
                    "denominations_Id=?, denomination_Series_Id=?, mint_Mark=?, designer=?, " +
                    "diameter=?, metal_Content=?, weight=?, edge=?, notes=?" +
                    "WHERE coin_Id=?");
            ps.setString(1, coins.getMint_Year());
            ps.setInt(2, coins.getMintage_For_Circulation());
            ps.setInt(3, coins.getMintage_Of_Proofs());
            ps.setInt(4, coins.getDenominations_Id());
            ps.setInt(5, coins.getDenomination_Series_Id());
            ps.setString(6, coins.getMint_Mark());
            ps.setString(7, coins.getDesigner());
            ps.setString(8, coins.getDiameter());
            ps.setString(9, coins.getMetal_Content());
            ps.setString(10, coins.getWeight());
            ps.setString(11, coins.getEdge());
            ps.setString(12, coins.getNotes());

            ps.setInt(13, coins.getCoin_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return coins;
    }

    // ******************************************************************************************
    public boolean remove(Coins coins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM coins WHERE coin_Id=?");
            ps.setInt(1, coins.getCoin_Id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }

    // ******************************************************************************************
    protected Coins processRow(ResultSet rs) throws SQLException
    {
        Coins coins = new Coins();
        coins.setCoin_Id(rs.getInt("coin_Id"));
        coins.setMint_Year(rs.getString("mint_Year"));
        coins.setMintage_For_Circulation(rs.getInt("mintage_For_Circulation"));
        coins.setMintage_Of_Proofs(rs.getInt("mintage_Of_Proofs"));
        coins.setDenominations_Id(rs.getInt("denominations_Id"));
        coins.setDenomination_Series_Id(rs.getInt("denomination_Series_Id"));
        coins.setMint_Mark(rs.getString("mint_Mark"));
        coins.setDesigner(rs.getString("designer"));
        coins.setDiameter(rs.getString("diameter"));
        coins.setMetal_Content(rs.getString("metal_Content"));
        coins.setWeight(rs.getString("weight"));
        coins.setEdge(rs.getString("edge"));
        coins.setNotes(rs.getString("notes"));
        return coins;
    }
}
