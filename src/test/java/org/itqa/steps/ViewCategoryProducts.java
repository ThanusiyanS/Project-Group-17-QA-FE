package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.*;


public class ViewCategoryProducts {
    private final WebDriver driver = DriverFactory.getWebDriver();


    @Given("I verify that categories are visible on the left sidebar")
    public void iVerifyCategoriesVisible() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement categoriesSidebar = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/h2"));
        assertTrue(categoriesSidebar.isDisplayed(), "Categories sidebar is not visible.");
    }

    @When("I click on the {string} category")
    public void iClickOnCategory(String category) {
        WebElement categoryLink = driver.findElement(By.xpath("//a[@href='#"+category+"']"));
        categoryLink.click();
    }

    @When("I click on the Dress link under {string} category")
    public void iClickOnSubCategory(String category) {
         // Scroll down to products
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement subCategoryLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a"))
        );
        subCategoryLink.click();
    }

    @Then("I verify that the category page is displayed with text {string}")
    public void iVerifyCategoryPage(String expectedText) {
        WebElement pageHeader = driver.findElement(By.xpath("//h2[contains(@class, 'title')]"));
        assertTrue(pageHeader.getText().contains(expectedText), "Category page text does not match.");
    }

}
