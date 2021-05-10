package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum LoginPageElements {
    EMAIL(new By.ById("email")),
    PASSWORD(new By.ById("password")),
    RESET_PASSWORD(new By.ById("resetPassword")),
    SUBMIT(new By.ById("login")),
    SIGN_UP(new By.ByLinkText("Sign up"));

    private final By by;

    LoginPageElements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
