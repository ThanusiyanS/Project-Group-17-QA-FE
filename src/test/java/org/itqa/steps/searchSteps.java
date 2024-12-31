package org.itqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.itqa.utills.CommonOp;
import org.itqa.utills.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class searchSteps {
    WebDriver driver;

    CommonOp commonOpObj = new CommonOp(driver);

    @Given("I am on the homepage of UOM website")
    public void i_am_on_the_homepage() {
        System.setProperty("webdriver.chrome.driver", "D:\\WDS\\e2e_linkfx_selenium\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uom.lk/");
    }

    @When("I check the search icon")
    public void i_check_the_search_icon() {

        commonOpObj.Sleep(Constants.WAITING_TIME_OVER_HIGH);
        WebElement element = driver.findElement(By.xpath(
                "/html[1]/body[1]/header[1]/div[2]/div[1]/a[2]/i[1]"));
        element.click();
    }
    @Then("I search for a keyword")
    public void i_search_for_a_keyword() {

        commonOpObj.Sleep(Constants.WAITING_TIME_OVER_HIGH);
        WebElement element = driver.findElement(By.xpath(
                "/html[1]/body[1]/header[1]/div[3]/form[1]/input[1]"));
        element.click();
        element.sendKeys("ABOUT");
        element.submit();
    }
}
