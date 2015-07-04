package net.downthehall.ui.splitPanels.horizontalRight;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import net.downthehall.ui.tabbedPanel.detailPanel.DetailTabPanel;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.MVPView;
import org.vaadin.addon.cdiproperties.annotation.VerticalSplitPanelProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/26/2014.
 * TopLeftViewImpl is the implementation of TopLeftView and receives
 * the calls from TopLeft.
 */
@SuppressWarnings("serial")
public class RightViewImpl extends AbstractMVPView implements RightView
{
    /*
     * Instance<TopLeftTwo> is used here so the topLeftTwo and topLeftOne won't
     * be injected until needed (Lazy initialization). They are both @UIScoped
     * so topLeftTwo.get() will always return the same instance (for the current
     * UI).
     */
    @Inject
    private Instance<DetailTabPanel> detailTabPanels;
    @Inject
    @VerticalSplitPanelProperties(splitPosition = 45.f)
    private VerticalSplitPanel verticalSplitPanel;
    @Inject
    private Instance<MVPView> views;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        layout.addComponent(verticalSplitPanel);
        layout.setExpandRatio(verticalSplitPanel, 1);
    }

    // **********************************************************************************
    @Override
    public void setVerticalTopView(Class<? extends MVPView> viewClass)
    {
        MVPView view = views.select(viewClass).get();

        verticalSplitPanel.setFirstComponent((Component) view);
    }

    @Override
    public void setVerticalBottomView(Class<? extends MVPView> viewClass)
    {
        MVPView view = views.select(viewClass).get();

        verticalSplitPanel.setSecondComponent((Component) view);
    }

    // **********************************************************************************
    @Override
    public void enter()
    {
        super.enter();
        fireViewEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW, null);
        fireViewEvent(RightPresenter.DETAIL_TAB_PANEL, null);
    }
}
