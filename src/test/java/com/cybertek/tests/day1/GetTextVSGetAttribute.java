package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVSGetAttribute {

    public static void main(String[] args) throws Exception {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //locating gmail link from top right on google page

        //driver.findElement(By.linkText("Gmail")).getText();
        System.out.println("Get txt method = " + driver.findElement(By.linkText("Gmail")).getText());
        // above gets the link text
        System.out.println("Get attribute value method= " + driver.findElement(By.linkText("Gmail")).getAttribute("href"));
        //above gets the attribute value of the link

        Thread.sleep(2000);
        driver.quit();

    }


}
