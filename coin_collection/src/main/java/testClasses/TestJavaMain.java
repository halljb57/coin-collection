package testClasses;

import net.downthehall.business.service.ShowCoinAttributesTableService;
import net.downthehall.util.ConvertStringAndNumber;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by joseph on 9/21/2014.
 */
public class TestJavaMain
{
    ConvertStringAndNumber convert = new ConvertStringAndNumber();
    ShowCoinAttributesTableService service = new ShowCoinAttributesTableService();

    public TestJavaMain()
    {
        convert.setCharString("58955.67");
        convert.setNum(41556789);
//        currentTread();
//        removeSpecialCharacters();
//        convertStringAndNumber();
//        checkIfNumber();
//        coinAttributesTable();


        String text = "Flying Eagle Type 1856-1858";
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
        Font font = new Font("Tahoma", Font.PLAIN, 14);
        int textwidth = (int)(font.getStringBounds(text, frc).getWidth());
        int textheight = (int)(font.getStringBounds(text, frc).getHeight());

        System.out.println("textwidth " + textwidth);
        System.out.println("textheight " + textheight);


    }

    private void coinAttributesTable()
    {
        service.deleteAllTrue();

        for (String i : service.findColumnOrder())
        {
            System.out.println("Test " + i);
        }

//        System.out.println("Column Order list " + service1.findColumnOrder());
//        System.out.println("Column Order list " + Collections.addAll(myList, service1.findColumnOrder()));
//        System.out.println("Total in Column Order list " + service1.findColumnOrder().size());
//        System.out.println("Column Header list " + service1.findColumnHeader());
//        System.out.println("Total in Column Header list " + service1.findColumnHeader().size());
    }

    private void checkIfNumber()
    {
        System.out.println("Is This a Number: " + convert.checkIfNumber());
    }

    private void convertStringAndNumber()
    {
        System.out.println("Get Number: " + convert.removeSpecialCharacters());
        System.out.println("\n" + "3. DecimalFormat with ,: " + convert.numberToString());
    }

    // **********************************************************************************
    private void currentTread()
    {
        System.out.println("Current Tread: " + Thread.currentThread().getName());

        new Thread()
        {
            public void run()
            {
                System.out.println("Thread: running" + "\n");
            }
        }.start();

        for (int i = 0; i < 10; i++)
        {
            new Thread("" + i)
            {
                public void run()
                {
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }

    // **********************************************************************************
    private int removeSpecialCharacters()
    {
        String c = "125,895,567";
        Pattern pt = Pattern.compile("[^a-z$]|[^A-Z$]|[^0-9$]");
        Matcher match = pt.matcher(c);
        while (match.find())
        {
            String s = match.group();
            c = c.replaceAll("\\W" + s, "");
        }
        System.out.println("\n" + c);

        return Integer.parseInt(c);
    }

    public static void main(String[] args)
    {
        new TestJavaMain();
    }


}
