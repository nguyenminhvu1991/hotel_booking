package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.ReviewEntity;
import com.cybersoft.hotel_booking.model.ReviewHotelModel;
import com.cybersoft.hotel_booking.repository.ReviewHotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewHotelServiceImp implements ReviewHotelService {
    @Autowired
    ReviewHotelRepository reviewHotelRepository;

    @Autowired
    ModelMapper modelMapper;
//    @Override
//    public List<ReviewHotelModel> findReviewsByHotelId(int id) {
//        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByHotelId(id);
//        List<ReviewHotelModel> reviewHotelModelList = new ArrayList<>();
//        for(ReviewEntity reviewEntity : reviewEntityList){
//            ReviewHotelModel reviewHotelModel = new ReviewHotelModel();
//            reviewHotelModel.setId(reviewEntity.getId());
//            //reviewHotelModel.setHotelID(reviewEntity.getHotelId());
//            reviewHotelModel.setHotelID(reviewEntity.getHotel().getId());
//
//            //reviewHotelModel.setUserID(reviewEntity.getUsersId());
//            reviewHotelModel.setUsersID(reviewEntity.getUsers().getId());
//
//            reviewHotelModel.setContent(reviewEntity.getContent());
//            reviewHotelModel.setRateScore(reviewEntity.getRateScore());
//            reviewHotelModel.setCreatedDate(reviewEntity.getCreatedDate());
//            reviewHotelModelList.add(reviewHotelModel);
//        }
//
//        return reviewHotelModelList;
//    }

    @Override
    public Float findAvgRateByHotelId(int id) {
        Float avgRate = 0.0f;
        avgRate = reviewHotelRepository.findAvgRateByHotelId(id);
        return avgRate;
    }

    @Override
    public List<ReviewHotelModel> findReviewsByHotelId(int id) {
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByHotelId(id);
        return parseReviewEntityListToReviewModelList(reviewEntityList);
    }

    @Override
    public List<ReviewHotelModel> findReviewsByUserId(int id) {
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByUserId(id);
        return parseReviewEntityListToReviewModelList(reviewEntityList);

    }



    private List<ReviewHotelModel> parseReviewEntityListToReviewModelList(List<ReviewEntity> reviewEntityList) {
        List<ReviewHotelModel> reviewHotelModelList = new ArrayList<>();
        for(ReviewEntity reviewEntity : reviewEntityList){
            ReviewHotelModel reviewHotelModel = new ReviewHotelModel();
            reviewHotelModel.setId(reviewEntity.getId());
            //reviewHotelModel.setHotelID(reviewEntity.getHotelId());
            reviewHotelModel.setHotelID(reviewEntity.getHotel().getId());
            //reviewHotelModel.setUsersID(reviewEntity.getUsersId());
            reviewHotelModel.setUsersID(reviewEntity.getUsers().getId());
            reviewHotelModel.setContent(reviewEntity.getContent());
            reviewHotelModel.setRateScore(reviewEntity.getRateScore());
            reviewHotelModel.setCreatedDate(reviewEntity.getCreatedDate());
            reviewHotelModelList.add(reviewHotelModel);
        }

        return reviewHotelModelList;
    }

    @Override
    public List<ReviewHotelModel> findReviewsByUserIdAndHotelId(int userId,int hotelId) {
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByUserIdAndHotelId(userId, hotelId);
        return parseReviewEntityListToReviewModelList(reviewEntityList);
    }


    @Override
    public boolean addReview(ReviewHotelModel reviewHotelModel) {
        ReviewEntity reviewEntity = this.modelMapper.map(reviewHotelModel,ReviewEntity.class);
        try {
            reviewHotelRepository.save(reviewEntity);
            return true;
        }catch (Exception e){
            System.out.println("Message : " + e);
            return false;
        }
    }

    @Override
    public boolean updateReview(int reviewId, ReviewHotelModel reviewHotelModel) {
        Optional<ReviewEntity> reviewEntity = reviewHotelRepository.findById(reviewId);
        ReviewEntity reviewEntity2 = this.modelMapper.map(reviewHotelModel,ReviewEntity.class);
        if(reviewEntity.isPresent()){
            reviewEntity2.setId(reviewId);
            reviewHotelRepository.save(reviewEntity2);
            return true;
        }
        return false;


    }

    @Override
    public boolean deleteReview(int id) {
        try {
            reviewHotelRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println("Message : " + e);
            return false;
        }
    }



}