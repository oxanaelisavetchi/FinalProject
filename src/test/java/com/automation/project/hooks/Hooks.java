package com.automation.project.hooks;

import com.automation.project.driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before("@UI")
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After("@UI")
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
