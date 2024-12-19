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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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




}
