package testClasses;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

import java.text.DateFormat;
import java.util.Date;

@SuppressWarnings("serial")
@UIScoped
public class DatePopupInputPromptExample extends VerticalLayout
{

    private PopupDateField startDate;
    String data = "09-10-1954";

    public DatePopupInputPromptExample()
    {
        setSpacing(true);

        startDate = new PopupDateField();
        startDate.setInputPrompt(data);

        // Set the correct resolution
//        startDate.setResolution(PopupDateField.RESOLUTION_DAY);
        startDate.setResolution(Resolution.DAY);

        // Add valueChangeListener
        startDate.setImmediate(true);
        startDate.addValueChangeListener(new ValueChangeListener()
        {
            @Override
            public void valueChange(ValueChangeEvent event)
            {
                // Get the new value and format it to the current locale
                DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
                Object value = event.getProperty().getValue();
                if (value == null || !(value instanceof Date))
                {
//            getWindow().showNotification("Invalid date entered");
                    Notification.show("Invalid date entered");
                }
                else
                {
                    String dateOut = dateFormatter.format(value);
                    // Show notification
//            getWindow().showNotification("Starting date: " + dateOut);
                    Notification.show("Starting date: " + dateOut);
                }
            }
        });

        addComponent(startDate);
    }
}