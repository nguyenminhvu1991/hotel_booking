package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.HotelServiceEntity;
import com.cybersoft.hotel_booking.model.ServiceModel;
import com.cybersoft.hotel_booking.repository.HotelServiceRepository;
//import com.cybersoft.hotel_booking.repository.ServiceHotelRepository;
//import com.cybersoft.hotel_booking.repository.ServiceOfHotelRepository;
import com.cybersoft.hotel_booking.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceServiceImp implements HotelServiceService { //ServiceOfHotelServiceImp

    @Autowired
    HotelServiceRepository hotelServiceRepository;//ServiceOfHotelRepository
    @Autowired
    ServiceService serviceService; //ServiceHotelService

    @Override
    public List<ServiceModel> findServiceByHotelId(int id) {
        List<HotelServiceEntity> hotelServiceEntityList = hotelServiceRepository.findHotelServiceByHotelId(id);

        List<ServiceModel> serviceModelList = new ArrayList<>();
        for(HotelServiceEntity hotelServiceEntity : hotelServiceEntityList){
            //ServiceModel serviceModel = serviceHotelService.findById(hotelServiceEntity.getServiceId());
            ServiceModel serviceModel = serviceService.findById(hotelServiceEntity.getService().getId());
            serviceModelList.add(serviceModel);
        }
        return serviceModelList;
    }
}
