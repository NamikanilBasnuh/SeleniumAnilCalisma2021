package com.cybertek.tests.day4;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C_TestNGSeleniumPractice {


    WebDriver driver;

    @BeforeMethod
    public void setUp (){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

    @Test (priority = 2)
    public void test1(){

        //1- Go to: https://www.google.com
        //2- Verify title : Google
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test(priority = 1)
    public void test2(){

        //1- open browser
        //2- go to https://google.com
        //3- search "apple"
        //search box is dynamic that's why I have used dynamic xpath locator!
        WebElement SearchBox = driver.findElement(By.xpath("//input[contains(@class,'gLFyf')]"));
        SearchBox.sendKeys("apple"+ Keys.ENTER);
        //4- verify title contains "apple"
        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- close browser





    }






    //1- open browser
    //2- go to https://google.com
    //3- search "apple"
    //4- verify title contains "apple"
    //5- close browser

}
