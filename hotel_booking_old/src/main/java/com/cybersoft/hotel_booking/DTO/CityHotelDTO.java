package com.cybersoft.hotel_booking.DTO;

import com.cybersoft.hotel_booking.model.HotelModel;

import java.util.List;

public class CityHotelDTO {
    private int id;
    private String city;
    private List<HotelModel> hotelModelList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<HotelModel> getHotelModelList() {
        return hotelModelList;
    }

    public void setHotelModelList(List<HotelModel> hotelModelList) {
        this.hotelModelList = hotelModelList;
    }
}