package testClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by joseph on 9/23/2014.
 * http://javarevisited.blogspot.com/2012/10/regular-expression-example-in-java-to-check-String-number.html
 */
public class RegularExpressionExample
{
    public static void main(String args[])
    {

        // Regular expression in Java to check if String is number or not
//        Pattern pattern = Pattern.compile(".*[^0-9].*");
        Pattern pattern = Pattern.compile(".*\\D.*");
        String[] inputs = {"123", "-123", "123.12", "abcd123"};

        for (String input : inputs)
        {
            System.out.println("does " + input + " is number : "
                               + !pattern.matcher(input).matches() + "\n");
        }

        // Regular expression in java to check if String is 6 digit number or not
        String[] numbers = {"123", "1234", "123.12", "abcd123", "123456"};
        Pattern digitPattern = Pattern.compile("\\d{6}");
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");


        for (String number : numbers)
        {
            System.out.println("does " + number + " is 6 digit number : "
                               + digitPattern.matcher(number).matches());
        }

        /**
         * regular expression in java to remove special characters
         *replaceAll("[^\\w\\s\\-_]", "");
         * http://stackoverflow.com/questions/14361556/remove-all-special-characters-in-java
         *
         */
        String c = "125,895,567";
        Pattern pt = Pattern.compile("[^a-z$]|[^A-Z$]|[^0-9$]");
        Matcher match = pt.matcher(c);
        while (match.find())
        {
            String s = match.group();
            c = c.replaceAll("[^\\w\\s\\-_]", "");
        }
        System.out.println("\n" + "125,895,567" + "\n" + "Remove Special Characters: " + c);

       /*
       String c = "hjdg$h&jk8^i0ssh6";
        Pattern pt = Pattern.compile("[^a-z$]|[^A-Z$]|[^0-9$]");
        Matcher match = pt.matcher(c);
        while (match.find())
        {
            String s = match.group();
            c = c.replaceAll("\\" + s, "");
        }
        System.out.println("\n" + c);
        */
    }
}
