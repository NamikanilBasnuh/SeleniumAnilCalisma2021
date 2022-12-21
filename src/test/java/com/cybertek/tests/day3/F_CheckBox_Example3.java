package com.cybertek.tests.day3;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class F_CheckBox_Example3 {

    //TC #3: SeleniumEasy Checkbox Verification –Section 2
    // 1.Open Chrome browser
    // 2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // 3.Verify “Check All” button text is “Check All”
    // 4.Click to “Check All” button
    // 5.Verify all check boxes are checked
    // 6.Verify button text changed to “Uncheck All”

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // 3.Verify “Check All” button text is “Check All”
        WebElement CheckAllButton = driver.findElement(By.xpath("//input[@type='button']"));

        if(CheckAllButton.getAttribute("value").equals("Check All")){
            System.out.println("Check All” button text is Check All. Verification PASSED!");
        }
        else {
            System.out.println("Check All” button text is NOT Check All. Verification FAILED!");
        }

        // 4.Click to “Check All” button
        CheckAllButton.click();
        // 5.Verify all check boxes are checked
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        int j=1;
        for (int i=0; i<=allCheckBoxes.size()-1; i++){
            if (allCheckBoxes.get(i).isSelected()) {
                System.out.println("check Box "+j+" is checked. PASSED!");

            }
            else {
                System.out.println("check Box "+j+ " is NOT checked. FAILED!!");

            }
            j++;
        }


        // 6.Verify button text changed to “Uncheck All”
        WebElement UncheckAllButton = driver.findElement(By.xpath("//input[@type='button']"));

        if ( UncheckAllButton.getAttribute("value").equals("Uncheck All")) {
            System.out.println("button text changed to “Uncheck All”. PASSED!");

        }else {
            System.out.println("button text NOT changed to “Uncheck All”. FAILED!");
        }


    }




}
