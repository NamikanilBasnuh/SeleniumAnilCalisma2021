package com.cybertek.tests.day3;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C_ImplicitWait_Example {


         //TC #0: FINDELEMENTS
         //1. Open Chrome browser
         //2. Go to https://www.merriam-webster.com/
         //3. Print out the texts of all links
         //4. Print out how many link is missing text
         //5. Print out how many link has text
         //6. Print out how many total link

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();


        //Implicit wait will wait UPTO given seconds.
                //If page is loaded before it will continue.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.merriam-webster.com/");

        List<WebElement> listofAllLinks = driver.findElements(By.xpath("//body//a"));

        //3. Print out the texts of all links
        for (WebElement item:listofAllLinks) {
            System.out.println(item.getText());

        }
        //4. Print out how many link is missing text
        //5. Print out how many link has text
        int linkisMissingText=0;
        int linkisHasText = 0;

        for (int i=0; i<=listofAllLinks.size()-1;i++){
            if(listofAllLinks.get(i).getText().isEmpty()){
                linkisMissingText++;
            }else {
                linkisHasText++;
            }
        }
        System.out.println("There are "+linkisHasText+" links have texts");
        System.out.println("There are "+linkisMissingText+" links are missing texts");



        //6. Print out how many total link
         System.out.println("Total link count is "+listofAllLinks.size());

    }



}
