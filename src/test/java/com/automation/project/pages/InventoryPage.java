package com.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoryPage {

    private WebDriver driver;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        boolean visible = pageTitle.isDisplayed() && pageTitle.getText().equalsIgnoreCase("Products");
        System.out.println("Inventory page displayed: " + visible);
        return visible;
    }

}