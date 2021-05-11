package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import com.unibuddy.event.page_elements.DashboardElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage{
    private final String url = Urls.DASHBOARD.getValue();

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public void verifyElements(){
        Assert.assertTrue(presenceOf(DashboardElements.WELCOME_MESSAGE.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DashboardElements.FEED_RED.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DashboardElements.FEED_GREEN.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DashboardElements.DIRECT_MESSAGES.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DashboardElements.LOGOUT.getBy()).isDisplayed());
    }

    public void clickRedFeed(){
        clickable(DashboardElements.FEED_RED.getBy()).click();
    }

    public void clickDirectMessages(){
        clickable(DashboardElements.DIRECT_MESSAGES.getBy()).click();
    }

    public void clickLogOut(){
        clickable(DashboardElements.LOGOUT.getBy()).click();
        checkAlert();
    }

    private void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }
}
