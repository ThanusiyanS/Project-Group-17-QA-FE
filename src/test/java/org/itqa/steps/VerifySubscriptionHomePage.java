package org.itqa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VerifySubscriptionHomePage {
    WebDriver driver;

    @Given("I launch the browser and navigate to the test automation website")
    public void i_launch_the_browser_and_navigate_to_the_test_automation_website() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }

    @And("I verify that the home page is visible successfully")
    public void i_verify_that_the_home_page_is_visible_successfully() {
        String homeTitle = driver.getTitle();
        assertTrue(homeTitle.contains("Automation Exercise"), "Home page is not visible successfully");
    }

    @When("I scroll down to the footer of the home page")
    public void i_scroll_down_to_the_footer_of_the_home_page() {
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"footer\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"#footer\")", footer);
    }

    @Then("I verify the text {string} is visible")
    public void i_verify_the_text_is_visible(String text) {
        WebElement subscriptionText = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        assertTrue(subscriptionText.isDisplayed(), "Text '" + text + "' is not visible");
    }

    @Then("I enter the email address in the subscription input field and click the arrow button")
    public void i_enter_the_email_address_in_the_subscription_input_field_and_click_the_arrow_button() {
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]"));
        emailInput.sendKeys("test@example.com");
        WebElement subscribeButton = driver.findElement(By.xpath("//*[@id=\"subscribe\"]"));
        subscribeButton.click();
    }

    @Then("I verify the success message {string} is visible")
    public void i_verify_the_success_message_is_visible(String message) {
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        assertTrue(successMessage.isDisplayed(), "Success message is not visible");
        assertEquals(successMessage.getText(), message, "Success message text does not match");
    }
}
