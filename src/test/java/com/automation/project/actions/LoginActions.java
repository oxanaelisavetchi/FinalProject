package com.automation.project.actions;

import com.automation.project.pages.InventoryPage;
import com.automation.project.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginActions {
    private final WebDriver driver;
    private final LoginPage loginPage;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void navigateToLoginPage() {
        loginPage.loadLoginPage();
    }

    public void loginWithCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public boolean isInventoryPageDisplayed() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage.isLoaded();
    }
}
