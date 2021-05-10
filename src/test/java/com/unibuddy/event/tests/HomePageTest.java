package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import com.unibuddy.event.utilities.CsvUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.unibuddy.event.page_objects.HomePage;

import java.io.IOException;


public class HomePageTest extends BaseDriver {

    @Description("Basic validations on Home Page")
    @Test
    public void homePageTest() throws IOException {
        WebDriver driver = getDriver();

        // Validate the HomePage of Unibuddy-event Home page
        HomePage loginSignUpPage = new HomePage(driver);
        loginSignUpPage.launchHomePage();

        // Validate various aspects of HomePage
        loginSignUpPage.verifySignUpButton();
        loginSignUpPage.verifyLoginButton();

    }
}
