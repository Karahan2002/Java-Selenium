package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class apitest_1 {
    String spartanurl = "http://54.237.100.89:8000";
    @Test
    public void test1() {
        Response response = when().get(spartanurl + "/api/spartans/3");
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
    }
    /*
    * TASK
    * When user sends a get request to /api/spartan/3
    * Then status code should be 200
    * And content type should be application/json/charset=UTF-8
    * and json body should contain Fidole
    * */
    @Test
    public void test2(){
            //send request to /api/spartan/3
            Response response = when().get(spartanurl+"/api/spartans/3");

            //verify status code
            Assert.assertEquals(response.statusCode(),200);

            //verify content type
            Assert.assertEquals(response.contentType(),"application/json");

            //verify Fidole
            Assert.assertTrue(response.body().asString().contains("Fidole"));
    }
    /*
    * Given no headers provided
    * When users sends GET request to /api/hello
    * Then response status code should be 200
    * And content type header should be "text/plain;charset=UTF-8"
    * And header should contain date
    * And content length should be 17
    * And body should be "Hello from sparta"
    * */
    @Test
    public void helloTest(){
        //request
        Response response = when().get(spartanurl+"/api/hello");

        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //verify content-type
        Assert.assertEquals(response.contentType(),"text/plain;charset=UTF-8");

        //verify we have headers named date
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));

        //to get and header passing as a key
        System.out.println("Content Type : "+response.header("Content-Type"));
        System.out.println("Content Length : "+response.header("Content-Length"));
        System.out.println("Date : "+response.header("Date"));

        //verify content length is 17
        Assert.assertEquals(response.header("Content-Length"),"17");
        //verify hello from sparta
        Assert.assertTrue(response.body().asString().contains("Hello from Sparta"));

        System.out.println(response.body().asString());
        System.out.println(response.body().asString().contains("Hello from Sparta"));
        System.out.println(response.asString());
        System.out.println(response.toString());

    }
}
