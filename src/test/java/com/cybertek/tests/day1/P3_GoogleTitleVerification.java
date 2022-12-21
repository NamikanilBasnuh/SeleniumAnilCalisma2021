package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_GoogleTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC#4:	Google	search
        1-Open	a	chrome	browser
        2-Go	to:	https://google.com
        3-Write	“apple”	in	search	box
        4-Click	google	search	button
        5-Verify	title:
        Expected:	Title	should	start	with	“apple
         */

        //Open	a	chrome	browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Go	to:	https://google.com
        driver.get("https://google.com");

        //Write	“apple”	in	search	box
        driver.findElement(By.name("q")).sendKeys("apple");

        //Click	google	search	button below down!!!
        driver.findElement(By.name("btnK")).click();

        //Verify	title:
        //Expected:	Title	should	start	with	“apple
        String actualTitle = driver.getTitle();
        String expectedtitleStartsWith = "apple";

        System.out.println("actualTitle = " + actualTitle); //apple - Google Search

        if (actualTitle.startsWith(expectedtitleStartsWith)){
            System.out.println("Title Starts with apple verification is Passed");
        } else {
            System.out.println("Title Starts with apple verification is Failed");
        }

        Thread.sleep(2000);
        driver.quit();








    }
}
