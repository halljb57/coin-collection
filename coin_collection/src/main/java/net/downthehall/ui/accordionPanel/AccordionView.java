package net.downthehall.ui.accordionPanel;

import net.downthehall.business.model.vo.CollectionNames;
import net.downthehall.business.model.vo.ShowDenominationSeries;
import net.downthehall.business.model.vo.ShowDenominations;
import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 8/3/2014.
 */
public interface AccordionView extends MVPView
{

    void setCollectionNameList(Collection<CollectionNames> collectionName);
    void setDenominationsList(Collection<ShowDenominations> showDenominations);
    void setDenominationSeriesList(Collection<ShowDenominationSeries> showDenominationSeries);
    void refreshCollectionList(Collection<CollectionNames> collectionName);
    void refreshDenominationsList(Collection<ShowDenominations> showDenominations);
    void refreshDenominationSeriesList(Collection<ShowDenominationSeries> showDenominationSeries);
    void setCollectionTab();
    void setDenominationTab();
    void setDenominationSeriesTab();
}
