package com.cybersoft.hotel_booking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionModel {
    private int id = 0; //Hưng
    private String name = "";
    private int hotelID = 0;
    private float distance = 0;
    private String image = "";
//    private int id; //code cũ
//    private String name;
//    private float distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
