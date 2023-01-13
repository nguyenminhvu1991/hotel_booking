package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.HotelEntity;

import java.util.List;

public interface HotelsService {
    //CREATE
    public abstract HotelEntity addHotel(HotelEntity hotelEntity);

    //READ
    public abstract List<HotelEntity> findAllHotel();

    public abstract HotelEntity findHotelById(int id);

    //UPDATE
    public abstract HotelEntity updateHotel(int id, HotelEntity hotelEntity);

    //DELETE
    public abstract boolean deleteHotelById(int id);
}
