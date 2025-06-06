package com.automation.project.steps;


import com.automation.project.configuration.ConfigurationProperties;
import com.automation.project.enums.ApiPaths;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.automation.project.asserts.CustomAssert;



import static com.automation.project.actions.ApiRequests.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class RestApiSteps {
//    private static final Logger log = LoggerFactory.getLogger(CommonSteps.class);
    private Response response;
    private static final String BASE_URL = ConfigurationProperties.getConfigPropertyValue("rest.api.url");

    @Given("the API is accessible via the configured base URL")
    public void theApiIsAccessibleViaTheConfiguredBaseUrl() {
//        log.info("Checking API accessibility at: {}", BASE_URL);
        int statusCode = given().baseUri(BASE_URL).when().get().then().extract().statusCode();
        CustomAssert.assertThat("API should return HTTP 200", statusCode, is(200));
    }

    @When("a GET request is sent to the endpoint {string}")
    public void aGetRequestIsSentToTheEndpoint(String urlKey) {
        ApiPaths apiPath = ApiPaths.valueOf(urlKey);
        response = sendGetRequest(apiPath.getPath());
//        log.info("GET response from [{}]: {}", apiPath.getPath(), response.statusCode());
    }

    @Then("the response of GET status code should be {int} with message {string}")
    public void validateStatusCode(int expectedCode, String message) {
        int actualStatusCode = response.statusCode();
//        log.info("Expected status: {}, Actual status: {}, Message: {}", expectedCode, actualStatusCode, message);
        CustomAssert.assertThat(message, actualStatusCode, is(expectedCode));
    }

    @Then("the response should contain {string} with value {int}")
    public void validateResponseField(String field, int expectedValue) {
        Object actualValue = response.getBody().jsonPath().get(field);
        CustomAssert.assertThat("Validating response field", actualValue, is(expectedValue));
    }
}