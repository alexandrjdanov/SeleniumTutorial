package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InteractingWithDropdowns {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
//        Thread.sleep(20000);
//        select.getWrappedElement().click();
        for (WebElement element : select.getOptions())
        System.out.println("Available options: " + element.getText());

        System.out.println("Is this a multi-select: " + select.isMultiple());

        select.selectByValue("1");
        Thread.sleep(1000);
        select.selectByVisibleText("Option 2");
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);

        driver.quit();

    }


}
