package net.downthehall.ui.tabbedPanel.editPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.model.vo.ShowCoinAttributes;
import net.downthehall.ui.Toolbar;
import net.downthehall.ui.tabbedPanel.SaveCoinAttributes;
import net.downthehall.ui.tabbedPanel.UpdateCoinAttributes;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.FormLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.GridLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.TextFieldProperties;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 8/2/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class ItemDetailForm extends ViewComponent
{
    // ********************************************************************************** Components
    @PropertyId("coin_Attributes_Id")
    private TextField coinAttributesId = new TextField();
    @PropertyId("collection_Id")
    private TextField collectionId = new TextField();
    // TextFieldProperties
    @Inject
    @TextFieldProperties(caption = "Country", immediate = true)
    @PropertyId("country")
    private TextField country;
    @Inject
    @TextFieldProperties(caption = "Country", immediate = true)
    @PropertyId("current_Value")
    private TextField currentValue;
    @Inject
    @TextFieldProperties(caption = "Mintage For Circulation", immediate = true, required = true,
                         requiredError = "Please enter total Mintage For Circulation.")
    @PropertyId("mintage_For_Circulation")
    private TextField mintageForCirculation;
    @Inject
    @TextFieldProperties(caption = "Mintage Of Proofs", immediate = true, required = true,
                         requiredError = "Please enter total Mintage Of Proofs.")
    @PropertyId("mintage_Of_Proofs")
    private TextField mintageOfProofs;
    @Inject
    @TextFieldProperties(caption = "Quantity", immediate = true, required = true,
                         requiredError = "Please enter a quantity.")
    @PropertyId("quantity")
    private TextField quantity;
    @Inject
    @TextFieldProperties(caption = "Denomination", immediate = true)
    @PropertyId("denomination")
    private TextField denomination;
    @Inject
    @TextFieldProperties(caption = "Mint Year", immediate = true)
    @PropertyId("mint_Year")
    private TextField mintYear;
    @Inject
    @TextFieldProperties(caption = "Denomination Series", immediate = true)
    @PropertyId("denomination_Series")
    private TextField denominationSeries;
    @Inject
    @TextFieldProperties(caption = "Collection", immediate = true)
    private TextField collectionName;
    // ********************************************************************************** Layouts
    @Inject
    @FormLayoutProperties(margin = true, immediate = true)
    private FormLayout leftForm, rightForm;
    @Inject
    @GridLayoutProperties(columns = 2)
    private GridLayout gridLayout;
    // ********************************************************************************** Class Instance
    @Inject
    private Instance<Toolbar> toolbars;
    // **********************************************************************************
    private FieldGroup fieldGroup;
    private Item newDataSource;
    // ********************************************************************************** Variables
    private String _collectionId;
    private String _collectionName;
    private String countryName;
    private String denominationName;
    private String denominationSeriesName;
    private String tableName;
    private int newCollectionId;
    private int _quantity;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        buildGridLayout();
    }

    // Initialize BuildHorizontalLayout
    private GridLayout buildGridLayout()
    {
        setCompositionRoot(gridLayout);
        setSizeFull();

        leftForm = buildLeftForm();
        rightForm = buildRightForm();
        gridLayout.addComponent(leftForm);
        gridLayout.addComponent(rightForm);

        return gridLayout;
    }

    // Initialize BuildLeftForm
    private FormLayout buildLeftForm()
    {
        collectionName = buildCollectionName();
        country = buildCountry();
        denomination = buildDenomination();
        mintageForCirculation = buildMintageForCirculation();
        mintageOfProofs = buildMintageOfProofs();
        leftForm.addComponent(collectionName);
        leftForm.addComponent(country);
        leftForm.addComponent(denomination);
        leftForm.addComponent(mintageForCirculation);
        leftForm.addComponent(mintageOfProofs);

        return leftForm;
    }

    // Initialize BuildRightForm
    private FormLayout buildRightForm()
    {
        mintYear = buildMintYear();
        currentValue = buildCurrentValue();
        quantity = buildQuantity();
        denominationSeries = buildDenominationSeries();
        rightForm.addComponent(mintYear);
        rightForm.addComponent(currentValue);
        rightForm.addComponent(quantity);
        rightForm.addComponent(denominationSeries);

        return rightForm;
    }

    // **********************************************************************************
    // Initialize BuildCollectionName
    private TextField buildCollectionName()
    {
        return collectionName;
    }

    // Initialize BuildCountry
    private TextField buildCountry()
    {
        return country;
    }

    // Initialize BuildDenomination
    private TextField buildDenomination()
    {
        return denomination;
    }

    // Initialize BuildMintageForCirculation
    private TextField buildMintageForCirculation()
    {
        mintageForCirculation.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                if (quantity.isValid() && mintageForCirculation.isValid() && mintageOfProofs.isValid())
                {
                    fireViewEvent(EditPanelPresenter.DISABLE_EDIT_PANEL_DELETE_BUTTONS, null);
                }
                else
                {
                    fireViewEvent(EditPanelPresenter.ENABLE_EDIT_PANEL_CANCEL_BUTTONS, null);
                }
            }
        });

        return mintageForCirculation;
    }

    // Initialize BuildMintageOfProofs
    private TextField buildMintageOfProofs()
    {
        mintageOfProofs.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                if (quantity.isValid() && mintageForCirculation.isValid() && mintageOfProofs.isValid())
                {
                    fireViewEvent(EditPanelPresenter.DISABLE_EDIT_PANEL_DELETE_BUTTONS, null);
                }
                else
                {
                    fireViewEvent(EditPanelPresenter.ENABLE_EDIT_PANEL_CANCEL_BUTTONS, null);
                }
            }
        });

        return mintageOfProofs;
    }

    // Initialize BuildMintYear
    private TextField buildMintYear()
    {
        return mintYear;
    }

    // Initialize BuildCurrentValue
    private TextField buildCurrentValue()
    {
        return currentValue;
    }

    // Initialize BuildQuantity
    private TextField buildQuantity()
    {
        quantity.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                if (quantity.isValid() && mintageForCirculation.isValid() && mintageOfProofs.isValid())
                {

                    fireViewEvent(EditPanelPresenter.DISABLE_EDIT_PANEL_DELETE_BUTTONS, null);
                }
                else
                {
                    fireViewEvent(EditPanelPresenter.ENABLE_EDIT_PANEL_CANCEL_BUTTONS, null);
                }
            }
        });

        return quantity;
    }

    // Initialize BuildDenominationSeries
    private TextField buildDenominationSeries()
    {
        denominationSeries.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                try
                {
                String s = String.valueOf(fieldGroup.getField("denomination_Series").getValue());
                denominationSeries.setDescription(s);
                }
                catch (NullPointerException e)
                {}
            }
        });

        return denominationSeries;
    }

    // **********************************************************************************
    public void setItemDataSource(final Item newDataSource)
    {
        this.newDataSource = newDataSource;

        if (newDataSource != null)
        {
            fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);
        }
    }

    private void updateCoinAttributes()
    {
        String _coinAttributesId = String.valueOf(fieldGroup.getField("coin_Attributes_Id").getValue());
        UpdateCoinAttributes.getInstance().updateItemDetail(_coinAttributesId, collectionId, country,
                                                            denomination, mintageForCirculation,
                                                            mintageOfProofs, currentValue, quantity,
                                                            mintYear, denominationSeries);
    }

    // **********************************************************************************
    private void saveCoinAttributes()
    {
        String _mintageForCirculation = String.valueOf(fieldGroup.getField("mintage_For_Circulation").getValue());
        String _mintageOfProofs = String.valueOf(fieldGroup.getField("mintage_Of_Proofs").getValue());
        String _mintYear = String.valueOf(fieldGroup.getField("mint_Year").getValue());
        SaveCoinAttributes.getInstance().saveItemDetail(country, denomination, _mintageForCirculation,
                                                        _mintageOfProofs, _mintYear, denominationSeries);

        collectionId.getValue();
        SaveCoinAttributes.getInstance().setCollectionId(collectionId);
        currentValue.getValue();
        currentValue.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setCurrentValue(currentValue);
        quantity.getValue();
        quantity.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setQuantity(quantity);
    }

    private void collectionNameById()
    {
        String _collectionId = (String) fieldGroup.getField("collection_Id").getValue();
        fireViewEvent(EditPanelPresenter.COLLECTION_NAME_BY_ID, _collectionId);
        collectionId.setValue(_collectionId);

        collectionName.setValue(getCollectionName());
    }

    // **********************************************************************************
    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

        collectionName.setReadOnly(readOnly);
        country.setReadOnly(readOnly);
        denomination.setReadOnly(readOnly);
        mintageForCirculation.setReadOnly(readOnly);
        mintageOfProofs.setReadOnly(readOnly);
        mintYear.setReadOnly(readOnly);
        currentValue.setReadOnly(readOnly);
        quantity.setReadOnly(readOnly);
        denominationSeries.setReadOnly(readOnly);
    }

    @SuppressWarnings("unchecked")
    protected CoinAttributes getItemCoinAttributes()
    {
        return (CoinAttributes) fieldGroup.getFields();
    }

    @SuppressWarnings("unchecked")
    protected ShowCoinAttributes getItemShowCoinAttributes()
    {
        return (ShowCoinAttributes) fieldGroup.getFields();
    }

    public void editNewCoinAttribute(final CoinAttributes coinAttributes)
    {
        setItemDataSource(new BeanItem<CoinAttributes>(coinAttributes));
    }

    private void clearForm()
    {
        collectionName.setValue("");
        collectionId.setValue("");
        country.setValue("");
        denomination.setValue("");
        mintageForCirculation.setValue("");
        mintageOfProofs.setValue("");
        mintYear.setValue("");
        currentValue.setValue("");
        quantity.setValue("");
        denominationSeries.setValue("");
        // ******************************************************************************
        collectionName.setNullRepresentation("");
        collectionId.setNullRepresentation("");
        country.setNullRepresentation("");
        denomination.setNullRepresentation("");
        mintageForCirculation.setNullRepresentation("");
        mintageOfProofs.setNullRepresentation("");
        mintYear.setNullRepresentation("");
        currentValue.setNullRepresentation("");
        quantity.setNullRepresentation("");
        denominationSeries.setNullRepresentation("");
    }


    // **********************************************************************************
    public String get_collectionId()
    {
        return _collectionId;
    }

    public void set_collectionId(String _collectionId)
    {
        this._collectionId = _collectionId;
    }

    public Item getNewDataSource()
    {
        return newDataSource;
    }

    public void setNewDataSource(Item newDataSource)
    {
        this.newDataSource = newDataSource;
    }

    public void cancelEditing()
    {
        clearForm();
    }

    public String getCollectionName()
    {
        return _collectionName;
    }

    public void setCollectionName(String collectionName)
    {
        this._collectionName = collectionName;
        this.collectionName.setValue(collectionName);
    }

    // ********************************************************************************** Setters
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
        country.setValue(countryName);
        SaveCoinAttributes.getInstance().setCountry(country);
    }

    public void setDenominationName(String denominationName)
    {
        this.denominationName = denominationName;
        this.denomination.setValue(denominationName);
        SaveCoinAttributes.getInstance().setDenomination(denomination);
    }

    public void setDenominationSeriesName(String denominationSeriesName)
    {
        this.denominationSeriesName = denominationSeriesName;
        this.denominationSeries.setValue(this.denominationSeriesName);
        SaveCoinAttributes.getInstance().setDenominationSeries(denominationSeries);

    }

    public void setNewCollectionId(int newCollectionId)
    {
        this.newCollectionId = newCollectionId;
        collectionId.setValue(String.valueOf(newCollectionId));
        SaveCoinAttributes.getInstance().setCollectionId(collectionId);
    }

    protected void setTableName(String tableName)
    {
        this.tableName = tableName;
        String s = "coinsTable";
        if (s != tableName)
        {
            collectionNameById();
            updateCoinAttributes();
        }
        else
        {
            saveCoinAttributes();
        }
    }

    public void setQuantity(int quantity)
    {
        this._quantity = quantity;
    }

    public int get_quantity()
    {
        return _quantity;
    }
}
