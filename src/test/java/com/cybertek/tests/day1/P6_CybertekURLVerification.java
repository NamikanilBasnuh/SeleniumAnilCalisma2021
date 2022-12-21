package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_CybertekURLVerification {

    public static void main(String[] args) throws InterruptedException {

        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/forgot_password
        // 3.Enter any email into input box
        // 4.Click on Retrieve password
        // 5.Verify URL contains: Expected: “email_sent”
        // 6.Verify textbox displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”
        // Hint: You need to use getText method for this practice

        //TC #3: PracticeCybertek/ForgotPassword URL verification

        //--------------------------------------------------------------------------------------------//

        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/forgot_password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");


        // 3.Enter any email into input box
        // 4.Click on Retrieve password
        driver.findElement(By.name("email")).sendKeys("www.testtesttest@hotmail.com");
        Thread.sleep(2);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("form_submit")).click();
        System.out.println(driver.getCurrentUrl());


        //INTERNAL SERVER ERROR VERIYOR. SITE CALISMIYOR
        System.out.println(driver.findElement(By.xpath("/html/body/h1")).getText());

        // 5.Verify URL contains: Expected: “email_sent”


        // 6.Verify textbox displayed the content as expected.

        // Expected: “Your e-mail’s been sent!”


    }
}
