package com.testnepal.resources;

import java.util.HashMap;

public class Payload {

    public static HashMap<String, String> createUserData(String name, String role) {
        HashMap<String, String> createUserData = new HashMap<>();
        createUserData.put("name", "MD SADAB");
        createUserData.put("job", "Tester");
        return  createUserData;
    }
}
