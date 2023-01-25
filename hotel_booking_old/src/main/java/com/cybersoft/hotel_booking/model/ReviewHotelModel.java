package com.cybersoft.hotel_booking.model;

import java.util.Date;

public class ReviewHotelModel {
    private int id = 0;
    private String content = "";
    private int hotelID = 0;
    private int usersID = 0;
    private float rateScore = 0;
    private Date createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getUsersID() {
        return usersID;
    }

    public void setUsersID(int userID) {
        this.usersID = userID;
    }

    public float getRateScore() {
        return rateScore;
    }

    public void setRateScore(float rateScore) {
        this.rateScore = rateScore;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}