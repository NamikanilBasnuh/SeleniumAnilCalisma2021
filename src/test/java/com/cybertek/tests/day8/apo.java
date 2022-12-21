package com.cybertek.tests.day8;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class apo {


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

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @Ignore
    @Test
    public void test1(){


        /*TC	#	:	Window	Handlepractice
        1.Create	a	new	class	called:	WindowHandlePractice
        2.Create	new	tests	and	make	set	ups
        3.Go	to	:	http://practice.cybertekschool.com/windows
        4.Assert:	Title	is	“Practice”
        5.Click	to:	“Click	Here”text
        6.Switch	to	new	Window.
        7.Assert:	Title	is	“New	Window*/

        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        Set<String> windowhandles = driver.getWindowHandles();

        String Window_1 = "";
        String Window_2 = "";
        for (String item:windowhandles) {
            if(driver.switchTo().window(item).getTitle().equals("Practice")){
                Window_1=driver.getWindowHandle();
            }else if(driver.switchTo().window(item).getTitle().equals("New Window")){
                Window_2=driver.getWindowHandle();
            }
        }
        System.out.println(driver.getTitle());

        BrowserUtils.wait(1);
        System.out.println(driver.switchTo().window(Window_1).getTitle()); //practice

        BrowserUtils.wait(1);
        System.out.println("===========================================");
        System.out.println(driver.switchTo().window(Window_2).getTitle()); //new window

        System.out.println("===============================================");
        driver.switchTo().window(Window_1);
        Actions actions  =new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Home']"))).perform();
        BrowserUtils.wait(2);


        driver.switchTo().window(Window_2).close();
        BrowserUtils.wait(2);
        driver.switchTo().window(Window_1).close();
        BrowserUtils.wait(2);
        driver.quit();

    }

    @Test
    public void test2(){
        // 3.Go to : https://www.amazon.com
        // 4.Copy paste the lines from below into your class
        // 5.Create a logic to switch to the tab where Etsy.com is open
        // 6.Assert: Title contains “Etsy”
        //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://xvideos.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> AllWindows_Tabs = driver.getWindowHandles();

        String amazonTab = "";
        String xvideosTab = "";
        String etsyTab = "";
        String facebookTab = "";


        for (String eachTab : AllWindows_Tabs) {

            if(driver.switchTo().window(eachTab).getCurrentUrl().equalsIgnoreCase("https://www.Amazon.com")){
                amazonTab=driver.getWindowHandle();
            }else if(driver.switchTo().window(eachTab).getTitle().contains("XV")){
                xvideosTab=driver.getWindowHandle();
            }else if(driver.switchTo().window(eachTab).getCurrentUrl().equalsIgnoreCase("https://www.etsy.com/")){
                etsyTab=driver.getWindowHandle();
            }else if(driver.switchTo().window(eachTab).getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")){
                facebookTab=driver.getWindowHandle();
            }

        }
        driver.switchTo().window(amazonTab);
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone"+ Keys.ENTER);
        BrowserUtils.wait(2);


        driver.switchTo().window(xvideosTab);
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("(//input[@name='k'])[1]")).sendKeys("Yok mu beni siken"+Keys.ENTER);
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("(//a[contains(@href,'demekki_sikeni_yok')])[1]")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("(//img[@title='Play'])[1]")).click();



        driver.switchTo().window(etsyTab);
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']")).sendKeys("Boat"+Keys.ENTER);
        BrowserUtils.wait(2);


        driver.switchTo().window(facebookTab);
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[contains(@id,'u_0_d')]")).click();
        BrowserUtils.wait(2);
        driver.close();

        driver.switchTo().window(amazonTab);
        BrowserUtils.wait(2);
        driver.close();

        driver.switchTo().window(etsyTab);
        BrowserUtils.wait(2);
        driver.close();

        driver.switchTo().window(xvideosTab);
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//img[@title='Pause']")).click();
        BrowserUtils.wait(1);
        driver.close();

        driver.quit();
    }
}

