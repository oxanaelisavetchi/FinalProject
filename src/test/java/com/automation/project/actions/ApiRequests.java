package com.automation.project.actions;

import com.automation.project.configuration.ConfigurationProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;


public class ApiRequests {

    private static final String baseUrl = ConfigurationProperties.getConfigPropertyValue("rest.api.url");

    public static Response sendGetRequest(String path) {
        return given()
                .baseUri(baseUrl)
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
        String normalizedBase = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        return normalizedBase + "api/" + path;
    }
}