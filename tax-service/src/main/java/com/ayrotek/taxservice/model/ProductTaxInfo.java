package com.ayrotek.taxservice.model;

public class ProductTaxInfo {
    public float price;
    public int tax_category;
    public String code;

    public ProductTaxInfo(float price, int tax_category, String code) {

        this.price = price;
        this.tax_category = tax_category;
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTaxCategory() {
        return tax_category;
    }

    public void setTaxCategory(int tax_category) {
        this.tax_category = tax_category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
