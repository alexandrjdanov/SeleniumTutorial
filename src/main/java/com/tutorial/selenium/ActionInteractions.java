package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionInteractions {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> avatars = driver.findElements(By.className("figure"));

        Actions action = new Actions(driver);
        action.moveToElement(avatars.get(1)).perform();

        Thread.sleep(3000);
        driver.findElement(By.linkText("View profile")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
