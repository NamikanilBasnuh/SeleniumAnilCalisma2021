package com.cybertek.tests.day5;

public class B_AlertsSyntaxAndInfo {

    /*
       There are 2 types of alerts.
          1- HTML Alert/Pop Up
          2- JavaScript Alerts

          1- HTML Alert:
             - Created using regular HTML tags, such as divs.
             - How to handle HTML ALERTS?
             - We locate just as any other web element.
             - And click to close/accept/dismiss.

        2- JavaScript Alerts:
             - JS Alerts are created implementing JS in HTML.
             - When JS Alert is on the page, user cannot do any other action until handling the alert.

             To handle alerts, we need to create instance of "Alert" class,
             then switch driver's focus to the currently present alert.

             There are 3 types of JavaScript alerts!!!

             1- Warning/Information Alert:
               - User has only one option: ACCEPT.
               - You can only accept this alert.

                    syntax:
                          Alert alert = driver.switchTo().alert();
                                       alert.accept();

              2- Confirmation Alert:
                 - User has two options. ACCEPT or DECLINE.
                 - You can accept or dismiss this alert.

                        syntax:
                            Alert alert = driver.switchTo().alert();
                                    alert.accept();
                                     alert.dismiss();

                3- Prompt Alert:
                  - User can accept, dismiss, and also sendKeys to this alert.

                          syntax:
                                 Alert alert = driver.switchTo().alert();
                                       alert.accept();
                                       alert.dismiss();
                                       alert.sendKeys("Anything you want to send inside of the alert");








     */

}
