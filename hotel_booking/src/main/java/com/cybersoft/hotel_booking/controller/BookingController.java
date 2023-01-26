package com.cybersoft.hotel_booking.controller;

import com.cybersoft.hotel_booking.DTO.BookingDTO;
import com.cybersoft.hotel_booking.entity.BookingEntity;
import com.cybersoft.hotel_booking.entity.BookingRoomEntity;
import com.cybersoft.hotel_booking.entity.UsersEntity;
import com.cybersoft.hotel_booking.jwt.JwtTokenFilter;
import com.cybersoft.hotel_booking.jwt.JwtTokenHelper;
import com.cybersoft.hotel_booking.model.BookingModel;
import com.cybersoft.hotel_booking.payload.response.DataResponse;
import com.cybersoft.hotel_booking.repository.BookingRepository;
import com.cybersoft.hotel_booking.repository.UsersRepository;
import com.cybersoft.hotel_booking.service.BookingService;
import com.cybersoft.hotel_booking.service.CityProvinceServiceImp;
import com.cybersoft.hotel_booking.service.UsersService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    JwtTokenHelper jwtTokenHelper;
    @Autowired
    JwtTokenFilter jwtTokenFilter;
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CityProvinceServiceImp cityProvinceServiceImp;


    @GetMapping("/{userId}")
    public ResponseEntity<?> findBookingByUserId(@PathVariable("userId") Integer userId) {
        DataResponse dataResponse = new DataResponse();
//        Gson gson = new Gson();
//        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring(7);
//        String json = jwtTokenHelper.decodeToken(token);
//        Map map = gson.fromJson(json, Map.class);
//        String email = map.get("username").toString();
//        UsersEntity user = usersRepository.findByEmail(email).get(0);
//        List<BookingDTO> listBooking = bookingService.findAllBookingByUsersId(user.getId());
        List<BookingDTO> listBooking = bookingService.findAllBookingByUsersId(userId);
        if (listBooking.size() == 0) {
            dataResponse.setStatus(HttpStatus.OK.value());//200
            dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
            dataResponse.setSuccess(true);
            dataResponse.setData("Is Empty");
        } else {
            dataResponse.setStatus(HttpStatus.OK.value());//200
            dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
            dataResponse.setSuccess(true);
            dataResponse.setData(listBooking);
        }

        return ResponseEntity.ok(dataResponse);

    }

    @GetMapping("{userId}/{hotelId}")
    public ResponseEntity<?> findBookingByUserIdAndHotelId(@PathVariable("userId") Integer userId, @PathVariable("hotelId") Integer hotelId) {
        DataResponse dataResponse = new DataResponse();
//        Gson gson = new Gson();
//        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring(7);
//        String json = jwtTokenHelper.decodeToken(token);
//        Map map = gson.fromJson(json, Map.class);
//        String email = map.get("username").toString();
//        UsersEntity user = usersRepository.findByEmail(email).get(0);
//        List<BookingDTO> listBooking = bookingService.findAllBookingByUsersIdAndHotelId(user.getId(), id);
        List<BookingDTO> listBooking = bookingService.findBookingByUsersIdAndHotelId(userId, hotelId);
        System.out.println(hotelId);
        if (listBooking.isEmpty()) {
            dataResponse.setStatus(HttpStatus.OK.value());//200
            dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
            dataResponse.setSuccess(true);
            dataResponse.setData("Is Empty");
        } else {
            dataResponse.setStatus(HttpStatus.OK.value());//200
            dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
            dataResponse.setSuccess(true);
            dataResponse.setData(listBooking);
        }

        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("/detail/{userId}/{bookingId}")
    public ResponseEntity<?> getBookingDetail(@PathVariable("userId") Integer userId, @PathVariable("bookingId") Integer bookingId ) {
        DataResponse dataResponse = new DataResponse();
//        Gson gson = new Gson();
//        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring(7);
//        String json = jwtTokenHelper.decodeToken(token);
//        Map map = gson.fromJson(json, Map.class);
//        String email = map.get("username").toString();
//        UsersEntity user = usersRepository.findByEmail(email).get(0);
        BookingDTO bookingDetail =  bookingService.findBookingDetailByIDAndUserId(bookingId,userId);
        if (bookingDetail==null){
            dataResponse.setStatus(HttpStatus.OK.value());//200
            dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
            dataResponse.setSuccess(true);
            dataResponse.setData("Is empty");
        } else {
            dataResponse.setStatus(HttpStatus.OK.value());//200
            dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
            dataResponse.setSuccess(true);
            dataResponse.setData(bookingDetail);
        }
        return ResponseEntity.ok(dataResponse);

    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancel(@PathVariable("id") int id) {
        return ResponseEntity.ok(cityProvinceServiceImp.cancel(id));
    }

    @PostMapping("/{userId}/{roomId}")
    public ResponseEntity<?> addBooking(@PathVariable("userId") int userId, @PathVariable("roomId") int roomId, @RequestBody BookingEntity bookingEntity) {
        DataResponse dataResponse = new DataResponse();

        String message = bookingService.addBooking(userId, roomId, bookingEntity);

        if (message != null) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase() + message);//BAD REQUEST
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(bookingEntity);

        return ResponseEntity.ok(dataResponse);
    }
}