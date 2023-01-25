package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.ServiceEntity;
import com.cybersoft.hotel_booking.model.ServiceModel;
import com.cybersoft.hotel_booking.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImp implements ServiceService {//ServiceHotelServiceImp by Hưng
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public ServiceModel findById(int id) {
        Optional<ServiceEntity> serviceEntity = serviceRepository.findById(id);
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setId(serviceEntity.get().getId());
        serviceModel.setName(serviceEntity.get().getService());
        return serviceModel;
    }
}