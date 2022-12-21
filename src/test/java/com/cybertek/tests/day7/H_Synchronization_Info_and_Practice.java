package com.cybertek.tests.day7;

import com.cybertek.Utility.Driver;
import com.cybertek.pages.Loading1Page;
import com.cybertek.pages.Loading7Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class H_Synchronization_Info_and_Practice {

    /*

                         WAITS
        Option 1:

        Thread.sleep
          -This adds hard codded wait inside of our program.
          -It dosen not depend on any kind of condition.
          -It will wait for the given time period no matter what
          -This is not considered a good practice.
          -Try not to use this unless you have to!
          -Too much use will make the test long and heavy!
          -THERE ARE SOME CERTAIN SCENARIO ImplicitlyWait, ExplicitlyWait WILL NOT WORK!!!
              AT THAT TIME USE IT!

        Option 2:

        ImplicitlyWait
           -Not used for a specific condition applies to many lines
              until that driver continue looking for the WebElement for the given duration!
           -Makes driver continue looking for the WebElement for the given duration!
           -THE ONLY HELP it gives us when we are trying to LOCATE WebElement. That's it!
           -Stops polling as soon as the element is found!
           -If element is not found it will throw exception after the given time(NoSuchElementException)
           -It will apply to every single line where findElement(); or FindElements() is used!!
           -It is written ONCE!

        Option 3:

        Explicitly Wait
           -Can be used wait for a certain condition
           -Wait until element is visible
           -Wait until element is avaliable
           -Wait until element is clickable
           -Wait until element is not avaliable etc...

           Syntax:

              WebDriverWait wait = new WebDriverWait(driver,10);

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

          -Above syntax and example will wait 10 seconds using the the locator provided(xpath,etc...)
          -If condition does not happen ->throws exception-> TimeOutException <- !!!!!
   */

    @Test(description = "Dynamic Title Test",priority =0 )
    public void test1(){

         /*
    TC#40: Dynamically Loaded Page Elements 7
    1.Go to http://practice.cybertekschool.com/dynamic_loading/7
    2.Wait until title is “Dynamic Title”
    3.Assert : Message “Done” is displayed.
    4.Assert : Image is displayed.Note: Follow POM
     */
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        // wait.until(ExpectedConditions.) ->HAS SOOOOO MANY OPTIONS!!!!!!!!!

        Loading7Page loading7Page = new Loading7Page();

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());

        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());
    }

    @Test(description = "loading bar disappears",priority = 1)
    public void test2(){
         /*
    TC#41: Dynamically Loaded Page Elements 1
    1.Go to http://practice.cybertekschool.com/dynamic_loading/1
    2.Click to start
    3.Wait until loading bar disappears
    4.Assert username inputboxis displayed
    5.Enter username: tomsmith
    6.Enter password: incorrectpassword
    7.Click to Submit button
    8.Assert “Your password is invalid!” text is displayed.Note: Follow POM
    */

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Loading1Page loading1Page = new Loading1Page();
        loading1Page.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));

        Assert.assertTrue(loading1Page.userNameInputBox.isDisplayed());

        loading1Page.userNameInputBox.sendKeys("tomsmith");
        loading1Page.passwordInputBox.sendKeys("incorrectpassword");
        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.passwordErrorMessage.isDisplayed());



    }




}
