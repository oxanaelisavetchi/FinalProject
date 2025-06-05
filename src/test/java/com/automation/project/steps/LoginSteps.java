package com.automation.project.steps;

import com.automation.project.actions.LoginActions;
import com.automation.project.context.ScenarioContext;
import com.automation.project.driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginActions loginActions;
    private ScenarioContext context;

    @Before
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        loginActions = new LoginActions(driver);
        context = new ScenarioContext();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Given("user navigates to 'Home' page")
    public void navigateToHomePage() {
        loginActions.navigateToLoginPage();
    }

    @When("user enters the {string} and {string}")
    public void enterCredentials(String username, String password) {
        loginActions.loginWithCredentials(username, password);
    }

    @Then("user enters on product page")
    public void verifyProductPageDisplayed() {
        Assertions.assertTrue(loginActions.isInventoryPageDisplayed(), "Inventory page is not loaded!");
    }
}


