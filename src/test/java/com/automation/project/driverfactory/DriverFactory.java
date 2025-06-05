package com.automation.project.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void initDriver() {
        WebDriverManager.chromedriver().driverVersion("137.0.7151.56").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driverThread.set(driver);
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverThread.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver nu a fost inițializat. Apel initDriver() mai întâi.");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}
