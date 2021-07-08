package day3_webElement_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class verifyConfirmationMessage {
    public static void main(String[] args) {
        //open chrome web browser and go to http://practice.cybertekschool.com/forgot_password
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "manajer166@gmail.com";
        //sendKeys()--> send keyboard action to the webElement
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        //two main ways to get txt from web elements
        //1. getText()--> It will work %99 and it will return string
        //2. getAttribute("value) --> second way of getting text especially input boxes
        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        //verify that email is displayed in the input box
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //click on retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says "Your email's been sent"
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        System.out.println(actualConfirmationMessage.getText());
        //save expected message
        String expectedMessage = "Your e-mail's been sent!";
        //save actual message to variable
        String actualMessage = actualConfirmationMessage.getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }
        //quit the browser
        driver.quit();
    }
}
