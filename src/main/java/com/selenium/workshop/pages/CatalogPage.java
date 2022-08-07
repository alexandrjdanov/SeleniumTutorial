package com.selenium.workshop.pages;

import com.selenium.workshop.CatalogProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage {

    @FindBy(css=".product-grid > div")
    private List<WebElement> catalogProductElements;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<CatalogProduct> getProductList() {
        List<CatalogProduct> catalogProducts = new ArrayList<>();
        for (WebElement productEl : catalogProductElements) {
            catalogProducts.add(new CatalogProduct(productEl));
        }
        return catalogProducts;
    }

    public void openItem(int productIndex) {
        catalogProductElements.get(productIndex).click();
    }
}
