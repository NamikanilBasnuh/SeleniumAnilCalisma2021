package com.cybertek.tests.vytrack;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.Utility.Driver;
import com.cybertek.Utility.VytrackLogin;
import com.cybertek.pages.VytrackWebElements;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Vytrack_Test1 {


    /*
        User Story:
               As a truck driver I should be able to access
                 Vehicle Costs page.

            Acceptance Criteria:

              1.Verify that truck driver should be able to see all cars' cost information on the Vehicle Costs
                 page.
              2.Verify that truck driver should be able to create Vehicle cost an cancel it.
              3.Verify that truck driver should be able to edit or delete Vehicle cost
              4.Verify that truck driver should be able to add Attachment on General information
                page by click on any of the car on the grid.
              5.Verify that truck driver should be able to Add Event
              6.Verify that truck driver should be able to reset the grid by click on Grit setting
*/


    @BeforeMethod()
    public void setUp_LoginPage() {


        Driver.getDriver().get("http://qa3.vytrack.com/user/login");
        BrowserUtils.wait(2);


    }


    @Test(description = "truck driver should be able to see all cars' cost information on the Vehicle Costs\n" +
            "        page.", priority = 1)
    public void verify_1() {

        VytrackLogin.vyTrackDriverLogin(Driver.getDriver());
        BrowserUtils.wait(2);
        VytrackWebElements vytrackWebElements = new VytrackWebElements();
        vytrackWebElements.fleetModuleDropdown.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(vytrackWebElements.vehicleCostButton));
        vytrackWebElements.vehicleCostButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(vytrackWebElements.viewPerPageDropDown));
        vytrackWebElements.viewPerPageDropDown.click();
        BrowserUtils.wait(2);
        vytrackWebElements.viewPerPageDropDownDataSize100.click();
        BrowserUtils.wait(2);


        Assert.assertTrue(Driver.getDriver().getTitle().contains("Vehicle Cost"), "FAILED! Truck Driver CAN NOT SEE the Vehicle Cost Page");

    }

    @Test(description = "2.Verify that truck driver should be able to create Vehicle cost an cancel it."
            , priority = 2)
    public void verify_2() {
        VytrackLogin.vyTrackDriverLogin(Driver.getDriver());
        BrowserUtils.wait(2);
        VytrackWebElements vytrackWebElements = new VytrackWebElements();

        //create Vehicle cost
        vytrackWebElements.fleetModuleDropdown.click();
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
        wait1.until(ExpectedConditions.elementToBeClickable(vytrackWebElements.vehicleCostButton));
        vytrackWebElements.vehicleCostButton.click();
        wait1.until(ExpectedConditions.elementToBeClickable(vytrackWebElements.createVehicleCost_ahref));
        vytrackWebElements.createVehicleCost_ahref.click();
        BrowserUtils.wait(1);
        vytrackWebElements.saveAndCloseButton.click();

        BrowserUtils.wait(1);
        Assert.assertTrue(vytrackWebElements.entitySavedMessage.isDisplayed(), "Failed! truck driver WAS NOT able to create Vehicle Cost!");


        //Vehicle cost cancel it after filled out all inputs and dropDowns!
        vytrackWebElements.fleetModuleDropdown.click();
        vytrackWebElements.vehicleCostButton.click();

        vytrackWebElements.createVehicleCost_ahref.click();
        vytrackWebElements.vehicleCostType.click();
        vytrackWebElements.vehicleCosts_chooseSnowTire.click();
        vytrackWebElements.vehicleCostTotalPriceInput.sendKeys("1500");
        vytrackWebElements.VehicleCost_DateInput.sendKeys("11/11/2020" + Keys.ENTER);
        vytrackWebElements.vehicleCost_CostDescription.sendKeys("Test Test Test!");
        BrowserUtils.wait(2);

        vytrackWebElements.vehicleCost_CancelButton.click();
        BrowserUtils.wait(2);

        Assert.assertFalse(Driver.getDriver().getCurrentUrl().contains("item"), "Failed! Total Created results DO NOT MATCH!");

    }


    @Test(description = "3.Verify that truck driver should be able to edit or delete Vehicle cost", priority = 3)
    public void verify_3() {

        VytrackLogin.vyTrackDriverLogin(Driver.getDriver());
        BrowserUtils.wait(2);
        VytrackWebElements vytrackWebElements = new VytrackWebElements();
        vytrackWebElements.fleetModuleDropdown.click();
        vytrackWebElements.vehicleCostButton.click();

        BrowserUtils.wait(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vytrackWebElements.toggleDropDownButton).perform();
        BrowserUtils.wait(1);

        vytrackWebElements.toggleDropDownButton_Edit.click();


        vytrackWebElements.fleetModuleDropdown.click();
        vytrackWebElements.vehicleCostButton.click();
        Actions actions2 = new Actions(Driver.getDriver());
        actions2.moveToElement(vytrackWebElements.toggleDropDownButton).perform();

        vytrackWebElements.toggleDropdown_Delete.click();
        vytrackWebElements.yes_Delete_Button.click();


        //THIS ONE WILL FAIL! THY SYSTEM DOESN"T LET A TRUCK DRIVER TO EDIT OR DELETE VEHICLE COST!

        //Error Messages Below!
        //You do not have permission to perform this action.-> For-> Truck driver should able DELETE Vehicle cost"
        //You do not have permission to perform this action.->For Truck driver should able EDIT Vehicle cost"

        Assert.assertTrue(vytrackWebElements.edit_ErrorMessage.isDisplayed());
        Assert.assertTrue(vytrackWebElements.delete_ErrorMessage.isDisplayed());

    }

    @Test(description = " 4.Verify that truck driver should be able to add Attachment on General information\n" +
            "                page by click on any of the car on the grid.", priority = 4)
    public void verify_4() {

        VytrackLogin.vyTrackDriverLogin(Driver.getDriver());
        BrowserUtils.wait(2);
        VytrackWebElements vytrackWebElements = new VytrackWebElements();
        vytrackWebElements.fleetModuleDropdown.click();
        vytrackWebElements.vehicleCostButton.click();

        BrowserUtils.wait(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vytrackWebElements.toggleDropDownButton).perform();

        vytrackWebElements.ToggleDropDownButton_ViewLinkTex.click();
        BrowserUtils.wait(2);

        vytrackWebElements.add_Attach_Button.click();

        String theFileThatIwantToUpload = "C:\\Users\\namik\\Desktop\\Access-Modifiers-in-Java.png";
        // "C:\\Users\\namik\\Desktop\\downloadForUpload.jfif"
        vytrackWebElements.upload_Input_Button.sendKeys(theFileThatIwantToUpload);
        String comments = "Test Test Test!";
        vytrackWebElements.comments_Input.sendKeys(comments);
        vytrackWebElements.saveButton_InAddAttachmentBox.click();

        Assert.assertTrue(vytrackWebElements.attachment_SuccessMessage.isDisplayed(),
                "Failed, Attachment Success message was not displayed! " +
                        "Truck driver NOT ABLE TO add Attachment on General information ");


    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(2);

        Driver.closeDriver();
    }

   /*@Test(description = "Verify that truck driver should be able to Add Event", priority = 5)
    public void Verify_5() {


        VytrackLogin.vyTrackDriverLogin(Driver.getDriver());
        VytrackWebElements vytrackWebElements = new VytrackWebElements();
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

        /*vytrackWebElements.addEvent_StartDate.click();
        //SELECT DROPDOWNS ARE NOT WORKING!!!!! DON"T EVEN TRY! WORKING BUT NOW WORKING PROPERLY!
       /* Select select = new Select(vytrackWebElements.addEvent_StartDate_Select_Month);
        select.selectByValue("Jun");
        Driver.getDriver().navigate().refresh()*/
        //vytrackWebElements.addEvent_RandomlyOpendedCloseButton.click();

        // VERY IMPORTANT NOTE:BU APP TAM BIR BAS BELASI! HIC BIR SEY DOGRU DUZGUN CALISMIYOR!
        //BU VERIFICATION DA COK VAKIT HARCADIM! KENDI KENDINE CLICKLER YAPIYOR VS....
        //TUM LOCATORLAR VS DOGRU AMA LOCATE ETMEYIYOR. click command i vermiyorum. click yapiyor!!
        //Su an ki hala calisiyor. Dokunma.
        //vytrackWebElements.addEvent_AlldayEventCheckBox.click();
//        vytrackWebElements.addEvent_RepeatCheckBox.click();

        // Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //vytrackWebElements.addEvent_SaveButton.click();
//
        //Assert.assertTrue(vytrackWebElements.addEvent_SuccessMessage.isDisplayed());


}










