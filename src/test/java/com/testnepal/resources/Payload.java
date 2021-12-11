package com.testnepal.resources;

import java.util.HashMap;

public class Payload {

    public static HashMap<String, String> createUpdateUserPayload(String name, String role) {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("job", role);
        return data;
    }
}
