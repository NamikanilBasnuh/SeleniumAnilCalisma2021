package com.cybertek.tests.day5;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class G_Windows_Handling_Practices {


    /*
    TC	#	:	Window	Handlepractice
    1.Create	a	new	class	called:	WindowHandlePractice
    2.Create	new	tests	and	make	set	ups
    3.Go	to	:	http://practice.cybertekschool.com/windows
    4.Assert:	Title	is	“Practice”
    5.Click	to:	“Click	Here”text
    6.Switch	to	new	Window.
    7.Assert:	Title	is	“New	Window
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    /*@AfterMethod
    public void tearDown(){
        BrowserUtils.wait(5);
        driver.close();
    }   */

    @Test
    public void practice1_handling_2_windows(){

        /*
    TC	#	:	Window	Handlepractice
    1.Create	a	new	class	called:	WindowHandlePractice
    2.Create	new	tests	and	make	set	ups
    3.Go	to	:	http://practice.cybertekschool.com/windows
    4.Assert:	Title	is	“Practice”
    5.Click	to:	“Click	Here”text
    6.Switch	to	new	Window.
    7.Assert:	Title	is	“New	Window
     */

        //3.Go	to	:	http://practice.cybertekschool.com/windows
        driver.get("http://practice.cybertekschool.com/windows");

        // 4.Assert:	Title	is	“Practice”

        String defaultTitle = driver.getTitle();
        Assert.assertTrue(defaultTitle.equals("Practice"));

        //    5.Click	to:	“Click	Here”text
        WebElement clickHereLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHereLink.click();

        String titleAfterclickHereLink = driver.getTitle();
        System.out.println("titleAfterclickHereLink = " + titleAfterclickHereLink);
        //Above code  and print out shows that title doesn't change even we are on New Window
        // Title was supposed to "New Window" BUT Still it is "Practice".
        //Because Selenium still thinks that you are on the Practice window!!!!


        //    6.Switch	to	new	Window.

        String MainWindowHandle = driver.getWindowHandle(); //--> We store main window by using this method.
                                                           //-> Later on we will use it
        System.out.println("MainWindowHandle = " + MainWindowHandle);

        // the number above keeps changing as many as you run the tests!don't worry about it!

        Set<String> windowHandleS = driver.getWindowHandles(); //-> Set only allows unique values!

        for (String item : windowHandleS) {
            //How do we switch to a different window using selenium?
            //driver.switchTo().window(WINDOWHANDLE);

            driver.switchTo().window(item); //Now we are on New Window!!!
            System.out.println("Current Title = " + driver.getTitle()); //Now we are on New Window!!!

        }

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle); //Now we are on New Window!!!


        //    7.Assert:	Title	is	“New	Window"

        Assert.assertTrue(driver.getTitle().equals("New Window"));

        //Now I will switch to Main window

        driver.switchTo().window(MainWindowHandle);

        System.out.println("Main page Title = " + driver.getTitle());

    }


    @Test
    public void practice2_handling_more_than_two_windows(){


        // 2.Create new tests and make set ups
        // 3.Go to : https://www.amazon.com
        // 4.Copy paste the lines from below into your class
        // 5.Create a logic to switch to the tab where Etsy.com is open
        // 6.Assert: Title contains “Etsy”
        //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        //----------------------------------------------------------------------------------------//
        //Important Syntax
        // driver.getWindowHandle() ->returns String-> We store a single Window in it!
        //driver.getWindowHandles() ->returns Set<String> -> We store multiple Windows in it!
        //We use Foreach loop to switch windows!!
        //driver.switchTo().window(WINDOWHANDLE); ->to Switch
                                  //WINDOWHANDLE-> item, each OR a specific window that you store before
                                  // by using String window = driver.getWindowHandle()...
        //-----------------------------------------------------------------------------------------//


       // 3.Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        // 4.Copy paste the lines from below into your class

        //This LINE IS BASICALLY : We are downcasting our driver type to JavaScriptExecuter
        //The only thing this 3 lines are doing is USING JS EXECUTOR -> opening new tabs with given links!
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        // 5.Create a logic to switch to the tab where Etsy.com is open

        String AmazonMainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowsHandles = driver.getWindowHandles();


        String etsyWindowHandle="";
        String googleWindowHandle="";
        String facebookWindowHandle="";


        for (String item : allWindowsHandles) {

            driver.switchTo().window(item);

            System.out.println("driver.getTitle() = " + driver.getTitle());
            //driver.getTitle() = Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
            //driver.getTitle() = Facebook - Log In or Sign Up
            //driver.getTitle() = Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
            //driver.getTitle() = Google

            //What if we want to choose and use etsy? It is easy. Just create a if statement logic

            if(driver.getCurrentUrl().contains("etsy")){
                etsyWindowHandle=driver.getWindowHandle();
            }else if(driver.getCurrentUrl().contains("google")){
                googleWindowHandle=driver.getWindowHandle();
            }else if(driver.getCurrentUrl().contains("facebook")){
                facebookWindowHandle=driver.getWindowHandle();
            }
        }

        System.out.println("==================================================");

        driver.switchTo().window(etsyWindowHandle); // I switch to etsy
        System.out.println("Title is = " + driver.getTitle());

        driver.switchTo().window(googleWindowHandle);
        System.out.println("Title is = " + driver.getTitle()); // I switch to google

        driver.switchTo().window(facebookWindowHandle);
        System.out.println("Title is = " + driver.getTitle()); // I switch to facebook

        driver.switchTo().window(AmazonMainWindowHandle);
        System.out.println("Title is = " + driver.getTitle()); // I switch to amazon

        // 6.Assert: Title contains “Etsy”
        driver.switchTo().window(etsyWindowHandle);
        // I will send some keys to etsy -> "You are the best"! and I will Assert it!
        WebElement etsySearchbox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        BrowserUtils.wait(1);
        etsySearchbox.sendKeys("You are the best"+ Keys.ENTER);
        BrowserUtils.wait(1);
        etsySearchbox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']")); //re-write it. re-reference it.



        Assert.assertEquals(etsySearchbox.getAttribute("value"),"You are the best","You made a mistake. Failed!");

        Assert.assertTrue(driver.getTitle().contains("Etsy"));

        //I am done with etsy. I will close it.
        driver.close();

        //7. I will switch to Amazon tab and I will send keys to search box and then assert it!
        driver.switchTo().window(AmazonMainWindowHandle);

        WebElement amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        BrowserUtils.wait(1);
        amazonSearchBox.sendKeys("You are the best, dude!"+Keys.ENTER);
        BrowserUtils.wait(1);
        amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));//Not to have StaleReferenceException


        Assert.assertTrue(amazonSearchBox.getAttribute("value").equals("You are the best, dude!"));
        Assert.assertEquals(driver.getTitle(),"Amazon.com : You are the best, dude!");

        //I am done with Amazon tab. I will close it!
        BrowserUtils.wait(1);
        driver.close();

        //8.I will switch to facebook tab and I will send keys to search box and then assert it!
            //and I will close the tab!
        driver.switchTo().window(facebookWindowHandle);

        WebElement facebookEmailorPhoneBox = driver.findElement(By.xpath("//input[@id='email']"));
        facebookEmailorPhoneBox.sendKeys("Ara beni Boya beni!"+Keys.ENTER);
        BrowserUtils.wait(2);

        //facebookEmailorPhoneBox = driver.findElement(By.xpath("//input[@id='email']"));

        Assert.assertEquals(driver.getTitle(),"Log into Facebook");
        driver.close();

        //8. I am bored! I will switch to google tab and I will send keys to search box and then assert it!
            //and I will verify the title too!
            // then I will close the last tab also!
        driver.switchTo().window(googleWindowHandle);

        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys("SOR BAKALIM ANNENE KODCU DAMAT SEVER MI?"+Keys.ENTER);
        BrowserUtils.wait(4);

        googleSearchBox = driver.findElement(By.xpath("//input[@name='q']"));


        //input[@value='SOR BAKALIM ANNENE KODCU DAMAT SEVER MI?']
        Assert.assertEquals(googleSearchBox.getAttribute("value"),"SOR BAKALIM ANNENE KODCU DAMAT SEVER MI?");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        Assert.assertTrue(driver.getTitle().equals("SOR BAKALIM ANNENE KODCU DAMAT SEVER MI? - Google Search"));

        driver.close();
    }
}
