package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_Etsy_Title_Verification {


    public static void main(String[] args)  throws Exception {

        /*
        TC #1: EtsyTitle Verification1.Open Chrome browser
        2.Go to https://www.etsy.com
        3.Search for “wooden spoon”
        4.Verify title:
                Expected: “Wooden spoon | Etsy”*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon"+ Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";

        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.equals(expectedTitle)){

            System.out.println("Title Verification Passed!!");
        } else{

            System.out.println("Title Verification Failed!!");
        }

        Thread.sleep(2000);
        driver.quit();






    }

}

