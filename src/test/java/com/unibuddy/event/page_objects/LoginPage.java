package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.unibuddy.event.page_elements.LoginPageElements;

public class LoginPage extends BasePage{

    private final String url = Urls.LOGIN.getValue();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void clickSignUp(){
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageElements.SIGN_UP.getBy()));
        driver.findElement(LoginPageElements.SIGN_UP.getBy()).click();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageElements.SUBMIT.getBy()));
        driver.findElement(LoginPageElements.SUBMIT.getBy()).click();
    }

    public void verifyAllHrefs(){
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageElements.SUBMIT.getBy()));
        Assert.assertEquals(driver.findElement(LoginPageElements.SIGN_UP.getBy()).getAttribute("href"), Urls.REGISTRATION_MAIN.getValue());
        Assert.assertEquals(driver.findElement(LoginPageElements.RESET_PASSWORD.getBy()).getAttribute("href"), Urls.RESET_PASSWORD.getValue());
    }

    public void verifyAllFields(){
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageElements.EMAIL.getBy()));
        Assert.assertTrue(driver.findElement(LoginPageElements.EMAIL.getBy()).isDisplayed());
        Assert.assertTrue(driver.findElement(LoginPageElements.PASSWORD.getBy()).isDisplayed());
    }

    public void verifySubmitIsDisabled() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageElements.SUBMIT.getBy()));
        Assert.assertFalse(driver.findElement(LoginPageElements.SUBMIT.getBy()).isEnabled());
    }
}
