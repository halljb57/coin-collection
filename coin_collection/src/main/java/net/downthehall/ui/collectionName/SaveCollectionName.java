package net.downthehall.ui.collectionName;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import net.downthehall.business.model.vo.CollectionNames;
import net.downthehall.business.service.CollectionNamesService;
import net.downthehall.business.service.FindIdByNameService;
import net.downthehall.util.CurrentTimeStamp;

/**
 * Created by joseph on 9/15/2014.
 */
public class SaveCollectionName
{
    private static SaveCollectionName instance = null;
    // **********************************************************************************
    private CollectionNames collectionNames = new CollectionNames();
    private CollectionNamesService service = new CollectionNamesService();
    private CurrentTimeStamp timeStamp = new CurrentTimeStamp();
    FindIdByNameService service1 = new FindIdByNameService();
    // **********************************************************************************
    private TextField collectionName;
    private ComboBox country;
    private TextArea comments;
    private int countryId;

    // **********************************************************************************
    protected SaveCollectionName()
    {
        // Exists only to defeat instantiation.
    }

    public static SaveCollectionName getInstance()
    {
        if (instance == null)
        {
            instance = new SaveCollectionName();
        }
        return instance;
    }

    // **********************************************************************************
    public void saveCollectionName(TextField collectionName, ComboBox country, TextArea comments)
    {
        this.collectionName = collectionName;
        this.country = country;
        this.comments = comments;
    }

    // **********************************************************************************
    // TODO Move to presenter
    public void save()
    {
        countryIdByName();

        collectionNames.setCollection_Name(collectionName.getValue());
        collectionNames.setCountry_Id(service1.getId());
        collectionNames.setComments(String.valueOf(comments));
        collectionNames.setDate_Created(timeStamp.currentTimeStamp());

        service.create(collectionNames);
    }

    /* Get the Integer value of the country name */
    // TODO Move to presenter
    private void countryIdByName()
    {
        service1.setTableName("country_names");
        service1.setColumnId("country_Id");
        service1.setColumnName("country");
        service1.setNewName(String.valueOf(country.getValue()));
        service1.findIdByName();
    }
}
