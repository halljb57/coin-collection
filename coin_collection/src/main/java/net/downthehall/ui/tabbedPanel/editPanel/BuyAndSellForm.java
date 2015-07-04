package net.downthehall.ui.tabbedPanel.editPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.ui.tabbedPanel.SaveCoinAttributes;
import net.downthehall.ui.tabbedPanel.UpdateCoinAttributes;
import net.downthehall.util.Props;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.FormLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.GridLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.PopupDateFieldProperties;
import org.vaadin.addon.cdiproperties.annotation.TextFieldProperties;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by joseph on 7/13/2014.
 * <p>
 * Using a FieldFactory to Build and Bind Fields
 * https://vaadin.com/book/vaadin7/-/page/datamodel.itembinding.html
 * http://blog.oio.de/2014/04/25/select-nested-javabeans-vaadin-fieldgroup/
 */
@SuppressWarnings("serial")
@UIScoped
public class BuyAndSellForm extends ViewComponent
{
    // ********************************************************************************** Components
    @Inject
    @TextFieldProperties(caption = "Sold To", immediate = true)
    @PropertyId("sold_To")
    private TextField soldTo;
    @Inject
    @TextFieldProperties(caption = "Sold Price", immediate = true)
    @PropertyId("sold_Price")
    private TextField soldPrice;
    @Inject
    @TextFieldProperties(caption = "Purchase From", immediate = true)
    @PropertyId("purchase_From")
    private TextField purchaseFrom;
    @Inject
    @TextFieldProperties(caption = "Purchase Price", immediate = true)
    @PropertyId("purchase_Price")
    private TextField purchasePrice;
    @Inject
    @PopupDateFieldProperties(caption = "Sold Date", immediate = true)
    private PopupDateField soldDateField;
    @Inject
    @PopupDateFieldProperties(caption = "Purchase Date", immediate = true)
    private PopupDateField purchaseDateField;
    // ********************************************************************************** Layout
    @Inject
    @FormLayoutProperties(margin = true, immediate = true)
    private FormLayout topForm, bottomForm;
    @Inject
    @GridLayoutProperties(rows = 2)
    private GridLayout gridLayout;
    // **********************************************************************************
    private FieldGroup fieldGroup;
    // ********************************************************************************** variables
    private Item newDataSource;
    private String tableName;
    private DateFormat dateFormat = new SimpleDateFormat(Props.DATE_FORMAT);
    private String _purchaseDateField;
    private String _soldDateField;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        buildGridLayout();
        popupDateFieldDisabled();
    }

    // Initialize VerticalLayout
    private GridLayout buildGridLayout()
    {
        gridLayout.setSpacing(true);
        topForm = buildTopForm();
        bottomForm = buildBottomForm();
        gridLayout.addComponent(topForm);
        gridLayout.addComponent(bottomForm);
        setCompositionRoot(gridLayout);

        return gridLayout;
    }

    // Initialize Top Form
    private FormLayout buildTopForm()
    {
        topForm.setCaption("Sold Info.");
        topForm.addStyleName("topform");
        soldTo = builtSoldTo();
        soldPrice = builtSoldPrice();
        soldDateField = buildSoldDate();
        topForm.addComponent(soldTo);
        topForm.addComponent(soldDateField);
        topForm.addComponent(soldPrice);

        return topForm;
    }

    // Initialize Bottom Form
    private FormLayout buildBottomForm()
    {
        bottomForm.setCaption("Purchase Info.");
        purchaseFrom = builtPurchaseFrom();
        purchasePrice = builtPurchasePrice();
        purchaseDateField = buildPurchaseDate();
        bottomForm.addComponent(purchaseFrom);
        bottomForm.addComponent(purchaseDateField);
        bottomForm.addComponent(purchasePrice);

        return bottomForm;
    }

    // Initialize BuiltSoldTo
    private TextField builtSoldTo()
    {
        return soldTo;
    }

    // Initialize Sold Date
    private PopupDateField buildSoldDate()
    {
        soldDateField.setImmediate(true);
        soldDateField.setResolution(Resolution.DAY);

        soldDateField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(final Property.ValueChangeEvent event)
            {
                final String valueString = String.valueOf(event.getProperty().getValue());

                Object value = event.getProperty().getValue();
                String dateOut = dateFormat.format(value);
                UpdateCoinAttributes.getInstance().setSoldDate(dateOut);
            }
        });

        return soldDateField;
    }

    // Initialize BuiltSoldPrice
    private TextField builtSoldPrice()
    {
        return soldPrice;
    }

    // Initialize BuiltPurchaseFrom
    private TextField builtPurchaseFrom()
    {
        return purchaseFrom;
    }

    // Initialize Purchase Date
    private PopupDateField buildPurchaseDate()
    {
        purchaseDateField.setImmediate(true);
        purchaseDateField.setResolution(Resolution.DAY);

        purchaseDateField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(final Property.ValueChangeEvent event)
            {
                final String valueString = String.valueOf(event.getProperty().getValue());

                Object value = event.getProperty().getValue();
                String dateOut = dateFormat.format(value);
                UpdateCoinAttributes.getInstance().setPurchaseDate(dateOut);
            }
        });

        return purchaseDateField;
    }

    // Initialize BuiltPurchasePrice
    private TextField builtPurchasePrice()
    {
        return purchasePrice;
    }

    // **********************************************************************************
    public void setItemDataSource(final Item newDataSource)
    {
        this.newDataSource = newDataSource;
        if (newDataSource != null)
        {
            fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);

            setDatePickerData(newDataSource);
        }
    }

    private void setDatePickerData(Item newDataSource)
    {
        /* Populate soldDate picker using the soldDate in the data container */
        try
        {
            String _soldDate = (String) newDataSource.getItemProperty("sold_Date").getValue();
            String _purchaseDate = (String) newDataSource.getItemProperty("purchase_Date").getValue();
            Date dateSold = dateFormat.parse(_soldDate);
            soldDateField.setValue(dateSold);
            Date datePurchase = dateFormat.parse(_purchaseDate);
            purchaseDateField.setValue(datePurchase);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {

        }

    }

    private void updateSaveCoinAttributes()
    {
        UpdateCoinAttributes.getInstance().updateBuyAndSell(soldTo, soldPrice,
                                                            purchaseFrom, purchasePrice);
    }

    private void saveCoinAttributes()
    {
        SaveCoinAttributes.getInstance().saveBuyAndSell(soldTo, soldPrice,
                                                        purchaseFrom, purchasePrice);

        soldTo.getValue();
        soldTo.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setSoldTo(soldTo);
        soldPrice.getValue();
        soldPrice.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setSoldPrice(soldPrice);
        purchaseFrom.getValue();
        purchaseFrom.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setPurchaseFrom(purchaseFrom);
        purchasePrice.getValue();
        purchasePrice.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setPurchasePrice(purchasePrice);
    }

    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

        soldTo.setReadOnly(readOnly);
        soldPrice.setReadOnly(readOnly);
        purchaseFrom.setReadOnly(readOnly);
        purchasePrice.setReadOnly(readOnly);
    }

    @SuppressWarnings("unchecked")
    private CoinAttributes getItemCoinAttributes()
    {
        return (CoinAttributes) fieldGroup.getFields();
    }

    public void editNewCoinAttribute(final CoinAttributes coinAttributes)
    {
        setItemDataSource(new BeanItem<CoinAttributes>(coinAttributes));
        setReadOnly(false);
    }

    private void clearForm()
    {
        soldTo.setValue("");
        soldPrice.setValue("");
        purchaseFrom.setValue("");
        purchasePrice.setValue("");

        // **********************************************************************************
        soldTo.setNullRepresentation("");
        soldPrice.setNullRepresentation("");
        purchaseFrom.setNullRepresentation("");
        purchasePrice.setNullRepresentation("");
    }

    public void cancelEditing()
    {
        clearForm();
    }

    protected void setTableName(String tableName)
    {
        this.tableName = tableName;
        String s = "coinsTable";
        if (s != tableName)
        {
            updateSaveCoinAttributes();
        }
        else
        {
            saveCoinAttributes();
        }
    }

    // **********************************************************************************
    public void popupDateFieldEnabled()
    {
        soldDateField.setEnabled(true);
        purchaseDateField.setEnabled(true);
    }

    public void popupDateFieldDisabled()
    {
        soldDateField.setEnabled(false);
        purchaseDateField.setEnabled(false);
    }

    // **********************************************************************************

    public String get_soldDateField()
    {
        return _soldDateField;
    }

    public void set_soldDateField(String _soldDateField)
    {
        this._soldDateField = _soldDateField;
    }

    public String get_purchaseDateField()
    {
        return _purchaseDateField;
    }

    public void set_purchaseDateField(String _purchaseDateField)
    {
        this._purchaseDateField = _purchaseDateField;
    }
}

