package com.unibuddy.event.page_elements;

import org.openqa.selenium.By;

public enum Registration2Elements {
    ENTRY_DATE(new By.ById("dateOfEntry")),
    COUNTRY(new By.ById("country")),
    LEVEL(new By.ById("degree-level")),
    AREA_OF_STUDY(new By.ById("degrees")),
    FAVOURITE_CHEESE(new By.ByXPath("//label[contains(text(),'What Is Your Favourite Cheese')]/following-sibling::div//input")),
    TEST_DATE(new By.ByXPath("//label[contains(text(),'Test')]/following-sibling::div//input")),
    DOB(new By.ByXPath("//label[contains(text(),'DOB')]/following-sibling::div//input")),
    MARKETING_CONSENT(new By.ById("marketing")),
    CONTINUE(new By.ById("continue")),

    ;

    private final By by;

    Registration2Elements(By by){
        this.by = by;
    }

    public By getBy(){
        return this.by;
    }
}
