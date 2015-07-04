package net.downthehall.ui.tabbedPanel.editPanel;

import org.vaadin.addon.cdimvp.MVPView;

import java.util.Collection;

/**
 * Created by joseph on 8/3/2014.
 */
public interface EditPanelView extends MVPView
{
    void setGradeOptions(Collection<String> gradeOptions);

    void setGradeByOptions(Collection<String> gradeByOptions);

    void setSerialNumberOptions(Collection<String> serialNumberOptions);

    void setQualityOptions(Collection<String> qualityOptions);

    void setCatalogTypeOptions(Collection<String> catalogTypeOptions);

    void popupDateFieldEnabled();

    void popupDateFieldDisabled();

    void cancelEditing();
}
