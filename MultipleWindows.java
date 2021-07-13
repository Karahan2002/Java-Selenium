package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;

public class OpenBrowser{
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod()throws InterruptedException {
        //Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("title before new window : "+driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("title after new window : "+driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        System.out.println("title after switch new window : "+driver.getTitle());
    }
}
