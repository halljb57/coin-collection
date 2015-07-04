package net.downthehall.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by joseph on 9/24/2014.
 */
public class ConvertStringAndNumber
{
    DecimalFormat numFormat;
    String number;
    int num; // Get it's value from setter
    String charString; // Get it's value from setter

    // **********************************************************************************
    public ConvertStringAndNumber()
    {
    }

    // **********************************************************************************
    public boolean checkIfNumber()
    {
        // Regular expression in Java to check if String is number or not
//        Pattern pattern = Pattern.compile(".*[^0-9].*");
        Pattern pattern = Pattern.compile(".*\\D.*");



        /*String[] inputs = {"123", "-123", "123.12", "abcd123"};

        for (String input : inputs)
        {
            System.out.println("does " + input + " is number : "
                               + !pattern.matcher(input).matches() + "\n");
        }*/

        return !pattern.matcher(charString).matches();
    }

    // **********************************************************************************
    public int removeSpecialCharacters()
    {
        Pattern pt = Pattern.compile("[^a-z$]|[^A-Z$]|[^0-9$]");
        Matcher match = pt.matcher(charString);
        while (match.find())
        {
            String s = match.group();
            charString = charString.replaceAll("[^\\w\\s\\-_]", "");
        }
        return Integer.parseInt(charString);
    }

    // **********************************************************************************
    public String numberToString()
    {
        // use of , to group numbers
        numFormat = new DecimalFormat("###,###,###");
        number = numFormat.format(num);
        return number;
    }

    // **********************************************************************************
    public void setNum(int num)
    {
        this.num = num;
    }

    public void setCharString(String charString)
    {
        this.charString = charString;
    }
}
