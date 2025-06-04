package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * DriverFactory inițializează un WebDriver (Chrome) folosind WebDriverManager.
 * Toate clasele de test pot apela DriverFactory.initDriver() și DriverFactory.getDriver().
 */
public class DriverFactory {

    // ThreadLocal păstrează o instanță de WebDriver pentru fiecare thread (pentru rulare paralelă)
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    /**
     * Inițializează și setează driverul de Chrome în ThreadLocal.
     */
    public static void initDriver() {
        // Descarcă automat chromedriver-ul corespunzător versiunii instalate de Chrome
        WebDriverManager.chromedriver().setup();

        // Setează opțiunile Chrome (maximizat, notificări dezactivate)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        // Instanțiază driverul și îl păstrează în ThreadLocal
        WebDriver driver = new ChromeDriver(options);
        driverThread.set(driver);
    }

    /**
     * Returnează instanța WebDriver asociată thread-ului curent.
     * Dacă initDriver() nu a fost apelat înainte, se aruncă o excepție.
     */
    public static WebDriver getDriver() {
        WebDriver driver = driverThread.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver nu a fost inițializat. Apelează DriverFactory.initDriver() mai întâi.");
        }
        return driver;
    }

    /**
     * Închide browserul și șterge instanța din ThreadLocal.
     */
    public static void quitDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}
