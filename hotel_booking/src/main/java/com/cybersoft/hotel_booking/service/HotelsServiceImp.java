package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.HotelEntity;
import com.cybersoft.hotel_booking.repository.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelsServiceImp implements HotelsService {
    @Autowired
    private HotelsRepository hotelsRepository;

    //CREATE
    @Override
    public HotelEntity addHotel(HotelEntity hotelEntity) {
        hotelEntity.setId(0);
        return hotelsRepository.save(hotelEntity);
    }

    //READ
    @Override
    public List<HotelEntity> findAllHotel() {
        return hotelsRepository.findAll();
    }

    @Override
    public HotelEntity findHotelById(int id) {
        return hotelsRepository.findById(id).orElse(null);
    }

    //UPDATE
    @Override
    public HotelEntity updateHotel(int id, HotelEntity hotelEntity) {
        HotelEntity hotelEntityFromDB = hotelsRepository.findById(id).orElse(null);
        if (hotelEntityFromDB != null) {
            hotelEntity.setId(id);
            return hotelsRepository.save(hotelEntity);
        }
        return null;
    }

    //DELETE
    @Override
    public boolean deleteHotelById(int id) {
        HotelEntity hotelEntityFromDB = hotelsRepository.findById(id).orElse(null);
        if (hotelEntityFromDB != null) {
            hotelsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
