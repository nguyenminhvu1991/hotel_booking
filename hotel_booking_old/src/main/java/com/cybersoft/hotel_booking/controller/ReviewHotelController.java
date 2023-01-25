package com.cybersoft.hotel_booking.controller;

import com.cybersoft.hotel_booking.entity.HotelEntity;
import com.cybersoft.hotel_booking.entity.ReviewEntity;
import com.cybersoft.hotel_booking.model.ReviewHotelModel;
import com.cybersoft.hotel_booking.payload.response.DataResponse;
import com.cybersoft.hotel_booking.repository.ReviewHotelRepository;
import com.cybersoft.hotel_booking.service.ReviewHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewHotelController {
    @Autowired
    ReviewHotelService reviewHotelService;
    @Autowired
    ReviewHotelRepository reviewHotelRepository;


    @GetMapping("/find/user/{userId}")
    public ResponseEntity<?> findReviewsByUserId(@PathVariable("userId") int id){
        DataResponse dataResponse = new DataResponse();
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByUserId(id);
        if(reviewEntityList.isEmpty()){
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Tìm reviews thất bại ");
            dataResponse.setData(null);
            return new ResponseEntity<>(dataResponse,HttpStatus.NOT_FOUND);
        }else{
            List<ReviewHotelModel> reviewHotelModelList = reviewHotelService.findReviewsByUserId(id);
            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Tìm reviews thành công ");
            dataResponse.setData(reviewHotelModelList);
            return new ResponseEntity<>(dataResponse,HttpStatus.OK);
        }
    }
    @GetMapping("/find/userhotel/{userId}/{hotelId}")
    public ResponseEntity<?> findReviewsByUserIdAndHotelId(@PathVariable("userId") int userId,@PathVariable("hotelId") int hotelId){
        DataResponse dataResponse = new DataResponse();
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByUserIdAndHotelId(userId, hotelId);
        if(reviewEntityList.isEmpty()){
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Tìm reviews thất bại ");
            dataResponse.setData("");
            return new ResponseEntity<>(dataResponse,HttpStatus.NOT_FOUND);
        }else{
            List<ReviewHotelModel> reviewHotelModelList = reviewHotelService.findReviewsByUserIdAndHotelId(userId, hotelId);
            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Tìm reviews thành công ");
            dataResponse.setData(reviewHotelModelList);
            return new ResponseEntity<>(dataResponse,HttpStatus.OK);
        }
    }
    @GetMapping("/find/hotel/{hotelId}")
    public ResponseEntity<?> findReviewsByHotelId(@PathVariable("hotelId") int id){
        DataResponse dataResponse = new DataResponse();
        List<ReviewEntity> reviewEntityList = reviewHotelRepository.findReviewsByHotelId(id);
        if(reviewEntityList.isEmpty()){
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Tìm reviews thất bại ");
            dataResponse.setData(null);
            return new ResponseEntity<>(dataResponse,HttpStatus.NOT_FOUND);
        }else{
            List<ReviewHotelModel> reviewHotelModelList = reviewHotelService.findReviewsByHotelId(id);
            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Tìm reviews thành công ");
            dataResponse.setData(reviewHotelModelList);
            return new ResponseEntity<>(dataResponse,HttpStatus.OK);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestBody ReviewHotelModel reviewHotelModel) {
        DataResponse dataResponse = new DataResponse();
        if(reviewHotelService.addReview(reviewHotelModel)) {
            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Add review thành công ");
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } else {

            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Add review thất bại");
            return new ResponseEntity<>(dataResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReview(@PathVariable("id") Integer id,@RequestBody ReviewHotelModel reviewHotelModel) {
        DataResponse dataResponse = new DataResponse();
        if(reviewHotelService.updateReview(id,reviewHotelModel)) {
            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Update review thành công ");
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } else {

            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Update review thất bại");
            return new ResponseEntity<>(dataResponse, HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();
        if(reviewHotelService.deleteReview(id)) {
            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Delete review thành công ");
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } else {

            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Delete review thất bại");
            return new ResponseEntity<>(dataResponse, HttpStatus.BAD_REQUEST);
        }

    }

}