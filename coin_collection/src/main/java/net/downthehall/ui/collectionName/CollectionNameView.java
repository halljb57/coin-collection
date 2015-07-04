package net.downthehall.ui.collectionName;

import net.downthehall.business.model.vo.CollectionNames;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 8/9/2014.
 */
public interface CollectionNameView extends MVPView
{
    void setCollectionNameList(Collection<CollectionNames> collectionName);

    void showCollectionNameDetails();

    void editNewCollectionName(CollectionNames collectionNames);

//    void setCityOptions(Collection<String> cityOptions);

    void addCollectionNameToList(CollectionNames collectionNames);

    void selectCollectionName(CollectionNames collectionNames);

    void editSelectedCollectionName();

//    void applyFilter(SearchFilter searchFilter);

    void cancelEditing();

    void refreshCollectionListView(Collection<CollectionNames> collectionName);
}