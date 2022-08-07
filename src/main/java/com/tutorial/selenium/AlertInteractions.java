package com.tutorial.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AlertInteractions {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        if (buttons.size() == 3) {
            buttons.get(2).click();
        }

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        Thread.sleep(2000);

        alert.sendKeys("Hello there!");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);

        driver.quit();
    }
}
