package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.model.ReviewHotelModel;

import java.util.List;

public interface ReviewHotelService {
    public List<ReviewHotelModel> findReviewsByHotelId(int id);
    Float findAvgRateByHotelId(int id);
}