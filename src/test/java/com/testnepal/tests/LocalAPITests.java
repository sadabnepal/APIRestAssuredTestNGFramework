package com.testnepal.tests;

import static com.testnepal.constants.ResponseCodes.*;
import static com.testnepal.utils.Formatter.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class LocalAPITests extends BaseTestLocal {

    @Test(priority = 3, description = "Employee Data Test")
    public void getEmployeesTest() {
        Response response = given().when().get("employees").then().extract().response();
        logLocalAPIResponseInReport(response);
        Assert.assertEquals(response.statusCode(), SUCCESS_STATUS_CODE);
        JsonPath jsonPath = convertResponseToJson(response);
        Assert.assertEquals(jsonPath.getInt("data[0].id"), 1);
        Assert.assertEquals(jsonPath.getString("data[0].first_name"), "Sebastian");
        Assert.assertEquals(jsonPath.getString("data[0].last_name"), "Eschweiler");
    }

    @Test(priority = 4, description = "Company Information Test")
    public void getCompanyTest() {
        Response response = given().when().get("company").then().extract().response();
        logLocalAPIResponseInReport(response);
        JsonPath jsonPath = convertResponseToJson(response);
        Assert.assertEquals(response.statusCode(), SUCCESS_STATUS_CODE);
        Assert.assertEquals(jsonPath.getString("name"), "Test Automation Hub");
        Assert.assertEquals(jsonPath.getString("location"), "Nepal");
        Assert.assertEquals(jsonPath.getInt("noOfEmployee"), 200);
    }
}
