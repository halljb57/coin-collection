package testClasses;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("serial")
@UIScoped
public class DatePopupExample extends VerticalLayout
{
    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");


    private PopupDateField datetime;

    public DatePopupExample()
    {
        setSpacing(true);

        datetime = new PopupDateField("Please select the starting time:");

        // Set the value of the PopupDateField to current date
        try
        {
            Date date3 = dateFormat.parse("12-4-2013");
            datetime.setValue(date3);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        // Set the correct resolution
        datetime.setResolution(Resolution.DAY);

        // Add valueChangeListener
        datetime.setImmediate(true);
        datetime.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(ValueChangeEvent event)
            {
                // Get the new value and format it to the current locale
//                DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                Object value = event.getProperty().getValue();
                if (value == null || !(value instanceof Date))
                {
                    Notification.show("Invalid date entered");
                }
                else
                {
                    String dateOut = dateFormatter.format(value);
                    // Show notification
                    Notification.show("Starting date: " + dateOut);
                }
            }
        });

        addComponent(datetime);

        showDate();
    }

    private void showDate()
    {
        String string = "January 2, 2010";
        Date date = null;
        try
        {
            date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(string);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println(date); // Sat Jan 02 00:00:00 BOT 2010

        // ******************************************************************************
        String str_date = "11-June-07";
        DateFormat formatter;
        Date date1 = null;
        formatter = new SimpleDateFormat("dd-MMM-yy");
        try
        {
            date1 = formatter.parse(str_date);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println(date1);
        System.out.println(formatter.format(date1));

        // ******************************************************************************
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date2 = null;
        try
        {
            date2 = dateFormat.parse("12-4-2013");
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println(date2.toString()); // 2013-12-04
        System.out.println(dateFormat.format(date2));

        // ******************************************************************************
        // Code location - http://www.mkyong.com/java/how-to-convert-string-to-date-java/
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";

        try
        {

            Date date6 = formatter1.parse(dateInString);
            System.out.println(date6);
            System.out.println(formatter1.format(date6));

        } catch (ParseException e)
        {
            e.printStackTrace();
        }


    }
}

