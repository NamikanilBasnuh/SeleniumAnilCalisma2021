package com.cybertek.tests.day6;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class E_DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){

       Driver.getDriver().get("https://www.google.com/");

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String search = ConfigurationReader.getProperty("searchValue");


        searchBox.sendKeys(search+ Keys.ENTER);

        Assert.assertTrue(Driver.getDriver().getTitle().contains(search));
        BrowserUtils.wait(1);

        Driver.closeDriver();




    }

}
