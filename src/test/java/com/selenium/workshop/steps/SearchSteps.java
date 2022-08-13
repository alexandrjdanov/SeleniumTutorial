package com.selenium.workshop.steps;

import com.selenium.workshop.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    MainPage mainPage;
    public SearchSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void searhItem(String searchTerm) {
        mainPage.search(searchTerm);
    }
}
