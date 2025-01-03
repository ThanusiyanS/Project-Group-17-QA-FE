package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductSearchSteps {
    WebDriver driver;

    @Given("I launch the browser and navigate to test automation website to search product")
    public void iLaunchTheBrowserAndNavigateToUrl() {
        driver = DriverFactory.getWebDriver();
        driver.get("https://www.automationexercise.com");
    }

    @Then("I verify that the home page is successfully visible")
    public void iVerifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("I click on the Products button in home page")
    public void iClickOnTheProductsButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
    }

    // Step for verifying navigation to the "ALL PRODUCTS" page
    @And("I verify that the user is navigated to the \"ALL PRODUCTS\" page successfully")
    public void iVerifyUserIsNavigatedToAllProductsPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.automationexercise.com/products"); // replace with actual URL
    }

    // Step for entering the product name into the search input field
    @When("I enter a product name in the search input")
    public void iEnterProductNameInSearchInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search_product\"]")); // replace with actual search input field
        searchInput.clear();
        searchInput.sendKeys("T-Shirt");
    }

    // Step for clicking the "Search" button
    @When("I click the Search button")
    public void iClickOnTheSearchButton() {
        driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click(); // replace with actual button
    }

    // Step for verifying that the "SEARCHED PRODUCTS" section is visible
    @Then("I verify that the SEARCHED PRODUCTS section is visible")
    public void iVerifySearchedProductsSectionIsVisible() {
        WebElement searchedProductsSection = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2")); // replace with actual section ID
        assertTrue(searchedProductsSection.isDisplayed(),"Not displayed");
    }

    // Step for verifying that all products related to the search are visible
}