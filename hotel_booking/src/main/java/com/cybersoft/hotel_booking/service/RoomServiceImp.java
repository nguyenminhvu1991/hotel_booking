package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.RoomEntity;
import com.cybersoft.hotel_booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    //CRUD
    @Override
    public RoomEntity addRoom(RoomEntity roomEntity) {
        roomEntity.setId(0);
        return roomRepository.save(roomEntity);
    }

    @Override
    public List<RoomEntity> findAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity findRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public RoomEntity updateRoom(Integer id, RoomEntity roomEntity) {
        boolean exist = roomRepository.existsById(id);
        if (exist) {
            roomEntity.setId(id);
            return roomRepository.save(roomEntity);
        }
        return null;
    }

    @Override
    public boolean deleteRoomById(Integer id) {
        boolean exist = roomRepository.existsById(id);
        if (exist) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}