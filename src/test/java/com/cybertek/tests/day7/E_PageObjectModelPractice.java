package com.cybertek.tests.day7;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import com.cybertek.pages.LoginPage;
import org.testng.annotations.Test;



public class E_PageObjectModelPractice {


    @Test
    public void login_smartBearByUsing_PageObjectModel(){
        LoginPage login = new LoginPage();

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        login.userIdInput.sendKeys("Tester");
        login.userPasswordInput.sendKeys("test");
        BrowserUtils.wait(1);
        login.loginButton.click();


    }


}
