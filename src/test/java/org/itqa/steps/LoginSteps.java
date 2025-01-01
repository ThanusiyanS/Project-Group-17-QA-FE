package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.pages.LoginPage;
import org.itqa.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver = DriverFactory.getWebDriver();
        driver.get("https://www.automationexercise.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the user dashboard")
    public void iShouldSeeTheUserDashboard() {
        String actualTitle = driver.getTitle();
        assertEquals("Automation Exercise", actualTitle);
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        String error = loginPage.getErrorMessage();
        assertEquals("Your email or password is incorrect!", error);
        driver.quit();
    }

    @When("I enter invalid username {string} and password {string}")
    public void iEnterInValidUsernameAndPassword(String username, String password) {
        loginPage.logOutButton();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }
}
