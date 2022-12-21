package com.cybertek.tests.day6;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class D_ReadingProperties {

    @Test
    public void Reading_from_properties_file() {

        //use Properties class object  (Java.util)
        //use class FileInputStream
        // we will load the file
        //we read from the file
        //Close the file

        Properties properties =new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //("configuration.properties"); ->Copied from path from content root
            // of configuration.properties file which is under the Project level!
            properties.load(fileInputStream);

            fileInputStream.close();//we should close the file.It can create a glitch!
        } catch (IOException e) {
            //OException - Exception thrown when there has been an Input/Output (usually when working with files) error.
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("username"));



    }
}
