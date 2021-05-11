package com.unibuddy.event.tests;

import com.unibuddy.event.BaseDriver;
import com.unibuddy.event.page_objects.Registration2Page;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration2Test extends BaseDriver {
    @Description("Basic Test for Registration2 Page")
    @Test
    public void registration2Test() throws IOException {
        WebDriver driver = getDriver();

        Registration2Page registration2Page = new Registration2Page(driver);
        registration2Page.launchRegistration2Page();
        registration2Page.registration2Fill(1);
    }
}
