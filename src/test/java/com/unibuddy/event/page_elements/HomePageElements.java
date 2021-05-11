package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum HomePageElements {
    SIGNUP(new By.ByLinkText("Sign up")),
    LOGIN(new By.ByLinkText("Log in")),
    HEADING(new By.ByXPath("//*[text()='My First Event']"));

    private final By by;

    HomePageElements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
