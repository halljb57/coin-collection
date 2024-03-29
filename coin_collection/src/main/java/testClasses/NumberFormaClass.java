package testClasses;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by joseph on 9/23/2014.
 * http://examples.javacodegeeks.com/core-java/text/java-number-format-example/
 */
public class NumberFormaClass
{
    public static void main(String[] args) {

        double decimal = 7.27467;
        System.out.println("The test number: "+decimal);
        int decimalPlaces = 3;	// the scale for the decimal

        // use of BigDecimal class
        BigDecimal bd = new BigDecimal(decimal);

        // set the scale and round up if >= 0.5
        bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        double bigDecimal = bd.doubleValue();
        System.out.println("BigDecimal rounded in 3rd decimal: "+bigDecimal);

        // use of DecimalFormat
        DecimalFormat decFormat = new DecimalFormat("#.00");
        double formatDecimal = new Double(decFormat.format(decimal)).doubleValue();
        System.out.println("DecimalFormat rounded in 2nd decimal: "+formatDecimal);

        System.out.println("--------------------------------------");

        DecimalFormat numFormat;
        String number;

        // 2 digits before decimal point and then 2 digits (rounded)
        numFormat = new DecimalFormat("000.##");
        number = numFormat.format(-15.567);
        System.out.println("1. DecimalFormat with .: " + number);

        // string '$' in front of the number
        numFormat = new DecimalFormat("'$'00.####");
        number = numFormat.format(15.567);
        System.out.println("2. DecimalFormat with '$': " + number);

        // use of , to group numbers
        numFormat = new DecimalFormat("###,###,###");
        number = numFormat.format(1556789);
        System.out.println("3. DecimalFormat with ,: " + number);

        // use of % for percentage
        numFormat = new DecimalFormat("%");
        number = numFormat.format(0.15);
        System.out.println("4. DecimalFormat with percentage: " + number);

        // 2 digits before decimal point and 2 digits after
        numFormat = new DecimalFormat("00.00");
        number = numFormat.format(-15.567);
        System.out.println("5. DecimalFormat with 4 digits: " + number);

        // left part of decimal number
        numFormat = new DecimalFormat("##");
        number = numFormat.format(156.567);
        System.out.println("6. DecimalFormat with no decimal part: " + number);

        // 5 or less digits in the decimal part
        numFormat = new DecimalFormat(".#####");
        number = numFormat.format(1890.567);
        System.out.println("7. DecimalFormat with 5 or less digits (in decimal part): " + number);

        // string 'JCG' in front of the number
        numFormat = new DecimalFormat("'JCG'000.#");
        number = numFormat.format(15.567);
        System.out.println("8. DecimalFormat with 'JCG': " + number);
    }

    /*
    #.00: when this pattern is used, we receive double numbers with 2 digits in the
    decimal part (or zeros if digits don’t exist).

    000.##: this pattern indicates three digits at the left part of the double number
    and 2 digits at the right part (or nothing if the digits don’t exist).

    '$'00.####: the quotes (‘ ‘) define the prefix string, where in this situation is $.
    The 0 and # declare the number format as we mentioned above.

    #,###,###: commas is a placeholder for grouping separator.

    %: multiplies the number with 100 in order to show the percentage.
    */
}
