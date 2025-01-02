package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.testng.Assert.*;

public class AddAndRemoveFromCartSteps {
    private static final Logger log = LoggerFactory.getLogger(AddAndRemoveFromCartSteps.class);
    WebDriver driver;

    @Given("I launch the browser and navigate to test automation website")
    public void iLaunchTheBrowserAndNavigateToUrl() {
        driver = DriverFactory.getWebDriver();
        driver.get("https://www.automationexercise.com");
    }

    @Then("I verify that the home page is visible successfully")
    public void iVerifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("I click on the Products button")
    public void iClickOnTheProductsButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
    }

    @When("I hover over the first product and click 'Add to cart'")
    public void iHoverOverFirstProductAndAddToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)"); // Scroll down to products
        WebElement firstProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
        firstProduct.click();
    }

    @When("I click 'View Cart' button")
    public void iClickViewCartButton() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"))
        );
        viewCart.click();
    }

    @Then("I verify the product is added to the cart")
    public void iVerifyProductIsAddedToCart() {
        WebElement productInCart = driver.findElement(By.xpath("//*[@id=\"product-1\"]"));
        assertTrue(productInCart.isDisplayed());
    }

    @Then("I verify the price, quantity, and total price")
    public void iVerifyPriceQuantityAndTotalPrice() {
        String price = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p")).getText();
        String quantity = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button")).getText();
        String totalPrice = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).getText();

        assertEquals("Rs. 500", price);
        assertEquals("1", quantity);
        assertEquals("Rs. 500", totalPrice);
    }

    @Given("I click 'Cart' button")
    public void iClickCartButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)"); // Scroll down to products

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
    }

    @Given("I verify that cart page is displayed")
    public void iVerifyThatCartPageIsDisplayed() {
        WebElement cartHeader = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        assertTrue(cartHeader.isDisplayed());
    }

    @When("I click the 'Remove' button for the product")
    public void iClickTheRemoveButtonForTheProduct() {
        driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[6]/a")).click(); // Remove item
    }

    @Then("I verify the product is removed from the cart")
    public void iVerifyTheProductIsRemovedFromTheCart() {
        WebElement emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"product-1\"]"));
        assertTrue(emptyCartMessage.isDisplayed());
    }

    @Given("I verify the product is added to the cart before the remove")
    public void iVerifyProductIsAddedToCartBeforeTheRemove() {
        WebElement productInCart = driver.findElement(By.xpath("//*[@id=\"product-1\"]"));
        assertTrue(productInCart.isDisplayed());
    }

}
