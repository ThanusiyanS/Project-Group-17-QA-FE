package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AddToCartByRecommendSteps {
    WebDriver driver = DriverFactory.getWebDriver();


    @Given("I scroll to the bottom of the page")
    public void iScrollToBottom() {
        // Scroll to the bottom of the page

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Given("I verify 'RECOMMENDED ITEMS' are visible")
    public void iVerifyRecommendedItemsVisible() {
        WebElement recommendedItemsSection = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[2]/h2"));
        assertTrue(recommendedItemsSection.isDisplayed(), "'RECOMMENDED ITEMS' section is not visible.");
    }

    @When("I click on 'Add To Cart' on a recommended product")
    public void iClickAddToCartOnRecommendedProduct() {
        // Locate the 'Add To Cart' button for a recommended product
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div/a"));
        addToCartButton.click();
    }

    @When("I click on 'View Cart' button")
    public void iClickViewCartButton() {
        WebElement viewCartButton = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        viewCartButton.click();
    }

    @Then("I verify that the product is displayed in the cart page")
    public void iVerifyProductInCart() {
        WebElement cartProduct = driver.findElement(By.xpath("//td[.//img[@src='get_product_picture/4']]"));
        assertTrue(cartProduct.isDisplayed(), "Product is not displayed in the cart page.");
    }
}
