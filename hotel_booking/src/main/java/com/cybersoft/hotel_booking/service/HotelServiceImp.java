package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.HotelEntity;
import com.cybersoft.hotel_booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    //CRUD
    @Override
    public HotelEntity addHotel(HotelEntity hotelEntity) {
        hotelEntity.setId(0);
        return hotelRepository.save(hotelEntity);
    }

    @Override
    public List<HotelEntity> findAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public HotelEntity findHotelById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public HotelEntity updateHotel(int id, HotelEntity hotelEntity) {
        HotelEntity hotelEntityFromDB = hotelRepository.findById(id).orElse(null);
        if (hotelEntityFromDB != null) {
            hotelEntity.setId(id);
            return hotelRepository.save(hotelEntity);
        }
        return null;
    }

//    @Override //comment by Vu
//    public boolean deleteAllHotel() {
//        List<HotelEntity> hotelEntityList = hotelRepository.findAll();
//        if (!hotelEntityList.isEmpty()) {
//            hotelRepository.deleteAll();
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean deleteHotelById(int id) {
        HotelEntity hotelEntityFromDB = hotelRepository.findById(id).orElse(null);
        if (hotelEntityFromDB != null) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
