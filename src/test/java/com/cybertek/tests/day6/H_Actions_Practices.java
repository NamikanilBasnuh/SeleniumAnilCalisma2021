package com.cybertek.tests.day6;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/*
               ACTION CLASS
      Class that provides ways to handle advanced mouse and keyboard events!!
      Mouse Events
                -actions.contextClick(WebElement).perform();
                     -gets 1 WebElement in it
                -actions.moveToElement(WebElement).perform();
                     -gets 1 WebElement in it
                -actions.doubleClick(WebElement).perform();
                     -gets 1 WebElement in it
                -actions.dragAndDrop(WebElement source,WebElement target).perform();
                     -gets 2 WebElements in it!
                     -WebElement source ->The element that you want to drag
                     -WebElement target-> The element will be dropped into!
                -actions.clickAndHold(WebElement).perform();

                -actions.release().perform();
                -actions.build().perform();

        -YOU MUST USE .perform(); in the end!!!! OTHERWISE, IT WILL NOT WORK!!!

       SYNTAX and example:
       Actions actions = new Actions(You must provide the driver here!->Driver.getDriver() )

       1-actions.clickAndHold(smallCirle).moveToElement(biggerCirle).release().perform();

       2-actions.dragAndDrop(smallCirle,biggerCirle).perform();

       1 and 2 , they are doing same things and same results.
       both example we drag a small cirle and drop into a bigger circle.
       YOU CAN USE WHICH ONE YOU WANT!





 */

public class H_Actions_Practices {

         /*
        TC #15: Hover Test
        1. Go to http://practice.cybertekschool.com/hovers
        2. Hover over to first image
        3. Assert:
            a. “name: user1” is displayed
        4. Hover over to second image
        5. Assert:
            a. “name: user2” is displayed
        6. Hover over to third image
        7. Confirm:
            a. “name: user3” is displayed
         */

    @Test
    public void hover_over_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(Driver.getDriver());

        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement image2 =Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement image3 =Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]/following-sibling::div[2]"));

        WebElement user1 =Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));


        //2. Hover over to first image
        //        3. Assert:
        //            a. “name: user1” is displayed
        actions.moveToElement(image1).perform();
        Assert.assertTrue(user1.isDisplayed(),"Mistake, User 1 is not displayed");
        BrowserUtils.wait(1);

       // 4. Hover over to second image
        //        5. Assert:
        //            a. “name: user2” is displayed
        actions.moveToElement(image2).perform();
        Assert.assertTrue(user2.isDisplayed(),"Mistake, User 2 is not displayed");
        BrowserUtils.wait(1);

        //6. Hover over to third image
        //        7. Confirm:
        //            a. “name: user3” is displayed
        //         */

        actions.moveToElement(image3).perform();
        Assert.assertTrue(user3.isDisplayed(),"Mistake, User 3 is not displayed");
        BrowserUtils.wait(1);

    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }




}
