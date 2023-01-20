package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.model.ServiceModel;

import java.util.List;

public interface HotelServiceService  { //ServiceOfHotelService
    List<ServiceModel> findServiceByHotelId(int id);
}