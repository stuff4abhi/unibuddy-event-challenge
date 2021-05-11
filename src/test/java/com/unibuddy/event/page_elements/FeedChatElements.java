package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum FeedChatElements {
    INPUT_BOX(new By.ByXPath("//*[@data-test-id='chat-input-field']")),
    LAST_MESSAGE(new By.ByXPath("//li[last()]//div[@data-test-id='chat-message-bubble']/div/span/span")),
    MY_MESSAGE(new By.ByXPath("//li[last()]//div[@data-test-id='chat-message-bubble']/div/span//*[text()='My message']")),
    SEND(new By.ByXPath("//*[text()='Send']"))
    ;

    private final By by;

    FeedChatElements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
