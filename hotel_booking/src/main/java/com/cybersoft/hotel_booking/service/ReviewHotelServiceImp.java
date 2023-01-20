package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.ReviewEntity;
import com.cybersoft.hotel_booking.model.ReviewHotelModel;
import com.cybersoft.hotel_booking.repository.ReviewHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewHotelServiceImp implements ReviewHotelService {
    @Autowired
    ReviewHotelRepository reviewHotelRepository;
    @Override
    public List<ReviewHotelModel> findReviewsByHotelId(int id) {
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByHotelId(id);
        List<ReviewHotelModel> reviewHotelModelList = new ArrayList<>();
        for(ReviewEntity reviewEntity : reviewEntityList){
            ReviewHotelModel reviewHotelModel = new ReviewHotelModel();
            reviewHotelModel.setId(reviewEntity.getId());
            //reviewHotelModel.setHotelID(reviewEntity.getHotelId());
            reviewHotelModel.setHotelID(reviewEntity.getHotel().getId());

            //reviewHotelModel.setUserID(reviewEntity.getUsersId());
            reviewHotelModel.setUserID(reviewEntity.getUsers().getId());

            reviewHotelModel.setContent(reviewEntity.getContent());
            reviewHotelModel.setRateScore(reviewEntity.getRateScore());
            reviewHotelModel.setCreatedDate(reviewEntity.getCreatedDate());
            reviewHotelModelList.add(reviewHotelModel);
        }

        return reviewHotelModelList;
    }

    @Override
    public Float findAvgRateByHotelId(int id) {
        Float avgRate = 0.0f;
        avgRate = reviewHotelRepository.findAvgRateByHotelId(id);
        return avgRate;
    }
}