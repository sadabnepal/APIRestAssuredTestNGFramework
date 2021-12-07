package com.testnepal.tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetCallSampleTests extends BaseTest {

	@Test(priority = 0)
	public static void getUsersByIDTest() {
		Response response =  given()
				.when().log().all().get("users/2")
				.then().extract().response();

		JsonPath jsonPath = new JsonPath(response.asString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonPath.getInt("data.id"), 2);
		Assert.assertEquals(jsonPath.getString("data.first_name"), "Janet");
		Assert.assertEquals(jsonPath.getString("data.last_name"), "Weaver");
		Assert.assertEquals(jsonPath.getString("data.email"), "janet.weaver@reqres.in");
	}

	@Test(priority = 1)
	public static void getUserListByPageTest() {
		Response response = given().queryParam("page", "2").log().all()
				.when().get("users")
				.then().extract().response();
		JsonPath jsonPath = new JsonPath(response.asString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(jsonPath.getInt("page"), 2);
		Assert.assertEquals(jsonPath.getInt("per_page"), 6);
		Assert.assertEquals(jsonPath.getInt("data[0].id"), 7);
		Assert.assertEquals(jsonPath.getString("data[0].email"), "michael.lawson@reqres.in");
		Assert.assertEquals(jsonPath.getString("data[0].first_name"), "Michael");
		Assert.assertEquals(jsonPath.getString("data[0].last_name"), "Lawson");
	}
}
