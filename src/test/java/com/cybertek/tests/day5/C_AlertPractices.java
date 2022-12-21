package com.cybertek.tests.day5;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C_AlertPractices {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.close();
    }

    @Test
    public void information_Alert() {
        /*TC #1:
            2. Go to website: http://practice.cybertekschool.com/javascript_alerts
            3. Click to “Click for JS Alert” button
            4. Click to OK button from the alert
            5. Verify “You successfully clicked an alert” text is displayed.
        */
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        informationAlertButton.click();

        BrowserUtils.wait(2);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement succesResult = driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']"));

        String actualResult = succesResult.getText();
        String expectedResult = "You successfuly clicked an alert";

        Assert.assertEquals(actualResult, expectedResult, "Failed");


    }

    @Test
    public void confirmation_Alert() {
        /* TC #2:
            2. Go to website: http://practice.cybertekschool.com/javascript_alerts
            3. Click to “Click for JS Confirm” button
            4. Click to OK button from the alert
            5. Verify “You clicked: Ok” text is displayed.
         */

        //3. Click to “Click for JS Confirm” button
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmAlertButton.click();

        BrowserUtils.wait(2);
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement actualResultMessage = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));

        String actualResult= actualResultMessage.getText();
        String expectedResult = "You clicked: Ok";

        Assert.assertTrue(actualResult.equals(expectedResult));
    }

    @Test
    public void prompt_Alert(){

         /* TC #3:
            2. Go to website: http://practice.cybertekschool.com/javascript_alerts
            3. Click to “Click for JS Prompt” button
            4. Send “hello” text to alert
            5. Click to OK button from the alert
            6. Verify “You entered: hello” text is displayed.
         */

        //3. Click to “Click for JS Prompt” button
        WebElement prompt_Alert_button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        prompt_Alert_button.click();

        BrowserUtils.wait(2);
        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        BrowserUtils.wait(2);
        // 5. Click to OK button from the alert
        alert.accept();
        // 6. Verify “You entered: hello” text is displayed.

        WebElement displayedResult = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        String expectedResult = "You entered: hello";

        Assert.assertEquals(displayedResult.getText(),expectedResult);
    }


}
