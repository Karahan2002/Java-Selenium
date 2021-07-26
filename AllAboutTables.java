package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllAboutTables{
    WebDriver driver;
    public String headerxPath = "//table[@id='table1']//th";
    public String tableXpath = "//table[@id='table1']";
    public String rowsWithHeader = "//table[@id='table1']//tr";
    public String rowsWithoutHeader = "//table[@id='table1']/tbody/tr";
    public String singleCellXpath = "//table[@id='table1']/tbody/tr[3]/td[5]";
    public String JasonXpath = "//table[@id='table1']//td[.='Jason']/../td[3]";
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){
        System.out.println("TEST 1 : ");
        WebElement table = driver.findElement(By.xpath(tableXpath));
        System.out.println("table.getText() = ");
        System.out.println(table.getText());
    }
    @Test
    public void test2(){
        System.out.println("TEST 2 : ");
        List<WebElement> headers = driver.findElements(By.xpath(headerxPath));
        System.out.println("headers.size() = " + headers.size());
        for(WebElement header : headers){
            System.out.print(header.getText()+" ");
        }
    }
    @Test
    public void test3(){
        System.out.println("TEST 3 : ");
        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath(headerxPath));
        System.out.println("headers.size() = " + headers.size());

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath(rowsWithHeader));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath(rowsWithoutHeader));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
    }
    @Test
    public void test4(){
        System.out.println("TEST 4 : ");
        List<WebElement> numRows = driver.findElements(By.xpath(rowsWithoutHeader));
        for(int i=1;i<=numRows.size();i++){
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+" - "+row.getText());
        }
    }
    @Test
    public void test5(){
        System.out.println("TEST 5 : ");
        List<WebElement> AllCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        for(WebElement element : AllCellsInOneRow){
            System.out.println(element.getText());
        }
    }
    @Test
    public void test6(){
        System.out.println("TEST 6 : ");
        WebElement singleCell = driver.findElement(By.xpath(singleCellXpath));
        System.out.println("singleCell.getText() = " + singleCell.getText());
    }
    @Test
    public void test7(){
        System.out.println("TEST 7 : ");
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("Col number : "+colNumber);
        System.out.println("Row number : "+rowNumber);

        for(int i=1;i<=rowNumber;i++){
            for(int x=1;x<=colNumber;x++){
                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+x+"]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());
            }
        }
    }


    public int getNumberOfRows(){
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath(rowsWithoutHeader));
        return allRowsWithoutHeader.size();
    }
    public int getNumberOfColumns(){
        List<WebElement> headers = driver.findElements(By.xpath(headerxPath));
        return headers.size();
    }


    @Test
    public void test8(){
        System.out.println("TEST 8 : ");
        WebElement email = driver.findElement(By.xpath(JasonXpath));
        System.out.println(email.getText());
    }
}








