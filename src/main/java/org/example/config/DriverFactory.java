package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * DriverFactory inițializează un WebDriver (Chrome) folosind WebDriverManager.
 * Folosim ThreadLocal<WebDriver> pentru a susține rularea paralelă a testelor.
 */
public class DriverFactory {

    // ThreadLocal va păstra o instanță WebDriver pentru fiecare thread (test paralel)
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    /**
     * Inițializează și setează WebDriver (Chrome).
     * Dacă vrei să rulezi headless, poți adăuga opțiunea corespunzătoare.
     */
    public static void initDriver() {
        // 1. Descarcă automat chromedriver-ul (versiunea compatibilă cu Chrome-ul instalat)
        WebDriverManager.chromedriver().setup();

        // 2. Setează opțiunile Chrome (poți adăuga alte argumente dacă vrei)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");       // pornește Chrome maximizat
        options.addArguments("--disable-notifications");  // dezactivează notificările (dacă apar)

        // 3. Creează instanța efectivă de ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // 4. Pune driverul în ThreadLocal, ca fiecare test (thread) să aibă instanța lui separată
        driverThread.set(driver);
    }

    /**
     * Returnează instanța WebDriver din ThreadLocal.
     * Dacă nu a fost apelat initDriver(), aruncă o RuntimeException clară.
     */
    public static WebDriver getDriver() {
        WebDriver driver = driverThread.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver nu a fost inițializat. Apelează DriverFactory.initDriver() mai întâi.");
        }
        return driver;
    }

    /**
     * Închide browser-ul și curăță referința din ThreadLocal.
     * Apelează această metodă la finalul fiecărui test.
     */
    public static void quitDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}
