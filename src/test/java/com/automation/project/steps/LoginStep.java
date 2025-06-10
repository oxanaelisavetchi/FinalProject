package com.automation.project.steps;

import com.automation.project.actions.LoginAction;
import com.automation.project.context.ScenarioContext;
import com.automation.project.driverfactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginStep {

    private WebDriver driver;
    private LoginAction loginAction;
    private ScenarioContext context;

    @Before("@UI")
    public void setup() {
        driver = DriverFactory.getDriver(); // obținut după ce e inițializat în Hooks
        loginAction = new LoginAction(driver);
        context = new ScenarioContext();
    }

    @Given("user navigates to 'Home' page")
    public void navigateToHomePage() {
        loginAction.navigateToLoginPage();
    }

    @When("user enters the {string} and {string}")
    public void enterCredentials(String username, String password) {
        loginAction.loginWithCredentials(username, password);
    }

    @Then("user enters on product page")
    public void verifyProductPageDisplayed() {
        Assertions.assertTrue(loginAction.isInventoryPageDisplayed(), "Inventory page is not loaded!");
    }
}


