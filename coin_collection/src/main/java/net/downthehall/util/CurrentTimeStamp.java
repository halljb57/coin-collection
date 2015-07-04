package net.downthehall.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by joseph on 9/15/2014.
 */
public class CurrentTimeStamp
{
    public String currentTimeStamp()
    {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(dNow);
    }
}
