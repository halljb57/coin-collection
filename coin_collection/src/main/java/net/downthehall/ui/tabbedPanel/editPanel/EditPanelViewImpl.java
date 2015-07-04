package net.downthehall.ui.tabbedPanel.editPanel;

import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by joseph on 8/3/2014.
 */
@SuppressWarnings("serial")
public class EditPanelViewImpl extends AbstractMVPView implements EditPanelView
{
    @Inject
    private Instance<EditTabPanel> editTabPanels;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForms;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        editTabPanels.get().init();
        layout.addComponent(editTabPanels.get());
    }

    @Override
    public void setGradeOptions(final Collection<String> gradeOptions)
    {
        moreDetailForms.get().setGradeOptions(gradeOptions);
    }

    @Override
    public void setGradeByOptions(final Collection<String> gradeByOptions)
    {
        moreDetailForms.get().setGradeByOptions(gradeByOptions);
    }

    @Override
    public void setSerialNumberOptions(final Collection<String> serialNumberOptions)
    {
        moreDetailForms.get().setSerialNumberOptions(serialNumberOptions);
    }

    @Override
    public void setQualityOptions(final Collection<String> qualityOptions)
    {
        moreDetailForms.get().setQualityOptions(qualityOptions);
    }

    @Override
    public void setCatalogTypeOptions(final Collection<String> catalogTypeOptions)
    {
        moreDetailForms.get().setCatalogTypeOptions(catalogTypeOptions);
    }

    @Override
    public void popupDateFieldEnabled()
    {
        buyAndSellForms.get().popupDateFieldEnabled();
    }

    @Override
    public void popupDateFieldDisabled()
    {
        buyAndSellForms.get().popupDateFieldDisabled();
    }

    // **********************************************************************************
    @Override
    public void cancelEditing()
    {
        itemDetailForms.get().cancelEditing();
        moreDetailForms.get().cancelEditing();
        buyAndSellForms.get().cancelEditing();
    }
}
