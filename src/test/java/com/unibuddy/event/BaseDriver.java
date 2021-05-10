package com.unibuddy.event;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.unibuddy.event.listeners.ScreenShotListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenShotListener.class)
public class BaseDriver {

    private static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    public void driverSetUp()
//    {
//        driver=new ChromeDriver(initDriverOptions());
//    }
}
