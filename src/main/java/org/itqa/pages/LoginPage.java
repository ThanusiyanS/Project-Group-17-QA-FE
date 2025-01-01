package org.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By emailInput = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By passwordInput = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    By errorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    By logout =By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void logOutButton(){
        driver.findElement(logout).click();
    }
}
