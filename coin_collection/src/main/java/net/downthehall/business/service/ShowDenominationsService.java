package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.ShowDenominations;

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
public class ShowDenominationsService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public List<ShowDenominations> findAll()
    {
        List<ShowDenominations> denominationsList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_denominations");
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
            rs = stmt.executeQuery("SELECT * FROM show_denominations");
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
    public ShowDenominations create(ShowDenominations showDenominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("INSERT INTO showDenominations (denomination, country_Id) VALUES (?, ?)",
                                       new String[]{"ID"});
            ps.setString(1, showDenominations.getDenomination());
            ps.setInt(2, showDenominations.getCountry_Id());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            showDenominations.setDenominations_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showDenominations;
    }

    // ******************************************************************************************
    public ShowDenominations update(ShowDenominations showDenominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("UPDATE showDenominations SET denomination=?, country_Id=? WHERE denomination=?");
            ps.setString(1, showDenominations.getDenomination());
            ps.setInt(2, showDenominations.getCountry_Id());

            ps.setInt(3, showDenominations.getDenominations_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return showDenominations;
    }

    // ******************************************************************************************
    public boolean remove(ShowDenominations showDenominations)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_denominations WHERE denomination=?");
            ps.setInt(1, showDenominations.getDenominations_Id());
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
    protected ShowDenominations processRow(ResultSet rs) throws SQLException
    {
        ShowDenominations showDenominations = new ShowDenominations();
        showDenominations.setDenominations_Id(rs.getInt("denominations_Id"));
        showDenominations.setDenomination(rs.getString("denomination"));
        showDenominations.setCountry_Id(rs.getInt("country_Id"));
        return showDenominations;
    }
}
