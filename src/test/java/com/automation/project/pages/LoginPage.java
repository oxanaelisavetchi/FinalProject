package com.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    // Selectori
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Deschide pagina de login
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    // Introduce username
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    // Introduce password
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Apasă login
    public void clickLogin() {
        loginButton.click();
    }
}