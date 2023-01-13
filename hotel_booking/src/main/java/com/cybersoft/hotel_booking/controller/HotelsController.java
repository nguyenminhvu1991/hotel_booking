package com.cybersoft.hotel_booking.controller;

import com.cybersoft.hotel_booking.entity.HotelEntity;
import com.cybersoft.hotel_booking.payload.response.DataResponse;
import com.cybersoft.hotel_booking.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelsController {
    @Autowired
    private HotelsService hotelsService;

    //CREATE
    @PostMapping("/add")
    public ResponseEntity<?> addHotel(@RequestBody HotelEntity hotelEntity, BindingResult bindingResult) {
        DataResponse dataResponse = new DataResponse();

        if (bindingResult.hasErrors()) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setSuccess(false);
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());//BAD REQUEST
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        HotelEntity hotelEntityAdded = hotelsService.addHotel(hotelEntity);

        dataResponse.setStatus(HttpStatus.CREATED.value());//201
        dataResponse.setSuccess(true);
        dataResponse.setDesc(HttpStatus.CREATED.getReasonPhrase());//CREATED
        dataResponse.setData(hotelEntityAdded);

        return ResponseEntity.ok(dataResponse);
    }

    //READ
    @GetMapping("/get")
    public ResponseEntity<?> findAllHotel() {
        DataResponse dataResponse = new DataResponse();

        List<HotelEntity> hotelEntityList = hotelsService.findAllHotel();

        if (hotelEntityList.isEmpty()) {//NO CONTENT
            dataResponse.setStatus(HttpStatus.NO_CONTENT.value());//204
            dataResponse.setSuccess(false);
            dataResponse.setDesc(HttpStatus.NO_CONTENT.getReasonPhrase());//NO CONTENT
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setSuccess(true);
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setData(hotelEntityList);

        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findHotelById(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();

        HotelEntity hotelEntity = hotelsService.findHotelById(id);

        if (hotelEntity == null) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setSuccess(false);
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setSuccess(true);
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setData(hotelEntity);

        return ResponseEntity.ok(dataResponse);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable("id") Integer id, @RequestBody HotelEntity hotelEntity, BindingResult bindingResult) {
        DataResponse dataResponse = new DataResponse();

        if (bindingResult.hasErrors()) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setSuccess(false);
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());//BAD REQUEST
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        HotelEntity hotelEntityUpdated = hotelsService.updateHotel(id, hotelEntity);

        if (hotelEntityUpdated == null) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setSuccess(false);
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setSuccess(true);
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setData(hotelEntityUpdated);

        return ResponseEntity.ok(dataResponse);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();

        boolean success = hotelsService.deleteHotelById(id);

        if (!success) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setSuccess(false);
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setSuccess(true);
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setData("");

        return ResponseEntity.ok(dataResponse);
    }
}
