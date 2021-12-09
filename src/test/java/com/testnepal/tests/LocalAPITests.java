package com.testnepal.tests;

import static com.testnepal.utils.JsonFormatter.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class LocalAPITests {

    @BeforeMethod
    public static  void  setUp() {
        baseURI = "http://localhost:3000/";
    }

    @Test(priority = 3, description = "Employee Data Test")
    public static  void getEmployeesTest() {
        Response response = given().when().get("employees").then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = convertResponseToJson(response);
        Assert.assertEquals(jsonPath.getInt("data[0].id"), 1);
        Assert.assertEquals(jsonPath.getString("data[0].first_name"), "Sebastian");
        Assert.assertEquals(jsonPath.getString("data[0].last_name"), "Eschweiler");
    }

    @Test(priority = 4, description = "Company Information Test")
    public static void  getCompanyTest() {
        Response response = given().when().get("company").then().extract().response();

        JsonPath jsonPath = convertResponseToJson(response);
        Assert.assertEquals(jsonPath.getString("name"), "Test Automation Hub");
        Assert.assertEquals(jsonPath.getString("location"), "Nepal");
        Assert.assertEquals(jsonPath.getInt("noOfEmployee"), 200);
    }
}
