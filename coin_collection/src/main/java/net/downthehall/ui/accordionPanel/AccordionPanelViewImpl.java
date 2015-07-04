package net.downthehall.ui.accordionPanel;

import com.vaadin.ui.VerticalLayout;
import net.downthehall.business.model.vo.CollectionNames;
import net.downthehall.business.model.vo.ShowDenominationSeries;
import net.downthehall.business.model.vo.ShowDenominations;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/3/2014.
 */
@SuppressWarnings("serial")
public class AccordionPanelViewImpl extends AbstractMVPView implements AccordionView
{
    @Inject
    private Instance<AccordionPanelView> accordionPanels;
    @Inject
    private Instance<AccordionCollectionList> accordionCollectionLists;
    @Inject
    private Instance<AccordionDenominationList> accordionDenominationLists;
    @Inject
    private Instance<AccordionDenominationSeriesList> accordionDenominationSeriesLists;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        accordionPanels.get().init();
        layout.addComponent(accordionPanels.get());
    }

    // **********************************************************************************
    @Override
    public void setCollectionNameList(Collection<CollectionNames> collectionName)
    {
        accordionCollectionLists.get().setCollectionNameList(collectionName);
    }

    @Override
    public void setDenominationsList(Collection<ShowDenominations> showDenominations)
    {
        accordionDenominationLists.get().setDenominationsList(showDenominations);
    }

    @Override
    public void setDenominationSeriesList(Collection<ShowDenominationSeries> showDenominationSeries)
    {
        accordionDenominationSeriesLists.get().setDenominationSeriesList(showDenominationSeries);
    }

    @Override
    public void refreshCollectionList(Collection<CollectionNames> collectionName)
    {
        if (collectionName == null)
        {
            accordionCollectionLists.get().refreshCollectionList();
        }
    }

    @Override
    public void refreshDenominationsList(Collection<ShowDenominations> showDenominations)
    {
        if (showDenominations == null)
        {
            accordionDenominationLists.get().refreshDenominationsList();
        }
    }

    @Override
    public void refreshDenominationSeriesList(Collection<ShowDenominationSeries> showDenominationSeries)
    {
        if (showDenominationSeries == null)
        {
            accordionDenominationSeriesLists.get().refreshDenominationSeriesList();
        }
    }

    @Override
    public void setCollectionTab()
    {
        accordionPanels.get().setL1Tab();
    }

    @Override
    public void setDenominationTab()
    {
        accordionPanels.get().setL2Tab();
    }

    @Override
    public void setDenominationSeriesTab()
    {
        accordionPanels.get().setL3Tab();
    }
}
