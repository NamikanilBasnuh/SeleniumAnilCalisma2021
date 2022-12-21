package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpathPractice02 {

    /*TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
     1. Open Chrome browser
     2. Go to http://practice.cybertekschool.com/add_remove_elements
     3. Click to “Add Element” button
     4. Verify “Delete” button is displayed after clicking.
     5. Click to “Delete” button.
     6. Verify “Delete” button is NOT displayed after clicking.
         USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS    */

    public static void main(String[] args)  {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement AddElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        AddElementButton.click();
        WebElement DeleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if(DeleteButton.isDisplayed()){
            System.out.println("Delete button is displayed after clicking Add Element Button. Verification Passed!");
        } else {
            System.out.println("Delete button is NOT displayed after clicking. Verification Failed!");
        }





       try{

           DeleteButton.click();

           if(!DeleteButton.isDisplayed()){
               System.out.println("Delete button is DISAPPEARED after clicking delete button. Verification Passed!");
           }else {
               System.out.println("Delete button is Still DISPLAYED after clicking delete button. Verification Failed!");
           }

       }catch (StaleElementReferenceException exception){
           System.out.println("StaleElementExcaption is Thrown because WebElement Deleted from HTML completely");
           System.out.println("Delete button is DISAPPEARED after clicking delete button. Verification Passed!");

       }








    }


}