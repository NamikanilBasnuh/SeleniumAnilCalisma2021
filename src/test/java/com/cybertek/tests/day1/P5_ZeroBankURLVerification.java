package com.cybertek.tests.day1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_ZeroBankURLVerification {



    public static void main(String[] args) {

        //C #4: Zero Bank URLverification
        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        // 3.Get attribute value of href from the “forgot your password”link
        // 4.Verify attribute value contains
        // Expected: “/forgot-password.html”

        //TC #4: Zero Bank URL verification
        //--------------------------------------------------------------------------------------------//

        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");


        // 3.Get attribute value of href from the “forgot your password”link
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password ?"));
        String actualAttributeValue = forgotPasswordLink.getAttribute("href");
        System.out.println("actualAttributeValue = " + actualAttributeValue);
        //http://zero.webappsecurity.com/forgot-password.html

        //4.Verify attribute value CONTAINS
        // Expected: “/forgot-password.html”
        String expectedAttributeValue = "/forgot-password.html";

        if (actualAttributeValue.contains(expectedAttributeValue)){
            System.out.println("Actual attribute value contains expected Attribute Value. Passed!" );
        }else{
            System.out.println("Actual attribute value doesn't contains expected Attribute Value. Failed!" );
        }
        System.out.println(expectedAttributeValue);





    }


}
