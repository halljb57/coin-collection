package net.downthehall.ui.tabbedPanel.editPanel;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.downthehall.business.model.vo.CoinAttributes;
import net.downthehall.business.service.CoinAttributesService;
import net.downthehall.ui.tabbedPanel.SaveCoinAttributes;
import net.downthehall.ui.tabbedPanel.UpdateCoinAttributes;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/2/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class MoreDetailForm extends ViewComponent
{
    public static final String height = "350px";
    // ********************************************************************************** Components
    // ComboBoxes
    @Inject
    @ComboBoxProperties(caption = "Grade", immediate = true)
    private ComboBox grade;
    @Inject
    @ComboBoxProperties(caption = "GradeBy", immediate = true)
    private ComboBox gradeBy;
    @Inject
    @ComboBoxProperties(caption = "serial Number", immediate = true)
    private ComboBox serialNumber;
    @Inject
    @ComboBoxProperties(caption = "Quality", immediate = true)
    private ComboBox quality;
    @Inject
    @ComboBoxProperties(caption = "Catalog Type", immediate = true)
    private ComboBox catalogType;
    // TextFields
    @Inject
    @TextFieldProperties(caption = "Metal Content", immediate = true)
    @PropertyId("metal_Content")
    private TextField metalContent;
    @Inject
    @TextFieldProperties(caption = "Mint Mark", immediate = true)
    @PropertyId("mint_Mark")
    private TextField mintMark;
    @Inject
    @TextFieldProperties(caption = "Mint", immediate = true)
    @PropertyId("mint")
    private TextField mint;
    @Inject
    @TextFieldProperties(caption = "Diameter", immediate = true)
    @PropertyId("diameter")
    private TextField diameter;
    @Inject
    @TextFieldProperties(caption = "Weight", immediate = true)
    @PropertyId("weight")
    private TextField weight;
    @Inject
    @TextFieldProperties(caption = "Thickness", immediate = true)
    @PropertyId("thickness")
    private TextField thickness;
    @Inject
    @TextFieldProperties(caption = "Composition", immediate = true)
    @PropertyId("composition")
    private TextField composition;
    @Inject
    @TextFieldProperties(caption = "Edge", immediate = true)
    @PropertyId("edge")
    private TextField edge;
    @Inject
    @TextFieldProperties(caption = "Designer", immediate = true)
    @PropertyId("designer")
    private TextField designer;
    @Inject
    @TextAreaProperties(caption = "Notes", immediate = true, width = "200px", height = "120px")
    @PropertyId("notes")
    private TextArea notes;
    // ********************************************************************************** Layouts
    @Inject
    @FormLayoutProperties(margin = true, immediate = true)
    private FormLayout leftForm, rightForm;
    @Inject
    @GridLayoutProperties(columns = 2)
    private GridLayout gridLayout;
    // **********************************************************************************
    private FieldGroup fieldGroup;
    private Item newDataSource;
    // ********************************************************************************** Variables
    private String _catalogType;
    private String _quality;
    private String _serialNumber;
    private String _gradeBy;
    private String _grade;
    private String tableName;

    private Collection<String> gradeOptions;
    private Collection<String> gradeByOptions;
    private Collection<String> serialNumberOptions;
    private Collection<String> qualityOptions;
    private Collection<String> catalogTypeOptions;

    @Inject
    private CoinAttributesService service;

    // **********************************************************************************
    // Initialize Class
    public void init()
    {
        buildGridLayout();
    }

    // Initialize HorizontalLayout
    private GridLayout buildGridLayout()
    {
        setCompositionRoot(gridLayout);

        leftForm = buildLeftForm();
        rightForm = buildRightForm();

        gridLayout.addComponent(leftForm);
        gridLayout.addComponent(rightForm);
        return gridLayout;
    }

    // Initialize LeftForm
    private FormLayout buildLeftForm()
    {
        grade = builtGrade();
        gradeBy = builtGradeBy();
        serialNumber = builtSerialNumber();
        quality = builtQuality();
        metalContent = builtMetalContent();
        mintMark = builtMintMark();
        mint = builtMint();
        catalogType = builtCatalogType();

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
        diameter = builtDiameter();
        weight = builtWeight();
        thickness = builtThickness();
        composition = builtComposition();
        edge = builtEdge();
        designer = builtDesigner();
        notes = builtNotes();

        rightForm.addComponent(diameter);
        rightForm.addComponent(weight);
        rightForm.addComponent(thickness);
        rightForm.addComponent(composition);
        rightForm.addComponent(edge);
        rightForm.addComponent(designer);
        rightForm.addComponent(notes);

        return rightForm;
    }

    // **********************************************************************************
    // Initialize BuiltGrade
    private ComboBox builtGrade()
    {
        grade.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                UpdateCoinAttributes.getInstance().setGrade(String.valueOf(grade.getValue()));
                SaveCoinAttributes.getInstance().setGrade(String.valueOf(grade.getValue()));
            }
        });

        return grade;
    }

    // Initialize BuiltGradeBy
    private ComboBox builtGradeBy()
    {
        gradeBy.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                UpdateCoinAttributes.getInstance().setGradeBy(String.valueOf(gradeBy.getValue()));
                SaveCoinAttributes.getInstance().setGradeBy(String.valueOf(gradeBy.getValue()));
            }
        });

        return gradeBy;
    }

    // Initialize BuiltSerialNumber
    private ComboBox builtSerialNumber()
    {
        serialNumber.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                UpdateCoinAttributes.getInstance().setSerialNumber(String.valueOf(serialNumber.getValue()));
                SaveCoinAttributes.getInstance().setSerialNumber(String.valueOf(serialNumber.getValue()));
            }
        });

        return serialNumber;
    }

    // Initialize BuiltQuality
    private ComboBox builtQuality()
    {
        quality.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                UpdateCoinAttributes.getInstance().setQuality(String.valueOf(quality.getValue()));
                SaveCoinAttributes.getInstance().setQuality(String.valueOf(quality.getValue()));
            }
        });

        return quality;
    }

    // Initialize BuiltMetalContent
    private TextField builtMetalContent()
    {
        metalContent.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                String s = String.valueOf(fieldGroup.getField("metal_Content").getValue());
                metalContent.setDescription(s);
            }
        });

        return metalContent;
    }

    // Initialize BuiltMintMark
    private TextField builtMintMark()
    {
        return mintMark;
    }

    // Initialize BuiltMint
    private TextField builtMint()
    {
        return mint;
    }

    // Initialize BuiltCatalogType
    private ComboBox builtCatalogType()
    {
        catalogType.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent)
            {
                UpdateCoinAttributes.getInstance().setCatalogType(String.valueOf(catalogType.getValue()));
                SaveCoinAttributes.getInstance().setCatalogType(String.valueOf(catalogType.getValue()));
            }
        });

        return catalogType;
    }

    // Initialize BuiltDiameter
    private TextField builtDiameter()
    {
        return diameter;
    }

    // Initialize BuiltWeight
    private TextField builtWeight()
    {
        weight.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                String s = String.valueOf(fieldGroup.getField("weight").getValue());
                weight.setDescription(s);
            }
        });

        return weight;
    }

    // Initialize BuiltThickness
    private TextField builtThickness()
    {
        return thickness;
    }

    // Initialize BuiltComposition
    private TextField builtComposition()
    {
        return composition;
    }

    // Initialize BuiltEdge
    private TextField builtEdge()
    {
        return edge;
    }

    // Initialize BuiltDesigner
    private TextField builtDesigner()
    {
        designer.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override
            public void valueChange(Property.ValueChangeEvent event)
            {
                String s = String.valueOf(fieldGroup.getField("designer").getValue());
                designer.setDescription(s);
            }
        });

        return designer;
    }

    // Initialize BuiltNotes
    private TextArea builtNotes()
    {
        return notes;
    }

    // **********************************************************************************
    /* Populate form from selection in table */
    public void setItemDataSource(Item newDataSource)
    {
        this.newDataSource = newDataSource;
        if (newDataSource != null)
        {
            fieldGroup = new FieldGroup(newDataSource);
            fieldGroup.bindMemberFields(this);

            saveCoinAttributesData();
            setComboBoxDataSource();
            setComboBoxData(newDataSource);
        }
    }

    private void setComboBoxData(Item newDataSource)
    {
        try
        {
        /* Populate grade select using the grade in the data container */
        _grade = (String) newDataSource.getItemProperty("grade").getValue();
        grade.addItem(_grade);
        /* Populate gradeBy select using the gradeBy in the data container */
        _gradeBy = (String) newDataSource.getItemProperty("grade_By").getValue();
        gradeBy.addItem(_gradeBy);
        /* Populate serialNumber select using the serialNumber in the data container */
        _serialNumber = (String) newDataSource.getItemProperty("serial_Number").getValue();
        serialNumber.addItem(_serialNumber);
        /* Populate quality select using the quality in the data container */
        _quality = (String) newDataSource.getItemProperty("quality").getValue();
        quality.addItem(_quality);
        /* Populate catalogType select using the catalogType in the data container */
        _catalogType = (String) newDataSource.getItemProperty("catalog_Type").getValue();
        catalogType.addItem(_catalogType);
        }
        catch (NullPointerException e)
        {
        }
    }

    private void updateCoinAttributes()
    {
        UpdateCoinAttributes.getInstance().updateMoreDetail(_grade, _gradeBy, _serialNumber, _quality,
                                                            _catalogType, metalContent, mintMark,
                                                            mint, diameter, weight, thickness,
                                                            composition, edge, designer, notes);
    }

    private void saveCoinAttributes()
    {
        try
        {
        String _metalContent = String.valueOf(fieldGroup.getField("metal_Content").getValue());
        String _mintMark = String.valueOf(fieldGroup.getField("mint_Mark").getValue());
        String _diameter = String.valueOf(fieldGroup.getField("diameter").getValue());
        String _weight = String.valueOf(fieldGroup.getField("weight").getValue());
        String _edge = String.valueOf(fieldGroup.getField("edge").getValue());
        String _notes = String.valueOf(fieldGroup.getField("notes").getValue());
        SaveCoinAttributes.getInstance().saveMoreDetail(_grade, _gradeBy, _serialNumber, _quality,
                                                        _catalogType, _metalContent, _mintMark,
                                                        _diameter, _weight, _edge, _notes);

        mint.getValue();
        mint.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setMint(mint);
        thickness.getValue();
        thickness.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setThickness(thickness);
        composition.getValue();
        composition.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setComposition(composition);
        designer.getValue();
        designer.setNullRepresentation("");
        SaveCoinAttributes.getInstance().setDesigner(designer);
        }
        catch (NullPointerException e)
        {
        }
    }

    protected void saveCoinAttributesData()
    {
        fireViewEvent(EditPanelPresenter.GRADE_OPTIONS, null);
        fireViewEvent(EditPanelPresenter.GRADE_BY_OPTIONS, null);
        fireViewEvent(EditPanelPresenter.CATALOG_TYPE_OPTIONS, null);
        fireViewEvent(EditPanelPresenter.QUALITY_OPTIONS, null);
        fireViewEvent(EditPanelPresenter.SERIAL_NUMBER_OPTIONS, null);
    }

    /* Populate comboBoxes from selection in table */
    private void setComboBoxDataSource()
    {
        /* Allow the user to enter new grade */
        grade.setNewItemsAllowed(true);
        /* We do not want to use null values */
        grade.setNullSelectionAllowed(false);
        /* Add an empty grade used for selecting no grade */
        grade.addItem("");
        try
        {
            grade.addItems(gradeOptions);

        } catch (NullPointerException e)
        {
        }

        /* Allow the user to enter new gradeBy */
        gradeBy.setNewItemsAllowed(true);
        /* We do not want to use null values */
        gradeBy.setNullSelectionAllowed(false);
        /* Add an empty gradeBy used for selecting no gradeBy */
        gradeBy.addItem("");
        try
        {
            gradeBy.addItems(gradeByOptions);

        } catch (NullPointerException e)
        {
        }

        /* Allow the user to enter new serialNumber */
        serialNumber.setNewItemsAllowed(true);
        /* We do not want to use null values */
        serialNumber.setNullSelectionAllowed(false);
        /* Add an empty serialNumber used for selecting no serialNumber */
        serialNumber.addItem("");
        try
        {
            serialNumber.addItems(serialNumberOptions);

        } catch (NullPointerException e)
        {
        }

        /* Allow the user to enter new quality */
        quality.setNewItemsAllowed(true);
        /* We do not want to use null values */
        quality.setNullSelectionAllowed(false);
        /* Add an empty quality used for selecting no quality */
        quality.addItem("");
        try
        {
            quality.addItems(qualityOptions);

        } catch (NullPointerException e)
        {
        }

        /* Allow the user to enter new catalog */
        catalogType.setNewItemsAllowed(true);
        /* We do not want to use null values */
        catalogType.setNullSelectionAllowed(false);
		/* Add an empty catalog used for selecting no catalog */
        catalogType.addItem("");
        try
        {
            catalogType.addItems(catalogTypeOptions);

        } catch (NullPointerException e)
        {
        }
    }

    // **********************************************************************************
    @Override
    public void setReadOnly(final boolean readOnly)
    {
        super.setReadOnly(readOnly);

        grade.setReadOnly(readOnly);
        gradeBy.setReadOnly(readOnly);
        serialNumber.setReadOnly(readOnly);
        quality.setReadOnly(readOnly);
        metalContent.setReadOnly(readOnly);
        mintMark.setReadOnly(readOnly);
        mint.setReadOnly(readOnly);
        catalogType.setReadOnly(readOnly);
        diameter.setReadOnly(readOnly);
        weight.setReadOnly(readOnly);
        thickness.setReadOnly(readOnly);
        composition.setReadOnly(readOnly);
        edge.setReadOnly(readOnly);
        designer.setReadOnly(readOnly);
        notes.setReadOnly(readOnly);
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
//        grade.setValue("");
//        gradeBy.setValue("");
//        serialNumber.setValue("");
//        quality.setValue("");
        metalContent.setValue("");
        mintMark.setValue("");
        mint.setValue("");
//        catalogType.setValue("");
        diameter.setValue("");
        weight.setValue("");
        thickness.setValue("");
        composition.setValue("");
        edge.setValue("");
        designer.setValue("");
        notes.setValue("");

        // **********************************************************************************
//        grade.setNullRepresentation("");
//        gradeBy.setNullRepresentation("");
//        serialNumber.setNullRepresentation("");
//        quality.setNullRepresentation("");
        metalContent.setNullRepresentation("");
        mintMark.setNullRepresentation("");
        mint.setNullRepresentation("");
//        catalogType.setNullRepresentation("");
        diameter.setNullRepresentation("");
        weight.setNullRepresentation("");
        thickness.setNullRepresentation("");
        composition.setNullRepresentation("");
        edge.setNullRepresentation("");
        designer.setNullRepresentation("");
        notes.setNullRepresentation("");
    }

    public void cancelEditing()
    {
        clearForm();
    }

    // **********************************************************************************
    protected void setTableName(String tableName)
    {
        this.tableName = tableName;
        String s = "coinsTable";
        if (s != tableName)
        {
//            setComboBoxData(newDataSource);
//            setComboBoxDataSource();
            updateCoinAttributes();
        }
        else
        {
//            saveCoinAttributesData();
            saveCoinAttributes();
        }
    }

    // **********************************************************************************
    public void setGradeOptions(Collection<String> gradeOptions)
    {
        this.gradeOptions = gradeOptions;
    }

    public void setGradeByOptions(Collection<String> gradeByOptions)
    {
        this.gradeByOptions = gradeByOptions;
    }

    public void setSerialNumberOptions(Collection<String> serialNumberOptions)
    {
        this.serialNumberOptions = serialNumberOptions;
    }

    public void setQualityOptions(Collection<String> qualityOptions)
    {
        this.qualityOptions = qualityOptions;
    }

    public void setCatalogTypeOptions(Collection<String> catalogTypeOptions)
    {
        this.catalogTypeOptions = catalogTypeOptions;
    }
}
