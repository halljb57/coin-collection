package net.downthehall.ui.tabbedPanel.detailPanel;

import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 8/3/2014.
 */
@SuppressWarnings("serial")
public class DetailPanelViewImpl extends AbstractMVPView implements DetailPanelView
{
    @Inject
    private Instance<DetailTabPanel> detailTabPanels;

    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        detailTabPanels.get().init();
        layout.addComponent(detailTabPanels.get());
    }
}
