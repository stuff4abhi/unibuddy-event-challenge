package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.unibuddy.event.page_elements.HomePageElements;

public class HomePage extends BasePage {

    private final String url = Urls.HOME.getValue();

    public HomePage(WebDriver driver){
        super(driver);
    }

    private String getPageUrl() {
        return url;
    }

    public void launchHomePage(){
        driver.get(getPageUrl());
    }

    public void verifySignUpButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageElements.SIGNUP.getBy()));
        WebElement signUp = driver.findElement(HomePageElements.SIGNUP.getBy());
        Assert.assertEquals(signUp.getText(), "Sign up");
        Assert.assertTrue(signUp.isEnabled());
        Assert.assertEquals(signUp.getAttribute("href"), Urls.REGISTRATION_MAIN.getValue());
    }

    public void verifyLoginButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageElements.LOGIN.getBy()));
        WebElement login = driver.findElement(HomePageElements.LOGIN.getBy());
        Assert.assertEquals(login.getText(), "Log in");
        Assert.assertTrue(login.isEnabled());
        Assert.assertEquals(login.getAttribute("href"), Urls.LOGIN.getValue());
    }

    public void clickForSignUp(){
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageElements.SIGNUP.getBy()));
        driver.findElement(HomePageElements.SIGNUP.getBy()).click();
    }

    public void clickForLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageElements.LOGIN.getBy()));
        driver.findElement(HomePageElements.LOGIN.getBy()).click();
    }
}
