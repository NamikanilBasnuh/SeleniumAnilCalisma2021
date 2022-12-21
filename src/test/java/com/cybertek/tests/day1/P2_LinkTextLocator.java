package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_LinkTextLocator {


    public static void main(String[] args) throws InterruptedException {

     /*
TC #3: Back and forth navigation
1-Open a chrome browser
2-Go to: https://www.google.com
3-Click to Gmail from top right.
4-Verify title contains:Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:Expected: Google


 */
        //Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Go to: https://www.google.com
        driver.get("https://www.google.com");

        //Click to Gmail from top right.
        driver.findElement(By.linkText("Gmail")).click();


        //Verify title contains:Expected: Gmail
        String actualGmailTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualGmailTitle); //Gmail - Email from Google

        String expectedGmailTitle = "Gmail";
        if (actualGmailTitle.contains(expectedGmailTitle)) {
            System.out.println("Title contain Gmail verification passed!!!");
        } else {
            System.out.println("Title contain Gmail verification Failed!!!");

        }

        Thread.sleep(2000);
        //Go back to Google by using the .back();
        driver.navigate().back();

        //Verify title equals:Expected: Google
        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";

        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google first page title verification Passed!!!");
        } else {
            System.out.println("Google first page title verification Failed!!!");

        }

        driver.quit();


    }


}
