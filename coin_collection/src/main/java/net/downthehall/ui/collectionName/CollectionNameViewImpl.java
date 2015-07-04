package net.downthehall.ui.collectionName;

import com.vaadin.data.Item;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CollectionNames;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/9/2014.
 */
@SuppressWarnings("serial")
public class CollectionNameViewImpl extends AbstractMVPView implements CollectionNameView
{
    @Inject
    private Instance<CollectionNameList> collectionNameLists;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        collectionNameLists.get().init();
        layout.addComponent(collectionNameLists.get());
    }

    // **********************************************************************************
    @Override
    public void setCollectionNameList(Collection<CollectionNames> collectionName)
    {
        if (collectionName == null)
        {
            Notification.show("From CollectionNameViewImpl NULL");
        }
//        collectionNameLists.get().setCollectionNameList(null);
        collectionNameLists.get().setCollectionNameList(collectionName);
    }

    @Override
    public void showCollectionNameDetails()
    {
        Item item = collectionNameLists.get().getSelectedItem();
    }

    @Override
    public void editNewCollectionName(CollectionNames collectionNames)
    {
        collectionNameLists.get().setValue(null);
    }

    @Override
    public void addCollectionNameToList(CollectionNames collectionNames)
    {
        collectionNameLists.get().addCollectionNameToList(collectionNames);
    }

    @Override
    public void selectCollectionName(CollectionNames collectionNames)
    {
        collectionNameLists.get().setValue(collectionNames);
    }

    @Override
    public void editSelectedCollectionName()
    {

    }

    @Override
    public void cancelEditing()
    {

    }

    @Override
    public void refreshCollectionListView(Collection<CollectionNames> collectionName)
    {
        if (collectionName == null)
        {
                collectionNameLists.get().refreshList();
        }
    }
}
