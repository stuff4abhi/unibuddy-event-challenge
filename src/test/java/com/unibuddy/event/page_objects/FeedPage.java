package com.unibuddy.event.page_objects;

import com.unibuddy.event.page_elements.FeedChatElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FeedPage extends BasePage{

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public void verifyElements(){
        Assert.assertTrue(presenceOf(FeedChatElements.INPUT_BOX.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(FeedChatElements.SEND.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(FeedChatElements.LAST_MESSAGE.getBy()).isDisplayed());
        Assert.assertFalse(presenceOf(FeedChatElements.SEND.getBy()).isEnabled());
    }

    public void sendMessage(String text){
        WebElement inputBox = presenceOf(FeedChatElements.INPUT_BOX.getBy());
        inputBox.sendKeys(text);
        clickable(FeedChatElements.SEND.getBy()).click();
    }

    public void validateLastMessage(String text){
        By myMessage = new By.ByXPath("//li[last()]//div[@data-test-id='chat-message-bubble']/div/span//*[text()='"+ text +"']");
        Assert.assertTrue(presenceOf(myMessage).isDisplayed());
    }

    public void verifyFeedPageHeading(String text){
        By feedName = new By.ByXPath("//*[text()='# "+ text +"']");
        Assert.assertTrue(presenceOf(feedName).isDisplayed());
    }

}
