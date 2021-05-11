package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.unibuddy.event.page_objects.HomePage;
import com.unibuddy.event.page_objects.LoginPage;

import java.io.IOException;

public class LoginPageTest extends BaseDriver {
    @Description("Basic validations on Login Page")
    @Test
    public void loginPageTest() throws IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.launchHomePage();

        // Click SignUp
        homePage.clickForLogin();

        // Validate Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyPageUrl();
        loginPage.verifyAllFields();
        loginPage.verifySubmitIsDisabled();
        loginPage.verifyAllHrefs();

    }
}
