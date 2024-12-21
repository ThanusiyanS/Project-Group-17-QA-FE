package SampleApp;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Test {
//    public void test(){
////        System.out.println("Hello");
//        System.setProperty("webdriver.chrome.driver","//Users//danurahathevanayagam//Downloads//chromedriver-mac-arm64//chromedriver");
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://uom.lk/");
//        driver.quit();
//    }
//
//}


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Test1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","//Users//danurahathevanayagam//Downloads//chromedriver-mac-arm64//chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uom.lk/");
    }

    @Test
    public void testTitle() {
        String expectedTitle = "University Of Moratuwa";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Title does not match!";
    }

    @Test
    public void testNavigationLinks() {
        List<WebElement> menuLinks = driver.findElements(By.cssSelector("nav a")); // Adjust selector as needed

        for (WebElement link : menuLinks) {
            String linkText = link.getText();
            String expectedUrl = link.getAttribute("href");

            link.click();
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL mismatch for " + linkText);
            Assert.assertTrue(driver.getTitle().contains(linkText), "Title mismatch for " + linkText);
            driver.navigate().back();
        }
    }
}
