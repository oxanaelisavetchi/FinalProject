package com.automation.project.actions;

import com.automation.project.configuration.ConfigurationPropertie;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;


public class ApiRequest {

    private static final String BASE_URL = ConfigurationPropertie.getConfigPropertyValue("rest.api.url");

    public static Response sendGetRequest(String path) {
        return given()
                .baseUri(BASE_URL)
                .when()
                .get(collectUrl(path))
                .then()
                .extract()
                .response();
    }
    public static JSONObject getJsonObject(String field, String value) {
        JSONObject data = new JSONObject();
        String[] fields = field.split(",");
        String[] values = value.split(",");
        for (int i = 0; i < fields.length; i++) {
            data.put(fields[i], values[i]);
        }
        return data;
    }

    public static String collectUrl(String path) {
        String normalizedBase = BASE_URL.endsWith("/") ? BASE_URL : BASE_URL + "/";
        return normalizedBase + "api/" + path;
    }
}