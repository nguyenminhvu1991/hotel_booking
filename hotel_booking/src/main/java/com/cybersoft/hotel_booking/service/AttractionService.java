package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.model.AttractionModel;
import com.cybersoft.hotel_booking.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AttractionService {
    public List<AttractionModel> findAttractionsByHotelId(int id);
}