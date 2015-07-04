package net.downthehall.ui.countryName;

import com.vaadin.data.Item;
import com.vaadin.ui.*;
import net.downthehall.business.model.vo.CountryNames;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/9/2014.
 */
@SuppressWarnings("serial")
public class CountryNameViewImpl extends AbstractMVPView implements CountryNameView
{
    @Inject
    private Instance<CountryList> countryLists;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

//        layout.addComponent(new Label("From CountryNameViewImpl"));
        countryLists.get().init();
        layout.addComponent(countryLists.get());
    }

    // **********************************************************************************
    @Override
    public void setCountryList(Collection<CountryNames> countryNames)
    {
        countryLists.get().setCountryList(countryNames);
    }

    @Override
    public void showSelectedCountryDetails()
    {
        Item item = countryLists.get().getSelectedItem();
    }

    @Override
    public void editNewCountry(CountryNames countryNames)
    {
        countryLists.get().setValue(null);
    }

    @Override
    public void addCountryToList(CountryNames countryNames)
    {
        countryLists.get().addCountryToList(countryNames);
    }

    @Override
    public void selectCountry(CountryNames countryNames)
    {
        countryLists.get().setValue(countryNames);
    }

    @Override
    public void editSelectedCountry()
    {

    }

    @Override
    public void cancelEditing()
    {

    }
}
