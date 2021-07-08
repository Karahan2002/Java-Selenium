package day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileWriter;

public class OpenBrowser2{
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = OpenBrowser.getDriver("chrome");
        File file = new File("pageSource.txt");
        try{
            if(file.createNewFile()){
                System.out.println("The File created successfully!!");
            }
        }catch(Exception e){
            System.out.println("error : "+e.getMessage());
        }
        driver.get("https://www.google.com/");
        System.out.println("-----------------------------------------");
        System.out.println("title : "+driver.getTitle());
        System.out.println("url : "+driver.getCurrentUrl());
        System.out.println("window handle : "+driver.getWindowHandle());
        System.out.println("window handles : "+driver.getWindowHandles());
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(driver.getPageSource());
            writer.close();
            System.out.println("-----------------------------------");
            System.out.println("The page source has been written");
        }catch(Exception e){
            System.out.println("error : "+e.getMessage());
        }
        System.out.println("------------------------------------");
        System.out.println("The file info : ");
        System.out.println("file name : "+file.getName());
        System.out.println("absolute file : "+file.getAbsoluteFile());
        System.out.println("file path : "+file.getPath());
        System.out.println("file total space : "+file.getTotalSpace());
        System.out.println("file usable space : "+file.getUsableSpace());
        Thread.sleep(2000);
        driver.quit();
    }
    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;
        switch(browserType.toLowerCase()){
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
