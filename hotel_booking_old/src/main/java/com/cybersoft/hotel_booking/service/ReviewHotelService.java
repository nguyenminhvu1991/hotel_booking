package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.model.ReviewHotelModel;

import java.util.List;

public interface ReviewHotelService {
    public List<ReviewHotelModel> findReviewsByHotelId(int id);
    Float findAvgRateByHotelId(int id);

    public List<ReviewHotelModel> findReviewsByUserIdAndHotelId(int userId,int hotelId);
    public List<ReviewHotelModel> findReviewsByUserId(int id);

    public boolean addReview(ReviewHotelModel reviewHotelModel);
    public boolean updateReview(int userId,ReviewHotelModel reviewHotelModel);

    public boolean deleteReview(int id);
}