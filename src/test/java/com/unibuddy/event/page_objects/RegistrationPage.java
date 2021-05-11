package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import com.unibuddy.event.utilities.CsvUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.unibuddy.event.page_elements.RegistrationElements;

import java.io.IOException;

public class RegistrationPage extends BasePage {

    private final String url = Urls.REGISTRATION_MAIN.getValue();
    private final String dataFile = "registrationData.csv";
    private final CsvUtility csv = new CsvUtility(dataFile);

    public RegistrationPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void verifyPageUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void verifyPolicyCheckBox(){
        presenceOf(RegistrationElements.POLICY_CHECK.getBy());
        Assert.assertFalse(driver.findElement(RegistrationElements.POLICY_CHECK.getBy()).isSelected(), "Policy checkbox already marked");
    }

    public void verifyAllMandatoryFields(){
        presenceOf(RegistrationElements.FIRSTNAME.getBy());
        Assert.assertEquals(driver.findElement(RegistrationElements.FIRSTNAME.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.LASTNAME.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.EMAIL.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.PASSWORD.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.CONFIRM_PASSWORD.getBy()).getAttribute("required"), "true");
        Assert.assertEquals(driver.findElement(RegistrationElements.POLICY_CHECK.getBy()).getAttribute("required"), "true");
    }

    public void verifyLoginLink(){
        presenceOf(RegistrationElements.LOGIN_LINK.getBy());
        WebElement login = driver.findElement(RegistrationElements.LOGIN_LINK.getBy());
        Assert.assertTrue(login.isDisplayed());
        Assert.assertEquals(login.getAttribute("href"), Urls.LOGIN.getValue());
    }

    public void verifySubmitButton(){
        presenceOf(RegistrationElements.SUBMIT.getBy());
        WebElement submit = driver.findElement(RegistrationElements.SUBMIT.getBy());
        Assert.assertTrue(submit.isDisplayed());
    }

    private void fillFirstName(int csvRow){
        String data = csv.getCellValue(csvRow, RegistrationElements.FIRSTNAME.toString());
        presenceOf(RegistrationElements.FIRSTNAME.getBy()).sendKeys(data);
    }

    private void fillLastName(int csvRow){
        String data = csv.getCellValue(csvRow, RegistrationElements.LASTNAME.toString());
        presenceOf(RegistrationElements.LASTNAME.getBy()).sendKeys(data);
    }

    private void fillPassword(int csvRow){
        String data = csv.getCellValue(csvRow, RegistrationElements.PASSWORD.toString());
        presenceOf(RegistrationElements.PASSWORD.getBy()).sendKeys(data);
    }

    private void fillConfPassword(int csvRow){
        String data = csv.getCellValue(csvRow, RegistrationElements.CONFIRM_PASSWORD.toString());
        presenceOf(RegistrationElements.CONFIRM_PASSWORD.getBy()).sendKeys(data);
    }

    public void registerWith(int csvRow, String uniqueId) {
        fillFirstName(csvRow);
        fillLastName(csvRow);
        presenceOf(RegistrationElements.EMAIL.getBy()).sendKeys(uniqueId);
        fillPassword(csvRow);
        fillConfPassword(csvRow);
        presenceOf(RegistrationElements.POLICY_CHECK.getBy()).click();
        presenceOf(RegistrationElements.SUBMIT.getBy()).click();
    }
}
