package com.cybertek.tests.vytrack;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.Utility.Driver;
import com.cybertek.Utility.VytrackLogin;
import com.cybertek.pages.VytrackWebElements;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Vytrack_Test2 {

    static VytrackWebElements vytrackWebElements = new VytrackWebElements();

    @BeforeMethod()
    public void setUp_LoginPage() {


        Driver.getDriver().get("http://qa1.vytrack.com/user/login");
        VytrackLogin.vyTrackDriverLogin(Driver.getDriver());


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(2);

        Driver.closeDriver();
    }

    @Test(description = "truck driver should be able to see all cars' cost information on the Vehicle Costs\n" +
            "        page.", priority = 1)
    public void verify_1() {


        BrowserUtils.wait(2);
        VytrackWebElements vytrackWebElements = new VytrackWebElements();
        vytrackWebElements.fleetModuleDropdown.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(vytrackWebElements.vehicleCostButton));
        vytrackWebElements.vehicleCostButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(vytrackWebElements.viewPerPageDropDown));
        vytrackWebElements.viewPerPageDropDown.click();
        vytrackWebElements.viewPerPageDropDownDataSize100.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Vehicle Cost"), "FAILED! Truck Driver CAN NOT SEE the Vehicle Cost Page");

    }

    @Test(description = "Verify that truck driver should be able to Add Event", priority = 5)
    public void Verify_5() {


        vytrackWebElements.fleetModuleDropdown.click();
        vytrackWebElements.vehicleCostButton.click();


        BrowserUtils.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vytrackWebElements.toggleDropDownButton).perform();


        vytrackWebElements.ToggleDropDownButton_ViewLinkTex.click();
        BrowserUtils.wait(1);
        vytrackWebElements.addEvent_Button.click();


        vytrackWebElements.addEvent_Title.sendKeys("Test is Starting!");
        BrowserUtils.wait(1);

        vytrackWebElements.addEvent_RandomlyOpendedCloseButton.click();


        Driver.getDriver().switchTo().frame(vytrackWebElements.iframeLocation);

        vytrackWebElements.addEvent_Description.sendKeys("Test is going on!");
        Driver.getDriver().switchTo().defaultContent();
        vytrackWebElements.addEvent_SaveButton.click();


    }

}
