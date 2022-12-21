package com.cybertek.tests.day7;

public class D_Page_Object_Design_Pattern_INFO {

    /*

    WHAT IS PAGE OBJECT MODEL?

    -Creating a class for each page of the Aut (Application under tests), and storing related
      Web Elements in to that page!

    WHY ARE WE USING PAGE OBJECT MODEL?

    Advantages of page object model:
      -Reusable web elements /less code/ non-repeating code
      -We make our project very organized: easy to maintain.
      -Readable

     HOW ARE WE IMPLEMENTING PAGE OBJECT MODEL DESIGN PATTERN?
!!!!! WE HAVE CREATED pages package under com.companyName!!!!!!
     !!! SAME LEVEL WITH tests and utility package!!!

     -Create a package named 'pages' in the same level with tests, and utilities package
     -Create a class for each page of AUT (Application under tests).
        -LoginPage
        -LandingPage
        -WhateverPage...

     -We need to create a constructor, then we pass one line in our constructor!
            public class LoginPage{

                public LoginPage(){
                     PageFactory.initElements(my driver, this);
                }

         //this-> means object of this class. Referencing the instance of this class.
        //Basically, we are creating a connection with our driver instance and instance of this class!
       //in Another class whenever we want to use the object of this class and call the web element of this page,
          our driver will know how to create the connection!!!


       No more findElement method! we will use @FindBy( Xpath, Css, Id... any locator it takes in it)
       -@FindBy -> Comes from Selenium!

       @FindBy(id="demo")
       public WebElement usernameInput;

       -We need to locate Web Elements using @FindBy annotation.
       -When we want to use any web element, we basically create the object of the class,
            and call the web element through the instance of the class.


        }




  */

}
