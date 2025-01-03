package org.itqa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DriverFactory {
    private static WebDriver webDriver;

    // Singleton Pattern for WebDriver
    public static void initializeDriver() {
        if (webDriver == null) {
            ChromeOptions options = new ChromeOptions();
            // CI-specific options
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            WebDriver webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
            setWebDriver(webDriver);
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
