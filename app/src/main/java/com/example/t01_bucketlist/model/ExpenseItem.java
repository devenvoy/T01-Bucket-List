package com.example.t01_bucketlist.model;

public class ExpenseItem {
    String id;
    String amount;
    String Description;
    String Date;
    String Category;

    public ExpenseItem(String id, String amount, String description, String date, String category) {
        this.id = id;
        this.amount = amount;
        Description = description;
        Date = date;
        Category = category;
    }

    ExpenseItem() {
        id = "";
        amount = "";
        Description = "";
        Date = "";
        Category = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
