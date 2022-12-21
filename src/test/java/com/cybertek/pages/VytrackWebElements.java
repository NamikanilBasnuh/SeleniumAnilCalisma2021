package com.cybertek.pages;

import com.cybertek.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WBufferStrategy;

import java.security.cert.X509Certificate;


public class VytrackWebElements {


    public VytrackWebElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//li[@class='dropdown user-menu-dropdown']/a")
    public WebElement userDropdownMenu;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath ="//a[@class='unclickable']/span")
    public WebElement fleetModuleDropdown;

    @FindBy(xpath = "//span[.='Vehicle Costs']")
    public WebElement vehicleCostButton;

    @FindBy(xpath = "//button[@data-toggle='dropdown'] ")
    public WebElement viewPerPageDropDown;

    @FindBy(xpath = "//a[@data-size='100'] ")
    public WebElement viewPerPageDropDownDataSize100;

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleCost_ahref;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    public WebElement CancelButton;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement entitySavedMessage;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement vehicleCostType;


    @FindBy(xpath = "//input[@class='select2-input']")
    public WebElement vehicleCostTypeInput;

    @FindBy(xpath = "(//li[@class='select2-results-dept-0 select2-result select2-result-selectable'])[4]/div")
    public WebElement vehicleCosts_chooseSnowTire;

    @FindBy(xpath = "//input[contains(@id,'TotalPrice-uid')]")
    public WebElement vehicleCostTotalPriceInput;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_Date')]")
    public WebElement VehicleCost_DateInput;

    @FindBy(xpath = "//div[@class='controls']/textarea[contains(@id,'custom_entity_type_CostDescriptions-uid')]")
    public WebElement vehicleCost_CostDescription;

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    public WebElement vehicleCost_CancelButton;

    @FindBy(xpath = "//td[4]/div/div/a")
    public WebElement toggleDropDownButton;

    @FindBy(xpath = "//a/i[@class='fa-pencil-square-o hide-text']")
    public WebElement toggleDropDownButton_Edit;

    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement edit_ErrorMessage;

    @FindBy(xpath = "//a/i[@class='fa-trash-o hide-text']")
    public WebElement toggleDropdown_Delete;

    @FindBy(xpath = "//a[@class='btn ok btn-danger']")
    public WebElement yes_Delete_Button;

    @FindBy(xpath = "//div/div[.='You do not have permission to perform this action.']")
    public WebElement delete_ErrorMessage;

    @FindBy(xpath = "    (//table//tr/td)[1]")
    public WebElement select_VehicleCostType_Row1;

    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement add_Attach_Button;

    @FindBy(xpath = "//div/input[contains(@id,'oro_attachment_file_file-uid')]")
    public WebElement upload_Input_Button;

    @FindBy(xpath = "//div/textarea[contains(@id,'oro_attachment_comment-uid')]")
    public WebElement comments_Input;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton_InAddAttachmentBox;

    @FindBy(xpath = "//div[.='Attachment created successfully']")
    public WebElement attachment_SuccessMessage;

    @FindBy(xpath = "(//a[@class='btn icons-holder-text no-hash'])[2]")
    public WebElement addEvent_Button;

    @FindBy(xpath = "(//button[@class='ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close'])[2]")
    public WebElement addEvent_RandomlyOpendedCloseButton;

    @FindBy(xpath = "/html/body/ul/li/ul/li[1]/a/i")
    public WebElement ToggleDropDownButton_ViewLinkTex;

    @FindBy(xpath = "//div[@class='controls']//input[contains(@id,'title')]")
    public WebElement addEvent_Title;

    @FindBy(xpath = "//iframe[contains(@id,'_ifr')]")
    public WebElement iframeLocation;

    @FindBy(xpath = "//body[contains(@data-id,'description')]")
    public WebElement addEvent_Description;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addEvent_SaveButton;

    @FindBy(xpath = "//div[.='Calendar event saved']")
    public WebElement addEvent_SuccessMessage;


}
