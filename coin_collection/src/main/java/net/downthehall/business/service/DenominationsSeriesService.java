package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.DenominationSeries;

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
public class DenominationsSeriesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private int denominationSeries_Id;

    // ******************************************************************************************
    public List<DenominationSeries> findAll()
    {
        List<DenominationSeries> denominationSeriesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denomination_series");
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
            ps = conn.prepareStatement("SELECT * FROM denomination_series WHERE denomination_Series_Id = ?");
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
            rs = stmt.executeQuery("SELECT * FROM denomination_series");
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
    public DenominationSeries create(DenominationSeries denominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO denominationSeries (denomination_Series, denominations_Id) VALUES (?, ?)",
                    new String[]{"ID"});
            ps.setString(1, denominationSeries.getDenomination_Series());
            ps.setInt(2, denominationSeries.getDenominations_Id());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            denominationSeries.setDenomination_Series_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationSeries;
    }

    // ******************************************************************************************
    public DenominationSeries update(DenominationSeries denominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE denominationSeries SET denomination_Series=?, denominations_Id=? WHERE denomination_Series_Id=?");
            ps.setString(1, denominationSeries.getDenomination_Series());
            ps.setInt(2, denominationSeries.getDenominations_Id());

            ps.setInt(3, denominationSeries.getDenomination_Series_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationSeries;
    }

    // ******************************************************************************************
    public boolean remove(DenominationSeries denominationSeries)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM denomination_series WHERE denomination_Series_Id=?");
            ps.setInt(1, denominationSeries.getDenomination_Series_Id());
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
    protected DenominationSeries processRow(ResultSet rs) throws SQLException
    {
        DenominationSeries denominationSeries = new DenominationSeries();
        denominationSeries.setDenomination_Series_Id(rs.getInt("denomination_Series_Id"));
        denominationSeries.setDenomination_Series(rs.getString("denomination_Series"));
        denominationSeries.setDenominations_Id(rs.getInt("denominations_Id"));
        return denominationSeries;
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
