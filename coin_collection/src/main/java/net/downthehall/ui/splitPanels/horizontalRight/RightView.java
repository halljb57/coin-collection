package net.downthehall.ui.splitPanels.horizontalRight;

import org.vaadin.addon.cdimvp.MVPView;

/**
 * Created by joseph on 7/26/2014.
 */
public interface RightView extends MVPView
{
    void setVerticalTopView(Class<? extends MVPView> viewClass);

    void setVerticalBottomView(Class<? extends MVPView> viewClass);
}
