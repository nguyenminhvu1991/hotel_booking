package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.RoomEntity;

import java.util.List;

public interface RoomService {
    //CRUD
    RoomEntity addRoom(RoomEntity roomEntity);
    List<RoomEntity> findAllRoom();
    RoomEntity findRoomById(Integer id);
    RoomEntity updateRoom(Integer id, RoomEntity roomEntity);
    boolean deleteRoomById(Integer id);
}