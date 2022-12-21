package com.cybertek.tests.day7;

public class F_Selenium_WhatWeLearnSoFar {

    /*
            What tools/languages we are currently using in our project?
    - Java

    - Selenium
        -> Selenium is basically some jar files(libraries) that has ready classes and methods that allows us to automate browsers.
        -> In simple terms, it is basically some jar files.
        -> We use these jar files to automate browsers, and test cases related to UI.

    - TestNG

    - Maven (as a built automation tool)
         > Maven is a built automation tool.
        -> Maven helps us automate creating projects.
        -> When we create a project with maven following things happen:

        What is built? : repeating steps to create a project.

         --> creating the folder structure
         --> compile
         --> add jar files, dependencies
         --> deploying

         Built is the repeated processes when you are creating a project


       - pom.xml file comes with the project.

      -> pom.xml file is the most important file in a maven project
      -> we manage our dependencies from our pom.xml file
      -> it helps us add and maintain the versions of our dependencies

    - JavaFaker
    - WebDriverManager


What does our folder structure look like?
    -src
        -test
            -java
                -com.PROJECT
                    -tests
                    -utilities
                        -Driver
                        -ConfigurationReader
                        -SmartBearUtils
                        -BrowserUtils
                        -WebDriverFactory
                    -pages
    -configuration.properties
    -pom.xml



                     TELL ME ABOUT YOUR FRAMEWORK?
      What tools we are using
      What kind of folder structure we created
      What kind of JAVA/SELENIUM logic we created
      What kind of design patterns we used in our project
      What Design Pattern we have used?

    - Singleton Design Pattern
        - What issue did we address using this pattern?
            - We solved the problem of doing the same setup for our driver in each and every class
            - We made sure that we are getting exactly the same driver instance every time we call our driver

        - How did we achieve Singleton Design Pattern?
            - Created a private constructor, and created getter method that returns the same driver instance all the time.

    - Page Object Model Design Pattern, aka(also known as) POM
        - What is Page Object Model Design Pattern:
            - Creating java classes for the each page of AUT (Application under tests).
                And we store related web elements in its own java class.
                - LoginPage.java
                    -username
                    -password
                    -loginbutton
                    -errormessage
                    -LOGINMETHOD(username,password)
                - LandingPage.java
                - SearchPage.java

    What are the advantages of using POM?

        - Re-usable: We locate web elements ONLY ONCE, then we keep re-using.
        - Easy to maintain : Since we store each web element only once, we know exactly where to find the web element and how to fix the problem.
        - Readable : Very easy to understand

    How do we achieve Page Object Model Design Pattern?

    -> After creating the java class

        #1 -  Create constructor, and initialize elements: driver, class object.
            public LoginPage(){
                PageFactory.initElements(driver, this);
            }
        #2 - We need to use @FindBy annotation to locate web elements
        @FindBy( locatorType = "locator")
        public WebElement usernameInput;


     */
}
