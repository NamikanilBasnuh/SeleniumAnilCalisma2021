package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Example_For_WebDriverFactory {


    /* We Created a Utility Package and under the java package;
       we have created a class that name is WebDriverFactory!!!!
       In WebDriverFactory Class, We have created a METHOD
       which will let us to set and use our browser easily!!!
       LIKE THIS WebDriver driver = WebDriverFactory.getDriver("chrome");
                                    (we call it by Class name) BECAUSE IT IS A STATIC METHOD
                 or
                 WebDriver driver = WebDriverFactory.getDriver("firefox");
                                    (we call it by Class name) BECAUSE IT IS A STATIC METHOD

     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        /* Instead of this
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
         */


    }


}
