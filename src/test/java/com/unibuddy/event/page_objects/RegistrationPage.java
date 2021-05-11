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

    public RegistrationPage(WebDriver driver){
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

    public void registrationMain(int csvRow) throws IOException {
        CsvUtility csv = new CsvUtility(dataFile);
        driver.findElement(RegistrationElements.FIRSTNAME.getBy()).sendKeys(csv.getCellValue(csvRow, "FIRSTNAME"));
        driver.findElement(RegistrationElements.LASTNAME.getBy()).sendKeys(csv.getCellValue(csvRow, "LASTNAME"));
        driver.findElement(RegistrationElements.EMAIL.getBy()).sendKeys(csv.getCellValue(csvRow, "EMAIL"));
        driver.findElement(RegistrationElements.PASSWORD.getBy()).sendKeys(csv.getCellValue(csvRow, "PASSWORD"));
        driver.findElement(RegistrationElements.CONFIRM_PASSWORD.getBy()).sendKeys(csv.getCellValue(csvRow, "CONFIRM_PASSWORD"));
        driver.findElement(RegistrationElements.POLICY_CHECK.getBy()).click();
        driver.findElement(RegistrationElements.SUBMIT.getBy()).click();
    }
}
