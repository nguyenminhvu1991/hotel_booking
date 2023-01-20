package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.AttractionEntity;
import com.cybersoft.hotel_booking.model.AttractionModel;
import com.cybersoft.hotel_booking.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttractionServiceImp implements AttractionService {
    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public List<AttractionModel> findAttractionsByHotelId(int id) {

//        List<AttractionModel> listModel = new ArrayList<>();
//        List<AttractionEntity> listEntity = hotelRepository.findAll();
//        for(AttractionEntity data: listEntity ){
//            AttractionModel attractionModel = new AttractionModel();
//            attractionModel.setId(data.getId());
//            attractionModel.setName(data.getName());
//            attractionModel.setDistance(data.getDistance());
//            attractionModel.setImage(data.getImage());
//            attractionModel.setHotelID(data.getHotelId());
//            listModel.add(attractionModel);
//        }
//        return listModel;
//    }
        List<AttractionModel> listModel = new ArrayList<>();
        List<AttractionEntity> attractionEntityList = attractionRepository.findAttractionsByHotelId(id);
        for(AttractionEntity data: attractionEntityList ){
            AttractionModel attractionModel = new AttractionModel();
            attractionModel.setId(data.getId());
            attractionModel.setName(data.getName());
            attractionModel.setDistance(data.getDistance());
            attractionModel.setImage(data.getImage());
            attractionModel.setHotelID(data.getHotel().getId());//Vũ sửa từ Hưng: data.getHotelID()
            listModel.add(attractionModel);
        }
        return listModel;
    }
}