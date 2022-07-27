package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InteractingWithElements {
    public static void main(String[] args) throws InterruptedException {

        By searchResults = By.cssSelector("div[data-index='0']");
        By department = By.xpath("//*[@class='a-size-base a-color-base' and contains(text(), 'Fire Tablets')]");
        By departments = By.cssSelector("#departments div.a-spacing-micro");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");

        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("Kindle");
        searchInput.submit();

        searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.clear();
        searchInput.sendKeys("Amazon Fire");
        searchInput.submit();

        WebElement products = driver.findElement(searchResults);
        System.out.println(products.getText());
        System.out.println(products.getAttribute("class"));

        WebElement department1 = driver.findElement(department);
//        List<WebElement> departmentFilters = driver.findElements(departments);
        System.out.println("Filter displayed: " + department1.isDisplayed());

        Thread.sleep(2000);

        driver.quit();
    }
}
