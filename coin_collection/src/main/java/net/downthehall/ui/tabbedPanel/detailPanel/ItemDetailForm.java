package net.downthehall.ui.tabbedPanel.detailPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.FormLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.GridLayoutProperties;

import javax.inject.Inject;

/**
 * Created by joseph on 8/2/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class ItemDetailForm extends ViewComponent
{
    @PropertyId("coin_Attributes_Id")
    private TextField coinAttributesId;
    @PropertyId("collection_Id")
    private TextField collectionId;
    @PropertyId("country")
    private TextField country;
    @PropertyId("current_Value")
    private TextField currentValue;
    @PropertyId("mintage_For_Circulation")
    private TextField mintageForCirculation;
    @PropertyId("mintage_Of_Proofs")
    private TextField mintageOfProofs;
    @PropertyId("quantity")
    private TextField quantity;
    @PropertyId("denomination")
    private TextField denomination;
    @PropertyId("mint_Year")
    private TextField mintYear;
    @PropertyId("denomination_Series")
    private TextField denominationSeries;
    @Inject
    @FormLayoutProperties(margin = true, sizeUndefined = true)
    private FormLayout leftForm, rightForm;
    @Inject
    @GridLayoutProperties(columns = 2)
    private GridLayout gridLayout;

    // Initialize Class
    public void init()
    {
        buildGridLayout();
        setReadOnly(true);
    }

    // Initialize Build-HorizontalLayout
    private GridLayout buildGridLayout()
    {
        setCompositionRoot(gridLayout);

        leftForm = buildLeftForm();
        rightForm = buildRightForm();

        gridLayout.addComponent(leftForm, 0, 0);
        gridLayout.addComponent(rightForm, 1, 0);

        return gridLayout;
    }

    // Initialize Build-Left-Form
    private FormLayout buildLeftForm()
    {
        coinAttributesId = new TextField();
        collectionId = new TextField("Collection");
        country = new TextField("Country");
        denomination = new TextField("Denomination");
        mintageForCirculation = new TextField("Mintage For Circulation");
        mintageOfProofs = new TextField("Mintage Of Proofs");

        leftForm.addComponent(collectionId);
        leftForm.addComponent(country);
        leftForm.addComponent(denomination);
        leftForm.addComponent(mintageForCirculation);
        leftForm.addComponent(mintageOfProofs);

        return leftForm;
    }

    // Initialize Build-Right-Form
    private FormLayout buildRightForm()
    {
        mintYear = new TextField("Mint Year");
        currentValue = new TextField("Current Value");
        quantity = new TextField("Quantity");
        denominationSeries = new TextField("Denomination Series");

        rightForm.addComponent(mintYear);
        rightForm.addComponent(currentValue);
        rightForm.addComponent(quantity);
        rightForm.addComponent(denominationSeries);

        return rightForm;
    }

    // **********************************************************************************
    public void setItemDataSource(final Item newDataSource)
    {
        if (newDataSource != null)
        {
            FieldGroup fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);
        }
    }

    // **********************************************************************************
    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

        collectionId.setReadOnly(readOnly);
        country.setReadOnly(readOnly);
        denomination.setReadOnly(readOnly);
        mintageForCirculation.setReadOnly(readOnly);
        mintageOfProofs.setReadOnly(readOnly);
        mintYear.setReadOnly(readOnly);
        currentValue.setReadOnly(readOnly);
        quantity.setReadOnly(readOnly);
        denominationSeries.setReadOnly(readOnly);
    }
}
