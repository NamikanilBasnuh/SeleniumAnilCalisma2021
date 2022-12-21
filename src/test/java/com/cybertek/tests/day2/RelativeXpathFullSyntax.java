package com.cybertek.tests.day2;

public class RelativeXpathFullSyntax {


    /* RELATIVE XPATH:
            - starts with double slash //
	- when you say // it allows you to start anywhere in the html code
	- more reliable
	- you can start from anywhere in the HTML code
	- more specific
    syntax : driver.findElement(By.xpath("xpath locator here"));
	1- //tagName[@attribute='value']
            2- //tagName[contains(@attribute, 'value')]
            3- //tagName[.='text']
            1- //tagName[@attribute='value'] --> looks for tagname attribute and value
            1- //*[@attribute='value'] --> * means look for all of the webElements
            2- //tagName[contains(@attribute, 'value')] --> locates all web elements with the given value
            3- //tagName[.='text'] --> looks for exact text match in webElement */

    //IMPORTANT!!!!!   /.. -> GOES TO Parent
    //                /tagName ->goes to child


     /*

      HOW DO YOU HANDLE DYNAMIC WEB ELEMENTS?
      HOW DO YOU HANDLE WEB ELEMENTS WITH DYNAMIC ATTRIBUTE VALUES?
   -> I use 3 methods that comes from xpath.
     - contains method, starts-with, and ends-with method.

          //div[contains(@attribute, 'value')]
         //div[starts-with(@attribute, 'value')]
        //div[ends-with(@attribute, 'value')]

     <div name="abd1234212" id="123123asfc"> </div>

   -> locator for the dynamic attribute value of google search button
            //input[contains(@data-ved, 'UDCA0')]




      */

    public static void main(String[] args) {



    }



}
