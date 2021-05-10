package com.unibuddy.event.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver,20);
    }
}
