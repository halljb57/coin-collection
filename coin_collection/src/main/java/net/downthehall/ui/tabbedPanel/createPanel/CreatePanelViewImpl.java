package net.downthehall.ui.tabbedPanel.createPanel;

import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 8/3/2014.
 */
@SuppressWarnings("serial")
public class CreatePanelViewImpl extends AbstractMVPView implements CreatePanelView
{
    @Inject
    private Instance<CreateTabPanel> createTabPanels;

    @PostConstruct
    protected void initView()
    {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        setCompositionRoot(layout);
        layout.setSizeFull();

        createTabPanels.get().init();
        layout.addComponent(createTabPanels.get());
    }
}
