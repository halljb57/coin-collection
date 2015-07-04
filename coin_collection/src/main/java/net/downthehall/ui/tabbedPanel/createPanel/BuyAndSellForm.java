package net.downthehall.ui.tabbedPanel.createPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.*;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.FormLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.GridLayoutProperties;

import javax.inject.Inject;

/**
 * Created by joseph on 7/13/2014.
 * <p/>
 * Using a FieldFactory to Build and Bind Fields
 * https://vaadin.com/book/vaadin7/-/page/datamodel.itembinding.html
 * http://blog.oio.de/2014/04/25/select-nested-javabeans-vaadin-fieldgroup/
 */
@SuppressWarnings("serial")
@UIScoped
public class BuyAndSellForm extends ViewComponent
{
    @PropertyId("sold_Date")
    private TextField soldDate;
    @PropertyId("sold_To")
    private TextField soldTo;
    @PropertyId("sold_Price")
    private TextField soldPrice;
    @PropertyId("purchase_From")
    private TextField purchaseFrom;
    @PropertyId("purchase_Date")
    private TextField purchaseDate;
    @PropertyId("purchase_Price")
    private TextField purchasePrice;
    @Inject
    @FormLayoutProperties(margin = true)
    private FormLayout topForm, bottomForm;
    @Inject
    @GridLayoutProperties(rows = 2)
    private GridLayout gridLayout;

    // Initialize Class
    public void init()
    {
        buildGridLayout();
    }

    // Build VerticalLayout
    private GridLayout buildGridLayout()
    {
        gridLayout.setSpacing(true);

        topForm = buildTopForm();
        bottomForm = buildBottomForm();

        gridLayout.addComponent(topForm, 0, 0);
        gridLayout.addComponent(bottomForm, 0, 1);
        setCompositionRoot(gridLayout);

        return gridLayout;
    }

    // Initialize Top Form
    private FormLayout buildTopForm()
    {
        soldDate = new TextField("Sold Date");
        soldTo = new TextField("Sold To");
        soldPrice = new TextField("Sold Price");

        topForm.addComponent(soldTo);
        topForm.addComponent(soldDate);
        topForm.addComponent(soldPrice);

        return topForm;
    }

    // Initialize Bottom Form
    private FormLayout buildBottomForm()
    {
        purchaseFrom = new TextField("Purchase From");
        purchaseDate = new TextField("Purchase Date");
        purchasePrice = new TextField("Purchase Price");

        bottomForm.addComponent(purchaseFrom);
        bottomForm.addComponent(purchaseDate);
        bottomForm.addComponent(purchasePrice);

        return bottomForm;
    }

    // **********************************************************************************
    public void setItemDataSource(final Item newDataSource)
    {
        if (newDataSource != null)
        {
            FieldGroup fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);

            /*CoinAttributes coinattributes = new CoinAttributes();
            coinattributes.setSold_Date(soldDate.getValue());
            coinattributes.setSold_Price(soldPrice.getValue());
            coinattributes.setSold_To(soldTo.getValue());
            coinattributes.setPurchase_Date(purchaseDate.getValue());
            coinattributes.setPurchase_From(purchaseFrom.getValue());
            coinattributes.setPurchase_Price(purchasePrice.getValue());*/
        }
    }

    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

        topForm.setReadOnly(readOnly);
        bottomForm.setReadOnly(readOnly);
    }
}

