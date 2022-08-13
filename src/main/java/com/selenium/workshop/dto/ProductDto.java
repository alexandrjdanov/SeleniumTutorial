package com.selenium.workshop.dto;

import com.selenium.workshop.CatalogProduct;
import com.selenium.workshop.DetailedProduct;

import java.util.Objects;

public class ProductDto {

    private int price;
    String description;

    public ProductDto(CatalogProduct catalogProduct) {
        setDescription(catalogProduct.getName());
        setPrice(catalogProduct.getPrice());
    }

    public ProductDto(DetailedProduct detailedProduct) {
        setDescription(detailedProduct.getName());
        setPrice(detailedProduct.getPrice());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return getPrice() == that.getPrice() &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getDescription());
    }
}
