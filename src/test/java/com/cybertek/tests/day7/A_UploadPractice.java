package com.cybertek.tests.day7;

import com.cybertek.Utility.BrowserUtils;
import com.cybertek.Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class A_UploadPractice {

   /*

       UPLOADING using Selenium
         1-We locate the upload web element using any locator
         2-We send the path of the file we want to upload to the upload web element

         WE WILL NOT BE CLICKING on the upload web element!
           Because when we click to this web element (choose file) it will open another page
                  Which the selenium will not able to reach!!!!
            Therefore, we will send the path directly by using sendKeys()! BUT NO ENTER OR CLICK!


    */

    //Getting the page
    //get the path of the file you want to upload
    //MAC: right click on the file you want to upload
    //  Click and hold "OPTION" button and select "copy as path name"

    //Windows: Right click -> properties -> copy from location
    //OR SHIFT + RIGHT CLICK --> Copy as path


    @Test
    public void uploading_file_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        WebElement chooseFileInput = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        BrowserUtils.wait(4);

        String pathTheImageThatIwantToUpload = "C:\\Users\\namik\\Desktop\\downloadForUpload.jfif";
        chooseFileInput.sendKeys(pathTheImageThatIwantToUpload);
        BrowserUtils.wait(4);

        WebElement upLoadInputButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        upLoadInputButton.click();
        BrowserUtils.wait(4);


        WebElement approvalText = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(approvalText.isDisplayed());
        Assert.assertEquals(approvalText.getText(),"File Uploaded!");


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
