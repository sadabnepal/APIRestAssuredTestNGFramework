package com.testnepal.tests;

import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {

    @BeforeTest
    public void setUpBaseURI() {
        baseURI = "https://reqres.in/api";
    }

}
