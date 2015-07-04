package net.downthehall.ui.main;

import org.vaadin.addon.cdimvp.MVPView;

/**
 * Created by joseph on 7/30/2014.
 */
public interface MainView extends MVPView
{
    void setHorizontalLeftView(Class<? extends MVPView> viewClass);

    void setHorizontalRightView(Class<? extends MVPView> viewClass);
}
