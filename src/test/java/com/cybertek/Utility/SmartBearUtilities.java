package com.cybertek.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    //Mini-Task:
    // •Create a method called loginToSmartBear
    // •This method simply logs in to SmartBear when you call it.
    // •Accepts WebDriver type as parameter



    public static void loginToSmartBear (WebDriver driver){


        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameInput.sendKeys("Tester");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordInput.sendKeys("tests");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }

    public static void verifyOrderNameAndDate(WebDriver driver, String name, String expectedOrderDate){

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement item:namesList) {
            if(item.getText().equals(name)){

               Assert.assertTrue(true);
                System.out.println("The name: "+name+ " that entered. And it is on the Order List!");
            }
        }

        String a =  "//table[@id='ctl00_MainContent_orderGrid']//tr//td[.='"+name+"']" ;
        WebElement enteredName = driver.findElement(By.xpath(a));
        WebElement actualChosenNameOrderDate = driver.findElement(By.xpath(a+"/following-sibling::td[3]"));

        System.out.println("Actual order date on the table is " + actualChosenNameOrderDate.getText());
        System.out.println("Expected order date is " + expectedOrderDate);

        Assert.assertEquals(actualChosenNameOrderDate.getText(),expectedOrderDate,"Actual order date is not matching with Expected order date");

    }


    public static void verifyOrder(WebDriver driver, String name){

        //Finding and storing all of the names in our web table in a list of web element
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));


        for (WebElement each : namesList) {
            if (each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail("The name does not exist in the list! Verification failed!");

    }

     /*
    Practice #5: Method: printNamesAndCities
    •Create a method named printNamesAndCitiesin SmartBearUtils class.
    •Method takes WebDriver object.
    •This method should simply print all the names in the List of All Orders.
    •Create a new TestNG tests to tests if the method is working as expected.
    •Output should be like:
    •Name1: name , City1: city
    •Name2: name , City2: city
     */

    public static void printNamesAndCities(WebDriver driver){

        List<WebElement> allnamesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        List<WebElement> allcitiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        int j = 1;
        for (int i = 0; i <= allnamesList.size() - 1; i++) {
            System.out.println("Name" + j + "= " + allnamesList.get(i).getText() + ", City" + j + "= " + allcitiesList.get(i).getText());
        }

    }











}






