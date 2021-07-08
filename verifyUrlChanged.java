package day3_webElement_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class verifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to site
            driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        //sendKeys()--> send keyboard action to the webElement
        emailInputBox.sendKeys("manajer166@gmail.com");
        //click retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        Thread.sleep(3000);
        //verify that url changed to http://practice.cybertekschool.com/email_sent
        //create expected url
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        //saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }
        //quit the browser
        driver.quit();
    }
}
