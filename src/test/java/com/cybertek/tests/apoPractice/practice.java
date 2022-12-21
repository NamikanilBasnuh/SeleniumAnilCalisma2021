package com.cybertek.tests.apoPractice;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.Utility.Driver;
import com.cybertek.pages.VytrackApoOdevPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice {



@BeforeMethod
    public void setUp(){

    VytrackApoOdevPage page = new VytrackApoOdevPage();
    Driver.getDriver().get(ConfigurationReader.getProperty("vytrackUrl"));
    page.userNameInput.sendKeys(ConfigurationReader.getProperty("vytrackTruckDriver_UserName"));
    page.passwordInput.sendKeys(ConfigurationReader.getProperty("vytrackTruckDriver_Password"));
    page.loginButton.click();
    BrowserUtils.wait(2);
    page.fleetModuleDropdown.click();
    page.Vehicle.click();
    BrowserUtils.wait(3);

}
@Test(description = "1.Verify That TruckDriver should be able to click Export Grid dropdown",priority = 1)
    public void test1(){

    VytrackApoOdevPage page = new VytrackApoOdevPage();




    page.exportGridDropdown.click();
    BrowserUtils.wait(2);
    Assert.assertTrue(page.boxOpenedClickedexportGridDropdown.isDisplayed());

}
@Test(description = "2.Verify That Export Grid dropdown is on the left of the page",priority = 2)
    public void  test2(){

    VytrackApoOdevPage page = new VytrackApoOdevPage();





    BrowserUtils.wait(2);
    Assert.assertTrue(page.exportGridOntheLeftWb.isDisplayed());

}


@AfterMethod
    public void tearDown(){
    Driver.closeDriver();
}






}
