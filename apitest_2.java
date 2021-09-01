package jdbctests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
public class apitest_2{
    @BeforeClass
    public void beforeClass(){
        baseURI = "http://54.237.100.89:8000";
    }
    /*
     * Given accept type is JSON
     * And id parameter value is 5
     * When user sends GET request to /api/spartans/{id}
     * Then response status code should be 200
     * And response content-type: application/json;charset=UTF-8
     * And "Blythe" should be in response payload
     *
     * */
    @Test
    public void test1(){
        ///send request to api/spartans/{id}
        Response response = given().accept(ContentType.JSON).and().pathParam("id",5).when().get("api/spartans/{id}");
        //verify status code
        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.contentType(),"application/json");
        //verify "Blythe"
        assertTrue(response.body().asString().contains("Blythe"));
    }
    /*
     * Task
     * Given accept type is JSON
     * And id parameter value is 500
     * When user sends Get request to /api/spartans/{id}
     * Then response status code should be 404
     * And response content-type: application/json;charset=UTF-8
     * And "spartan not found" message should be in response payload
     * */
    @Test
    public void test2(){
        //send request to api/spartans/{id}
        Response response = given().accept(ContentType.JSON).and().pathParam("id",500).when().get("api/spartans/{id}");
        //verify status code
        assertEquals(response.statusCode(),404);
        //verify content type
        assertEquals(response.contentType(),"application/json");
        //verify error message that is "Not Found"
        assertTrue(response.body().asString().contains("Not Found"));
    }
    /*
     * TASK
     * Given accept type is JSON
     * And query parameter values are:
     * gender|Female
     * nameContains|e
     * When user sends GET request to /api/spartans/search
     * Then response status code should be 200
     * And response content-type: application/json;charset=UTF-8
     * And "Female" should be in response payload
     * And "Janette" should be in response payload
     * */
    @Test
    public void test3(){
        //send request to api/spartans/search
        Response response = given().accept(ContentType.JSON).and().queryParams("gender","Female").queryParams("nameContains","z").then().when().get("api/spartans/search");
        //verify status code
        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.contentType(),"application/json");
        //verify "Female"
        assertTrue(response.body().asString().contains("Female"));
        //verify "Lorenza"
        assertTrue(response.body().asString().contains("Lorenza"));
    }
    @Test
    public void test4(){
        //create a map and add query parameters
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("gender","Female");
        queryMap.put("nameContains","e");
        //send request to /api/spartans/search
        Response response = given().accept(ContentType.JSON).and().queryParams(queryMap).when().get("/api/spartans/search");
        //verify status code
        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.contentType(),"application/json");
        //verify Female in the response
        assertTrue(response.body().asString().contains("Female"));
        //verify Janette in the response
        assertTrue(response.body().asString().contains("Lorenza"));
    }
}
