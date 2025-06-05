package com.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText().equalsIgnoreCase("PRODUCTS");
    }
}