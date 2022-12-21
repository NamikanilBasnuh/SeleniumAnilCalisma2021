package com.cybertek.tests.day4;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D_DropDownsPractice {

    //1.Open browser
    // 2.Go to website:http://practice.cybertekschool.com/dropdown
    //Select “December 1 , 1922” and verify it is selected.
    //   Select year using : visible text
    //   Select month using : value attribute
    //   Select day using: index number
    //Asserting year dropdown values vs expected
    //Asserting month dropdown values vs expected
    //Asserting day dropdown values vs expected

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1.Open browser
        // 2.Go to website:http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1() {
        //Select “December 1 , 1922” and verify it is selected.
        Select yearDropDown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropDown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        //   Select year using : visible text
        yearDropDown.selectByVisibleText("1922");
        //   Select month using : value attribute
        monthDropDown.selectByValue("11");
        //   Select day using: index number
        dayDropDown.selectByIndex(0);

        System.out.println(monthDropDown.getFirstSelectedOption().getText() + " " + dayDropDown.getFirstSelectedOption().getText() + " , " + yearDropDown.getFirstSelectedOption().getText());

        //Asserting year dropdown values vs expected
        String actualYearSelectedDropDown = yearDropDown.getFirstSelectedOption().getText();
        String expectedYearSelectedDropDown = "1922";
        Assert.assertEquals(actualYearSelectedDropDown, expectedYearSelectedDropDown);

        //Asserting month dropdown values vs expected
        String actualSelectedmonthDropDown = monthDropDown.getFirstSelectedOption().getText();
        String expectedSelectedmonthDropDown = "December";
        Assert.assertTrue(actualSelectedmonthDropDown.equals(expectedSelectedmonthDropDown));

        //Asserting day dropdown values vs expected
        String actualSelecteddayDropDown = dayDropDown.getFirstSelectedOption().getText();
        String expectedSelecteddayDropDown = "1";
        Assert.assertEquals(actualSelecteddayDropDown, expectedSelecteddayDropDown);
    }

    @Test
    public void test2() {

        //TC#7: Cybertek “month”dropdown default value
        // 1.Open browser
        // 2.Go to website: http://practice.cybertekschool.com/dropdowns

        //  ABOVE IS DEALT in BEFOREMETHOD!

        // 3.Verify default value is always showing the current year,month,day
        Select yearofDropDown = new Select(driver.findElement(By.xpath(" //select[@id='year']")));
        Select monthofDropDown = new Select(driver.findElement(By.xpath(" //select[@id='month']")));
        Select dayofDropDown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        String dropDownDate = yearofDropDown.getFirstSelectedOption().getText() + " " +
                              monthofDropDown.getFirstSelectedOption().getText() + " " +
                              dayofDropDown.getFirstSelectedOption().getText();


        String yearNow = String.valueOf(LocalDateTime.now().getYear());
        String monthNow = LocalDateTime.now().getMonth().name();
        String dayNow = String.valueOf(LocalDateTime.now().getDayOfMonth());

        String todaysDate = yearNow+" "+monthNow+" "+dayNow;

        // Expected: If currently in June, should show June selected.
        Assert.assertEquals(dropDownDate.toLowerCase(),todaysDate.toLowerCase());



        // Storing all of the options in the month dropdown into the list of web elements

        List<WebElement> allmonthDropDowns = monthofDropDown.getOptions();
        List<String> ActualAllmonthsDropDowns = new ArrayList<>();
        for (WebElement item:allmonthDropDowns) {
            ActualAllmonthsDropDowns.add(item.getText());
        }

        List<String> ExpectedDropDowns = new ArrayList<>(Arrays.asList("January","February","March","April", "May", "June", "July", "August", "September", "October", "November", "December"));


        System.out.println(ActualAllmonthsDropDowns);
        System.out.println(ExpectedDropDowns);

        Assert.assertTrue(ActualAllmonthsDropDowns.equals(ExpectedDropDowns));


        }

   @Test
    public void BrowserUtilsTest(){

       Select monthofDropDown = new Select(driver.findElement(By.xpath(" //select[@id='month']")));
       List<WebElement> allmonthDropDowns = monthofDropDown.getOptions();

       System.out.println(BrowserUtils.getElementsText(allmonthDropDowns));


       //BrowserUtils wait method usage
       //it wait 4 seconds and will not be thrown an exception
       //because interrupted exception is dealt in wait(int sec) method!!!

       BrowserUtils.wait(4);

   }



}


