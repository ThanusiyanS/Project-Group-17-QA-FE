package org.itqa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class viewCategorySteps {

    WebDriver driver;

    @Given("I launch the browser and navigate to test automation website to verify categories")
    public void iLaunchTheBrowserAndNavigateToUrl() {
        driver = DriverFactory.getWebDriver();
        driver.get("https://www.automationexercise.com");
    }

    @Then("I verify that the home page is visible to verify categories")
    public void iVerifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    @Then("I hover over the Categories")
    public void iHoverOverFirstProductAndAddToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @When("I click on the 'Women' button")
    public void iClickOnTheProductsButton() {
        driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]/span[1]/i[1]")).click();
    }

    @When("I  Click on 'Dress' category link under 'Women' category")
    public void iClickOnTheTops() {
        driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();
    }


    @And("On left side bar, click on any sub-category link of 'Men' category")
    public void iClickAnySubCateory(){
        driver.findElement(By.xpath("//body/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]")).click();

    }
    @Then("I click on any sub-category link of 'Men' category")
    public void iClickAnySubCateoryOfMen(){
        driver.findElement(By.xpath("//body/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]")).click();

    }
    @Then("I Verify that user is navigated to that category page")
    public void iVerifytheCateoryPage(){
        driver.findElement(By.xpath("//a[contains(text(),'Tshirts')]"));
}






}