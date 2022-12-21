package com.cybertek.tests.day2;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class RelativeXpathPractice01 {

    //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/forgot_password
    // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)

    // a. “Home” link
    // b. “Forgot password” header
    // c. “E-mail” text
    // d. E-mail input box
    // e. “Retrieve password” button
    // f. “Powered byCybertek School” text
    // 4. Verify all WebElements are displayed.

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // a. “Home” link
        //       //a[@class='nav-link'] or //a[.='Home'] or //a[contains(@class,'nav')] or //a[@href='/']
        WebElement HomeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        // b. “Forgot password” header
        WebElement ForgotPasswordHeader = driver.findElement(By.xpath("//div[@class='example']/h2"));

        //c. “E-mail” text
        WebElement E_MailText = driver.findElement(By.xpath("//label[@for='email']"));

        // d. E-mail input box
        WebElement E_mailInputBox = driver.findElement(By.xpath("//input[@name='email']"));

        //e. “Retrieve password” button
        WebElement RetrieveButton = driver.findElement(By.xpath("//button[@class='radius']"));

        //f. “Powered byCybertek School” text
        WebElement PoweredByCybertekSchool = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        ArrayList<WebElement> AllInclusive = new ArrayList<>();
        AllInclusive.addAll(Arrays.asList(HomeLink,ForgotPasswordHeader,E_MailText,E_mailInputBox,RetrieveButton,PoweredByCybertekSchool));

        for (int i = 0; i<=AllInclusive.size()-1; i++){
            if (AllInclusive.get(i).isDisplayed()){
                System.out.println("Verification is Passed" +i);
            }else {
                System.out.println("Verification failed" + i);
            }
        }

    }
}


