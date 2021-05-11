package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import com.unibuddy.event.utilities.CsvUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.unibuddy.event.page_elements.LoginPageElements;

import java.io.IOException;

public class LoginPage extends BasePage{

    private final String url = Urls.LOGIN.getValue();
    private final String dataFile = "registrationData.csv";
    private final CsvUtility csv = new CsvUtility(dataFile);

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void verifyPageUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void clickSignUp(){
        presenceOf(LoginPageElements.SIGN_UP.getBy());
        driver.findElement(LoginPageElements.SIGN_UP.getBy()).click();
    }

    public void clickLogin(){
        presenceOf(LoginPageElements.SUBMIT.getBy());
        driver.findElement(LoginPageElements.SUBMIT.getBy()).click();
    }

    public void verifyAllHrefs(){
        presenceOf(LoginPageElements.SUBMIT.getBy());
        Assert.assertEquals(driver.findElement(LoginPageElements.SIGN_UP.getBy()).getAttribute("href"), Urls.REGISTRATION_MAIN.getValue());
        Assert.assertEquals(driver.findElement(LoginPageElements.RESET_PASSWORD.getBy()).getAttribute("href"), Urls.RESET_PASSWORD.getValue());
    }

    public void verifyAllFields(){
        presenceOf(LoginPageElements.EMAIL.getBy());
        Assert.assertTrue(driver.findElement(LoginPageElements.EMAIL.getBy()).isDisplayed());
        Assert.assertTrue(driver.findElement(LoginPageElements.PASSWORD.getBy()).isDisplayed());
    }

    public void verifySubmitIsDisabled() {
        presenceOf(LoginPageElements.SUBMIT.getBy());
        Assert.assertFalse(driver.findElement(LoginPageElements.SUBMIT.getBy()).isEnabled());
    }

    public void enterUserCredentials(int csvRow){
        presenceOf(LoginPageElements.EMAIL.getBy()).sendKeys(csv.getCellValue(csvRow, LoginPageElements.EMAIL.toString()));
        presenceOf(LoginPageElements.PASSWORD.getBy()).sendKeys(csv.getCellValue(csvRow, LoginPageElements.PASSWORD.toString()));
    }
}
