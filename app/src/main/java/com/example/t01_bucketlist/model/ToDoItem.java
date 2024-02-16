package com.example.t01_bucketlist.model;

public class ToDoItem {
    String Id;
    String Title;
    String Place;
    String Description;
    String CDate;
    String Tdate;
    String category;

    ToDoItem() {
        Id = "";
        Title = "";
        Place = "";
        Description = "";
        CDate = "";
        Tdate = "";
        category = "";
    }

    public ToDoItem(String id, String title, String place, String description, String CDate, String tdate, String wcategory) {
        Id = id;
        Title = title;
        Place = place;
        Description = description;
        this.CDate = CDate;
        Tdate = tdate;
        this.category = category;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCDate() {
        return CDate;
    }

    public void setCDate(String CDate) {
        this.CDate = CDate;
    }

    public String getTdate() {
        return Tdate;
    }

    public void setTdate(String tdate) {
        Tdate = tdate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
