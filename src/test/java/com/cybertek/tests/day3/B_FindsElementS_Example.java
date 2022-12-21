package com.cybertek.tests.day3;

import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class B_FindsElementS_Example {

    /*
    TC #03: FINDELEMENTS_APPLE
    1.Open Chrome browser
    2.Go to https://www.apple.com
    3.Click to all of the headers one by one
    a.Mac, iPad, iPhone, Watch, TV, Music, Support
    4.Print out how many links on each page with the titles of the pages
    5.Loop through all
    6.Print out how many link is missing textTOTAL
    7.Print out how many link has textTOTAL
    8.Print out how many total linkTOTAL
*/

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(" https://www.apple.com");

        //3.Click to all of the headers one by one
        //a.Mac, iPad, iPhone, Watch, TV, Music, Support
        WebElement mac = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        WebElement iPad = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
        WebElement iPhone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        WebElement Watch = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
        WebElement Tv = driver.findElement(By.xpath("//a[@href='/tv/']"));
        WebElement Music= driver.findElement(By.xpath("//a[contains(@class,'music')]"));
        WebElement Support= driver.findElement(By.xpath("//a[@data-analytics-title='support']"));

        List<WebElement> AllHeaders = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));



        int j=1;
            for (int i=0; i<=AllHeaders.size()-2;i++) {
                if(AllHeaders.get(i).getAttribute("href").contains("mac")||
                        AllHeaders.get(i).getAttribute("href").contains("ipad")||
                        AllHeaders.get(i).getAttribute("href").contains("iphone")||
                        AllHeaders.get(i).getAttribute("href").contains("watch")||
                        AllHeaders.get(i).getAttribute("href").contains("tv")||
                AllHeaders.get(i).getAttribute("href").contains("music")||
                        AllHeaders.get(i).getAttribute("href").contains("support.apple")
                ){

                    Thread.sleep(2000);
                    AllHeaders.get(i).click();
                    System.out.println("Title "+ j+"= "+driver.getTitle());

                    AllHeaders = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a")); //For Stale Reference Element Exception. TO re-Reference it!
                    j++;
                }




            }



    }





}
