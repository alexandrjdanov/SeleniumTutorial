package com.tutorial.selenium;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setting web driver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://999.md");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Closing the driver");
        driver.quit();
    }

    @Test
    public void makeScreenshot() {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try {
            File destinationFile = new File("src/main/resources/screenshot.png");
            FileUtils.copyFile(screenshot, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
