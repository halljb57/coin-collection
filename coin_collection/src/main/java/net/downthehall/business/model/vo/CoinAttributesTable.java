package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created by joseph on 10/2/2014.
 */
public class CoinAttributesTable implements Serializable
{
    private static final long serialVersionUID = -2956787805885771407L;

    int table_Id;
    String column_Order;
    String column_Header;
    Boolean selected;

    public int getTable_Id()
    {
        return table_Id;
    }

    public void setTable_Id(int table_Id)
    {
        this.table_Id = table_Id;
    }

    public String getColumn_Order()
    {
        return column_Order;
    }

    public void setColumn_Order(String column_Order)
    {
        this.column_Order = column_Order;
    }

    public String getColumn_Header()
    {
        return column_Header;
    }

    public void setColumn_Header(String column_Header)
    {
        this.column_Header = column_Header;
    }

    public Boolean getSelected()
    {
        return selected;
    }

    public void setSelected(Boolean selected)
    {
        this.selected = selected;
    }
}
