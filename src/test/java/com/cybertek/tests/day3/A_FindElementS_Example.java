package com.cybertek.tests.day3;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class A_FindElementS_Example {

    //TC #02: FINDELEMENTS_APPLE
    // 1.Open Chrome browser
    // 2.Go to https://www.apple.com
    // 3.Click to iPhone
    // 4.Print out the texts of all links
    // 5.Print out how many link is missing text
    // 6.Print out how many link has text
    // 7.Print out how many total link

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");
        WebElement iphone =driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iphone.click();

        // 4.Print out the texts of all links
           //   -> Tum body nin icindeki a href ler -> //body//a
        List<WebElement> AllLinksTexts = driver.findElements(By.xpath("//body//a"));

        for (int i = 0;i<=AllLinksTexts.size()-1; i++){
            System.out.println(AllLinksTexts.get(i).getText());
        }
        System.out.println("======================================================");

        // 5.Print out how many link is missing text
        // 6.Print out how many link has text

        int EmptyLinkText=0;
        int NotEmptyLinkText=0;

        for (int i = 0; i<=AllLinksTexts.size()-1; i++){
            if(AllLinksTexts.get(i).getText().isEmpty()){
                EmptyLinkText++;
            }else {
                NotEmptyLinkText++;
            }
        }
        System.out.println("There are " + NotEmptyLinkText + " Link is missing Text");
        System.out.println("There are " + EmptyLinkText + " Links have texts");


        // 7.Print out how many total link
        System.out.println("There are " + AllLinksTexts.size() + " link texts are exist");



        }


    }


