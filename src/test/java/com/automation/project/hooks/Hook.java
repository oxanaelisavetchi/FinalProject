package com.automation.project.hooks;

import com.automation.project.driverfactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hook {

    @Before("@UI")
    public void setUpUI(Scenario scenario) {
        System.out.println("Starting UI test: " + scenario.getName());
        DriverFactory.initDriver(); // centralizat, thread-safe
    }


    @After("@UI")
    public void tearDownUI() {
        DriverFactory.quitDriver(); // închidere controlată
        System.out.println("UI test finished. Browser closed.");
    }
}
