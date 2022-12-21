package com.cybertek.tests.day3;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class E_Checkbox_Example2 {


    //TC #2: SeleniumEasy Checkbox Verification–Section 1
    // 1.Open Chrome browser
    // 2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // 3.Verify “Success –Check box is checked” message is NOT displayed.
    // 4.Click to checkbox under “Single Checkbox Demo” section
    // 5.Verify “Success –Check box is checked” message is displayed.

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");



        // 3.Verify “Success –Check box is checked” message is NOT displayed.
        WebElement SuccessCheckBox = driver.findElement(By.xpath(" //input[@id='isAgeSelected']"));
        if(!SuccessCheckBox.isSelected()){
            System.out.println("Success –Check box is checked message is NOT displayed. PASSED!");

        }else {
            System.out.println("Success –Check box is checked message is displayed. FAILED!");
        }

        // 4.Click to checkbox under “Single Checkbox Demo” section
        SuccessCheckBox.click();

        // 5.Verify “Success –Check box is checked” message is displayed.
        if(SuccessCheckBox.isSelected()){
            System.out.println("Success –Check box is checked message is displayed. PASSED!");

        }else {
            System.out.println("Success –Check box is checked message is NOT displayed. FAILED!");
        }


    }


}
