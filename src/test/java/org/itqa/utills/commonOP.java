package org.itqa.utills;

import org.openqa.selenium.WebDriver;


public class CommonOp {

    private WebDriver driver;

    public CommonOp(WebDriver driver) {
        this.driver = driver;
    }
    public void Sleep(long timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
