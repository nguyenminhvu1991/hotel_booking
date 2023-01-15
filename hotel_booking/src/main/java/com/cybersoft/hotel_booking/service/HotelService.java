package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.HotelEntity;

import java.util.List;

public interface HotelService {
    //CRUD
    HotelEntity addHotel(HotelEntity hotelEntity);
    List<HotelEntity> findAllHotel();
    HotelEntity findHotelById(int id);
    HotelEntity updateHotel(int id, HotelEntity hotelEntity);
    boolean deleteAllHotel();
    boolean deleteHotelById(int id);
}
