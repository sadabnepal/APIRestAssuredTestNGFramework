package com.testnepal.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static com.testnepal.resources.Payload.*;
import static com.testnepal.utils.JsonFormatter.*;

public class PostCallSampleTests extends BaseTest {

    @Test(priority = 2, description = "Create User")
    public static void createUserTest() {
        String user = "MD SADAB";
        String job = "Tester";

        Response response =  given()
                .body(createUserPayload(user, job))
                .contentType(ContentType.JSON)
                .when().post("users")
                .then().extract().response();

        JsonPath jsonPath = convertResponseToJson(response);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(jsonPath.getString("name"), user);
        Assert.assertEquals(jsonPath.getString("job"), job);
        Assert.assertNotNull(jsonPath.getString("id"));
        Assert.assertNotNull(jsonPath.getString("createdAt"));
    }
}