package org.itqa.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {


    @Before
    public WebDriver setUp() {
//        DriverFactory.initializeDriver();
//        driver = DriverFactory.getDriver();

        System.setProperty("webdriver.chrome.driver", "/Users/thanusiyans/Documents/University/L4S1/ITQA/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverFactory.setWebDriver(driver);
        return DriverFactory.getWebDriver();
    }

    @After
    public void tearDown() {
        if (DriverFactory.getWebDriver() != null) {
            DriverFactory.getWebDriver().quit();
        }
    }
}
