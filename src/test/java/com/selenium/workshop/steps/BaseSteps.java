package com.selenium.workshop.steps;

import com.selenium.workshop.pages.MainPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class BaseSteps {
    MainPage mainPage;

    public BaseSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void checkMainPageLoaded() {
        assertTrue("the main page is not loaded", mainPage.isPageLoaded());
    }
}
