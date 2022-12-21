package com.cybertek.pages;


import com.cybertek.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loading1Page {


    public Loading1Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//div[@id='loading']")
    public WebElement loadingBar;

    @FindBy(xpath ="//input[@id='username']")
    public WebElement userNameInputBox;

    @FindBy(xpath = "//input[@id='pwd']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement passwordErrorMessage;


}
