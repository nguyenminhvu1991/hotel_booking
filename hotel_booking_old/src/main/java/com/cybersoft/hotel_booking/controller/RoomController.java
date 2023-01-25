package com.cybersoft.hotel_booking.controller;

import com.cybersoft.hotel_booking.entity.RoomEntity;
import com.cybersoft.hotel_booking.payload.response.DataResponse;
import com.cybersoft.hotel_booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //CRUD
    @PostMapping("")
    public ResponseEntity<?> addRoom(@RequestBody RoomEntity roomEntity, BindingResult bindingResult) {
        DataResponse dataResponse = new DataResponse();

        if (bindingResult.hasErrors()) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());//BAD REQUEST
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        RoomEntity roomEntityAdded = roomService.addRoom(roomEntity);

        dataResponse.setStatus(HttpStatus.CREATED.value());//201
        dataResponse.setDesc(HttpStatus.CREATED.getReasonPhrase());//CREATED
        dataResponse.setSuccess(true);
        dataResponse.setData(roomEntityAdded);

        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("")
    public ResponseEntity<?> findAllRoom() {
        DataResponse dataResponse = new DataResponse();

        List<RoomEntity> roomEntityList = roomService.findAllRoom();

        if (roomEntityList.isEmpty()) {//NO CONTENT
            dataResponse.setStatus(HttpStatus.NO_CONTENT.value());//204
            dataResponse.setDesc(HttpStatus.NO_CONTENT.getReasonPhrase());//NO CONTENT
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(roomEntityList);

        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findRoomById(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();

        RoomEntity roomEntity = roomService.findRoomById(id);

        if (roomEntity == null) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(roomEntity);

        return ResponseEntity.ok(dataResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable("id") Integer id, @RequestBody RoomEntity roomEntity, BindingResult bindingResult) {
        DataResponse dataResponse = new DataResponse();

        if (bindingResult.hasErrors()) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());//BAD REQUEST
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        RoomEntity roomEntityUpdated = roomService.updateRoom(id, roomEntity);

        if (roomEntityUpdated == null) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(roomEntityUpdated);

        return ResponseEntity.ok(dataResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();

        boolean success = roomService.deleteRoomById(id);

        if (!success) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData("");

        return ResponseEntity.ok(dataResponse);
    }
}