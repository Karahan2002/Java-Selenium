package day1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assertion{
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Open browser");
    }
    @Test
    public void test1(){
        System.out.println("first assertion : ");
        Assert.assertEquals("yakup","yakup");
        System.out.println("second assertion");
        Assert.assertEquals("URL","uRL");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
}
