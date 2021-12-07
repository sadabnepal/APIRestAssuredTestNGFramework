package com.testnepal.tests;

import com.testnepal.utils.JsonFormatter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LocalAPITests {

    @BeforeMethod
    public static  void  setUp() {
        baseURI = "http://localhost:3000/";
    }

    @Test(priority = 3)
    public static  void getCompanyTest() {
        Response response = given().when().get("employees").then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = JsonFormatter.convertResponseToJson(response);
        Assert.assertEquals(jsonPath.getInt("data[0].id"), 1);
        Assert.assertEquals(jsonPath.getString("data[0].first_name"), "Sebastian");
        Assert.assertEquals(jsonPath.getString("data[0].last_name"), "Eschweiler");
    }

    @Test(priority = 4)
    public static void  getEmployeesTest() {
        Response response = given().when().get("company").then().extract().response();

        JsonPath jsonPath = JsonFormatter.convertResponseToJson(response);
        Assert.assertEquals(jsonPath.getString("name"), "Test Automation Hub");
        Assert.assertEquals(jsonPath.getString("location"), "Nepal");
        Assert.assertEquals(jsonPath.getInt("noOfEmployee"), 200);
    }
}
