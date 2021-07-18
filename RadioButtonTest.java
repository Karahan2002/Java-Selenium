package day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest{
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement button1 = driver.findElement(By.cssSelector("#blue"));
        WebElement button2 = driver.findElement(By.cssSelector("#red"));

        System.out.println("blue button : button1.isSelected() = " + button1.isSelected());
        System.out.println("red button : button2.isSelected() = " + button2.isSelected());

        Assert.assertTrue(button1.isSelected(),"verify that blue is selected");
        Assert.assertFalse(button2.isSelected(),"verify that red is not selected");

        System.out.println("clicking to red button");
        button2.click();
        Assert.assertTrue(button1.isSelected(),"verify that blue is selected");
        Assert.assertFalse(button2.isSelected(),"verify that red is not selected");
    }
}
