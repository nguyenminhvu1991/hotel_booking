package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.RoomEntity;
import com.cybersoft.hotel_booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybersoft.hotel_booking.DTO.RoomDetailDTO;
import com.cybersoft.hotel_booking.model.RoomCategoryModel;


import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
//    @Autowired
//    private RoomRepository roomRepository;

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BedCategoryService bedCategoryService;
    @Autowired
    RoomCategoryService roomCategoryService;
    @Override
    public List<RoomDetailDTO> findRoomsByHotelId(int hotelId) { //Hưng
        List<RoomEntity> roomEntityList = roomRepository.findRoomEntitiesByHotelId(hotelId);//VŨ SỬA TỪ HƯNG: id => hotelId
        List<RoomDetailDTO> roomDetailDTOList = new ArrayList<>();
        for(RoomEntity roomEntity : roomEntityList){
            RoomDetailDTO roomDetailDTO = new RoomDetailDTO();
            roomDetailDTO.setId(roomEntity.getId());
            roomDetailDTO.setRoomName(roomEntity.getRoomName());
            roomDetailDTO.setPrice(roomEntity.getPrice());
            roomDetailDTO.setHotelId(hotelId);
            roomDetailDTO.setMaxOccupyAdult(roomEntity.getMaxOccupyAdult());
            roomDetailDTO.setMaxOccupyChild(roomEntity.getMaxOccupyChild());
            //roomDetailDTO.setBedCategoryId(roomEntity.getBedCategoryId());//Vũ comment
            roomDetailDTO.setBedCategory(roomEntity.getBedCategoryEntity().getBedCategory());
            //roomDetailDTO.setBedCategoryModel(bedCategoryService.findBedModelById(roomEntity.getBedCategoryId()));//Vũ comment
            //roomDetailDTO.setRoomCategoryModel(roomCategoryService.findRoomModelById(roomEntity.getRoomCategoryId())); //Vũ comment
            roomDetailDTO.setRoomCategory(roomEntity.getRoomCategoryEntity().getRoomCategory());
            roomDetailDTOList.add(roomDetailDTO);
        }
        return roomDetailDTOList;
    }

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