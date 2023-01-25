package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.RoomCategoryEntity;
import com.cybersoft.hotel_booking.model.RoomCategoryModel;
import com.cybersoft.hotel_booking.repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomCategoryServiceImp implements RoomCategoryService {
    @Autowired
    RoomCategoryRepository roomCategoryRepository;
    @Override
    public RoomCategoryModel findRoomModelById(int id) {
        Optional<RoomCategoryEntity> roomCategoryEntity = roomCategoryRepository.findById(id);
        RoomCategoryModel roomCategoryModel = new RoomCategoryModel();
        roomCategoryModel.setId(roomCategoryEntity.get().getId());
        roomCategoryModel.setRoomCategory(roomCategoryEntity.get().getRoomCategory());
        return roomCategoryModel;
    }
}