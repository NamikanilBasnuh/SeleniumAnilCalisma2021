package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementExplanation2 {


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement GmailLink = driver.findElement(By.xpath("//a[.='Gmail']"));

        //Click to the Gmaillink
        GmailLink.click();

        driver.navigate().back();

        //Added last!
        //We copied and pasted web element locator again to referesh the REFERENCE and it help us to sole the problem
        GmailLink = driver.findElement(By.xpath("//a[.='Gmail']"));


        //Click to the Gmaillink AGAIN! It will throw StaleElementReferenceException!!!
        //because-> stale element reference: element is not attached to the page document
        GmailLink.click();


    }

}
