package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.*;

public class ScrollFunctionalitySteps {
    WebDriver driver = DriverFactory.getWebDriver();



    @When("I scroll down to the bottom of the page")
    public void iScrollDownToTheBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Then("I verify that 'SUBSCRIPTION' is visible")
    public void iVerifyThatSUBSCRIPTIONIsVisible() {
        WebElement subscriptionSection = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        assertTrue(subscriptionSection.isDisplayed(), "'SUBSCRIPTION' section is not visible.");
    }

    @When("I click on the 'Arrow' button at the bottom right to scroll up")
    public void iClickOnTheArrowButtonAtTheBottomRightToScrollUp() {
        WebElement arrowButton = driver.findElement(By.id("scrollUp"));
        arrowButton.click();
    }

    @Then("I verify that the page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on the screen")
    public void iVerifyThatThePageIsScrolledUpAndTextIsVisibleOnTheScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement topText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")));
        assertTrue(topText.isDisplayed(), "'Full-Fledged practice website for Automation Engineers' text is not visible.");
    }
}
