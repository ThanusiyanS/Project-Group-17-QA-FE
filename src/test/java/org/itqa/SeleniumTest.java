//package org.itqa;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class SeleniumTest {
//
//    WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver","//Users//danurahathevanayagam//Downloads//chromedriver-mac-arm64//chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://uom.lk/");
//    }
//
//    @Test
//    public void testTitle() {
//        String expectedTitle = "University Of Moratuwa";
//        String actualTitle = driver.getTitle();
//        assert actualTitle.equals(expectedTitle) : "Title does not match!";
//    }
//
//    @Test
//    public void testNavigationLinks() {
//        List<WebElement> menuLinks = driver.findElements(By.cssSelector("nav a")); // Adjust selector as needed
//
//        for (WebElement link : menuLinks) {
//            String linkText = link.getText();
//            String expectedUrl = link.getAttribute("href");
//
//            link.click();
//            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL mismatch for " + linkText);
//            Assert.assertTrue(driver.getTitle().contains(linkText), "Title mismatch for " + linkText);
//            driver.navigate().back();
//        }
//    }
//}
