package org.itqa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;

public class SubmitContactUsFormSteps {

    WebDriver driver;

    @Given("I launch the browser and navigate to test automation website to submit contact us form")
    public void iLaunchTheBrowserAndNavigateToUrl() {
        driver = DriverFactory.getWebDriver();
        driver.get("https://www.automationexercise.com");
    }
    @Then("I verify that the home page is visible to submit the form")
    public void iVerifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    @When("I click on the Contact Us button")
    public void iClickOnContactUsButton(){
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[8]/a[1]")).click();
    }

    @Then("I Verify 'GET IN TOUCH' is visible")
    public void iVerifyGetInTouchIsVisible() {

        boolean isVisible = driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed();

        assertEquals(isVisible, true, "'GET IN TOUCH' is not visible on the page.");
    }

    @And("I Enter name")
    public void iEnterName(){
        driver.findElement(By.xpath("//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/input[1]")).sendKeys("Amanda");
    }

    @Then("I enter my mail")
    public void iEnterEmail(){
        driver.findElement(By.xpath("//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[3]/form[1]/div[2]/input[1]")).sendKeys("Amanda@gmail.com");
    }

    @Then("I enter the subject")
    public void iEnterSubject(){
        driver.findElement(By.xpath("//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[3]/form[1]/div[3]/input[1]")).sendKeys("I want to buy a product");
    }

    @Then("I enter the message")
    public void iEnterMessage(){
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I couldn't add the product to the cart");
    }

    @When("I hover over the 'Submit button'")
    public void iHoverOverSubmitButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @And("I Click 'Submit button'")
    public void iClickSubmitButton(){
        driver.findElement(By.xpath("//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[3]/form[1]/div[6]/input[1]")).click();
    }

    @And("I Click 'OK' button appearing in the popup")
    public void iClickOKButton() {

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        assertEquals(alertText, "Press OK to proceed!", "Unexpected alert text!");

        alert.accept();
    }

    @Then("I Verify success message 'Success! Your details have been submitted successfully.' is visible")
    public void iVerifySuccessMessage() {
        boolean isVisible = driver.findElement(By.xpath("//div[@id='form-section']")).isDisplayed();

        assertEquals(isVisible, true, "'Success! Your details have been submitted successfully.' is not visible on the page.");

    }
    @And("I Click 'Home' button and verify that landed to home page successfully")
    public void iClickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

}
