package com.cybertek.tests.day3;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class D_CheckBox_Example1 {

    //Practice: Cybertek Checkboxes

    //1. Go to http://practice.cybertekschool.com/checkboxes
    //2. Confirm checkbox #1 is NOT selected by default
    //3. Confirm checkbox #2 is SELECTED by default.
    //4. Click checkbox #1 to select it.
    //5. Click checkbox #2 to deselect it.
    //6. Confirm checkbox #1 is SELECTED.
    //7. Confirm checkbox #2 is NOT selected.

    public static void main(String[] args) throws InterruptedException {

        //1. Go to http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = driver.findElement(By.xpath("//form/input[@type='checkbox'][1]"));

        if(!checkbox1.isSelected()){
            System.out.println("Checkbox #1 is NOT selected by default. Verification PASSED!");
        }else {
            System.out.println("Checkbox #1 is SELECTED by default. Verification FAILED!");
        }

        //3. Confirm checkbox #2 is SELECTED by default

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (checkbox2.isSelected()){
            System.out.println("Checkbox #2 Selected by Default. Verification is PASSED!");
        }else {
            System.out.println("Checkbox #2 is NOT Selected by Default. Verification is FAILED!");

        }

        //4. Click checkbox #1 to select it.
         Thread.sleep(2000);
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        if (checkbox1.isSelected()){
            System.out.println("Checkbox #1 is SELECTED. Verification PASSED!");
        }else {
            System.out.println("Checkbox #1 is NOT SELECTED. Verification FAILED!");
        }

        //7. Confirm checkbox #2 is NOT selected.
        if(!checkbox2.isSelected()){
            System.out.println("Checkbox #2 is NOT SELECTED. Verification PASSED!");
        }else {
            System.out.println("Checkbox #2 is SELECTED. Verification FAILED!");
        }




    }


}
