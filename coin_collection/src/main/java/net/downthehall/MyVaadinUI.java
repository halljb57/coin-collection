package net.downthehall;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import net.downthehall.ui.main.MainViewImpl;
import net.downthehall.util.Props;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Theme(Props.THEME_NAME)
@SuppressWarnings("serial")
@CDIUI
public class MyVaadinUI extends UI
{
    @Inject
    private Instance<MainViewImpl> mainViews;

    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request)
    {
        setContent(mainViews.get());
        mainViews.get().enter();
    }
}
