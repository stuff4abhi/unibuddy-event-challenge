package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum DirectMessagesElements {
    SEND(new By.ById("send")),
    CHAT_INPUT(new By.ById("chat-input")),
    LAST_MESSAGE(new By.ByXPath("//*[@data-test-id='message-id'][last()]//span/span")),
    MY_MESSAGE(new By.ByXPath("//*[@data-test-id='message-id'][last()]//span/span[text()='My message']")),
    ;

    private final By by;

    DirectMessagesElements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
