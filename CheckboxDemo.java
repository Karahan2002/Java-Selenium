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

public class CheckboxDemo{
    @Test
    public void test()throws InterruptedException{
        //open web browser and go to url
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));

        //
        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        //How to verify checkbox is selected or not ?
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //verify checkbox 1 is not selected, 2 is selected
        Assert.assertFalse(checkBox1.isSelected(),"verify checkbox 1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify checkbox 2 is selected");

        //how to check checkboxes?
        //just like a radio button we use click() method
        Thread.sleep(2000);
        checkBox1.click();

        //verify after click
        Assert.assertTrue(checkBox1.isSelected(),"verify checkbox 1 is selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify checkbox 2 is selected");
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
