package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import com.unibuddy.event.page_objects.*;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class End2EndTest extends BaseDriver {
    @Description("Validations on End to End Test")
    @Test
    public void directChatPageTest() throws IOException {
        WebDriver driver = getDriver();
        // ---------------------------       SignUp and logout      ------------------------
        // Home page
        HomePage homePage = new HomePage(driver);
        homePage.launchHomePage();
        homePage.clickForSignUp();

        // Registration Page
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.verifyAllMandatoryFields();
        // Generate Unique Message
        int dataId = 1;
        String uniqueId = "test" + RandomStringUtils.randomAlphanumeric(4) + "@mail.com";
        registrationPage.registerWith(dataId, uniqueId);

        // Registration Page 2
        Registration2Page registration2Page = new Registration2Page(driver);
        registration2Page.registration2Submit(dataId);

        // Dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyElements();

        // Logout
        dashboardPage.clickLogOut();
        homePage.varifyAllElements();

        // ----------------------         After Logout       ---------------------
        // Home page
        homePage.varifyAllElements();
        homePage.clickForLogin();

        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyPageUrl();
        loginPage.enterUserCredentialsWithId(dataId, uniqueId);
        loginPage.clickLogin();

        // Dashboard
        dashboardPage.verifyElements();

        // ~~~~~~~~~~~~~~     Feed Chat Flow   ~~~~~~~~~~~~~~~
        dashboardPage.clickRedFeed();

        // Red Feed chat
        FeedPage feedPage = new FeedPage(driver);
        feedPage.verifyElements();
        feedPage.verifyFeedPageHeading("red");
        // Generate Unique Message
        String feedInput = "Test Message - " + RandomStringUtils.randomAlphanumeric(10);
        // Send Message
        feedPage.sendMessage(feedInput);
        feedPage.validateLastMessage(feedInput);

        // ~~~~~~~~~~~~~~~   Direct Message Flow   ~~~~~~~~~~~~~~~~
        dashboardPage.clickDirectMessages();

        // Switch to Modal
        driver.switchTo().activeElement();
        By lisa = new By.ByXPath("//div[@aria-modal='true']//*[text()='Lisa']");
        WebElement friend = dashboardPage.clickable(lisa);
        friend.click();
        driver.switchTo().defaultContent();

        // Direct chat
        DirectChatPage directChatPage = new DirectChatPage(driver);
        directChatPage.validateElements();
        // Generate Unique Message
        String textInput = "Test Message - " + RandomStringUtils.randomAlphanumeric(10);
        directChatPage.sendMessage(textInput);
        directChatPage.validateLastMessage(textInput);

        // Logout
        dashboardPage.clickLogOut();
        // Verify Home Page
        homePage.varifyAllElements();
    }
}
