package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsExecutor {

    private static final String SCRIPT = "arguments[0].scrollIntoView();";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/large");

        WebElement table = driver.findElement(By.id("large-table"));

        ((JavascriptExecutor) driver).executeScript(SCRIPT, table);

        driver.quit();
    }

    public static void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        ExpectedCondition<Boolean> jsLoad = d -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .toString().equals("complete");
        wait.until(jsLoad);
    }
}
