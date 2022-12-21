package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitleVerification  {


    public static void main(String[] args) throws Exception {



   /*
        TC	#1:	Google	Title	Verification
        1.Open	Chrome	browser
        2.Go to	https://www.google.com
        3.Verify	title:	Expected:	Google

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Google";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification Passed!");
        }else {
            System.out.println("Google title verification Failed!");
        }

        Thread.sleep(2000);
        driver.quit();


    }




}
