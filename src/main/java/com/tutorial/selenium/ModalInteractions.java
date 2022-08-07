package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalInteractions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/bootstrap/bootstrap_modal.asp");

        //Get current window handle
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("button[data-toggle='modal']")).click();
        Thread.sleep(3000);
        WebElement modal = driver.findElement(By.className("modal-body"));

        for (String windowName : driver.getWindowHandles()) {
            if (!windowName.equals(currentWindow)) {
                driver.switchTo().window(windowName);
                break;
            }
        }

        Thread.sleep(3000);
        modal.findElement(By.xpath("//*[@class='btn btn-default']")).click();
        Thread.sleep(3000);

        driver.switchTo().window(currentWindow);

        driver.quit();
    }
}
