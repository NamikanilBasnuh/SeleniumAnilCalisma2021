package com.cybertek.Utility;


  /*
    In this case We will store utility methods that can be applied to any browsers!

    Anytime you feel like you have a good logic that you can use it in the future,
    create a method of it and store it in this class
    */

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
    Accepts a list of Web Element
    @param List<Weblement>
    @return List<String>
    Method should be returning a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> list){

        List<String> webElementToString = new ArrayList<>();

        for (WebElement item:list) {
            webElementToString.add(item.getText());

        }

        return webElementToString;
    }

    /*
    Create a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that I pass as parameter should be accepted as SECONDS
    Handle checked exception with try/catch

     */

    public static void wait(int sec){

        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception caught!");
        }


    }









}
