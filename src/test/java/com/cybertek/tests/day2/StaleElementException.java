package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementException {


    /*
      -Stale means NO LONGER FRESH!!!
      -It happens in 2 CASES!!!
        1-THE ELEMENT HAS BEEN DELETED ENTIRELY!
        2-THE ELEMENT IS NO LONGER ATTACHED TO THE DOM(HTML PAGE)!


     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //Locate Gmail linktext right side on the top
        WebElement GmailLink = driver.findElement(By.xpath("//a[.='Gmail']"));

        //Refresh the page
        driver.navigate().refresh(); //This ONE WILL CAUSE A STALE ELEMENT EXCEPTION!
                                     //It was attached but when We refreshed it lost the REFERENCE!!
            // Web Element still there and located correctly because we haven't received NoSuchElement Exception!
            //BUT IT LOST THE REFERENCE that's why we have received StaleElementException
           //If you read the Exception explanation which is
           //stale element reference: element is not attached to the page document!!!
          // YOU WILL CLEARLY UNDERSTAND WHAT I MEAN!!!
        //TO Solve this problem->
        //                WE have to copy the web element locating line and paste after driver.navigate().refresh();


        GmailLink = driver.findElement(By.xpath("//a[.='Gmail']")); //this one solve the problem!!!
        //We copied and paste it before the click and no more stale exception
        //Because we did RE-REFERENCE NOT Re-locate!!

        //Click to the Gmaillink
        GmailLink.click();











    }
}
