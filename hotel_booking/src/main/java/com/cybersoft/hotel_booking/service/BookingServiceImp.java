package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.DTO.BookingDTO;
import com.cybersoft.hotel_booking.entity.BookingEntity;
import com.cybersoft.hotel_booking.entity.BookingRoomEntity;
import com.cybersoft.hotel_booking.entity.UsersEntity;
import com.cybersoft.hotel_booking.repository.BookingRepository;
import com.cybersoft.hotel_booking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UsersRepository usersRepository;

//    @Override
//    public List<BookingEntity> findAllBookingByUsers(UsersEntity usersEntity) {
//        return bookingRepository.findByUsers(usersEntity).size() > 0 ?
//                bookingRepository.findByUsers(usersEntity) : null;
//    }

    @Override
    public List<BookingDTO> findAllBookingByUsersId(int userId) {
        return bookingRepository.findBookingByUsersId(userId);
    }

    @Override
    public List<BookingDTO> findBookingByUsersIdAndHotelId(int userId, int hotelId){
        return bookingRepository.findBookingByUsersIdAndHotelId(userId, hotelId);
    }

    @Override
    public BookingDTO findBookingDetailByIDAndUserId(int bookingId, int userId){
        return bookingRepository.findBookingDetailByIDAndUserId(bookingId, userId).size() > 0 ?
                bookingRepository.findBookingDetailByIDAndUserId(bookingId,userId).get(0) : null;
    }

    public List<BookingEntity> cancel(int bookingId) {
        List<BookingEntity> bookingEntities = bookingRepository.findById(bookingId);
        for (BookingEntity bookingEntity : bookingEntities) {
            bookingEntities.get(0).setCancelDate(new Date());
            bookingEntities.get(0).setBookingStatus("cancel");
            for (BookingRoomEntity bookingRoomEntity : bookingEntity.getBookingRoomEntitySet()) {
                bookingRoomEntity.getRoom().getRoomDatesEntitySet().stream()
                        .filter(roomDatesEntity -> (roomDatesEntity.getRoomStatus() == 0))
                        .forEach(roomDatesEntity -> roomDatesEntity.setRoomStatus(1));
            }
        }
        return bookingRepository.saveAll(bookingEntities);

    }
}