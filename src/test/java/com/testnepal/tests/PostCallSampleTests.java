package com.testnepal.tests;

import com.testnepal.resources.Payload;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostCallSampleTests {

    @BeforeMethod
    public static void setUp() {
        baseURI = "https://reqres.in/api";
    }

    @Test(priority = 2)
    public static void createUserTest() {
        String user = "MD SADAB";
        String job = "Tester";

        Response response =  given()
                .body(Payload.createUserData(user, job))
                .contentType(ContentType.JSON)
                .when().post("users")
                .then().extract().response();

        JsonPath jsonPath = new JsonPath(response.asString());
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(jsonPath.getString("name"), user);
        Assert.assertEquals(jsonPath.getString("job"), job);
        Assert.assertNotNull(jsonPath.getString("id"));
        Assert.assertNotNull(jsonPath.getString("createdAt"));
    }
}
