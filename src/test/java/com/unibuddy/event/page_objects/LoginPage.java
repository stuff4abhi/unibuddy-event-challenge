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
        presenceOf(LoginPageElements.SIGN_UP.getBy()).click();
    }

    public void clickLogin(){
        presenceOf(LoginPageElements.SUBMIT.getBy()).click();
    }

    public void verifyAllHrefs(){
        Assert.assertEquals(presenceOf(LoginPageElements.SIGN_UP.getBy()).getAttribute("href"), Urls.REGISTRATION_MAIN.getValue());
        Assert.assertEquals(presenceOf(LoginPageElements.RESET_PASSWORD.getBy()).getAttribute("href"), Urls.RESET_PASSWORD.getValue());
    }

    public void verifyAllFields(){
        Assert.assertTrue(presenceOf(LoginPageElements.EMAIL.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(LoginPageElements.PASSWORD.getBy()).isDisplayed());
    }

    public void verifySubmitIsDisabled() {
        Assert.assertFalse(presenceOf(LoginPageElements.SUBMIT.getBy()).isEnabled());
    }

    public void enterUserCredentials(int csvRow){
        presenceOf(LoginPageElements.EMAIL.getBy()).sendKeys(csv.getCellValue(csvRow, LoginPageElements.EMAIL.toString()));
        presenceOf(LoginPageElements.PASSWORD.getBy()).sendKeys(csv.getCellValue(csvRow, LoginPageElements.PASSWORD.toString()));
    }

    public void enterUserCredentialsWithId(int csvRow, String uniqueId){
        presenceOf(LoginPageElements.EMAIL.getBy()).sendKeys(uniqueId);
        presenceOf(LoginPageElements.PASSWORD.getBy()).sendKeys(csv.getCellValue(csvRow, LoginPageElements.PASSWORD.toString()));
    }
}
