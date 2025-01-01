package org.itqa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver webDriver;

    // Singleton Pattern for WebDriver
    public static void initializeDriver() {
        if (webDriver == null) {
            ChromeOptions options = new ChromeOptions();

            // Check if running in CI environment
            if (System.getenv("CI") != null) {
                // CI-specific options
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--remote-allow-origins=*");
            }

            System.setProperty("webdriver.chrome.driver", "/Users/thanusiyans/Documents/University/L4S1/ITQA/chromedriver-mac-arm64/chromedriver");
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        }





    }

    public static void setWebDriver(WebDriver webDriver) {
        DriverFactory.webDriver = webDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
