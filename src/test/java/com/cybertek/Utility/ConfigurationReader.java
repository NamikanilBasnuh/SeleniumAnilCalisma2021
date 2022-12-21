package com.cybertek.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

       //1-We created the properties object
      //2-We get the path and pass it into FileInputStream to open the file
      //3-We load the opened file into properties object
     //4-We read the file
     //5-Close the file

    /*

    Why are we using static block?
      - Because static block runs before everything else and initializes everything in it.
      - Since we are opening files, and reading values we want to make sure that everything (such browser type, url value) are ready for our source code to use it.
      - And also, we cannot directly type java code outside of some kind of block.
     */

    /*

    Why we make variable private?

    Making a variable private "protects" its value when the code runs. ...
    Those other classes should only access behavior by calling methods on the class,
    not by changing values of variables directly.

    At this level, we are not concerned with protecting it from other programmers changing the code itself.
    The point of so-called "data hiding" is to keep internal data hidden from other classes which use the class.


     WHAT IS THIS Properties Utility(ConfigurationReader) , and why are we using it?
       -Properties Utility is the class and method we created so that we can read IMPORTANT TEST DATA
         from outside of our source code!
       -This utility and logic allows us to Avoid Hardcoding the important tests data!
       -So that we can change the tests data such as browser type, username, password,URL.




     */


    private static Properties properties = new Properties();

   static {

       try {
           FileInputStream fileInputStream = new FileInputStream("configuration.properties");
           properties.load(fileInputStream);
           fileInputStream.close();

       } catch (IOException e) {
           System.out.println("properties file is not FOUND!!");
       }

   }

    //4-We read the file
   public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);

   }





}
