package com.cybertek.tests.base;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    /*IT WAS CREATED IN DAY5 while we are dealing with "H_SmartBearPractices_9_10_11" */

    /*
    - Testbase is a class that will hold the common variables and setup/teardown methods
    - So that we can just extend to TestBase class and not have to re-write or copy/paste the same statements again and again.
    - Repeated statements that we are going to be eliminating:
    - @BeforeMethod, @AfterMethod
    - maximize
    - implicit wait etc.
    - So far we don't have a parent class for our tests.
    - TestBase class will be the parent of all of our tests.
    - TestBase is NOT a Utility class, it is a parent class for our tests so that we can extend to it and get common setups,
         and variables.
    */

    protected WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }


}
