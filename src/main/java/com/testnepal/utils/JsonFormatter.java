package com.testnepal.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonFormatter {

    public static JsonPath convertResponseToJson(Response response) {
        return new JsonPath(response.asString());
    }
}
