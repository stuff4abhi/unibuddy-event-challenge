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

public class DirectChatPageTest extends BaseDriver {
    @Description("Validations on DirectChat")
    @Test
    public void directChatPageTest() throws IOException {
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
        homePage.varifyAllElements();
    }
}
