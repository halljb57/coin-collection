package net.downthehall.ui.tabbedPanel.editPanel;

import net.downthehall.business.model.vo.ShowCoinAttributes;
import net.downthehall.business.model.vo.ShowCoins;
import net.downthehall.business.service.FindByName;
import net.downthehall.business.service.FindIdByNameService;
import net.downthehall.business.service.FindNameByIdService;
import net.downthehall.ui.tabbedPanel.SaveCoinAttributes;
import net.downthehall.ui.tabbedPanel.UpdateCoinAttributes;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by joseph on 8/3/2014.
 */
@SuppressWarnings("serial")
@AbstractMVPPresenter.ViewInterface(EditPanelView.class)
public class EditPanelPresenter extends AbstractMVPPresenter<EditPanelView>
{
    public static final String SAVE_COIN_ATTRIBUTE = "Save Coin Attribute";
    public static final String SAVE_COIN_ATTRIBUTES_DATA = "Save Coin Attributes Data";
    public static final String UPDATE_COIN_ATTRIBUTE = "Update Coin Attribute";
    public static final String COLLECTION_NAME_BY_ID = "Collection Name By Id";
    public static final String CANCEL_EDITING = "Cancel Editing";
    public static final String DELETE_COIN_ATTRIBUTE = "Delete Coin Attribute";
    public static final String SET_TABLE_NAME = "Set Table Name";
    public static final String SET_COLLECTION_NAME = "Set Collection Name";
    public static final String SET_COUNTRY_NAME = "Set Country Name";
    public static final String SET_DENOMINATION_NAME = "Set Denomination Name";
    public static final String SET_DENOMINATION_SERIES_NAME = "Set Denomination Series Name";
    public static final String SET_READ_ONLY_TRUE = "Set ReadOnly True";
    public static final String SET_READ_ONLY_FALSE = "Set ReadOnly False";
    public static final String SET_MAIN_TAB = "Set Main Tab";
    public static final String ENABLE_EDIT_PANEL_BUTTONS = "Enable Edit Panel Buttons";
    public static final String ENABLE_EDIT_PANEL_CANCEL_BUTTONS = "Enable Edit Panel Cancel Buttons";
    public static final String DISABLE_EDIT_PANEL_BUTTONS = "Disable Edit Panel Buttons";
    public static final String DISABLE_EDIT_PANEL_DELETE_BUTTONS = "Disable Edit Panel Delete Buttons";
    public static final String POPUP_DATE_FIELD_ENABLED = "Popup Date Field Enabled";
    public static final String POPUP_DATE_FIELD_DISABLED = "Popup Date Field Disabled";
    public static final String GRADE_OPTIONS = "Grade Options";
    public static final String GRADE_BY_OPTIONS = "Grade By Options";
    public static final String SERIAL_NUMBER_OPTIONS = "Serial Number Options";
    public static final String QUALITY_OPTIONS = "Quality Options";
    public static final String CATALOG_TYPE_OPTIONS = "Catalog Type Options";


    // ********************************************************************************** Injected Services
    @Inject
    FindNameByIdService findNameByIdService;
    @Inject
    FindIdByNameService findIdByNameService;
    @Inject
    FindByName findByName;
    // ********************************************************************************** Injected Classes
    @Inject
    private Instance<EditTabPanel> editTabPanels;
    @Inject
    private Instance<ItemDetailForm> itemDetailForms;
    @Inject
    private Instance<MoreDetailForm> moreDetailForms;
    @Inject
    private Instance<BuyAndSellForm> buyAndSellForms;

    // ********************************************************************************** Views
    protected void cancelEditing(
            @Observes @CDIEvent(CANCEL_EDITING) final ParameterDTO parameters)
    {
        view.cancelEditing();
    }

    // ********************************************************************************** Save Update Delete
    protected void saveCoinAttribute(
            @Observes @CDIEvent(SAVE_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        ShowCoins coins = parameters.getPrimaryParameter(ShowCoins.class);

        if (coins.isPersistent())
        {
            SaveCoinAttributes.getInstance().setMintYear(coins.getMint_Year());
            SaveCoinAttributes.getInstance().setMintageForCirculation(
                    String.valueOf(coins.getMintage_For_Circulation()));
            SaveCoinAttributes.getInstance().setMintageOfProofs(String.valueOf(coins.getMintage_Of_Proofs()));
            SaveCoinAttributes.getInstance().setMintMark(coins.getMint_Mark());
            SaveCoinAttributes.getInstance().setDiameter(coins.getDiameter());
            SaveCoinAttributes.getInstance().setMetalContent(coins.getMetal_Content());
            SaveCoinAttributes.getInstance().setWeight(coins.getWeight());
            SaveCoinAttributes.getInstance().setEdge(coins.getEdge());
            SaveCoinAttributes.getInstance().setNotes(coins.getNotes());

            SaveCoinAttributes.getInstance().save();
        }
        else
        {
            SaveCoinAttributes.getInstance().save();
        }
    }

    protected void updateCoinAttribute(
            @Observes @CDIEvent(UPDATE_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        ShowCoinAttributes coinAttributes = parameters.getPrimaryParameter(ShowCoinAttributes.class);


        if (coinAttributes.isPersistent())
        {
            UpdateCoinAttributes.getInstance().update();
        }
        else
        {
            System.out.println("updateCoinAttribute NOT PERSISTENT");
        }
    }

    protected void deleteCoinAttribute(
            @Observes @CDIEvent(DELETE_COIN_ATTRIBUTE) final ParameterDTO parameters)
    {
        ShowCoinAttributes coinAttributes = parameters.getPrimaryParameter(ShowCoinAttributes.class);


        if (coinAttributes.isPersistent())
        {
            UpdateCoinAttributes.getInstance().delete();
        }
        else
        {
            System.out.println("NO");
        }
    }

    // ********************************************************************************** Set Names
    protected void collectionNameById(
            @Observes @CDIEvent(COLLECTION_NAME_BY_ID) final ParameterDTO parameters)
    {
        String id = (String) parameters.getPrimaryParameter();
        findNameByIdService.setTableName("collection_names");
        findNameByIdService.setColumnId("collection_Id");
        findNameByIdService.setColumnName("collection_Name");
        findNameByIdService.setId(Integer.parseInt(id));
        findNameByIdService.findNameById();

        itemDetailForms.get().setCollectionName(findNameByIdService.getNewName());

    }

    protected void setCollectionName(
            @Observes @CDIEvent(SET_COLLECTION_NAME) final ParameterDTO parameters)
    {
        String name = (String) parameters.getPrimaryParameter();

        findIdByNameService.setTableName("collection_names");
        findIdByNameService.setColumnId("collection_Id");
        findIdByNameService.setColumnName("collection_Name");
        findIdByNameService.setNewName(name);
        findIdByNameService.findIdByName();

        itemDetailForms.get().setCollectionName(name);
        itemDetailForms.get().setNewCollectionId(findIdByNameService.getId());
    }

    protected void setCountryName(
            @Observes @CDIEvent(SET_COUNTRY_NAME) final ParameterDTO parameters)
    {
        int id = (int) parameters.getPrimaryParameter();
        findNameByIdService.setTableName("country_names");
        findNameByIdService.setColumnId("country_Id");
        findNameByIdService.setColumnName("country");
        findNameByIdService.setId(id);
        findNameByIdService.findNameById();

        itemDetailForms.get().setCountryName(findNameByIdService.getNewName());
    }

    protected void setDenominationName(
            @Observes @CDIEvent(SET_DENOMINATION_NAME) final ParameterDTO parameters)
    {
        String name = (String) parameters.getPrimaryParameter();
        itemDetailForms.get().setDenominationName(name);
    }

    protected void setDenominationSeriesName(
            @Observes @CDIEvent(SET_DENOMINATION_SERIES_NAME) final ParameterDTO parameters)
    {
        String name = (String) parameters.getPrimaryParameter();
        itemDetailForms.get().setDenominationSeriesName(name);
    }

    // ********************************************************************************** setReadOnly
    protected void setReadOnlyFalse(
            @Observes @CDIEvent(SET_READ_ONLY_FALSE) final ParameterDTO parameters)
    {
        itemDetailForms.get().setReadOnly(false);
        moreDetailForms.get().setReadOnly(false);
        buyAndSellForms.get().setReadOnly(false);
    }

    protected void setReadOnlyTRUE(
            @Observes @CDIEvent(SET_READ_ONLY_TRUE) final ParameterDTO parameters)
    {
        itemDetailForms.get().setReadOnly(true);
        moreDetailForms.get().setReadOnly(true);
        buyAndSellForms.get().setReadOnly(true);
    }

    // ********************************************************************************** Edit Panel Button Control
    protected void enableEditPanelButtons(
            @Observes @CDIEvent(ENABLE_EDIT_PANEL_BUTTONS) final ParameterDTO parameters)
    {
        editTabPanels.get().saveBtn.setEnabled(true);
        editTabPanels.get().deleteBtn.setEnabled(true);
        editTabPanels.get().cancelBtn.setEnabled(true);
    }

    protected void disableEditPanelButtons(
            @Observes @CDIEvent(DISABLE_EDIT_PANEL_BUTTONS) final ParameterDTO parameters)
    {
        editTabPanels.get().saveBtn.setEnabled(false);
        editTabPanels.get().deleteBtn.setEnabled(false);
        editTabPanels.get().cancelBtn.setEnabled(false);
    }

    protected void disableEditPanelDeletButtons(
            @Observes @CDIEvent(DISABLE_EDIT_PANEL_DELETE_BUTTONS) final ParameterDTO parameters)
    {
        editTabPanels.get().saveBtn.setEnabled(true);
        editTabPanels.get().deleteBtn.setEnabled(false);
        editTabPanels.get().cancelBtn.setEnabled(true);
    }

    protected void enableEditPanelCancelButtons(
            @Observes @CDIEvent(ENABLE_EDIT_PANEL_CANCEL_BUTTONS) final ParameterDTO parameters)
    {
        editTabPanels.get().saveBtn.setEnabled(false);
        editTabPanels.get().deleteBtn.setEnabled(false);
        editTabPanels.get().cancelBtn.setEnabled(true);
    }

    // ********************************************************************************** Set Main Tab
    protected void setMainTab(
            @Observes @CDIEvent(SET_MAIN_TAB) final ParameterDTO parameters)
    {
        editTabPanels.get().setMainTab();
    }

    // ********************************************************************************** Set Table Name
    protected void setTableName(
            @Observes @CDIEvent(SET_TABLE_NAME) final ParameterDTO parameters)
    {
        String s = (String) parameters.getPrimaryParameter();
        editTabPanels.get().setTableName(s);
        itemDetailForms.get().setTableName(s);
        moreDetailForms.get().setTableName(s);
        buyAndSellForms.get().setTableName(s);
    }

    protected void saveCoinAttributesData(
            @Observes @CDIEvent(SAVE_COIN_ATTRIBUTES_DATA) final ParameterDTO parameters)
    {
//        moreDetailForms.get().saveCoinAttributesData();
    }

    // ********************************************************************************** PopupDateField
    protected void popupDateFieldEnabled(
            @Observes @CDIEvent(POPUP_DATE_FIELD_ENABLED) final ParameterDTO parameters)
    {
        view.popupDateFieldEnabled();
    }

    protected void popupDateFieldDisabled(
            @Observes @CDIEvent(POPUP_DATE_FIELD_DISABLED) final ParameterDTO parameters)
    {
        view.popupDateFieldDisabled();
    }

    // ********************************************************************************** ComboBox Data
    protected void gradeOptions(
            @Observes @CDIEvent(GRADE_OPTIONS) final ParameterDTO parameters)
    {
        findByName.setTableName("coin_attributes");
        findByName.setColumnName("grade");
        view.setGradeOptions(findByName.findByName());
    }

    protected void gradeByOptions(
            @Observes @CDIEvent(GRADE_BY_OPTIONS) final ParameterDTO parameters)
    {
        findByName.setTableName("coin_attributes");
        findByName.setColumnName("grade_By");
        view.setGradeByOptions(findByName.findByName());
    }

    protected void serialNumberOptions(
            @Observes @CDIEvent(SERIAL_NUMBER_OPTIONS) final ParameterDTO parameters)
    {
        findByName.setTableName("coin_attributes");
        findByName.setColumnName("serial_Number");
        view.setSerialNumberOptions(findByName.findByName());
    }

    protected void qualityOptions(
            @Observes @CDIEvent(QUALITY_OPTIONS) final ParameterDTO parameters)
    {
        findByName.setTableName("coin_attributes");
        findByName.setColumnName("quality");
        view.setQualityOptions(findByName.findByName());
    }

    protected void catalogTypeOptions(
            @Observes @CDIEvent(CATALOG_TYPE_OPTIONS) final ParameterDTO parameters)
    {
        findByName.setTableName("coin_attributes");
        findByName.setColumnName("catalog_Type");
        view.setCatalogTypeOptions(findByName.findByName());
    }

    // **********************************************************************************
    @Override
    public void viewEntered()
    {

    }
}
