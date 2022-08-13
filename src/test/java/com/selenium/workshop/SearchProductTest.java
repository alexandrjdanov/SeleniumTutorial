package com.selenium.workshop;

import com.selenium.workshop.dto.ProductDto;
import com.selenium.workshop.pages.CatalogPage;
import com.selenium.workshop.pages.MainPage;
import com.selenium.workshop.pages.ProductPage;
import com.selenium.workshop.steps.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchProductTest extends BaseTest{
    /**
     * 1. Navigate to main page
     * 2. Check page loaded
     * 3. Search a product
     * 4. Check the list of results contains the search term
     * 5. Save the product data
     * 6. Open the product
     * 7. Check the data is same as search page
     */

    private MainPage mainPage;
    private ProductPage productPage;
    private CatalogPage catalogPage;

    private BaseSteps baseSteps;
    private SearchSteps searchSteps;
    private CatalogSteps catalogSteps;
    private ProductDetailsSteps productDetailsSteps;
    private CheckDetailsSteps checkDetailsSteps;

    @Before
    public void setUpPages() {
        mainPage = new MainPage(BaseTest.getDriver());
        catalogPage = new CatalogPage(BaseTest.getDriver());
        productPage = new ProductPage(BaseTest.getDriver());

        baseSteps = new BaseSteps(getDriver());
        searchSteps = new SearchSteps(getDriver());
        catalogSteps = new CatalogSteps(getDriver());
        productDetailsSteps = new ProductDetailsSteps(getDriver());
        checkDetailsSteps = new CheckDetailsSteps();
    }

    @Test
    public void searchProductTest() {
        // prerequisites will navigate to main page

        final String searchTerm = "HF-N94";

        assertTrue("the main page is not loaded", mainPage.isPageLoaded());

        mainPage.search(searchTerm);

        List<CatalogProduct> productList = catalogPage.getProductList();

        assertTrue("the list is empty", productList.size() > 0);

        for (Product product: productList) {
            assertTrue("the product doesn't contain " + searchTerm, product.getName().contains(searchTerm));
        }

        final CatalogProduct firstProduct = productList.get(0);
        final String firstProductName = firstProduct.getName();
        final int firstProductPrice = firstProduct.getPrice();

        catalogPage.openItem(0);

        assertTrue("the product page is not loaded", productPage.isPageLoaded());

        final DetailedProduct actualProduct = productPage.getProduct();

        final String actualProductName = actualProduct.getName();
        final int actualProductPrice = actualProduct.getPrice();

        assertTrue("the name on the product page is different from the name on catalog page", firstProductName.equals(actualProductName));
        assertTrue("the price on the product page is different from the price on catalog page", firstProductPrice == actualProductPrice);
    }

    @Test
    public void searchProductTest2() {
        // prerequisites will navigate to main page

        final String searchTerm = "HF-N94";

        baseSteps.checkMainPageLoaded();
        searchSteps.searhItem(searchTerm);
        catalogSteps.checkResultsListIsPresent();
        catalogSteps.checkTermIsPresentInResults(searchTerm);

        final int productIndex = 0;
        ProductDto catalogProduct = catalogSteps.getProductDetails(productIndex);
        catalogSteps.openProduct(productIndex);

        productDetailsSteps.checkProductPageLoaded();
        ProductDto detailedProduct = productDetailsSteps.getProductDetails();

        checkDetailsSteps.checkProductMatch(catalogProduct, detailedProduct);

    }
}
