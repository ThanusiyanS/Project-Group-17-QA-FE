package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.pages.HomePage;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class navigationSteps {
    WebDriver driver;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        // Setup ChromeDriver path explicitly if needed
        System.setProperty("webdriver.chrome.driver", "/Users/danurahathevanayagam/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uom.lk/");
    }

    @When("I click on all the navigation links")
    public void i_click_on_all_the_navigation_links() {
        List<WebElement> menuLinks = driver.findElements(By.cssSelector("nav a"));
        for (WebElement link : menuLinks) {
            String linkText = link.getText();
            String expectedUrl = link.getAttribute("href");

            link.click();
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL mismatch for " + linkText);
            Assert.assertTrue(driver.getTitle().contains(linkText), "Title mismatch for " + linkText);
            driver.navigate().back();
        }
    }

    @Then("I should navigate to the correct page with matching titles")
    public void i_should_navigate_to_the_correct_page_with_matching_titles() {
        driver.quit();
    }
}
