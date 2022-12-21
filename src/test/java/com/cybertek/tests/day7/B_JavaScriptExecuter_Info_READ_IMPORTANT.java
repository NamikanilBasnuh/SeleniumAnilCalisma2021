package com.cybertek.tests.day7;

public class B_JavaScriptExecuter_Info_READ_IMPORTANT {

    /*

   JAVASCRIPT EXECUTOR
   -What is JavaScript Executer?
     -JS Executor is just an interface in Selenium Library.
     -It is just has 2 methods in it.
   -Why do we use it?
     -it allows us to pass/use/inject "javascript" code in our java/selenium code
     -We might need it for Scrolling, or clicking...

   How do we use it?
     - WE MUST CAST OUR driver to JavaScriptExecutor type
     - After casting our driver, we can reach the methods coming from this interface.

     1- We create instance of JSExecutor and cast our driver type to it.
       JavaScriptExecutor js =(JavaScriptExecutor)Driver.getDriver();

     2- use the methods that come from this interface
       js.executeScript("javascript function as a string", obj obj); (This one gets 2 args!!!)
     arg1-> any javascript function that we want to pass.
     arg2-> where do we want to apply this function to



   P.I.O(Possible interview question)
       How many ways do you know scrolling in Selenium?

     1-Using Action moveToElement(given element) method.

     2- js.executeScript("window.scrollBy(0,500)")

     3-js.executeScript("arguments[0].scrollIntoView(true)", element); //Below line explanation!
       js.executeScript("javascript function as a string", obj obj); (This one gets 2 args!!!)



       -> sending string using js function
          js.executeScript("arguments[0].setAttribute('value', 'something@gmail.com')", emailInput);
           -> clicking to web element using js function
           js.executeScript("arguments[0].click()", signUpbutton);



     */
}
