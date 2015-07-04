package net.downthehall.ui.countryName;

import net.downthehall.business.model.vo.CountryNames;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 8/9/2014.
 */
public interface CountryNameView extends MVPView
{
    void setCountryList(Collection<CountryNames> countryNames);

    void showSelectedCountryDetails();

    void editNewCountry(CountryNames countryNames);

//    void setCityOptions(Collection<String> cityOptions);

    void addCountryToList(CountryNames countryNames);

    void selectCountry(CountryNames countryNames);

    void editSelectedCountry();

//    void applyFilter(SearchFilter searchFilter);

    void cancelEditing();
}