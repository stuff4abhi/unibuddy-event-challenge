package com.unibuddy.event;

import com.unibuddy.event.drivers.DriverConfigs;
import com.unibuddy.event.listeners.ScreenShotListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenShotListener.class)
public class BaseDriver {

    private static final ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    @BeforeClass
    public void setupClass() {
        drivers.set(driverSetUp());
    }

    public static RemoteWebDriver getDriver() {
        return drivers.get();
    }

    @AfterClass
    public void teardown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    private RemoteWebDriver driverSetUp()
    {
        DriverConfigs driverConfig = DriverConfigs.CHROME;
        String browser = System.getProperty("browser", driverConfig.toString()).toUpperCase();
        driverConfig = DriverConfigs.valueOf(browser);
        return driverConfig.getWebDriver();
    }
}
