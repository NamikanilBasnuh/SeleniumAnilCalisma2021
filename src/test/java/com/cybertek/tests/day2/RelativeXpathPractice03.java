package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RelativeXpathPractice03 {


    //TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
    //1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements/
    // 3. Click to “Add Element” button 50 times
    // 4. Verify 50 “Delete” button is displayed after clicking.
    // 5. Click to ALL “Delete” buttons to delete them.
    // 6. Verify “Delete” button is NOT displayed after clicking.
    // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement AddElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));


        for (int i = 1; i <= 50; i++) {
            AddElementButton.click();
            System.out.println("Add Element Button clicked " + i + " times");
        }

        // 4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> listOfDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));

        System.out.println("Number of delete buttons on the page: " + listOfDeleteButtons.size());
        //Number of delete buttons on the page: 50

        WebElement DeleteButton = driver.findElement(By.xpath("//button[.='Delete']"));


        /*   // ctrl+alt+t shortcut try Catch
        try {

            for(int i = 1; i<=50; i++){
                DeleteButton.click();
                DeleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

            }
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        */


        // 5. Click to ALL “Delete” buttons to delete them.
        for (WebElement button:listOfDeleteButtons) {

            button.click();

        }

        // 6. Verify “Delete” button is NOT displayed after clicking.\


        //try catch kendi icinde run yapar bagimsiz olarak. unuttun. unutuma!

        try {

            if (!DeleteButton.isDisplayed()){
                System.out.println("Delete button is NOT displayed! PASSED!");
            }else {
                System.out.println("Delete button is displayed! FAILED!");

            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Reference Exception is Thrown");
            System.out.println("Because Web Element is completely deleted from HTML");
            System.out.println("Delete button is NOT displayed! PASSED!");
        }


    }


}
