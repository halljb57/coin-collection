package net.downthehall.ui.main;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.ui.MenuBarTop;
import net.downthehall.ui.Toolbar;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.MVPView;
import org.vaadin.addon.cdiproperties.annotation.HorizontalSplitPanelProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/30/2014.
 */
@SuppressWarnings("serial")
public class MainViewImpl extends AbstractMVPView implements MainView
{
    @Inject
    @HorizontalSplitPanelProperties
    private HorizontalSplitPanel horizontalSplit;

    @Inject
    private Instance<MVPView> views;
    @Inject
    private Instance<Toolbar> toolbars;
    @Inject
    private Instance<MenuBarTop> menuBarTops;

    // **********************************************************************************
    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        VerticalLayout mainLayout = new VerticalLayout();
        setCompositionRoot(mainLayout);
        mainLayout.setSizeFull();

        mainLayout.addComponent(menuBarTops.get());
        mainLayout.addComponent(toolbars.get());
        mainLayout.addComponent(horizontalSplit);
        mainLayout.setExpandRatio(horizontalSplit, 1);

        horizontalSplit.setSplitPosition(400, Unit.PIXELS);
    }

    // **********************************************************************************
    @Override
    public void setHorizontalLeftView(Class<? extends MVPView> viewClass)
    {
        MVPView view = views.select(viewClass).get();

        horizontalSplit.setFirstComponent((Component) view);
    }

    @Override
    public void setHorizontalRightView(Class<? extends MVPView> viewClass)
    {
        MVPView view = views.select(viewClass).get();

        horizontalSplit.setSecondComponent((Component) view);
    }

    // **********************************************************************************
    @Override
    public void enter()
    {
        super.enter();
        fireViewEvent(MainPresenter.HORIZONTAL_LEFT, null);
        fireViewEvent(MainPresenter.HORIZONTAL_RIGHT, null);
    }
}
