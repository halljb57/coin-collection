package net.downthehall.ui.tabbedPanel.createPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.*;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.CoinAttributesService;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.FormLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.GridLayoutProperties;

import javax.inject.Inject;

/**
 * Created by joseph on 8/2/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class MoreDetailForm extends ViewComponent
{
    public static final String height = "350px";
    // ComboBox
    private ComboBox grade;
    private ComboBox gradeBy;
    private ComboBox serialNumber;
    private ComboBox quality;
    private ComboBox catalogType;
    // TextFields
    @PropertyId("material")
    private TextField metalContent;
    @PropertyId("mint_Mark")
    private TextField mintMark;
    @PropertyId("mint")
    private TextField mint;
    @PropertyId("diameter")
    private TextField diameter;
    @PropertyId("weight")
    private TextField weight;
    @PropertyId("thickness")
    private TextField thickness;
    @PropertyId("composition")
    private TextField composition;
    @PropertyId("edge")
    private TextField edge;
    @PropertyId("designer")
    private TextField designer;
    @PropertyId("notes")
    private TextArea notes;
    // Inject Classes
    @Inject
    @FormLayoutProperties(margin = true)
    private FormLayout leftForm, rightForm;
    @Inject
    @GridLayoutProperties(columns = 2)
    private GridLayout gridLayout;

    // Initialize Class
    public void init()
    {
        buildGridLayout();
    }

    // Build HorizontalLayout
    private GridLayout buildGridLayout()
    {
        setCompositionRoot(gridLayout);

        leftForm = buildLeftForm();
        rightForm = buildRightForm();

        gridLayout.addComponent(leftForm, 0, 0);
        gridLayout.addComponent(rightForm, 1, 0);

        return gridLayout;
    }

    // Initialize LeftForm
    private FormLayout buildLeftForm()
    {
        grade = new ComboBox("Grade");
        gradeBy = new ComboBox("Grade By");
        serialNumber = new ComboBox("Serial Number");
        quality = new ComboBox("Quality");
        metalContent = new TextField("Material");
        mintMark = new TextField("MintMark");
        mint = new TextField("Mint");
        catalogType = new ComboBox("Catalog");

        leftForm.addComponent(grade);
        leftForm.addComponent(gradeBy);
        leftForm.addComponent(serialNumber);
        leftForm.addComponent(quality);
        leftForm.addComponent(metalContent);
        leftForm.addComponent(mintMark);
        leftForm.addComponent(mint);
        leftForm.addComponent(catalogType);

        return leftForm;
    }

    // Initialize RightForm
    private FormLayout buildRightForm()
    {
        diameter = new TextField("Diameter");
        weight = new TextField("Weight");
        thickness = new TextField("Thickness");
        composition = new TextField("Composition");
        edge = new TextField("Edge");
        designer = new TextField("Designer");
        notes = new TextArea("Notes");

        notes.setWidth("200px");
        notes.setHeight("120px");

        rightForm.addComponent(diameter);
        rightForm.addComponent(weight);
        rightForm.addComponent(thickness);
        rightForm.addComponent(composition);
        rightForm.addComponent(edge);
        rightForm.addComponent(designer);
        rightForm.addComponent(notes);

        return rightForm;
    }

    /* Populate form from selection in table */
    public void setItemDataSource(final Item newDataSource)
    {
        if (newDataSource != null)
        {
            FieldGroup fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);

            setComboBoxDataSource(newDataSource);

            CoinAttributes coinAttributes = new CoinAttributes();
            coinAttributes.setGrade(String.valueOf(grade.getValue()));
            coinAttributes.setGrade_By(String.valueOf(gradeBy.getValue()));
            coinAttributes.setSerial_Number(String.valueOf(serialNumber.getValue()));
            coinAttributes.setQuality(String.valueOf(quality.getValue()));
            coinAttributes.setMetal_Content(metalContent.getValue());
            coinAttributes.setMint_Mark(mintMark.getValue());
            coinAttributes.setMint(mint.getValue());
            coinAttributes.setCatalog_Type(String.valueOf(catalogType.getValue()));
            coinAttributes.setDiameter(diameter.getValue());
            coinAttributes.setWeight(weight.getValue());
            coinAttributes.setThickness(thickness.getValue());
            coinAttributes.setComposition(composition.getValue());
            coinAttributes.setEdge(edge.getValue());
            coinAttributes.setDesigner(designer.getValue());
            coinAttributes.setNotes(notes.getValue());
        }
    }

    private void loadCombBoxes()
    {
    }

    /* Populate comboBoxes from selection in table */
    private void setComboBoxDataSource(final Item newDataSource)
    {
        CoinAttributesService service = new CoinAttributesService();
        // ******************************************************************************
        /* Allow the user to enter new grade */
        grade.setNewItemsAllowed(true);
        /* We do not want to use null values */
        grade.setNullSelectionAllowed(false);
        /* Add an empty grade used for selecting no grade */
        grade.addItem("");
        /* Populate grade select using the grade in the data container */
        String _grade = (String) newDataSource.getItemProperty("grade").getValue();
        grade.addItems(service.findGrade());

        /* Allow the user to enter new gradeBy */
        gradeBy.setNewItemsAllowed(true);
        /* We do not want to use null values */
        gradeBy.setNullSelectionAllowed(false);
        /* Add an empty gradeBy used for selecting no gradeBy */
        gradeBy.addItem("");
        /* Populate gradeBy select using the gradeBy in the data container */
        String _gradeBy = (String) newDataSource.getItemProperty("grade_By").getValue();
        gradeBy.addItems(service.findGradeBy());

        /* Allow the user to enter new serialNumber */
        serialNumber.setNewItemsAllowed(true);
        /* We do not want to use null values */
        serialNumber.setNullSelectionAllowed(false);
		/* Add an empty serialNumber used for selecting no serialNumber */
        serialNumber.addItem("");
        /* Populate serialNumber select using the serialNumber in the data container */
        String _serialNumber = (String) newDataSource.getItemProperty("serial_Number").getValue();
        serialNumber.addItems(service.findSerialNumber());

        /* Allow the user to enter new quality */
        quality.setNewItemsAllowed(true);
        /* We do not want to use null values */
        quality.setNullSelectionAllowed(false);
		/* Add an empty quality used for selecting no quality */
        quality.addItem("");
        /* Populate quality select using the quality in the data container */
        String _quality = (String) newDataSource.getItemProperty("quality").getValue();
        quality.addItems(service.findQuality());

        /* Allow the user to enter new catalog */
        catalogType.setNewItemsAllowed(true);
        /* We do not want to use null values */
        catalogType.setNullSelectionAllowed(false);
		/* Add an empty catalog used for selecting no catalog */
        catalogType.addItem("");
        /* Populate catalog select using the catalog in the data container */
        String _catalog = (String) newDataSource.getItemProperty("catalog_Type").getValue();
        catalogType.addItems(service.findCatalog());
    }

    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

//        topForm.setReadOnly(readOnly);
    }
}
