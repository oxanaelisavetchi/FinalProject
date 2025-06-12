package com.automation.project.steps;

import com.automation.project.enums.ApiPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RestApiSteps {

    private Response response;

    // === BACKGROUND ===
    @Given("the API is accessible via the configured base URL")
    public void apiIsAccessible() {
        response = given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users/2");

        Assertions.assertEquals(200, response.statusCode(), "API is not available!");
    }

    // === GET ===
    @When("a GET request is sent to the endpoint {string}")
    public void sendGetRequest(String key) {
        String endpoint = ApiPath.valueOf(key).getPath();

        response = given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/" + endpoint);
    }

    @Then("the response of GET status code should be {int} with message {string}")
    public void validateGetStatus(int expected, String message) {
        Assertions.assertEquals(expected, response.statusCode(), message);
    }

    @Then("the response should contain {string} with value {int}")
    public void validateIntegerField(String field, int expectedValue) {
        int actual = response.jsonPath().getInt(field);
        Assertions.assertEquals(expectedValue, actual, "Field mismatch: " + field);
    }

    // === REGISTER ===
    @When("I create a user with the following details:")
    public void createUserWithRegisterData(DataTable table) {
        JSONObject body = new JSONObject(table.asMap(String.class, String.class));
        System.out.println("➡️ Register payload:\n" + body.toString(2));

        response = given()
                .baseUri("https://reqres.in")
                .header("Content-Type", "application/json")
                .body(body.toString())
                .when()
                .post("/api/register");
    }

    @Then("the response status code should be {int}, with message {string}")
    public void validateStatus(int expected, String message) {
        Assertions.assertEquals(expected, response.statusCode(), message);
    }

    @Then("the response should contain field {string}")
    public void validateFieldExists(String field) {
        String value = response.jsonPath().getString(field);
        Assertions.assertNotNull(value, "Field not found: " + field);
    }

    @Then("the response should contain token")
    public void validateTokenPresent() {
        String token = response.jsonPath().getString("token");
        Assertions.assertNotNull(token, "Token is missing from response!");
    }
}
