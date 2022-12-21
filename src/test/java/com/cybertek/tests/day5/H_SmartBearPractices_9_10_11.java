package com.cybertek.tests.day5;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.SmartBearUtilities;
import com.cybertek.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class H_SmartBearPractices_9_10_11 extends TestBase {


    /*
    1.Open browser and login to SmartBear
    2.Delete"Mark Smith" from the list
    3.Assert it is deleted from the list
     */

    /*
    1.Open browser and login to SmartBear
    2.Click to edit button right corner of "Steve Johns"
    3.Change name to "Michael Jordan"
    4.Click Update
    5.Assert "Michael Jordan" is in the list
    */

    /*
    1.Accepts two parameters: WebDriver, String name
    2.Method will remove the given name from the list of SmartBear
    3.Create a new TestNG tests, and call your method.
    4.Assert that your method removed the given name

     */


    @Test
    public void test1() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
        //Above 2 line are enough because we have created an abstract class->TestBase
        // and we were EXTENDED that class!

        //2.Delete"Mark Smith" from the list

        WebElement markSmithSrow = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[3]/td[1]"));
        WebElement deleteButton = driver.findElement(By.xpath("//table//input[@name='ctl00$MainContent$btnDelete']"));
        markSmithSrow.click();
        BrowserUtils.wait(2);
        deleteButton.click();

        WebElement nameAsMarkSmith = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[3]/td[2]"));


        //3.Assert it is deleted from the list

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        //SmartBearUtilities.verifyOrder(driver,"Mark Smith");

        for (WebElement item: allNames) {
            Assert.assertFalse(item.getText().equals("Mark Smith"));

        }

    }



}
