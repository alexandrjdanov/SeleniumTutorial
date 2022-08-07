package com.selenium.ui_test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static WebDriver driver;
    private static final String URL = "https://www.browserstack.com/users/sign_in";
    private static final String EMAIL = "test@example.com";
    private static final String PASS = "test123";

    @BeforeClass
    public static void setUp() {
        System.out.println("Setting web driver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Close all tabs");
        driver.quit();
    }

    @Test
    public void loginTest() {
//        LoginPage loginPage = new LoginPage(driver);
        PageFactoryLoginPage loginPage = new PageFactoryLoginPage(driver);
        loginPage.login(EMAIL, PASS);
    }
}
