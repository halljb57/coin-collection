package net.downthehall.util;

/**
 * Created by joseph on 10/4/2014.
 */
public enum StringValue
{
    D("Denver"), P("Philadelphia"), S("San Francisco"), W("West Point"), CC("Carson City"), O("New Orleans");

    private String mint;

    StringValue(String s)
    {
        mint = s;
    }

    public String getMint()
    {
        return mint;
    }
}
