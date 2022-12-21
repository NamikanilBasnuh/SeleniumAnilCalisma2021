package com.cybertek.tests.day6;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class I_Actions_Practices2 {


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test
    public void double_click_Actions(){

        /*
      TC #16: Double Click Test
      1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
      2. Switch to iframe.
      3. Double click on the text “Double-click me to change my text color.”
      4. Assert: Text’s “style” attribute value contains “red”.
       */


        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        WebElement iframeLocation = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));
        Driver.getDriver().switchTo().frame(iframeLocation);

        WebElement doubleClicktextLocator = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(doubleClicktextLocator).perform();
        BrowserUtils.wait(2);

        Assert.assertTrue(doubleClicktextLocator.getAttribute("style").contains("red"));

        Driver.getDriver().switchTo().defaultContent();
    }

    @Test
    public void dragAndDrop_Actions(){

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        //2. Drag and drop the small circle to bigger circle.
        //3. Assert:
        //-Text in big circle changed to: “You did great

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement htmlAlert = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        BrowserUtils.wait(1);
        htmlAlert.click();
        BrowserUtils.wait(1);

        WebElement smallCirle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement biggerCirle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCirle,biggerCirle).perform();

        String successText = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']")).getText();
        Assert.assertEquals(successText,"You did great!","Double check! You made a Mistake");
        BrowserUtils.wait(1);

    }

    @Test
    public void clikcAndHold_Instead_of_dragAndDrop_Actions(){

        //SAME TEST WITH ABOVE. ONLY DIFFERENT approach!!

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        //2. Drag and drop the small circle to bigger circle.
        //Locating circles
        //DragAndDrop method expects to arguments:
        // #1-Which webElement you want to drag : SOURCE
        // #2-Where do you want to drop it? : TARGET
        //3. Assert:
        //-Text in big circle changed to: “You did great

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement htmlAlert = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        BrowserUtils.wait(1);
        htmlAlert.click();
        BrowserUtils.wait(1);

        WebElement smallCirle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement biggerCirle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());

        //THIS IS THE ONLY DIFFERENCE!!!
        actions.clickAndHold(smallCirle).moveToElement(biggerCirle).release().perform();

        String successText = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']")).getText();
        Assert.assertEquals(successText,"You did great!","Double check! You made a Mistake");
        BrowserUtils.wait(1);

    }

    @Test
    public void contextClick_RightClick(){

        //TC #17: Context Click – HOMEWORK
        //1. Go to https://the-internet.herokuapp.com/context_menu
        //2. Right click to the box.
        //3. Alert will open. Switch to alert
        //No assertion needed for this practice.

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement boxLocation = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(boxLocation).perform();

        BrowserUtils.wait(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        BrowserUtils.wait(1);
        alert.accept();





    }










}
