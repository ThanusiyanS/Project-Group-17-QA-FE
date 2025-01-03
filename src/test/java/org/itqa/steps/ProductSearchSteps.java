package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @When("I click on the \"Products\" menu in the navigation bar")
    public void iClickOnTheProductsMenu() {
        // Use a more robust and readable XPath to locate the "Products" menu
        WebElement productsMenu = driver.findElement(By.xpath("//nav//a[contains(text(),'Products')]"));
    }


    // Step for verifying navigation to the "ALL PRODUCTS" page
    @And("I verify that the user is navigated to the \"ALL PRODUCTS\" page successfully")
    public void iVerifyUserIsNavigatedToAllProductsPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://example.com/all-products"); // replace with actual URL
    }

    // Step for entering the product name into the search input field
    @When("I enter a product name in the search input")
    public void iEnterProductNameInSearchInput() {
        WebElement searchInput = driver.findElement(By.id("search-input")); // replace with actual search input field

    }

    // Step for clicking the "Search" button
    @When("I click the \"Search\" button")
    public void iClickOnTheSearchButton() {
        driver.findElement(By.xpath("//button[@id='search-button']")).click(); // replace with actual button
    }

    // Step for verifying that the "SEARCHED PRODUCTS" section is visible
    @Then("I verify that the \"SEARCHED PRODUCTS\" section is visible")
    public void iVerifySearchedProductsSectionIsVisible() {
        WebElement searchedProductsSection = driver.findElement(By.id("searched-products")); // replace with actual section ID

    }

    // Step for verifying that all products related to the search are visible
    @And("I verify that all the products related to the search are visible")
    public void iVerifyAllProductsRelatedToSearchAreVisible() {
        WebElement productList = driver.findElement(By.cssSelector(".product-item")); // replace with the correct selector
        assertTrue(productList.isDisplayed(), "No products related to the search are visible");
}
}