package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.Denominations;

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
public class DenominationsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<Denominations> findAll()
    {
        List<Denominations> denominationsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denominations");
            while (rs.next())
            {
                denominationsList.add(processRow(rs));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominationsList;
    }

    // ******************************************************************************************
    public List<String> findByName()
    {
        List<String> denominationsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM denominations");
            while (rs.next())
            {
                denominationsList.add(rs.getString("country"));
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
        return denominationsList;
    }

    // ******************************************************************************************
    public Denominations create(Denominations denominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO denominations (denomination, country_Id) VALUES (?, ?)",
                                       new String[]{"ID"});
            ps.setString(1, denominations.getDenomination());
            ps.setInt(2, denominations.getCountry_Id());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            denominations.setDenominations_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominations;
    }

    // ******************************************************************************************
    public Denominations update(Denominations denominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("UPDATE denominations SET denomination=?, country_Id=? WHERE denomination=?");
            ps.setString(1, denominations.getDenomination());
            ps.setInt(2, denominations.getCountry_Id());

            ps.setInt(3, denominations.getDenominations_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return denominations;
    }

    // ******************************************************************************************
    public boolean remove(Denominations denominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM denominations WHERE denomination=?");
            ps.setInt(1, denominations.getDenominations_Id());
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
    protected Denominations processRow(ResultSet rs) throws SQLException
    {
        Denominations denominations = new Denominations();
        denominations.setDenominations_Id(rs.getInt("denominations_Id"));
        denominations.setDenomination(rs.getString("denomination"));
        denominations.setCountry_Id(rs.getInt("country_Id"));
        return denominations;
    }
}
