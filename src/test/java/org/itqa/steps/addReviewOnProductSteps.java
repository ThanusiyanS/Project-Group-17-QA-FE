package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class addReviewOnProductSteps {

    WebDriver driver;

    @Given("I launch the browser and navigate to test automation website to add a review")
    public void iLaunchTheBrowserAndNavigateToUrl() {
        driver = DriverFactory.getWebDriver();
        driver.get("https://www.automationexercise.com");
    }

    @Then("I verify that the home page is visible")
    public void iVerifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("I click on the Products button to add review")
    public void iClickOnTheProductsButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
    }
    @When("I hover over the first product and click view product")
    public void iHoverOverFirstProductAndAddToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement firstProduct = driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]"));
        firstProduct.click();
    }
    @Then("I hover over the review forum")
    public void iHoverOverTheReviewForum() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    @Then("I enter my name")
    public void iEnterMyName() {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Amanda");
    }
    @Then("I enter my mailId")
    public void iEnterMyMailId() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tH5Ct@example.com");
    }
    @Then("I enter my review")
    public void iEnterMyReview() {
        driver.findElement(By.xpath("//textarea[@id='review']")).sendKeys("Good product");
    }
    @Then("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='button-review']"));
        submitButton.click();
    }

    @Then("I verify the review success message is displayed")
    public void iVerifyReviewSuccessMessageIsDisplayed() {
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        assertTrue("Success message is not displayed", successMessage.isDisplayed());
        assertEquals(successMessage.getText(), "Thank you for your review.", "Success message text does not match");
    }
}
