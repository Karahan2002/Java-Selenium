import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class WebDriverFactory{
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
public class WebdriverFactory{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("title : "+title);
        System.out.println("url : "+url);
        Thread.sleep(5000);
        driver.quit();
    }
}
