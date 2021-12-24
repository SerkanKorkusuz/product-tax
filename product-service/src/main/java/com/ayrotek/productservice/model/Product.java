package com.ayrotek.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
    private int id;
    public String code;
    public String name;
    public String vendor;
    public float price;
    public String price_currency;
    private int user_id;
    public int tax_category;
    private String create_date;
    private String update_date;

    public Product() {
    }

    public Product(int id, String code, String name, String vendor, float price, String price_currency,
                   int user_id, int tax_category, String create_date, String update_date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.price_currency = price_currency;
        this.user_id = user_id;
        this.tax_category = tax_category;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPriceCurrency() {
        return price_currency;
    }

    public void setPriceCurrency(String price_currency) {
        this.price_currency = price_currency;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getTaxCategory() {
        return tax_category;
    }

    public void setTaxCategory(int tax_category) {
        this.tax_category = tax_category;
    }

    public String getCreateDate() {
        return create_date;
    }

    public void setCreateDate(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdateDate() {
        return update_date;
    }

    public void setUpdateDate(String update_date) {
        this.update_date = update_date;
    }

}