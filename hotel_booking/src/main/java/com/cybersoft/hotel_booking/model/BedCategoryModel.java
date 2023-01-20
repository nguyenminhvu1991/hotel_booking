package com.cybersoft.hotel_booking.model;

public class BedCategoryModel {
    private int id = 0;
    private String bedCategory="";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBedCategory() {
        return bedCategory;
    }

    public void setBedCategory(String bedCategory) {
        this.bedCategory = bedCategory;
    }
}