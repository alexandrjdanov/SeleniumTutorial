package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindingElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        // Identify a list of elements on the page
        List<WebElement> cards = driver.findElements(By.cssSelector(".a-cardui-body"));
        if (cards.size() > 0)
            cards.get(0).click();

        //Identify a single element on the page
        WebElement somecard = driver.findElement(By.linkText("See more"));
        somecard.click();

        driver.quit();
    }
}
