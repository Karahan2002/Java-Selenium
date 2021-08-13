import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class AttributeTest{
    @Test
    public void test1() throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        WebElement blueRadioButton = driver.findElement(By.id("blue"));

        //get value of button (on or of)
        System.out.println("value of radio button(on or of) : "+blueRadioButton.getAttribute("value"));

        //get the value of type attribute
        System.out.println("type of radio button : "+blueRadioButton.getAttribute("type"));

        //get the value of name attribute
        System.out.println("name : "+blueRadioButton.getAttribute("name"));

        //get the value of checked
        System.out.println("value of checked(true or false) : "+blueRadioButton.getAttribute("checked"));

        //trying to get attribute that does not exist
        //when we use non exist attribute it will return null to us.
        System.out.println(blueRadioButton.getAttribute("href"));

        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        System.out.println("BUTTON");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("Inner HTML: "+button2.getAttribute("innerHTML"));

        Thread.sleep(2000);
        driver.quit();
    }
}


class WebDriverFactory{
    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
class ConfigurationReader{
    private static Properties properties;

    static{
        try{
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        }catch(Exception e){
            System.out.println("error : "+e.getMessage());
        }
    }
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
