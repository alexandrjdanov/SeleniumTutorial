package com.selenium.workshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailedProduct extends Product{

    @FindBy(css = "h1[itemprop='name']")
    private WebElement name;

    @FindBy(css = "span[itemprop='price']")
    private WebElement price;

    public DetailedProduct(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected WebElement getNameEl() {
        return name;
    }

    @Override
    protected WebElement getPriceEl() {
        return price;
    }
}
