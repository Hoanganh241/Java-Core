package com.t2010a.hellot2010aagain.entity;

import com.t2010a.hellot2010aagain.entity.base.BaseEntity;
import com.t2010a.hellot2010aagain.entity.myenum.CategoryStatus;
import com.t2010a.hellot2010aagain.entity.myenum.ProductStatus;

import java.time.LocalDateTime;

public class Product extends BaseEntity {
    private int id; //String id UUID.
    private int categoryId;
    private String name;
    private String description;
    private String detail;
    private String thumbnail; //muc dich tao ra link nhin van minh hon.
    private double price; //BiDecimal
    private ProductStatus status;

    public Product() {
            this.setCreatedAt(LocalDateTime.now());
            this.setUpdatedAt(LocalDateTime.now());
            this.status = ProductStatus.ACTIVE;
    }

    public Product(int id, int categoryId, String name, String description, String detail, String thumbnail, double price, ProductStatus status) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
