package org.example.tests;

import org.example.config.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

/**
 * BaseTest definește setup/teardown pentru fiecare test JUnit.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Inițializează WebDriver (Chrome) înainte de fiecare test
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    public void tearDown() {
        // Închide browser-ul după fiecare test
        DriverFactory.quitDriver();
    }
}
