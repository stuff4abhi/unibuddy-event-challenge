package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum RegistrationElements {

    FIRSTNAME(new By.ById("first-name")),
    LASTNAME(new By.ById("last-name")),
    EMAIL(new By.ById("email")),
    PASSWORD(new By.ById("password")),
    CONFIRM_PASSWORD(new By.ById("confirm-password")),
    POLICY_CHECK(new By.ByName("privacyChecked")),
    LOGIN_LINK(new By.ByLinkText("Log in")),
    SUBMIT(new By.ById("continue"));

    private final By by;

    RegistrationElements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
