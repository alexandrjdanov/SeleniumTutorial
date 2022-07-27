package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InteractingWithCkeckboxes {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(5000);
        driver.findElements(By.tagName("input")).get(0).click();
        Thread.sleep(5000);
        driver.findElements(By.tagName("input")).get(1).click();
        Thread.sleep(5000);

        driver.quit();

    }


}
