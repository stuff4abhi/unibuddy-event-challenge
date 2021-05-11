package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import com.unibuddy.event.page_objects.DashboardPage;
import com.unibuddy.event.page_objects.HomePage;
import com.unibuddy.event.page_objects.LoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardPageTest extends BaseDriver {
    @Description("Validations on Dashboard")
    @Test
    public void dashboardPageTest() throws IOException {
        WebDriver driver = getDriver();
        // Home page
        HomePage homePage = new HomePage(driver);
        homePage.launchHomePage();
        homePage.clickForLogin();

        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyPageUrl();
        loginPage.enterUserCredentials(1);
        loginPage.clickLogin();

        // Dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyElements();

        // Logout
        dashboardPage.clickLogOut();
        // Verify Home Page
        homePage.varifyAllElements();

    }
}
