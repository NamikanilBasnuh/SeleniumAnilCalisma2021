package com.cybertek.tests.day4;

import com.cybertek.Utility.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class G_SmartBear_OrderPlacing {

    // TC#2: Smartbearsoftware order placing
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “tests”
    // 5.Click on Login button
    // 6.Click on Order
    // 7.Select familyAlbum from product, set quantity to 2
    // 8.Click to “Calculate” button
    // 9.Fill address Info with JavaFaker•
    // Generate: name, street, city, state, zip code
    // 10.Click on “visa” radio button
    // 11.Generate card number using JavaFaker
    // 12.Click on “Process”
    // 13.Verify success message “New order has been successfully added.”

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1.Open browser
        // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 3.Enter username: “Tester”
        WebElement usernameInput = driver.findElement(By.xpath("//input[contains(@id,'username')]"));
        usernameInput.sendKeys("Tester");
        // 4.Enter password: “tests”
        WebElement passwordInput = driver.findElement(By.xpath("//input[contains(@id,'password')]"));
        passwordInput.sendKeys("com/cybertek/tests");
        // 5.Click on Login button
        WebElement loginInput = driver.findElement(By.xpath("//input[contains(@id,'login')]"));
        loginInput.click();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(4000);
        driver.close();
    }



    @Test
    public void test() throws InterruptedException{
        // 6.Click on Order
       WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
       orderLink.click();

        // 7.Select familyAlbum from product, set quantity to 2
        Select productDropDown = new Select(driver.findElement(By.xpath("//select[contains(@name,'Product')]")));
        Thread.sleep(1000);
        productDropDown.selectByValue("FamilyAlbum");
        WebElement quantityButton =driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantityButton.sendKeys("2");

        // 8.Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
        Thread.sleep(1000);
        // 9.Fill address Info with JavaFaker•
        // Generate: name, street, city, state, zip code

        WebElement customerNameInput = driver.findElement(By.xpath("//input[contains(@name,'Name')]"));
        WebElement streetInput= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        WebElement cityInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        WebElement stateInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        WebElement zipInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));

        Faker faker = new Faker();


        customerNameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        zipInput.sendKeys(faker.address().zipCode());



        // 10.Click on “visa” radio button
        WebElement visaRadionButton = driver.findElement(By.xpath("//input[@value='Visa']"));
        visaRadionButton.click();

        // 11.Generate card number using JavaFaker
        WebElement cardNumberInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumberInput.sendKeys(faker.number().digits(16));


        //12. Generete Expdate
        WebElement expirationDateButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expirationDateButton.sendKeys("12/28");
        Thread.sleep(1000);


        // 13.Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));

        processButton.click();
        Thread.sleep(10000);

        // I added to check my order
        /*
         WebElement viewAllordersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllordersButton.click();
        Thread.sleep(6);
         */


        // 14.Verify success message “New order has been successfully added.”
        WebElement message = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        Assert.assertEquals(message.getText(),"New order has been successfully added.");





    }





}
