package com.automation.project.steps;

import com.automation.project.driver.DriverFactory;
import com.automation.project.pages.InventoryPage;
import com.automation.project.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("user navigates to 'Home' page")
    public void userNavigatesToHomePage() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("user enters the {string} and {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("user enters on product page")
    public void verifyInventoryPageIsVisible() {
        inventoryPage = new InventoryPage(driver);
        Assertions.assertTrue(inventoryPage.isDisplayed(), "Inventory page is not displayed.");
    }
}


