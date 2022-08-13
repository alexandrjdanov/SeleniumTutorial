package com.selenium.workshop.steps;

import com.selenium.workshop.dto.ProductDto;
import com.selenium.workshop.pages.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProductDetailsSteps {
    ProductPage productPage;
    public ProductDetailsSteps(WebDriver driver) {
        productPage = new ProductPage(driver);
    }

    public void checkProductPageLoaded() {
        assertTrue("the product page is not loaded", productPage.isPageLoaded());
    }

    public ProductDto getProductDetails() {
        return new ProductDto(productPage.getProduct());
    }
}
