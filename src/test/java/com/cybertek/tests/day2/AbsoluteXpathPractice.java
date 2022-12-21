package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteXpathPractice {

    /*
    -> Absolute xpath starts with single slash -> /
		-> It starts from the very beginning of the HTML code
		-> Absolute xpath is not reliable,
		   because if there is any minimal structural change in your HTML code, your locator will not work
		-> Try avoid using it!!!!
		DO NOT USE IT!!!!
     */



    public static void main(String[] args) {

        //Go to http://practice.cybertekschool.com/multiple_buttons
        //Verify "Home" link is displayed on the page

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement HomeLink =driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

        if(HomeLink.isDisplayed()){
            System.out.println("Verification is Passed");
        } else {
            System.out.println("Verification is Failed!!!");
        }





    }
}
