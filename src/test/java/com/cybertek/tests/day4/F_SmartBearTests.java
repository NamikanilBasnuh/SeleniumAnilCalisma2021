package com.cybertek.tests.day4;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class F_SmartBearTests {

    //TC #1: Smartbear software link verification
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “tests”
    // 5.Click to Login button
    // 6.Print out count of all the links on landing page
    // 7.Print out each link text on this page

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException{

        // 3.Enter username: “Tester”
        // 4.Enter password: “tests”
        // 5.Click to Login button

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameInput.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordInput.sendKeys("com/cybertek/tests");
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        /*
        // 3.Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        // 4.Enter password: “tests”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("tests");
        // 5.Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
         */



        // 6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println(allLinks.size());

        // 7.Print out each link text on this page
        for (WebElement item:allLinks) {
            System.out.println(item.getText());
        }


    }









}
