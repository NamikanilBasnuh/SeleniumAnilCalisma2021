package com.cybertek.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    DRIVER UTILITY CLASS
     - Driver util class
     - Why are we learning this?
     -We have too many lines to initialize the driver
     -We are not able to pass the same driver instance when calling methods from other classes

   -What is Driver Utility class and why are we creating it?
     -We have some challenges that we want to overcome:
       1- Too many lines just to create and instantiate a WebDriver instance and do setup.
       2- Our driver instance is not re-usable.
          -Currently our driver instance lives and dies in the same class.
          -If we want to pass the driver instance in a method from another class, we must pass
            that specific instance into that method every time.

    -TO BE ABLE TO OVERCOME THESE CHALLENGES ,AND MAKE OUR CODE MORE STABLE AND EASY TO MAINTAIN,
         WE CREATE DRIVER UTILITY CLASS!!!



    SOLUTION: Creating a driver utility that guarantees a single instance of the driver and does the initial setup (maximize, imp)
    - It should be able to read values from configuration.properties dynamically


   *****!!!What happens when you create a private constructor in java class?
     - Stops everyone being able to create object from that class.


     SINGLETON DESIGN PATTERN:
        #1- We make constructor private.
        #2- We create a getter method for the constructor so that it returns the object in the way that we want to share it.


      ========================================================
     P.I.Q.
   -WHERE DO YOU USE OOP IN YOUR PROJECT!
     Inheritance : TestBase (extended to tests base)
     Abstract : TestBase class is abstract class
     Polymorphism : Used polymorphism with our WebDriver
     Encapsulation : DRIVER UTILS CLASS!
    ===================================================


     */


    private static WebDriver driver; //Private
    //Making a variable private "protects" its value when the code runs. ...
    //Those other classes should only access behavior by calling methods on the class,
    //Why Static? Because we are going to use it into a static method which we will create!

    private Driver() {
        //private constructor WILL STOP EVERYONE TO CREATE AND OBJECT FROM THIS CLASS
        //SO, THEY WILL USE ONLY YOUR OPTIONS!
    }

    //Creating a 'getter' method to allow users to reach private String above
    //Headless browser means; it is not visiable but doing the job in the background!

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                default:
                    System.out.println("There is a mistake in to you configuration.properties! " +
                            "Browser value is wrong! it Doesn't match with the browser which is in to DRIVER UTIL CLASS!");

            }
                     driver.manage().window().maximize();
                     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }


        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
