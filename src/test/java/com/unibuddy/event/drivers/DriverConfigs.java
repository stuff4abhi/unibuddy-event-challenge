package com.unibuddy.event.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverConfigs implements DriverSetup{
    CHROME {
        public RemoteWebDriver getWebDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(HEADLESS);
            return new ChromeDriver();
        }
    },

    FIREFOX {
        public RemoteWebDriver getWebDriver() {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(HEADLESS);
            return new FirefoxDriver(options);
        }
    };

    private static final boolean HEADLESS = Boolean.getBoolean("headless");

}
