package com.cybertek.tests.day6;

import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.tests.base.TestBase;
import org.testng.annotations.Test;

public class C_LearningProperties extends TestBase {



    @Test
    public void java_properties_test(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));



    }

}
