package net.downthehall.business.service;

import net.downthehall.business.db.DBConnection;
import net.downthehall.business.model.vo.CoinAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by joseph on 8/1/2014.
 */
public class CoinAttributesService
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    // ******************************************************************************************
    public Collection<CoinAttributes> findAll()
    {
        Collection<CoinAttributes> coinAttributesList = new ArrayList<>();
        try
        {
            conn = DBConnection.getInstance().connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coin_attributes");
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
            rs = stmt.executeQuery("SELECT country FROM coin_attributes");
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
    public Collection<String> findGradeBy()
    {
        Collection<String> gradeByList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT grade_By FROM coin_attributes");
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
    public Collection<String> findGrade()
    {
        Collection<String> gradeList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT grade FROM coin_attributes");
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
    public Collection<String> findSerialNumber()
    {
        Collection<String> serialNumberList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT serial_Number FROM coin_attributes");
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
    public Collection<String> findCatalog()
    {
        Collection<String> catalogList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT catalog_Type FROM coin_attributes");
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
    public Collection<String> findQuality()
    {
        Collection<String> qualityList = new ArrayList();
        try
        {
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT quality FROM coin_attributes");
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
    public CoinAttributes create(CoinAttributes coinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "INSERT INTO coin_attributes (" +
                    "catalog_Type, collection_Id, composition, quality, country, " +
                    "current_Value, denomination, denomination_Series, designer, " +
                    "diameter, edge, grade, grade_By, metal_Content, mint, mint_Mark, " +
                    "mint_Year, mintage_For_Circulation, mintage_Of_Proofs, " +
                    "purchase_Date, purchase_From, purchase_Price, quantity, " +
                    "serial_Number, sold_Date, sold_Price, sold_To, thickness, notes, weight)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new String[]{"ID"});
            ps.setString(1, coinAttributes.getCatalog_Type());
            ps.setInt(2, coinAttributes.getCollection_Id());
            ps.setString(3, coinAttributes.getComposition());
            ps.setString(4, coinAttributes.getQuality());
            ps.setString(5, coinAttributes.getCountry());
            ps.setString(6, coinAttributes.getCurrent_Value());
            ps.setString(7, coinAttributes.getDenomination());
            ps.setString(8, coinAttributes.getDenomination_Series());
            ps.setString(9, coinAttributes.getDesigner());
            ps.setString(10, coinAttributes.getDiameter());
            ps.setString(11, coinAttributes.getEdge());
            ps.setString(12, coinAttributes.getGrade());
            ps.setString(13, coinAttributes.getGrade_By());
            ps.setString(14, coinAttributes.getMetal_Content());
            ps.setString(15, coinAttributes.getMint());
            ps.setString(16, coinAttributes.getMint_Mark());
            ps.setString(17, coinAttributes.getMint_Year());
            ps.setInt(18, coinAttributes.getMintage_For_Circulation());
            ps.setInt(19, coinAttributes.getMintage_Of_Proofs());
            ps.setString(20, coinAttributes.getPurchase_Date());
            ps.setString(21, coinAttributes.getPurchase_From());
            ps.setString(22, coinAttributes.getPurchase_Price());
            ps.setInt(23, coinAttributes.getQuantity());
            ps.setString(24, coinAttributes.getSerial_Number());
            ps.setString(25, coinAttributes.getSold_Date());
            ps.setString(26, coinAttributes.getSold_Price());
            ps.setString(27, coinAttributes.getSold_To());
            ps.setString(28, coinAttributes.getThickness());
            ps.setString(29, coinAttributes.getNotes());
            ps.setString(30, coinAttributes.getWeight());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            coinAttributes.setCoin_Attributes_Id(id);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Saved!!! ");
        }
        return coinAttributes;
    }

    // ******************************************************************************************
    public CoinAttributes update(CoinAttributes coinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement(
                    "UPDATE coin_attributes SET catalog_Type=?, collection_Id=?, composition=?, " +
                    "quality=?, country=?, current_Value=?, denomination=?, " +
                    "denomination_Series=?, designer=?, diameter=?, edge=?, grade=?, " +
                    "grade_By=?, metal_Content=?, mint=?, mint_Mark=?, mint_Year=?, " +
                    "mintage_For_Circulation=?, mintage_Of_Proofs=?, purchase_Date=?, " +
                    "purchase_From=?, purchase_Price=?, quantity=?, serial_Number=?, " +
                    "sold_Date=?, sold_Price=?, sold_To=?, thickness=?, notes=?, weight=? WHERE coin_Attributes_Id=?");
            ps.setString(1, coinAttributes.getCatalog_Type());
            ps.setInt(2, coinAttributes.getCollection_Id());
            ps.setString(3, coinAttributes.getComposition());
            ps.setString(4, coinAttributes.getQuality());
            ps.setString(5, coinAttributes.getCountry());
            ps.setString(6, coinAttributes.getCurrent_Value());
            ps.setString(7, coinAttributes.getDenomination());
            ps.setString(8, coinAttributes.getDenomination_Series());
            ps.setString(9, coinAttributes.getDesigner());
            ps.setString(10, coinAttributes.getDiameter());
            ps.setString(11, coinAttributes.getEdge());
            ps.setString(12, coinAttributes.getGrade());
            ps.setString(13, coinAttributes.getGrade_By());
            ps.setString(14, coinAttributes.getMetal_Content());
            ps.setString(15, coinAttributes.getMint());
            ps.setString(16, coinAttributes.getMint_Mark());
            ps.setString(17, coinAttributes.getMint_Year());
            ps.setInt(18, coinAttributes.getMintage_For_Circulation());
            ps.setInt(19, coinAttributes.getMintage_Of_Proofs());
            ps.setString(20, coinAttributes.getPurchase_Date());
            ps.setString(21, coinAttributes.getPurchase_From());
            ps.setString(22, coinAttributes.getPurchase_Price());
            ps.setInt(23, coinAttributes.getQuantity());
            ps.setString(24, coinAttributes.getSerial_Number());
            ps.setString(25, coinAttributes.getSold_Date());
            ps.setString(26, coinAttributes.getSold_Price());
            ps.setString(27, coinAttributes.getSold_To());
            ps.setString(28, coinAttributes.getThickness());
            ps.setString(29, coinAttributes.getNotes());
            ps.setString(30, coinAttributes.getWeight());

            ps.setInt(31, coinAttributes.getCoin_Attributes_Id());
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
//            System.out.println("\n" + "Data Updated CoinAttributes_Id " + coinattributes.getCoin_Attributes_Id());
        }
        return coinAttributes;
    }

    // ******************************************************************************************
    public boolean remove(CoinAttributes coinAttributes)
    {
        try
        {
            conn = DBConnection.connect();
            ps = conn.prepareStatement("DELETE FROM coin_attributes WHERE coin_Attributes_Id=?");
            ps.setInt(1, coinAttributes.getCoin_Attributes_Id());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally
        {
            DBConnection.close(conn);
            System.out.println("\n" + "Data Deleted CoinAttributes_Id " + coinAttributes.getCoin_Attributes_Id());
        }
    }

    // ******************************************************************************************

    // ******************************************************************************************
    protected CoinAttributes processRow(ResultSet rs) throws SQLException
    {
        CoinAttributes coinAttributes = new CoinAttributes();
        coinAttributes.setCoin_Attributes_Id(rs.getInt("coin_Attributes_Id"));
        coinAttributes.setCatalog_Type(rs.getString("catalog_Type"));
        coinAttributes.setCollection_Id(rs.getInt("collection_Id"));
        coinAttributes.setComposition(rs.getString("composition"));
        coinAttributes.setQuality(rs.getString("quality"));
        coinAttributes.setCountry(rs.getString("country"));
        coinAttributes.setCurrent_Value(rs.getString("current_Value"));
        coinAttributes.setDenomination(rs.getString("denomination"));
        coinAttributes.setDenomination_Series(rs.getString("denomination_Series"));
        coinAttributes.setDesigner(rs.getString("designer"));
        coinAttributes.setDiameter(rs.getString("diameter"));
        coinAttributes.setEdge(rs.getString("edge"));
        coinAttributes.setGrade(rs.getString("grade"));
        coinAttributes.setGrade_By(rs.getString("grade_By"));
        coinAttributes.setMetal_Content(rs.getString("metal_Content"));
        coinAttributes.setMint(rs.getString("mint"));
        coinAttributes.setMint_Mark(rs.getString("mint_Mark"));
        coinAttributes.setMint_Year(rs.getString("mint_Year"));
        coinAttributes.setMintage_For_Circulation(rs.getInt("mintage_For_Circulation"));
        coinAttributes.setMintage_Of_Proofs(rs.getInt("mintage_Of_Proofs"));
        coinAttributes.setPurchase_Date(rs.getString("purchase_Date"));
        coinAttributes.setPurchase_From(rs.getString("purchase_From"));
        coinAttributes.setPurchase_Price(rs.getString("purchase_Price"));
        coinAttributes.setQuantity(rs.getInt("quantity"));
        coinAttributes.setSerial_Number(rs.getString("serial_Number"));
        coinAttributes.setSold_Date(rs.getString("sold_Date"));
        coinAttributes.setSold_Price(rs.getString("sold_Price"));
        coinAttributes.setSold_To(rs.getString("sold_To"));
        coinAttributes.setThickness(rs.getString("thickness"));
        coinAttributes.setNotes(rs.getString("notes"));
        coinAttributes.setWeight(rs.getString("weight"));
        return coinAttributes;
    }

    public CoinAttributes persist(CoinAttributes coinAttributes)
    {
        return null;
    }
}
