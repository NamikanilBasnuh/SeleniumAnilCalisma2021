package com.cybertek.tests.day4;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class B_DropDowns_Intro {


    //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    //    1. Open Chrome browser
    //    2. Go to http://practice.cybertekschool.com/dropdown
    //    3. Verify “Simple dropdown” default selected value is correct Expected: “Please select an option”
    //    4. Verify “State selection” default selected value is correct Expected: “Select a State”

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1(){
        //    3. Verify “Simple dropdown” default selected value is correct Expected: “Please select an option”
        //    4. Verify “State selection” default selected value is correct Expected: “Select a State”


        //THIS IS THE SYNTAX!!! You can put several dropdowns into a Select class!
        // AND YOU CAN MOVE TOP TO BUTTON BY USING getFirstSelectedOption() getAllSelectedOptions()

        Select SimpleDropDown =new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String ActualDefaultSimpleDropDownText= SimpleDropDown.getFirstSelectedOption().getText();
        String ExpectedDefaultSimpleDropDownText = "Please select an option";

        Assert.assertEquals(ActualDefaultSimpleDropDownText,ExpectedDefaultSimpleDropDownText);



        //    4. Verify “State selection” default selected value is correct Expected: “Select a State”

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String ActualStateDropDownDefaultValue = stateDropDown.getFirstSelectedOption().getText();
        String ExpectedStateDropDownDefaultValue = "Select a State";

        Assert.assertEquals(ActualStateDropDownDefaultValue,ExpectedStateDropDownDefaultValue);
    }


    @Test
    public void test2 () throws InterruptedException{

        //TC #2: Selecting state from State dropdown and verifying result 1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown



        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        //selectByValue("IL") value of the <option>

        Thread.sleep(3000);
        stateDropDown.selectByValue("IL");

        //I wanted to print out too!
        System.out.println(stateDropDown.getFirstSelectedOption().getText());


        //4. Select Virginia
        Thread.sleep(3000);
        stateDropDown.selectByIndex(47);

        //I wanted to print out too!
        System.out.println(stateDropDown.getFirstSelectedOption().getText());

        //5. Select California
        Thread.sleep(3000);
        stateDropDown.selectByVisibleText("California");
        System.out.println(stateDropDown.getFirstSelectedOption().getText());


        //6. Verify final selected option is California.
        String selectedStateDropdown = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedStateDropdown.equals("California"),"You made a Mistake if you see this");











    }



}
