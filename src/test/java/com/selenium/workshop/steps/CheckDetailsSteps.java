package com.selenium.workshop.steps;

import com.selenium.workshop.dto.ProductDto;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CheckDetailsSteps {

    public void checkProductMatch(ProductDto catalogProduct, ProductDto detailedProduct) {
        assertEquals("Catalog product is not equal to the product from the product page", catalogProduct, detailedProduct);
    }
}
