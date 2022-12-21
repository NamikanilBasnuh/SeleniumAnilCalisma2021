package com.cybertek.tests.day7;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class C_JavaScriptExecutor_Practices {

    /*
         There are 2 method that we use in JavascriptExecutor interface!!!
         1-js.executeScript("window.scrollDown(0,500)");
         2-js.executeScript("arguments[0].scrollIntoView(true)",WebElement);


     */


    @Test
    public void scroll_using_jsExecutor1(){

        //Get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //Create instance of JSExecutor and cast our driver type to it.
        //WE ARE DOING THIS BECAUSE OUR DRIVER IS USING WEB DRIVER INTERFACE NOW!!!
        //JavaScriptExecuter is an INTERFACE also!
        // WE HAVE TO Cast to type to use ->INTERFACE! THAT'S WHY WE ARE CASTING TO JavaScriptExecutor!
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // We got stuck. We need an option to use!
        // Scroll using js executor-> We googled it from StockFlow.
        //window.scrollBy(0,250) ->it is javaScript Function!
        //                       ->it is Coming from JavaScript Scripting language

        //use execute strip method

        //js.executeScript("window.scrollBy(0,500)"); ->it moves little bit
        //we will take it into a loop to scroll it down more by waiting 1 second between each move

        for (int i=0; i<=10; i++) {
            js.executeScript("window.scrollBy(0,500)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(1);
    }


    @Test
    public void scroll_using_jsExecutor2(){
        //get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/large");
        //locating cybertek school link
        WebElement cybertekLink = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));
        //use js executor to scroll 'Cybertek School' link intoView
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //use scrollIntoView function from JavaScript to scroll to a specific web element
        BrowserUtils.wait(1);
        js.executeScript("arguments[0].scrollIntoView(true)",cybertekLink);
        BrowserUtils.wait(1);

        //now I scroll up to Home link-> all the way up left side on the top

        //I went back to default content to locate web element.
        //Because my driver was using JavascriptExecutor INTERFACE
        Driver.getDriver().switchTo().defaultContent();

        WebElement homelink = Driver.getDriver().findElement(By.linkText("Home"));
        js.executeScript("arguments[0].scrollIntoView(true)",homelink);
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }




}
