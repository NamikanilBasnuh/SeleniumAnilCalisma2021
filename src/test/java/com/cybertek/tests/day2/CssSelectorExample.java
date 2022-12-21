package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelectorExample {

    //   Css selector SYNTAX ->  tagName[attribute='value']
    //  to go to child class tagName[attribute='value'] >

    public static void main(String[] args) {

        //1.Open browser
        //2. Go to https://amazon.com
        //3. Enter any search term (use cssSelector to locate search box)
        //4.Verify title contains the search term


        //1.Open browser
        //2. Go to https://amazon.com
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://amazon.com");


        //3. Enter any search term (use cssSelector to locate search box)
        WebElement SearchBox = driver.findElement(By.cssSelector("input[type='text']"));
        SearchBox.sendKeys("Foldable Bike"+ Keys.ENTER);

        //4.Verify title contains the search term
        String ActualTitle = driver.getTitle();
        String ExpectedInActualTitle = "Foldable Bike";

        if(ActualTitle.contains(ExpectedInActualTitle)){
            System.out.println("Title Verification Passed!!!");
        }else {
            System.out.println("Title Verification Failed!!!");
        }





    }
}
