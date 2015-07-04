package net.downthehall.ui.accordionPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.*;
import com.vaadin.ui.TabSheet.Tab;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.AccordionProperties;
import org.vaadin.addon.cdiproperties.annotation.ButtonProperties;
import org.vaadin.addon.cdiproperties.annotation.HorizontalLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 9/18/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class AccordionPanelView extends ViewComponent
{
    @Inject
    private Instance<AccordionCollectionList> accordionCollectionLists;
    @Inject
    private Instance<AccordionDenominationList> accordionDenominationLists;
    @Inject
    private Instance<AccordionDenominationSeriesList> accordionDenominationSeriesLists;

    @Inject
    @AccordionProperties(sizeFull = true)
    private Accordion accordion;
    @Inject
    @VerticalLayoutProperties
    private VerticalLayout verticalLayout;
    @Inject
    @VerticalLayoutProperties(sizeFull = true)
    private VerticalLayout l1, l2, l3;
    @Inject
    @ButtonProperties
    private Button button;
    @Inject
    @HorizontalLayoutProperties(spacing = true)
    private HorizontalLayout header;
    private Tab t1, t2, t3;
    private Label c_lable, d_lable, ds_lable;
    private String c_lableString = "test1", d_lableString = "test2", ds_lableString = "test3";


    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        buildVerticalLayout();
    }

    // Initialize buildVerticalLayout
    private VerticalLayout buildVerticalLayout()
    {
//        header = buildHorizontalLayout();
        accordion = buildAccordion();
//        verticalLayout.addComponent(header);
//        verticalLayout.addComponent(breadCrums.get());
        verticalLayout.addComponent(accordion);

        setCompositionRoot(verticalLayout);
        return verticalLayout;
    }

    // **********************************************************************************
    // Initialize buildVerticalLayout
    private HorizontalLayout buildHorizontalLayout()
    {
        c_lable = new Label("Collection: " + c_lableString);
        d_lable = new Label("Denomination: " + d_lableString);
        ds_lable = new Label("Denomination Series: " + ds_lableString);

        header.addComponent(c_lable);
        header.addComponent(d_lable);
        header.addComponent(ds_lable);

        return header;
    }



    // **********************************************************************************
    // Initialize buildAccordion
    private Accordion buildAccordion()
    {
        accordion.setSelectedTab(l1);


        // Tab 1 content
        accordionCollectionLists.get().init();
        l1.addComponent(accordionCollectionLists.get());

        // Tab 2 content
        accordionDenominationLists.get().init();
        l2.addComponent(accordionDenominationLists.get());

        // Tab 3 content
        accordionDenominationSeriesLists.get().init();
        l3.addComponent(accordionDenominationSeriesLists.get());

        t1 = accordion.addTab(l1, "Collection");
        t2 = accordion.addTab(l2, "Denomination");
        t3 = accordion.addTab(l3, "Denomination Series");

        t2.setEnabled(false);
        t3.setEnabled(false);

        // **********************************************************************************
        accordion.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener()
        {
            @Override
            public void selectedTabChange(TabSheet.SelectedTabChangeEvent event)
            {
                String selected = accordion.getTab(event.getTabSheet().getSelectedTab()).getCaption();

                if (selected.equals("Collection"))
                {
//                    accordion.setSelectedTab(l2);
//                    Notification.show("Clicked Collection Tab");
                }
                if (selected.equals("Denomination"))
                {
//                    Notification.show("Clicked Denomination Tab");
                }
                if (selected.equals("Denomination Series"))
                {
//                    Notification.show("Clicked Denomination Series Tab");
                }
            }
        });

        return accordion;
    }

    // **********************************************************************************
    public void setL1Tab()
    {
        t1.setEnabled(true);
        t2.setEnabled(false);
        t3.setEnabled(false);
        accordion.setSelectedTab(l1);
    }

    public void setL2Tab()
    {
        t2.setEnabled(true);
        t1.setEnabled(false);
       accordion.setSelectedTab(l2);
    }

    public void setL3Tab()
    {
        t3.setEnabled(true);
        t2.setEnabled(false);
//        t1.setEnabled(false);
        accordion.setSelectedTab(l3);
    }

}
