package com.unibuddy.event.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;

import static com.unibuddy.event.BaseDriver.getDriver;

public class ScreenShotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = getDriver();
        String screenshotDirectory = System.getProperty("screenshotDirectory", "target/screenshots");

        File screenshot = new File(screenshotDirectory + File.pathSeparator + result.getName()+".png");

        try {
            if(createFile(screenshot)){
                FileOutputStream screenshotStream = new FileOutputStream(screenshot);
                screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                screenshotStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    private boolean createFile(File screenshot) {
        boolean fileCreated = false;

        if (screenshot.exists()) {
            fileCreated = true;
        } else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                try {
                    fileCreated = screenshot.createNewFile();
                } catch (IOException errorCreatingScreenshot) {
                    errorCreatingScreenshot.printStackTrace();
                }
            }
        }

        return fileCreated;
    }
}
