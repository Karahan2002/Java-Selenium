import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTestWithExtentReport{
    WebDriver driver;
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;
    @BeforeMethod
    public void setUp(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Amazon Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));


        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
    }
    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        report.flush();
        driver.quit();
    }
    @Test
    public void test1(){
        extentLogger = report.createTest("TC123 Amazon Test");

        extentLogger.info("write 'iphone' to input");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("iphone");

        extentLogger.info("click to search button");
        WebElement button = driver.findElement(By.id("nav-search-submit-button"));
        button.click();


        WebElement text1 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
        WebElement text2 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]"));

        extentLogger.info("verify that '1-16 of over 1,000 results for' text is written");
        if(text1.getText().equals("1-16 of over 1,000 results for")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        extentLogger.info("verify that 'iphone' text is writter");
        if(text2.getText().equals("\"iphone\"")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        extentLogger.pass("PASSED");
    }
}
