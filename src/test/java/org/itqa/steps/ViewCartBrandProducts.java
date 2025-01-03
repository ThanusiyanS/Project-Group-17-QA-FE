package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.*;

public class ViewCartBrandProducts {
    WebDriver driver = DriverFactory.getWebDriver();

    @Given("I launch the browser and navigate to the test automation website to verify brands functionality")
    public void iLaunchTheBrowserAndNavigateToTheTestAutomationWebsite() {
        driver.get("http://automationexercise.com");
    }

    @Then("I verify that the home page is visible")
    public void iVerifyThatTheHomePageIsVisible() {
        WebElement homePageLogo = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        assertTrue(homePageLogo.isDisplayed(), "Home page is not visible.");
    }

    @When("I click on the 'Products' button")
    public void iClickOnTheProductsButton() {
        WebElement productsButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productsButton.click();
    }

    @Then("I verify that 'Brands' are visible on the left sidebar")
    public void iVerifyThatBrandsAreVisibleOnTheLeftSidebar() {
        WebElement brandsSection = driver.findElement(By.xpath("//h2[contains(text(),'Brands')]"));
        assertTrue(brandsSection.isDisplayed(), "'Brands' section is not visible on the left sidebar.");
    }

    @When("I click on a brand name")
    public void iClickOnABrandName() {
        WebElement brandLink = driver.findElement(By.xpath("//a[contains(text(),'Polo')]"));
        brandLink.click();
    }

    @Then("I verify that the user is navigated to the brand page")
    public void iVerifyThatTheUserIsNavigatedToTheBrandPage() {
        WebElement brandPageHeader = driver.findElement(By.xpath("//h2[contains(text(),'Brand - Polo Products')]"));
        assertTrue(brandPageHeader.isDisplayed(), "User is not navigated to the correct brand page.");
    }

    @Then("I verify that brand products are displayed")
    public void iVerifyThatBrandProductsAreDisplayed() {
        WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
        assertTrue(productList.isDisplayed(), "Brand products are not displayed.");
    }

    @When("I click on another brand name on the left sidebar")
    public void iClickOnAnotherBrandNameOnTheLeftSidebar() {
        WebElement anotherBrandLink = driver.findElement(By.xpath("//a[contains(text(),'H&M')]"));
        anotherBrandLink.click();
    }

    @Then("I verify that the user is navigated to the other brand page")
    public void iVerifyThatTheUserIsNavigatedToTheOtherBrandPage() {
        WebElement otherBrandPageHeader = driver.findElement(By.xpath("//h2[contains(text(),'Brand - H&M Products')]"));
        assertTrue(otherBrandPageHeader.isDisplayed(), "User is not navigated to the correct brand page.");
    }

    @Then("I verify that the other brand's products are displayed")
    public void iVerifyThatTheOtherBrandsProductsAreDisplayed() {
        WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
        assertTrue(productList.isDisplayed(), "Other brand products are not displayed.");
    }

    @And("I click the 'Home' button and verify that I landed on the home page successfully")
    public void iClickTheHomeButtonAndVerifyThatILandedOnTheHomePageSuccessfully() {
        WebElement homeButton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        homeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement homePageLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Website for automation practice']")));
        assertTrue(homePageLogo.isDisplayed(), "Did not land on the home page successfully.");
    }
}
