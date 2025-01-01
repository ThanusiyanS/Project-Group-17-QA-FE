package org.itqa.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {



    @After
    public void tearDown() {
        if (DriverFactory.getWebDriver() != null) {
            DriverFactory.getWebDriver().quit();
        }
    }
}
