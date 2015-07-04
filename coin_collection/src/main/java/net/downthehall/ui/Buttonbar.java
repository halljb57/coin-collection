package net.downthehall.ui;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import net.downthehall.ui.splitPanels.horizontalRight.RightPresenter;
import org.vaadin.addon.cdimvp.ViewComponent;
import org.vaadin.addon.cdiproperties.annotation.ButtonProperties;
import org.vaadin.addon.cdiproperties.annotation.HorizontalLayoutProperties;
import org.vaadin.addon.cdiproperties.annotation.VerticalLayoutProperties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by joseph on 7/26/2014.
 */
@SuppressWarnings("serial")
@UIScoped
public class Buttonbar extends ViewComponent
{
    @Inject
    @ButtonProperties(caption = "Detail")
    private Button detailButton;
    @Inject
    @ButtonProperties(caption = "Edit")
    private Button editButton;
    @Inject
    @ButtonProperties(caption = "Create")
    private Button createButton;

    @Inject
    @VerticalLayoutProperties(margin = true)
    private VerticalLayout verticalLayout;
    @Inject
    @HorizontalLayoutProperties(spacing = true)
    private HorizontalLayout horizontalLayout;

    @PostConstruct
    public void init()
    {
        buildVerticalLayout();
    }

    private VerticalLayout buildVerticalLayout()
    {
        setCompositionRoot(verticalLayout);

        horizontalLayout = buildHorizontalLayout();
        verticalLayout.addComponent(horizontalLayout);

        return verticalLayout;
    }

    private HorizontalLayout buildHorizontalLayout()
    {
        createButton = buildCreateButton();
        detailButton = buildDetailButton();
        editButton = buildEditButton();
        horizontalLayout.addComponent(createButton);
        horizontalLayout.addComponent(editButton);
        horizontalLayout.addComponent(detailButton);

        return horizontalLayout;
    }

    private Button buildCreateButton()
    {
        createButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                Notification.show("Create Form");
                fireViewEvent(RightPresenter.CREATE_TAB_PANEL, null);
            }
        });

        return createButton;
    }

    private Button buildDetailButton()
    {
        detailButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                Notification.show("Detail Form");
                fireViewEvent(RightPresenter.DETAIL_TAB_PANEL, null);
                fireViewEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW, null);
            }
        });

        return detailButton;
    }

    private Button buildEditButton()
    {
        editButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                Notification.show("Edit Form");
//                fireViewEvent(RightPresenter.SET_TABLE_NAME, null);
                fireViewEvent(RightPresenter.COIN_ATTRIBUTES_LIST_VIEW, null);
            }
        });

        return editButton;
    }
}
