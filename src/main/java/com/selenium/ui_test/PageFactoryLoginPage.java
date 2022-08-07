package com.selenium.ui_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginPage {
    private final WebDriver driver;

    private final By authorizationForm = By.className("auth-form-tablet");

    @FindBy(id = "user_email_login")
    @CacheLookup
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passField;

    @FindBy(id = "user_submit")
    private WebElement signButton;

    public PageFactoryLoginPage(WebDriver driver){
        this.driver = driver;
        new PageLoader(driver).isElementPresent(authorizationForm);
        PageFactory.initElements(this.driver, this);
    }

    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        signButton.click();
    }
}
