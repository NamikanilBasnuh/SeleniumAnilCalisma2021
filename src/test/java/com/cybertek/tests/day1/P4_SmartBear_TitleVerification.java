package com.cybertek.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_SmartBear_TitleVerification {

    public static void main(String[] args) {

         /*
        TC#5:	Basic	login	authentication
        1-Open	a	chrome	browser
        2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        3-Verify	title	equals:Expected:	Web	Orders	Login
        4-Enter	username:	Tester
        5-Enter	password:	tests
        6-Click	“Sign	In”	button
        7-Verify	titleequals:
               Expected:	Web	Orders
         */



        //Open	a	chrome	browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //Verify title equals:Expected: Web Orders	Login
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is Passed!!");
        } else {
            System.out.println("Title verification is Failed!!");
        }
        //Enter	username: Tester
        //Enter	password: tests
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("com/cybertek/tests");

        //Click	“Sign	In”	button
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        //Verify	titleequals:
        //Expected:	Web	Orders
        String actualTitleAfterCredentials = driver.getTitle();
        String ExpectedTitleAfterCredentials = "Web Orders";

        if(actualTitleAfterCredentials.equals(actualTitleAfterCredentials)){
            System.out.println("Title verification is Passed! after entering Credentials");
        } else {
            System.out.println("Title verification is Failed! after entering Credentials");
        }

        driver.quit();


    }
}
