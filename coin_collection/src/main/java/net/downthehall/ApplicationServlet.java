package net.downthehall;

import com.vaadin.server.Constants;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import net.downthehall.util.Props;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by joseph on 10/26/2014.
 */
@WebServlet(urlPatterns = "/*", initParams = {
        @WebInitParam(name = VaadinSession.UI_PARAMETER, value = Props.UI_NAME),
        @WebInitParam(name = Constants.SERVLET_PARAMETER_UI_PROVIDER, value = Props.CDIUI_PROVIDER)})
public class ApplicationServlet extends VaadinServlet
{
}
