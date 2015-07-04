package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.ShowDenominationSeries;

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
public class ShowDenominationsSeriesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private int denominationSeries_Id;

    // ******************************************************************************************
    public List<ShowDenominationSeries> findAll()
    {
        List<ShowDenominationSeries> denominationSeriesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_denomination_series");
            while (rs.next())
            {
                denominationSeriesList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationSeriesList;
    }

    // ******************************************************************************************
    public void findNameById()
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM show_denomination_series WHERE denomination_Series_Id = ?");
            ps.setInt(1, getDenominationSeries_Id());
            rs = ps.executeQuery();
            //System.out.println("\n" + "From DenominationsSeriesService Denomination_Series_Id " + rs.getInt("denomination_Series_Id"));
//            CoinAttributes.setDenominationSeries(rs.getString("denomination_Series"));
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
    }

    // ******************************************************************************************
    public List<String> findByName()
    {
        List<String> denominationSeriesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_denomination_series");
            while (rs.next())
            {
                denominationSeriesList.add(rs.getString("country"));
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
        return denominationSeriesList;
    }

    // ******************************************************************************************
    public ShowDenominationSeries create(ShowDenominationSeries showDenominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO showDenominationSeries (denomination_Series, denominations_Id) VALUES (?, ?)",
                    new String[]{"ID"});
            ps.setString(1, showDenominationSeries.getDenomination_Series());
            ps.setInt(2, showDenominationSeries.getDenominations_Id());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            showDenominationSeries.setDenomination_Series_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showDenominationSeries;
    }

    // ******************************************************************************************
    public ShowDenominationSeries update(ShowDenominationSeries showDenominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE showDenominationSeries SET denomination_Series=?, denominations_Id=? WHERE denomination_Series_Id=?");
            ps.setString(1, showDenominationSeries.getDenomination_Series());
            ps.setInt(2, showDenominationSeries.getDenominations_Id());

            ps.setInt(3, showDenominationSeries.getDenomination_Series_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showDenominationSeries;
    }

    // ******************************************************************************************
    public boolean remove(ShowDenominationSeries showDenominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_denomination_series WHERE denomination_Series_Id=?");
            ps.setInt(1, showDenominationSeries.getDenomination_Series_Id());
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
    protected ShowDenominationSeries processRow(ResultSet rs) throws SQLException
    {
        ShowDenominationSeries showDenominationSeries = new ShowDenominationSeries();
        showDenominationSeries.setDenomination_Series_Id(rs.getInt("denomination_Series_Id"));
        showDenominationSeries.setDenomination_Series(rs.getString("denomination_Series"));
        showDenominationSeries.setDenominations_Id(rs.getInt("denominations_Id"));
        return showDenominationSeries;
    }

    // ******************************************************************************************

    public int getDenominationSeries_Id()
    {
        return denominationSeries_Id;
    }

    public void setDenominationSeries_Id(int denominationSeries_Id)
    {
        this.denominationSeries_Id = denominationSeries_Id;
    }
}
