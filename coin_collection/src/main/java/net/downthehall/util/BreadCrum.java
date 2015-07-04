package net.downthehall.util;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.vaadin.addon.cdimvp.ViewComponent;

/**
 * Created by joseph on 9/22/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class BreadCrum extends ViewComponent
{

    private HorizontalLayout header;

    private Label c_lable, d_lable, ds_lable;
    private String c_lableString, d_lableString, ds_lableString;

    /*private static BreadCrum ourInstance = new BreadCrum();

    public static BreadCrum getInstance()
    {
        return ourInstance;
    }

    private BreadCrum()
    {
    }*/
    // **********************************************************************************
    // Initialize Class
    public BreadCrum()
    {
        buildHorizontalLayout();
    }

    // **********************************************************************************
    // Initialize buildHorizontalLayout
    public void buildHorizontalLayout()
    {
        header = new HorizontalLayout();
        header.setSpacing(true);
        setCompositionRoot(header);


        c_lable = new Label("Collection: " + c_lableString);
        d_lable = new Label("Denomination: " + d_lableString);
        ds_lable = new Label("Denomination Series: " + ds_lableString);

        header.addComponent(c_lable);
        header.addComponent(d_lable);
        header.addComponent(ds_lable);

    }

    public void setCollection(String collection)
    {
        c_lableString = collection;
    }
    public void setDenomination(String denomination)
    {
        d_lableString = denomination;
    }
    public void setDenominationSeries(String denominationSeries)
    {
        ds_lableString = denominationSeries;
    }
}
