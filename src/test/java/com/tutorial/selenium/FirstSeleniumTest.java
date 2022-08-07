package com.tutorial.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FirstSeleniumTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Initialize webdriver
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        // Close all tabs
        driver.quit();
    }

    @Test
    public void testASearch() {
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("Kindle");
        searchInput.submit();

        assertTrue("The url doesn't contain the expected term", driver.getCurrentUrl().contains("Kindle"));
    }

    @Test
    public void testBFilters(){
        WebElement priceFrom = driver.findElement(By.id("low-price"));
        priceFrom.sendKeys("150");
        priceFrom.submit();

        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));

        for (WebElement price : prices) {
            assertTrue(Integer.parseInt(price.getText()) >= 150);
        }
    }
}
