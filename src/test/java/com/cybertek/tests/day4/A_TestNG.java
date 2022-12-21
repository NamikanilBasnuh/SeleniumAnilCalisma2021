package com.cybertek.tests.day4;

import org.testng.annotations.*;

public class A_TestNG {

    @BeforeClass()
    public void beforeClass(){
        System.out.println("Before Class Runs before everything AND ONCE!!!");
    }

    @AfterClass()
    public void afterClass(){
        System.out.println("After Class Runs After everything AND ONCE!!!");
    }


    @BeforeMethod()
    public void setUp(){
        System.out.println("Before Method Running RUNS AFTER EACH TEST");
    }
    @AfterMethod()
    public void tearDown(){
        System.out.println("After Method Running RUNS AFTER EACH TEST");
    }
    @Test()
    public void test1(){
        System.out.println("Test1 is Running");
    }
    @Test()
    public void test2(){
        System.out.println("Test2 is Running");
    }

    /*

    IT RUNS LIKE THIS! @BeforeMethod and @AfterMethod run AFTER EACH @Test!!!!!
                       @BeforeClass and @AfterClass run beginning and at the End ONCE!


    Before Class Runs


    Before Method Running

    Test1 is Running

    After Method Running

    Before Method Running

    Test2 is Running

    After Method Running

    After Class Runs


     */




}
