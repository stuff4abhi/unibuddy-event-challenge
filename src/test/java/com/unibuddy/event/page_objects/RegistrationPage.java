package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.unibuddy.event.page_elements.RegistrationElements;

public class RegistrationPage extends BasePage {

    private final String url = Urls.REGISTRATION_MAIN.getValue();

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void verifyPageUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void verifyPolicyCheckBox(){
        wait.until(ExpectedConditions.presenceOfElementLocated(RegistrationElements.POLICY_CHECK.getBy()));
        Assert.assertFalse(driver.findElement(RegistrationElements.POLICY_CHECK.getBy()).isSelected(), "Policy checkbox already marked");
    }

    public void verifyAllMandatoryFields(){
        wait.until(ExpectedConditions.presenceOfElementLocated(RegistrationElements.FIRSTNAME.getBy()));
        Assert.assertEquals(driver.findElement(RegistrationElements.FIRSTNAME.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.LASTNAME.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.EMAIL.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.PASSWORD.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.CONFIRM_PASSWORD.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.POLICY_CHECK.getBy()).getAttribute("required"), "true");
    }

    public void verifyLoginLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(RegistrationElements.LOGIN_LINK.getBy()));
        WebElement login = driver.findElement(RegistrationElements.LOGIN_LINK.getBy());
        Assert.assertTrue(login.isDisplayed());
        Assert.assertEquals(login.getAttribute("href"), Urls.LOGIN.getValue());
    }

    public void verifySubmitButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(RegistrationElements.SUBMIT.getBy()));
        WebElement submit = driver.findElement(RegistrationElements.SUBMIT.getBy());
        Assert.assertTrue(submit.isDisplayed());
    }

    public void registrationMain(){
        driver.findElement(RegistrationElements.FIRSTNAME.getBy()).sendKeys("Kalagarla");
        driver.findElement(RegistrationElements.LASTNAME.getBy()).sendKeys("Abhiram");
        driver.findElement(RegistrationElements.EMAIL.getBy()).sendKeys("abhik@gmail.com");
        driver.findElement(RegistrationElements.PASSWORD.getBy()).sendKeys("k012345");
        driver.findElement(RegistrationElements.CONFIRM_PASSWORD.getBy()).sendKeys("k012345");
        driver.findElement(RegistrationElements.POLICY_CHECK.getBy()).click();
        driver.findElement(RegistrationElements.SUBMIT.getBy()).click();
    }
}
