package com.cybertek.tests.day5;

import com.cybertek.Utility.SmartBearUtilities;
import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class A_WebTableTasks {

    // SmartBear Software oder Verification
    // 1.Open browser and login to Smartbear software
    //2. Click on view all orders
    //3. Verify Susan McLaren has order on date "01/05/2010"



    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 1.Open browser and login to Smartbear software
        SmartBearUtilities.loginToSmartBear(driver);
    }




    @Test
    public void verify_Susans_order_date() throws InterruptedException {

        //2. Click on view all orders
        WebElement allOrdersView = driver.findElement(By.xpath("//a[.='View all orders']"));
        Thread.sleep(3000);
        allOrdersView.click();

        //3. Verify Susan McLaren has order on date "01/05/2010"

        SmartBearUtilities.verifyOrderNameAndDate(driver,"Susan McLaren","01/06/2010");

    }

    @Test
    public void print_names_cities_test() {

    SmartBearUtilities.printNamesAndCities(driver);

    }








       /* //order on date "01/05/2010"
        WebElement actualSusanMclarenDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedOrderDate = "01/05/2010";

        System.out.println(actualSusanMclarenDate.getText());
        System.out.println(expectedOrderDate);

        Assert.assertEquals(actualSusanMclarenDate.getText(),expectedOrderDate);  */




    }


