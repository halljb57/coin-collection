package net.downthehall.ui.coins.showCoinsView;

import com.vaadin.data.Container.Filterable;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import org.vaadin.addon.cdimvp.ViewComponent;

/**
 * Created by joseph on 10/4/2014.
 * Code Location - http://demo.vaadin.com/book-examples/book/#datamodel.container.filter.basic
 */
public class TableFilter extends ViewComponent
{
    private TextField tf = new TextField();
    private Table table;

    public void init()
    {
        setCompositionRoot(tf);

        // Filter table according to typed input
        tf.addTextChangeListener(new FieldEvents.TextChangeListener()
        {
            SimpleStringFilter filter = null;

            @Override
            public void textChange(FieldEvents.TextChangeEvent event)
            {
                Filterable f = (Filterable) table.getContainerDataSource();

            // Remove old filter
                if (filter != null)
                {
                    f.removeContainerFilter(filter);
                }
                // Set new filter for the "Name" column
                filter = new SimpleStringFilter("name", event.getText(), true, false);

                f.addContainerFilter(filter);
            }

        });
    }
}
