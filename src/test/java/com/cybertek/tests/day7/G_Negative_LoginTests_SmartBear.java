package com.cybertek.tests.day7;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.ConfigurationReader;
import com.cybertek.Utility.Driver;
import com.cybertek.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class G_Negative_LoginTests_SmartBear {


    @Test(description = "entering incorrect username by using login() method",priority = 0)
    public void negative_login_test1(){

        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));
        BrowserUtils.wait(1);


        /*
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("smartbear_username"),
                ConfigurationReader.getProperty("smartbear_password"));  */

        /*Above code is working well to login but I want to do NEGATIVE TEST. That's why I will send
        Wrong username and password!*/

        LoginPage loginPage = new LoginPage();

        String wrongUserName = "WrongUserName"; //Username was made wrong on a purpose
        loginPage.login(wrongUserName,ConfigurationReader.getProperty("smartbear_password"));

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"Error message is not displayed. Verification Failed!");

    }

    @Test (description ="entering incorrect username without using login() method",priority = 1)
    public void negative_login_test2(){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));
        BrowserUtils.wait(1);

        LoginPage loginPage = new LoginPage();

        //Now I will send WRONG username and Correct password individually
        //  without using login() method that I created in LoginPage class

        loginPage.userIdInput.sendKeys("aaaaaa");
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.getProperty("smartbear_password"));
        BrowserUtils.wait(1);
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"Error message is not displayed. Verification Failed!");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
