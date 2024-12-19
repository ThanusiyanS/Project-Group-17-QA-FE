package SampleApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public void test(){
//        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","//Users//danurahathevanayagam//Downloads//chromedriver-mac-arm64//chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://uom.lk/");
        driver.quit();
    }

}
