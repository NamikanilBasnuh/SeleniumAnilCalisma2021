package com.cybertek.tests.day6;

public class B_ImportanInfoAboutProperties {

    /*
                            PROPERTIES


configuration.properties
->It is just another type of a file -> like .text .xml .powerpoint
->configuration -> is just then name we gave
->.properties => IS THE TYPE OF THE FILE! -> like .text .xml .powerpoint .csv
-.properties file contains key=value
-why we use it?
  BECAUSE JAVA already has built in classes that is able to read key and value type of files!

-.properties files are mainly used in Java programs to maintain project configuration data,
database config or project settings, etc.
-IMPORTANT-> each parameter in properties file is stored as a pair of Strings!!!!


What is tests data?
- All of the data we pass into the app to tests the application, such as username, password, url, and any other information.

How we have been passing our tests data?
usernameInput.sendKeys("username");
passwordInput.sendKeys("password");
loginButton.click();

HARDCODING:
What is hard coding: is putting the data(tests data) itself in the source code (tests cases, @Test)

- Hardcoding is not a good practice because when you want to change a tests data,
    you have to go into the code itself.

Environments:
qa1.vyrack.com
qa2.vyrack.com
staging1.vtrack.com
staging2.vtrack.com
www.vytrack.com


-> We are going to be creating a logic to read data from outside of our source code.
-> This will make it easier for us to run the same tests against different tests data.

DATA DRIVEN TESTING:
-> Running the same tests(s) against different tests data.
- you could be changing
-url
-username
-password
-> If we write the tests data in the tests themselves, then we would have to go each an every single of the tests to change all of those values.
-> Therefore the better practice is to read the tests data from an external file so that it is easier to change it from one location.

What kind of benefits are there to read from external file:
-> We centralize the tests data, which is easier to maintain
ex: instead of going to 100 different tests cases, we switch from 1 file and it is applied to all of our tests.
-> It is extremely easier to maintain the code compared to previous version(hardcoding tests data in the source code)


QUESTION FOR INTERVIEW

How to read from properties file using JAVA:

#1 - Create instance of Properties class to read .properties file
Properties properties = new Properties

#2 - Use FileInputStream to open the file
FileInputStream file = new FileInputStream(FILEPATH);

#3 - Load the 'properties' object with the file I just opened.
properties.load(file);

#4 - THen we can use properties object to read the file
properties.getProperty(key) --> returns the value of the given 'key'


*/


}
