package day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;

public class OpenBrowser{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        File file = new File("source.txt");
        try{
            if(file.createNewFile()){
                System.out.println("file created");
            }
        }catch(Exception e){
            System.out.println("hata : "+e);
        }

        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();
        System.out.println("title : "+title);
        System.out.println("url : "+url);
        Thread.sleep(3000);
        driver.quit();
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(pageSource);
            writer.close();
            System.out.println("page source writed to "+file.getAbsoluteFile());
        }catch(Exception e){
            System.out.println("hata : "+e);
        }
    }
}
