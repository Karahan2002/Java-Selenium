package day3_webElement_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class verifyURLnotChanged {
    public static void main(String[] args) {
        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to site
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();
        //click on retrieve button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        //save actual url after clicking button
        String actualUrl = driver.getCurrentUrl();
        //verify that url did not change
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //quit the driver
        driver.quit();
    }
}
