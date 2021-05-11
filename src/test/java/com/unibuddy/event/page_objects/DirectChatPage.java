package com.unibuddy.event.page_objects;

import com.unibuddy.event.page_elements.DirectMessagesElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DirectChatPage extends BasePage{

    public DirectChatPage(WebDriver driver) {
        super(driver);
    }

    public void validateElements(){
        Assert.assertTrue(presenceOf(DirectMessagesElements.CHAT_INPUT.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DirectMessagesElements.SEND.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DirectMessagesElements.PROFILE_VIEW.getBy()).isDisplayed());
        Assert.assertTrue(presenceOf(DirectMessagesElements.LAST_MESSAGE.getBy()).isDisplayed());
    }

    public void sendMessage(String text){
        WebElement inputBox = presenceOf(DirectMessagesElements.CHAT_INPUT.getBy());
        inputBox.sendKeys(text);
        clickable(DirectMessagesElements.SEND.getBy()).click();
    }

    public void validateLastMessage(String text){
        By myMessage = new By.ByXPath("//*[@data-test-id='message-id'][last()]//span/span[text()='" + text + "']");
        Assert.assertTrue(presenceOf(myMessage).isDisplayed());
    }
}
