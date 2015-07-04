package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.ShowCoinAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by joseph on 8/1/2014.
 */
public class ShowCoinAttributesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public Collection<ShowCoinAttributes> findAll()
    {
        Collection<ShowCoinAttributes> coinAttributesList = new ArrayList<>();
        try
        {
            conn = DBConnection.getInstance().connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM show_coin_attributes");
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
    public Collection<String> findByName()
    {
        Collection<String> coinAttributesList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT country FROM show_coin_attributes");
            while (rs.next())
            {
                coinAttributesList.add(rs.getString("country"));
                //coinAttributesList.add(rs.getString("coinAttributesId"));
                //coinAttributesList.add(rs.getString("country"));
                System.out.println("Name ID is " + rs.getInt("coinAttributesId"));
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

    /**
     * Get a list of gradeBy objects
     *
     * @return gradeByList
     */
    public List<String> findGradeBy()
    {
        List<String> gradeByList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT grade_By FROM show_coin_attributes");
            while (rs.next())
            {
                gradeByList.add(rs.getString("grade_By"));
                //System.out.println("Name ID is " + rs.getString("grade_By"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return gradeByList;
    }

    // ******************************************************************************************

    /**
     * Get a list of grade objects
     *
     * @return gradeList
     */
    public List<String> findGrade()
    {
        List<String> gradeList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT grade FROM show_coin_attributes");
            while (rs.next())
            {
                gradeList.add(rs.getString("grade"));
                //System.out.println("Name ID is " + rs.getString("grade"));
                //System.out.println("Name ID is " + gradeList);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return gradeList;
    }

    // ******************************************************************************************

    /**
     * Get a list of serialNumber objects
     *
     * @return serialNumberList
     */
    public List<String> findSerialNumber()
    {
        List<String> serialNumberList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT serial_Number FROM show_coin_attributes");
            while (rs.next())
            {
                serialNumberList.add(rs.getString("serial_Number"));
                //System.out.println("Name ID is " + rs.getString("serial_Number"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return serialNumberList;
    }

    // ******************************************************************************************

    /**
     * Get a list of catalog objects
     *
     * @return catalogList
     */
    public List<String> findCatalog()
    {
        List<String> catalogList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT catalog_Type FROM show_coin_attributes");
            while (rs.next())
            {
                catalogList.add(rs.getString("catalog_Type"));
                //System.out.println("Name ID is " + rs.getString("catalog_Type"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return catalogList;
    }

    // ******************************************************************************************

    /**
     * Get a list of condition objects
     *
     * @return conditionList
     */
    public List<String> findQuality()
    {
        List<String> qualityList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT quality FROM show_coin_attributes");
            while (rs.next())
            {
                qualityList.add(rs.getString("quality"));
                //System.out.println("Name ID is " + rs.getString("quality"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
        }
        return qualityList;
    }

    // ******************************************************************************************
    public ShowCoinAttributes create(ShowCoinAttributes showCoinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO showCoinAttributes (" +
                    "catalog_Type, collection_Id, composition, quality, country, " +
                    "current_Value, denomination, denomination_Series, designer, " +
                    "diameter, edge, grade, grade_By, metal_Content, mint, mint_Mark, " +
                    "mint_Year, mintage_For_Circulation, mintage_Of_Proofs, " +
                    "purchase_Date, purchase_From, purchase_Price, quantity, " +
                    "serial_Number, sold_Date, sold_Price, sold_To, thickness, notes, weight)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, showCoinAttributes.getCatalog_Type());
            ps.setInt(2, showCoinAttributes.getCollection_Id());
            ps.setString(3, showCoinAttributes.getComposition());
            ps.setString(4, showCoinAttributes.getQuality());
            ps.setString(5, showCoinAttributes.getCountry());
            ps.setString(6, showCoinAttributes.getCurrent_Value());
            ps.setString(7, showCoinAttributes.getDenomination());
            ps.setString(8, showCoinAttributes.getDenomination_Series());
            ps.setString(9, showCoinAttributes.getDesigner());
            ps.setString(10, showCoinAttributes.getDiameter());
            ps.setString(11, showCoinAttributes.getEdge());
            ps.setString(12, showCoinAttributes.getGrade());
            ps.setString(13, showCoinAttributes.getGrade_By());
            ps.setString(14, showCoinAttributes.getMetal_Content());
            ps.setString(15, showCoinAttributes.getMint());
            ps.setString(16, showCoinAttributes.getMint_Mark());
            ps.setString(17, showCoinAttributes.getMint_Year());
            ps.setInt(18, showCoinAttributes.getMintage_For_Circulation());
            ps.setInt(19, showCoinAttributes.getMintage_Of_Proofs());
            ps.setString(20, showCoinAttributes.getPurchase_Date());
            ps.setString(21, showCoinAttributes.getPurchase_From());
            ps.setString(22, showCoinAttributes.getPurchase_Price());
            ps.setInt(23, showCoinAttributes.getQuantity());
            ps.setString(24, showCoinAttributes.getSerial_Number());
            ps.setString(25, showCoinAttributes.getSold_Date());
            ps.setString(26, showCoinAttributes.getSold_Price());
            ps.setString(27, showCoinAttributes.getSold_To());
            ps.setString(28, showCoinAttributes.getThickness());
            ps.setString(29, showCoinAttributes.getNotes());
            ps.setString(30, showCoinAttributes.getWeight());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            showCoinAttributes.setCoin_Attributes_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Saved!!! ");
        }
        return showCoinAttributes;
    }

    // ******************************************************************************************
    public ShowCoinAttributes update(ShowCoinAttributes showCoinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE showCoinAttributes SET catalog_Type=?, collection_Id=?, composition=?, " +
                    "quality=?, country=?, current_Value=?, denomination=?, " +
                    "denomination_Series=?, designer=?, diameter=?, edge=?, grade=?, " +
                    "grade_By=?, metal_Content=?, mint=?, mint_Mark=?, mint_Year=?, " +
                    "mintage_For_Circulation=?, mintage_Of_Proofs=?, purchase_Date=?, " +
                    "purchase_From=?, purchase_Price=?, quantity=?, serial_Number=?, " +
                    "sold_Date=?, sold_Price=?, sold_To=?, thickness=?, notes=?, weight=? WHERE coin_Attributes_Id=?");
            ps.setString(1, showCoinAttributes.getCatalog_Type());
            ps.setInt(2, showCoinAttributes.getCollection_Id());
            ps.setString(3, showCoinAttributes.getComposition());
            ps.setString(4, showCoinAttributes.getQuality());
            ps.setString(5, showCoinAttributes.getCountry());
            ps.setString(6, showCoinAttributes.getCurrent_Value());
            ps.setString(7, showCoinAttributes.getDenomination());
            ps.setString(8, showCoinAttributes.getDenomination_Series());
            ps.setString(9, showCoinAttributes.getDesigner());
            ps.setString(10, showCoinAttributes.getDiameter());
            ps.setString(11, showCoinAttributes.getEdge());
            ps.setString(12, showCoinAttributes.getGrade());
            ps.setString(13, showCoinAttributes.getGrade_By());
            ps.setString(14, showCoinAttributes.getMetal_Content());
            ps.setString(15, showCoinAttributes.getMint());
            ps.setString(16, showCoinAttributes.getMint_Mark());
            ps.setString(17, showCoinAttributes.getMint_Year());
            ps.setInt(18, showCoinAttributes.getMintage_For_Circulation());
            ps.setInt(19, showCoinAttributes.getMintage_Of_Proofs());
            ps.setString(20, showCoinAttributes.getPurchase_Date());
            ps.setString(21, showCoinAttributes.getPurchase_From());
            ps.setString(22, showCoinAttributes.getPurchase_Price());
            ps.setInt(23, showCoinAttributes.getQuantity());
            ps.setString(24, showCoinAttributes.getSerial_Number());
            ps.setString(25, showCoinAttributes.getSold_Date());
            ps.setString(26, showCoinAttributes.getSold_Price());
            ps.setString(27, showCoinAttributes.getSold_To());
            ps.setString(28, showCoinAttributes.getThickness());
            ps.setString(29, showCoinAttributes.getNotes());
            ps.setString(30, showCoinAttributes.getWeight());

            ps.setInt(31, showCoinAttributes.getCoin_Attributes_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Updated CoinAttributes_Id " + showCoinAttributes.getCoin_Attributes_Id());
        }
        return showCoinAttributes;
    }

    // ******************************************************************************************
    public boolean remove(ShowCoinAttributes showCoinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM show_coin_attributes WHERE coin_Attributes_Id=?");
            ps.setInt(1, showCoinAttributes.getCoin_Attributes_Id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Deleted CoinAttributes_Id " + showCoinAttributes.getCoin_Attributes_Id());
        }
    }

    // ******************************************************************************************

    // ******************************************************************************************
    protected ShowCoinAttributes processRow(ResultSet rs) throws SQLException
    {
        ShowCoinAttributes showCoinAttributes = new ShowCoinAttributes();
        showCoinAttributes.setCoin_Attributes_Id(rs.getInt("coin_Attributes_Id"));
        showCoinAttributes.setCatalog_Type(rs.getString("catalog_Type"));
        showCoinAttributes.setCollection_Id(rs.getInt("collection_Id"));
        showCoinAttributes.setComposition(rs.getString("composition"));
        showCoinAttributes.setQuality(rs.getString("quality"));
        showCoinAttributes.setCountry(rs.getString("country"));
        showCoinAttributes.setCurrent_Value(rs.getString("current_Value"));
        showCoinAttributes.setDenomination(rs.getString("denomination"));
        showCoinAttributes.setDenomination_Series(rs.getString("denomination_Series"));
        showCoinAttributes.setDesigner(rs.getString("designer"));
        showCoinAttributes.setDiameter(rs.getString("diameter"));
        showCoinAttributes.setEdge(rs.getString("edge"));
        showCoinAttributes.setGrade(rs.getString("grade"));
        showCoinAttributes.setGrade_By(rs.getString("grade_By"));
        showCoinAttributes.setMetal_Content(rs.getString("metal_Content"));
        showCoinAttributes.setMint(rs.getString("mint"));
        showCoinAttributes.setMint_Mark(rs.getString("mint_Mark"));
        showCoinAttributes.setMint_Year(rs.getString("mint_Year"));
        showCoinAttributes.setMintage_For_Circulation(rs.getInt("mintage_For_Circulation"));
        showCoinAttributes.setMintage_Of_Proofs(rs.getInt("mintage_Of_Proofs"));
        showCoinAttributes.setPurchase_Date(rs.getString("purchase_Date"));
        showCoinAttributes.setPurchase_From(rs.getString("purchase_From"));
        showCoinAttributes.setPurchase_Price(rs.getString("purchase_Price"));
        showCoinAttributes.setQuantity(rs.getInt("quantity"));
        showCoinAttributes.setSerial_Number(rs.getString("serial_Number"));
        showCoinAttributes.setSold_Date(rs.getString("sold_Date"));
        showCoinAttributes.setSold_Price(rs.getString("sold_Price"));
        showCoinAttributes.setSold_To(rs.getString("sold_To"));
        showCoinAttributes.setThickness(rs.getString("thickness"));
        showCoinAttributes.setNotes(rs.getString("notes"));
        showCoinAttributes.setWeight(rs.getString("weight"));
        return showCoinAttributes;
    }

    public ShowCoinAttributes persist(ShowCoinAttributes showCoinAttributes)
    {
        return null;
    }
}
