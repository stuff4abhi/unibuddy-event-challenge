package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.unibuddy.event.page_objects.HomePage;


public class HomePageTest extends BaseDriver {

    @Description("Basic validations on Home Page")
    @Test
    public void homePageTest() {
        WebDriver driver = getDriver();

        // Validate the HomePage of Unibuddy-event Home page
        HomePage loginSignUpPage = new HomePage(driver);
        loginSignUpPage.launchHomePage();

        // Validate various aspects of HomePage
        loginSignUpPage.verifySignUpButton();
        loginSignUpPage.verifyLoginButton();

    }
}
