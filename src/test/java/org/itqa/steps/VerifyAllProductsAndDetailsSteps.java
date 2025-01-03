package org.itqa.steps;
import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class VerifyAllProductsAndDetailsSteps {
    WebDriver driver = DriverFactory.getWebDriver();

//    @Given("I launch the browser and navigate to the automation exercise website")
//    public void iLaunchTheBrowserAndNavigateToAutomationExerciseWebsite() {
//        driver = DriverFactory.getWebDriver();
//        driver.get("https://www.automationexercise.com");
//    }
//
//    @Given("I verify that the home page is visible successfully")
//    public void iVerifyThatTheHomePageIsVisibleSuccessfully() {
//        String expectedTitle = "Automation Exercise";
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle, expectedTitle, "Home page is not visible successfully.");
//    }

//    @When("I click on the 'Products' button")
//    public void iClickOnTheProductsButton() {
//        WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
//        productsButton.click();
//    }

    @Then("I verify that the user is navigated to the ALL PRODUCTS page successfully")
    public void iVerifyThatTheUserIsNavigatedToTheAllProductsPageSuccessfully() {
        WebElement allProductsHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")));
        Assert.assertTrue(allProductsHeader.isDisplayed(), "User is not navigated to ALL PRODUCTS page successfully.");
    }

    @Then("I verify that the products list is visible")
    public void iVerifyThatTheProductsListIsVisible() {
        WebElement productsList = driver.findElement(By.cssSelector(".features_items"));
        Assert.assertTrue(productsList.isDisplayed(), "Products list is not visible.");
    }

    @When("I click on 'View Product' of the first product")
    public void iClickOnViewProductOfTheFirstProduct() {
        WebElement firstProductViewButton = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a"));
        firstProductViewButton.click();
    }

    @Then("I verify that the user is navigated to the product detail page")
    public void iVerifyThatTheUserIsNavigatedToTheProductDetailPage() {
        // Wait for the product information section to be visible
        WebElement productDetail = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div")));
        Assert.assertTrue(productDetail.isDisplayed(), "User is not navigated to the product detail page.");

//        // Retrieve the current URL
//        String currentUrl = driver.getCurrentUrl();
//
//        // Define the expected URL pattern for product detail pages
//        String expectedUrlPattern = "/product_details/2";
//
//        // Check if the current URL contains the expected pattern
//        Assert.assertTrue(currentUrl.contains(expectedUrlPattern),
//                "Current URL does not contain the expected product detail pattern. Actual URL: " + currentUrl);
    }


    @Then("I verify that product details are visible: product name, category, price, availability, condition, brand")
    public void iVerifyThatProductDetailsAreVisible() {
        WebElement productName = driver.findElement(By.xpath("//div[@class='product-information']//h2"));
        WebElement productCategory = driver.findElement(By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]"));
        WebElement productPrice = driver.findElement(By.xpath("//div[@class='product-information']//span//span"));
        WebElement productAvailability = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b"));
        WebElement productCondition = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b"));
        WebElement productBrand = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b"));

        Assert.assertTrue(productName.isDisplayed(), "Product name is not visible.");
        Assert.assertTrue(productCategory.isDisplayed(), "Product category is not visible.");
        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not visible.");
        Assert.assertTrue(productAvailability.isDisplayed(), "Product availability is not visible.");
        Assert.assertTrue(productCondition.isDisplayed(), "Product condition is not visible.");
        Assert.assertTrue(productBrand.isDisplayed(), "Product brand is not visible.");
    }
}
