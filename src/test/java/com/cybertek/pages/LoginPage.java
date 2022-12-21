package com.cybertek.pages;

import com.cybertek.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="ctl00_MainContent_username")
    public WebElement userIdInput;

    @FindBy(id="ctl00_MainContent_password")
    public WebElement userPasswordInput;

    @FindBy(name = "ctl00$MainContent$login_button")
    public WebElement loginButton;

   @FindBy(xpath = "//span[@id='ctl00_MainContent_status']")
   public WebElement errorMessage;




    public void login(String username,String password){

        userIdInput.sendKeys(username);
        userPasswordInput.sendKeys(password);
        loginButton.click();

    }






}
