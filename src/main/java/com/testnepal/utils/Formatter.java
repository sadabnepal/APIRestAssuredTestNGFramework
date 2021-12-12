package com.testnepal.utils;

import com.testnepal.reporter.ExtentManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Formatter {

    public static JsonPath convertResponseToJson(Response response) {
        return new JsonPath(response.asString());
    }

    public static void formatLogInReport(String content) {
        String prettyPrint = content.replace("\n", "<br>");
        ExtentManager.extentTest.info("<pre>" + prettyPrint + "</pre>");
    }
}
