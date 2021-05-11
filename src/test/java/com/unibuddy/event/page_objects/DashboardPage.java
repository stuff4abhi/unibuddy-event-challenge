package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import com.unibuddy.event.page_elements.DashboardElements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage{
    private final String url = Urls.DASHBOARD.getValue();

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public void verifyElements(){
        presenceOf(DashboardElements.FEED_RED.getBy()).isDisplayed();
        presenceOf(DashboardElements.FEED_GREEN.getBy()).isDisplayed();
        presenceOf(DashboardElements.DIRECT_MESSAGES.getBy()).isDisplayed();
        presenceOf(DashboardElements.LOGOUT.getBy()).isDisplayed();
    }

    public void clickRedFeed(){
        clickable(DashboardElements.FEED_RED.getBy()).click();
    }

    public void clickDirectMessages(){
        clickable(DashboardElements.DIRECT_MESSAGES.getBy()).click();
    }

    public void clickLogOut(){
        clickable(DashboardElements.LOGOUT.getBy()).click();
    }
}
