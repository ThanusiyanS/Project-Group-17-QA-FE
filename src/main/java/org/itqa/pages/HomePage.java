package org.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{
    // Locators
    private By navLinks = By.cssSelector("nav a");

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Get Navigation Links
    public List<String> getNavigationLinkTexts() {
        return findElements(navLinks).stream()
                .map(WebElement::getText)
                .toList();
    }

    public void clickNavigationLink(int index) {
        findElements(navLinks).get(index).click();
    }

    public String getNavigationLinkURL(int index) {
        return findElements(navLinks).get(index).getAttribute("href");
    }
}
