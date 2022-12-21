package com.cybertek.Utility;

import com.cybertek.pages.VytrackWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackLogin {

    public static void vyTrackDriverLogin(WebDriver driver){

        VytrackWebElements vytrackWebElements = new VytrackWebElements();
        vytrackWebElements.userNameInput.sendKeys(ConfigurationReader.getProperty("vytrackTruckDriver_UserName"));

        vytrackWebElements.passwordInput.sendKeys(ConfigurationReader.getProperty("vytrackTruckDriver_Password"));

        BrowserUtils.wait(1);
        vytrackWebElements.loginButton.click();




    }

}
