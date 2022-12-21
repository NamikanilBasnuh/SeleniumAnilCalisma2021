package com.cybertek.pages;

import com.cybertek.Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackApoOdevPage {

   public VytrackApoOdevPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@class='unclickable']/span")
    public WebElement fleetModuleDropdown;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement Vehicle;

    @FindBy(xpath = "(//div[@class='btn-group'])[1]")
    public WebElement exportGridDropdown;

    @FindBy(xpath = "(//div[@class='btn-group'])[1]//ul[@class='dropdown-menu']")
    public WebElement boxOpenedClickedexportGridDropdown;

    @FindBy(xpath = "//div[contains(@class,'pull-left grid')]")
    public WebElement exportGridOntheLeftWb;








}
