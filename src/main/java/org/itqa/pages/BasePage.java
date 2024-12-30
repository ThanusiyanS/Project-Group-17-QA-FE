package org.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Click Method
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Get Text
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Find Element
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Find List of Elements
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    // Navigate to URL
    public void navigateTo(String url) {
        driver.get(url);
    }
}
