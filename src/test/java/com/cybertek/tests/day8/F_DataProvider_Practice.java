package com.cybertek.tests.day8;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VytrackWebElements;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class F_DataProvider_Practice {

    /*
       1- We will go to "https://qa1.vytrack.com/user/login" page
       2-We will test login username and pass data which is provided us.
       3-We will send usernames and passwords
    */

    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(1);
        Driver.closeDriver();

    }


    // This annotation tells that these data will be use in @Test!
    // Without @DataProvider annotation it is not going to work!
    @DataProvider
    public Object[][] userTestData() {
        return new Object[][]{ {"storemanager85", "UserUser123"}, {"salesmanager110", "UserUser123"},
                {"user153", "UserUser123"}, {"storemanager85", "UserUser123"}
        };
        //there are 4 rows above and 2 cells(username, password) in each row. We will send these data into our @Test !


    }


    //I will use Page object model below
    @Test(dataProvider = "userTestData") //You must initialize it! otherwise will not work!
    public void vytrack_LoginTest(String username,String password) { //because you initialized it. you must put 2 String parameter!


        VytrackWebElements login = new VytrackWebElements();
        login.userNameInput.sendKeys(username);
        BrowserUtils.wait(1);
        login.passwordInput.sendKeys(password);
        BrowserUtils.wait(1);
        login.loginButton.click();
        BrowserUtils.wait(1);

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard","Verification Error!");


    }

}