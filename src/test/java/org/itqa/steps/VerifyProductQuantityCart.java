package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.*;

public class VerifyProductQuantityCart {
//    private static final Logger log = LoggerFactory.getLogger(VerifyProductQuantityCart.class);
    WebDriver driver = DriverFactory.getWebDriver();


//    @Then("I verify that the home page is visible successfully")
//    public void iVerifyThatTheHomePageIsVisibleSuccessfully() {
//        String homeTitle = driver.getTitle();
//        assertTrue(homeTitle.contains("Automation Exercise"), "Home page is not visible successfully.");
//        log.info("Home page verified successfully.");
//    }

//    @When("I click 'View Product' for any product on the home page")
//    public void iClickViewProductForAnyProductOnTheHomePage() {
//        WebElement viewProductButton = driver.findElement(By.xpath("//a[contains(text(),'View Product')]"));
//        viewProductButton.click();
//        log.info("Clicked 'View Product' for a product.");
//    }

//    @Then("I verify that the product detail page is opened")
//    public void iVerifyThatTheProductDetailPageIsOpened() {
//        WebElement productDetailsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Product Details')]"));
//        assertTrue(productDetailsHeader.isDisplayed(), "Product detail page is not opened.");
//        log.info("Product detail page verified successfully.");
//    }

    @When("I increase the quantity to {int}")
    public void iIncreaseTheQuantityTo(int quantity) {
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
//        log.info("Quantity increased to {}", quantity);
    }

    @And("I click Add to cart button")
    public void iClickAddToCartButton() {
        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
        addToCartButton.click();
    }

    @And("I click View Cart button")
    public void iClickViewCartButton() {
        WebElement viewCartButton = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
        viewCartButton.click();
//        log.info("Clicked 'View Cart' button.");
    }

    @Then("I verify that the product is displayed in the cart page with exact quantity {int}")
    public void iVerifyThatTheProductIsDisplayedInTheCartPageWithExactQuantity(int expectedQuantity) {
        WebElement cartQuantity = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
        int actualQuantity = Integer.parseInt(cartQuantity.getText());
        assertEquals(actualQuantity, expectedQuantity, "Product quantity in the cart does not match.");
//        log.info("Verified product is displayed in the cart with exact quantity {}.", expectedQuantity);
    }}
//
//    @After
//    public void tearDown() {
//        DriverFactory.quitWebDriver(); // Cleanup WebDriver instance
//        log.info("Browser closed.");
//    }
//}
