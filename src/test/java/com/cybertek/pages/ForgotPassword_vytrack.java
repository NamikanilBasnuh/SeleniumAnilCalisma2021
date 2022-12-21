package com.cybertek.pages;

import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword_vytrack {

    public ForgotPassword_vytrack(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//a[.='Forgot your password?']")
    public WebElement forgotYourPassButton;

    @FindBy(xpath ="//input[@id='prependedInput']")
    public WebElement userNameInputBox;

    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;


}
