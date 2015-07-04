package net.downthehall.ui.popUpWindows;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.*;
import net.downthehall.business.service.CountryNamesService;
import net.downthehall.ui.collectionName.SaveCollectionName;

/**
 * Created by joseph on 9/15/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class NewCollection extends Window
{
    private FormLayout formLayout = new FormLayout();
    private HorizontalLayout buttonLayout = new HorizontalLayout();
    private VerticalLayout verticalLayout = new VerticalLayout();
    private TextField collectionTextField = new TextField("Collection:");
    private ComboBox countryCBB = new ComboBox("Country:");
    private TextArea commentTextArea = new TextArea("Comments:");
    private CountryNamesService service = new CountryNamesService();

    // **********************************************************************************
    public NewCollection()
    {
        /*
          * Make the window modal, which will disable all other components while
          * it is visible
          */
        setModal(true);

        /* Make the sub window 50% the size of the browser window */
        setSizeUndefined();
         /*
          * Center the window both horizontally and vertically in the browser
          * window
          */
        center();

        setCaption("New Collection");

        buildVerticalLayout();
        buildCollectionForm();
        buildButtonLayout();
        setComboBoxDataSource();
    }

    // **********************************************************************************
    // Initialize buildVerticalLayout
    private VerticalLayout buildVerticalLayout()
    {
        verticalLayout.setSizeUndefined();
        verticalLayout.setMargin(true);

        verticalLayout.addComponent(formLayout);
        verticalLayout.addComponent(buttonLayout);

        setContent(verticalLayout);
        return verticalLayout;
    }

    // **********************************************************************************
    // Initialize buildButtonLayout
    private HorizontalLayout buildButtonLayout()
    {
        buttonLayout.setMargin(true);
        buttonLayout.addComponent(new Button("Save", new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                Notification.show("Save Button Clicked", Notification.Type.TRAY_NOTIFICATION);
                setSavedItems();
                getUI().removeWindow(NewCollection.this);
            }
        }));

        buttonLayout.addComponent(new Button("Cancel", new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                Notification.show("Cancel Button Clicked", Notification.Type.TRAY_NOTIFICATION);
                getUI().removeWindow(NewCollection.this);
            }
        }));

        buttonLayout.setSpacing(true);
        return buttonLayout;
    }

    // **********************************************************************************
    // Initialize buildCollectionForm
    private FormLayout buildCollectionForm()
    {
        formLayout.setSizeUndefined();
        formLayout.addComponent(collectionTextField);
        formLayout.addComponent(countryCBB);
        formLayout.addComponent(commentTextArea);
        return formLayout;
    }

    // **********************************************************************************
    private void setSavedItems()
    {


        SaveCollectionName.getInstance().saveCollectionName(collectionTextField, countryCBB, commentTextArea);
        SaveCollectionName.getInstance().save();
    }

    /* Populate comboBoxes from selection in table */
    private void setComboBoxDataSource()
    {
        /* Allow the user to enter new country */
//        countryCBB.setNewItemsAllowed(true);
        /* We do not want to use null values */
        countryCBB.setNullSelectionAllowed(false);
        /* Add an empty country used for selecting no country */
//        countryCBB.addItem("");
        countryCBB.addItems(service.findCountry());
    }


}
