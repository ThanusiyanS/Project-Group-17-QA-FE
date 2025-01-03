//package org.itqa.steps;
//
//import io.cucumber.java.en.*;
//import org.itqa.utils.DriverFactory;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.time.Duration;
//
//import static org.testng.Assert.*;
//
//public class VerifySubscriptionHomePage {
//    private static final Logger log = LoggerFactory.getLogger(VerifySubscriptionHomePage.class);
//    WebDriver driver = DriverFactory.getWebDriver();
//
////    @Given("I launch the browser and navigate to the test automation website")
////    public void iLaunchTheBrowserAndNavigateToTheTestAutomationWebsite() {
////        driver.get("http://automationexercise.com");
////        log.info("Navigated to the test automation website.");
////    }
//
////    @Then("I verify that the home page is visible successfully")
////    public void iVerifyThatTheHomePageIsVisibleSuccessfully() {
////        String homeTitle = driver.getTitle();
////        assertTrue(homeTitle.contains("Automation Exercise"), "Home page is not visible successfully.");
////        log.info("Home page is visible successfully.");
////    }
//
////    @When("I scroll down to the footer")
////    public void iScrollDownToTheFooter() {
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
////        log.info("Scrolled down to the footer.");
////    }
//
//    @Then("I verify the text 'SUBSCRIPTION' is visible")
//    public void iVerifyTheTextSUBSCRIPTIONIsVisible() {
//        WebElement subscriptionText = driver.findElement(By.xpath("//h2[contains(text(), 'Subscription')]"));
//        assertTrue(subscriptionText.isDisplayed(), "'SUBSCRIPTION' text is not visible.");
//        log.info("Verified 'SUBSCRIPTION' text is visible.");
//    }
//
//    @When("I enter email address {string} in the subscription input and click the arrow button")
//    public void iEnterEmailAddressInTheSubscriptionInputAndClickTheArrowButton(String email) {
//        WebElement emailInput = driver.findElement(By.xpath("//*[@id='susbscribe_email']"));
//        emailInput.sendKeys(email);
//        WebElement arrowButton = driver.findElement(By.xpath("//*[@id='subscribe']"));
//        arrowButton.click();
//        log.info("Entered email address and clicked the arrow button.");
//    }
//
//    @Then("I verify the success message 'You have been successfully subscribed!' is visible")
//    public void iVerifyTheSuccessMessageIsVisible() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(text(), 'You have been successfully subscribed!')]")
//        ));
//        assertTrue(successMessage.isDisplayed(), "Success message is not visible.");
//        log.info("Verified success message is visible.");
//    }
//}
