package com.cybertek.tests.day5;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class E_iframePractice {

    // 3 ways of iframe locating -> i stands for "inner" ->iframe-> inner frame!
    // 1. byIndex
           //driver.switchTo().frame(0);

    // 2. by Id or Name; passing id attribute value
           //driver.switchTo().frame("mce_0_ifr");

    // 3. locate as a web element, then switch to it
    //WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        //driver.switchTo().frame(iframe);

//    - There are 2 ways of switching back from the iframe.
//
//          1- driver.switchTo().defaultContent();
                 // Default content means, the main <html> code on the page.

//      2- driver.switchTo().parentFrame();
//            - This is similar to using /.. from xpath.
//            - It just goes back to the direct parent of the currently focused iframe.


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.close();
    }

    @Test
    public void iFrame_Practice1(){
        /* TC #4 :
        1. Create new tests and make set ups
        2. Go to: http://practice.cybertekschool.com/iframe


        3. Assert: “Your content goes here.” Text is displayed.
        4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
    */

        // 3. Assert: “Your content goes here.” Text is displayed.

           //WebElement contentText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
           //Assert.assertEquals(contentText.getText(),"Your content goes here.");

           //Above will be thrown an NoSuchElement exception.
           //Because the Web Element that you are trying to locate is in An iframe!!!
           //First you have deal with iframe. you have to go inside the iframe
           //Locate iframe and use syntax!
           //And then you MUST locate the “Your content goes here.”  web element!!

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe); //Now you are inside of the iframe

        WebElement contentText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        Assert.assertTrue(contentText.isDisplayed(),"Text is not displayed. Verification Failed!");

        driver.switchTo().defaultContent();// you went back to default html!
                                           //OtherWise your driver will be stuck into iframe!!

        //4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor

        //IF YOU DID not USE driver.switchTo().defaultContent();
        // You will not able to Assert below. Because driver will be stuck inside of the iframe!
        //You will receive NoSuchElementException!!!

        WebElement headerText = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(headerText.isDisplayed(),"Text is not displayed. Verification Failed!");

    }

    @Test
    public void iFrame_Practice2(){
        // Same example Only difference I will deal with iframe with .frame(index number)


        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='tox-edit-area__iframe']"));
        driver.switchTo().frame(0);
        WebElement contentText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        //3. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(contentText.isDisplayed(),"Is not Displayed FAIL");
        driver.switchTo().parentFrame(); //I have used this one
                                         //because there is not iframe inside of an iframe!
       // 4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        WebElement header3Text = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertEquals(header3Text.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor","Failed it is not Equals!!");
    }

    @Test
    public void iFrame_Practice3(){
        //Same example Only difference I will deal with iframe with .frame(attribute Value);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame("mce_0_ifr");

        //3. Assert: “Your content goes here.” Text is displayed.
        WebElement contentText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertEquals(contentText.getText(),"Your content goes here.");

        // 4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        driver.switchTo().defaultContent();
        WebElement h3Text = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(h3Text.isDisplayed());



    }





}
