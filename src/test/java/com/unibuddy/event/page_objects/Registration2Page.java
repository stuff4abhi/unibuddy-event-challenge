package com.unibuddy.event.page_objects;

import com.unibuddy.event.helpers.Urls;
import com.unibuddy.event.page_elements.Registration2Elements;
import com.unibuddy.event.utilities.CsvUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class Registration2Page extends BasePage {

    private final String url = Urls.REGISTRATION_SECOND.getValue();
    private final String dataFile = "registrationData.csv";
    private final CsvUtility csv = new CsvUtility(dataFile);

    public Registration2Page(WebDriver driver) throws IOException {
        super(driver);
    }

    private String getPageUrl() {
        return url;
    }

    public void launchRegistration2Page(){
        driver.get(getPageUrl());
    }

    private void fillEntryDate(int csvRow){
        WebElement date = clickable(Registration2Elements.ENTRY_DATE.getBy());
        date.click();
        Select entryDate = new Select(date);
        entryDate.selectByVisibleText(csv.getCellValue(csvRow, Registration2Elements.ENTRY_DATE.toString()));
    }

    private void fillCountry(int csvRow){
        String data = csv.getCellValue(csvRow, Registration2Elements.COUNTRY.toString());
        presenceOf(Registration2Elements.COUNTRY.getBy()).sendKeys(data);
        clickable(By.cssSelector("li[aria-label='"+ data +"']")).click();
    }

    private void fillDegreeLevel(int csvRow){
        WebElement level = clickable(Registration2Elements.LEVEL.getBy());
        level.click();
        Select levelDropdown = new Select(level);
        levelDropdown.selectByVisibleText(csv.getCellValue(csvRow, Registration2Elements.LEVEL.toString()));
    }

    private void fillAreaOfStudy(int csvRow){
        String data = csv.getCellValue(csvRow, Registration2Elements.AREA_OF_STUDY.toString());
        presenceOf(Registration2Elements.AREA_OF_STUDY.getBy()).sendKeys(data);
        clickable(By.xpath("//li[@aria-label='"+ data +"']")).click();
    }

    private void fillDateOfBirth(int csvRow){
        String data = csv.getCellValue(csvRow, Registration2Elements.DOB.toString());
        clickable(Registration2Elements.DOB.getBy()).click();
        clickable(Registration2Elements.DOB.getBy()).sendKeys(data);
    }

    private void fillTestDate(int csvRow){
        String data = csv.getCellValue(csvRow, Registration2Elements.TEST_DATE.toString());
        clickable(Registration2Elements.TEST_DATE.getBy()).click();
        clickable(Registration2Elements.TEST_DATE.getBy()).sendKeys(data);
    }

    private void fillCheese(int csvRow){
        String data = csv.getCellValue(csvRow, Registration2Elements.FAVOURITE_CHEESE.toString());
        presenceOf(Registration2Elements.FAVOURITE_CHEESE.getBy()).sendKeys(data);
    }

    public void registration2Fill(int csvRow) {
        // check presenceOf DOB and CONTINUE
        presenceOf(Registration2Elements.CONTINUE.getBy());
        presenceOf(Registration2Elements.DOB.getBy());
        // Entry Date
        fillEntryDate(csvRow);
        // Country
        fillCountry(csvRow);
        // Degree Level
        fillDegreeLevel(csvRow);
        // Area Of Study
        fillAreaOfStudy(csvRow);
        // Security Question
        fillCheese(csvRow);
        // Test Date
        fillTestDate(csvRow);
        // DOB
        fillDateOfBirth(csvRow);
        // Marketing Consent
        presenceOf(Registration2Elements.MARKETING_CONSENT.getBy()).click();
    }

    public void registration2Submit(int csvRow) {
        // check presenceOf DOB and CONTINUE
        presenceOf(Registration2Elements.CONTINUE.getBy());
        presenceOf(Registration2Elements.DOB.getBy());
        // Entry Date
        fillEntryDate(csvRow);
        // Country
        fillCountry(csvRow);
        // Degree Level
        fillDegreeLevel(csvRow);
        // Area Of Study
        fillAreaOfStudy(csvRow);
        // Security Question
        fillCheese(csvRow);
        // Test Date
        fillTestDate(csvRow);
        // DOB
        fillDateOfBirth(csvRow);
        // Marketing Consent
        presenceOf(Registration2Elements.MARKETING_CONSENT.getBy()).click();

        // Submit
        clickable(Registration2Elements.CONTINUE.getBy()).click();
    }

}
