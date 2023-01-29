package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.RoomEntity;
import com.cybersoft.hotel_booking.DTO.RoomDetailDTO;
import com.cybersoft.hotel_booking.model.RoomCategoryModel;
import com.cybersoft.hotel_booking.payload.request.SearchRequest;

import java.util.List;

public interface RoomService {

    public List<RoomDetailDTO> findRoomsByHotelId(int id); //Hung
    public List<RoomDetailDTO> findRoomsByHotelIdAndSearchRequest(int id, SearchRequest searchRequest); //Đại
    //CRUD
    RoomEntity addRoom(RoomEntity roomEntity);
    List<RoomEntity> findAllRoom();
    RoomEntity findRoomById(Integer id);
    RoomEntity updateRoom(Integer id, RoomEntity roomEntity);
    boolean deleteRoomById(Integer id);
}