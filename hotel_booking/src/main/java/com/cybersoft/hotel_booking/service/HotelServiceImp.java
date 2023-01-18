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
    public HotelEntity findHotelById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public HotelEntity updateHotel(Integer id, HotelEntity hotelEntity) {
        boolean exist = hotelRepository.existsById(id);
        if (exist) {
            hotelEntity.setId(id);
            return hotelRepository.save(hotelEntity);
        }
        return null;
    }

    @Override
    public boolean deleteHotelById(Integer id) {
        boolean exist = hotelRepository.existsById(id);
        if (exist) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
