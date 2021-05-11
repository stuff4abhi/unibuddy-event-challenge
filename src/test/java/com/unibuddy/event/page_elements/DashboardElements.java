package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum DashboardElements {
    WELCOME_MESSAGE(new By.ByXPath("//*[text()='Helllooooo - welcome!']")),
    FEED_RED(new By.ByXPath("//*[text()='red']")),
    FEED_GREEN(new By.ByXPath("//*[text()='green']")),
    DIRECT_MESSAGES(new By.ByXPath("//*[text()='Direct Messages']")),
    LOGOUT(new By.ByXPath("//*[@aria-label='Logout']//*[name()='svg']"))
    ;

    private final By by;

    DashboardElements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
