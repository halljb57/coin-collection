package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.ShowCoins;

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
public class ShowCoinsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<ShowCoins> findAll()
    {
        List<ShowCoins> coinsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_coins");
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
            rs = stmt.executeQuery("SELECT * FROM show_coins");
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
    public ShowCoins create(ShowCoins showCoins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO showCoins (" +
                    "mint_Year, mintage_For_Circulation, mintage_Of_Proofs, denominations_Id, " +
                    "denomination_Series_Id, mint_Mark, designer, " +
                    "diameter, metal_Content, weight, edge, notes) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, showCoins.getMint_Year());
            ps.setInt(2, showCoins.getMintage_For_Circulation());
            ps.setInt(3, showCoins.getMintage_Of_Proofs());
            ps.setInt(4, showCoins.getDenominations_Id());
            ps.setInt(5, showCoins.getDenomination_Series_Id());
            ps.setString(6, showCoins.getMint_Mark());
            ps.setString(7, showCoins.getDesigner());
            ps.setString(8, showCoins.getDiameter());
            ps.setString(9, showCoins.getMetal_Content());
            ps.setString(10, showCoins.getWeight());
            ps.setString(11, showCoins.getEdge());
            ps.setString(12, showCoins.getNotes());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            showCoins.setCoin_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showCoins;
    }

    // ******************************************************************************************
    public ShowCoins update(ShowCoins showCoins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE showCoins SET mint_Year=?, mintage_For_Circulation=?, mintage_Of_Proofs=?, " +
                    "denominations_Id=?, denomination_Series_Id=?, mint_Mark=?, designer=?, " +
                    "diameter=?, metal_Content=?, weight=?, edge=?, notes=?" +
                    "WHERE coin_Id=?");
            ps.setString(1, showCoins.getMint_Year());
            ps.setInt(2, showCoins.getMintage_For_Circulation());
            ps.setInt(3, showCoins.getMintage_Of_Proofs());
            ps.setInt(4, showCoins.getDenominations_Id());
            ps.setInt(5, showCoins.getDenomination_Series_Id());
            ps.setString(6, showCoins.getMint_Mark());
            ps.setString(7, showCoins.getDesigner());
            ps.setString(8, showCoins.getDiameter());
            ps.setString(9, showCoins.getMetal_Content());
            ps.setString(10, showCoins.getWeight());
            ps.setString(11, showCoins.getEdge());
            ps.setString(12, showCoins.getNotes());

            ps.setInt(13, showCoins.getCoin_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showCoins;
    }

    // ******************************************************************************************
    public boolean remove(ShowCoins showCoins)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_coins WHERE coin_Id=?");
            ps.setInt(1, showCoins.getCoin_Id());
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
    protected ShowCoins processRow(ResultSet rs) throws SQLException
    {
        ShowCoins showCoins = new ShowCoins();
        showCoins.setCoin_Id(rs.getInt("coin_Id"));
        showCoins.setMint_Year(rs.getString("mint_Year"));
        showCoins.setMintage_For_Circulation(rs.getInt("mintage_For_Circulation"));
        showCoins.setMintage_Of_Proofs(rs.getInt("mintage_Of_Proofs"));
        showCoins.setDenominations_Id(rs.getInt("denominations_Id"));
        showCoins.setDenomination_Series_Id(rs.getInt("denomination_Series_Id"));
        showCoins.setMint_Mark(rs.getString("mint_Mark"));
        showCoins.setDesigner(rs.getString("designer"));
        showCoins.setDiameter(rs.getString("diameter"));
        showCoins.setMetal_Content(rs.getString("metal_Content"));
        showCoins.setWeight(rs.getString("weight"));
        showCoins.setEdge(rs.getString("edge"));
        showCoins.setNotes(rs.getString("notes"));
        return showCoins;
    }
}
