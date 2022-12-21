package com.cybertek.tests.day7;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import com.cybertek.pages.ForgotPassword_vytrack;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class I_ForgotPasswordTest {




    @Test(description = "Verify Title and Url are Changed after clicking on " +
            "\"Forgot your password?\" ",priority=0)

    public void test1(){

           /*
    1. Go to https://qa2.vytrack.com
    2. Click to “Forgot your password?” link
    3. Verify title changed to expected
        Expected: “Forgot Password”
    4. Verify url is as expected:
        Expected: “https://qa2.vytrack.com/user/reset-request”
       Note: Follow Page Object Model design pattern
     */
        Driver.getDriver().get("https://qa2.vytrack.com");
        ForgotPassword_vytrack object = new ForgotPassword_vytrack();
        object.forgotYourPassButton.click();

        String expectedUrl = "https://qa2.vytrack.com/user/reset-request";
        Assert.assertEquals(Driver.getDriver().getTitle(),"Forgot Password");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedUrl);
    }

    @Test(description = "Vytrack forgot password page verification->ERROR MESSAGE",priority=1)
    public void test2(){
        /*
    TC#36 : Vytrack forgot password page verification->ERROR MESSAGE
        1. Go to https://qa3.vytrack.com/user/reset-request
        2. Enter random username
        3. Click to request button
        4. Verify error message is displayed
        5. Verify error message text is as expected.
        Expected: There is no active user with username or email address “given text”.
        Note: Follow Page Object Model design pattern
     */

        Driver.getDriver().get("https://qa3.vytrack.com/user/reset-request");
        ForgotPassword_vytrack object = new ForgotPassword_vytrack();
        Faker faker = new Faker();
        String RandomUsername=faker.funnyName().name();
        object.userNameInputBox.sendKeys(RandomUsername);
        BrowserUtils.wait(1);
        object.requestButton.click();

        Assert.assertTrue(object.errorMessage.isDisplayed());
        Assert.assertEquals(object.errorMessage.getText(),"There is no active user with username or email address \""+RandomUsername+"\".");

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
