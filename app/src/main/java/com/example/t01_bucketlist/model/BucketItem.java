package com.example.t01_bucketlist.model;

public class BucketItem {
    String id;
    String imgPath;
    String name;
    String description;
    String amount;
    String date;
    String category;

    public BucketItem(String id, String imgPath, String name, String description, String amount, String date, String category) {
        this.id = id;
        this.imgPath = imgPath;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    BucketItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
