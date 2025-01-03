package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.testng.Assert.*;
public class VerifySubscriptionInCartSteps {
    private static final Logger log = LoggerFactory.getLogger(VerifySubscriptionInCartSteps.class);
    WebDriver driver = DriverFactory.getWebDriver();



    @When("I click the 'Cart' button")
    public void iClickTheCartButton() {
        WebElement cartButton = driver.findElement(By.xpath("//a[contains(@href, '/view_cart')]"));
        cartButton.click();
    }

    @When("I scroll down to the footer")
    public void iScrollDownToTheFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("I verify the text 'SUBSCRIPTION' is visible")
    public void iVerifyTheTextSUBSCRIPTIONIsVisible() {
        WebElement subscriptionText = driver.findElement(By.xpath("//h2[contains(text(), 'Subscription')]"));
        assertTrue(subscriptionText.isDisplayed(), "'SUBSCRIPTION' text is not visible.");
    }

    @When("I enter email address {string} in the subscription input and click the arrow button")
    public void iEnterEmailAddressInTheSubscriptionInputAndClickTheArrowButton(String email) {
        WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
        emailInput.sendKeys(email);
        WebElement arrowButton = driver.findElement(By.id("subscribe"));
        arrowButton.click();
    }

    @Then("I verify the success message 'You have been successfully subscribed!' is visible")
    public void iVerifyTheSuccessMessageIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'You have been successfully subscribed!')]")));
        assertTrue(successMessage.isDisplayed(), "Success message is not visible.");
    }
}
