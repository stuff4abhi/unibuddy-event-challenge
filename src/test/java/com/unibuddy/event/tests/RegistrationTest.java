package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.unibuddy.event.page_objects.HomePage;
import com.unibuddy.event.page_objects.RegistrationPage;

public class RegistrationTest extends BaseDriver {
    @Description("Basic validations on Registration Page")
    @Test
    public void registerTest(){
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.launchHomePage();

        // Click SignUp
        homePage.clickForSignUp();

        // Validate Registration Page
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.verifyPageUrl();
        registrationPage.verifyPolicyCheckBox();
        registrationPage.verifyAllMandatoryFields();
        registrationPage.verifyLoginLink();
        registrationPage.verifySubmitButton();
    }
}
