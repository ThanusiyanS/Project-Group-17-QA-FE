package org.itqa.steps;

import io.cucumber.java.en.*;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.*;
import static org.testng.Assert.*;


public class ViewCategoryProducts {
    private final WebDriver driver = DriverFactory.getWebDriver();


    @Given("I verify that categories are visible on the left sidebar")
    public void iVerifyCategoriesVisible() {
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
        WebElement subCategoryLink = driver.findElement(By.xpath("//*[@id=\""+category+"\"]/div/ul/li[1]/a"));
        subCategoryLink.click();
    }

    @Then("I verify that the category page is displayed with text {string}")
    public void iVerifyCategoryPage(String expectedText) {
        WebElement pageHeader = driver.findElement(By.xpath("//h2[contains(@class, 'title')]"));
        assertTrue(pageHeader.getText().contains(expectedText), "Category page text does not match.");
    }

}
