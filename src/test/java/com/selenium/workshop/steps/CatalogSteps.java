package com.selenium.workshop.steps;

import com.selenium.workshop.CatalogProduct;
import com.selenium.workshop.dto.ProductDto;
import com.selenium.workshop.pages.CatalogPage;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CatalogSteps {
    CatalogPage catalogPage;
    public CatalogSteps(WebDriver driver) {
        catalogPage = new CatalogPage(driver);
    }

    public void checkResultsListIsPresent() {
        List<CatalogProduct> productList = catalogPage.getProductList();
        assertThat(productList).as("The product list is empty").hasSizeGreaterThan(0);
//        assertTrue("the list is empty", productList.size() > 0);
    }

    public void checkTermIsPresentInResults(String searchTerm) {
        for (CatalogProduct product: catalogPage.getProductList()) {
            assertTrue("the product doesn't contain " + searchTerm,
                    product.getName().contains(searchTerm));
        }
    }

    public ProductDto getProductDetails(int productIndex) {
        return new ProductDto(catalogPage.getProductList().get(productIndex));
    }

    public void openProduct(int productIndex) {
        catalogPage.openItem(productIndex);
    }
}
