package net.downthehall.ui.main;

import net.downthehall.ui.splitPanels.horizontalLeft.LeftView;
import net.downthehall.ui.splitPanels.horizontalLeft.LeftViewImpl;
import net.downthehall.ui.splitPanels.horizontalRight.RightView;
import net.downthehall.ui.splitPanels.horizontalRight.RightViewImpl;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 7/30/2014.
 */
@SuppressWarnings("serial")
@ViewInterface(MainView.class)
public class MainPresenter extends AbstractMVPPresenter<MainView>
{
    public static final String HORIZONTAL_LEFT = "main_presenter_horizontal_left";
    public static final String HORIZONTAL_RIGHT = "main_presenter_horizontal_right";

    // **********************************************************************************
    @Inject
    private Instance<RightViewImpl> rightViews;
    @Inject
    private Instance<LeftViewImpl> leftViews;

    // **********************************************************************************
    protected void horizontalLeft(
            @Observes @CDIEvent(HORIZONTAL_LEFT) final ParameterDTO parameters)
    {
        leftViews.get().enter();
        view.setHorizontalLeftView(LeftView.class);
    }

    protected void horizontalRight(
            @Observes @CDIEvent(HORIZONTAL_RIGHT) final ParameterDTO parameters)
    {
        rightViews.get().enter();
        view.setHorizontalRightView(RightView.class);
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
