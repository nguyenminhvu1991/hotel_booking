package com.cybersoft.hotel_booking.service;


import com.cybersoft.hotel_booking.DTO.CityHotelDTO;
import com.cybersoft.hotel_booking.DTO.CityProvinceDTO;

public interface CityService {

    public CityProvinceDTO findByCityId(int id); //Hưng
    public CityHotelDTO findByIdCity(int id); //Hưng
}
