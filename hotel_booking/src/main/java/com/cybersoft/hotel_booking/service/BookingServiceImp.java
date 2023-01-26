package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.DTO.BookingDTO;
import com.cybersoft.hotel_booking.entity.*;
import com.cybersoft.hotel_booking.repository.BookingRepository;
import com.cybersoft.hotel_booking.repository.BookingRoomRepository;
import com.cybersoft.hotel_booking.repository.RoomRepository;
import com.cybersoft.hotel_booking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRoomRepository bookingRoomRepository;

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

    //add booking
    @Override
    public String addBooking(int userId, int roomId, BookingEntity bookingEntity) {
        UsersEntity usersEntity = usersRepository.findById(userId).orElse(null);
        RoomEntity roomEntity = roomRepository.findById(roomId).orElse(null);

        //kiểm tra room tồn tại
        if (roomEntity == null) {
            return " - not found room";
        }

        //kiểm tra adultNumber <= maxOccupyAdult & childNumber <= maxOccupyChild
        int adultNumber = bookingEntity.getAdultNumber();
        int childNumber = bookingEntity.getChildNumber();
        int maxOccupyAdult = roomEntity.getMaxOccupyAdult();
        int maxOccupyChild = roomEntity.getMaxOccupyChild();
        if (adultNumber > maxOccupyAdult || childNumber > maxOccupyChild) {
            return " - adult number or child number exceed";
        }

        //kiểm tra checkIn < checkOut
        Date checkIn = bookingEntity.getCheckIn();
        Date checkOut = bookingEntity.getCheckOut();
        if (checkIn.compareTo(checkOut) >= 0) {
            return " - checkin, checkout invalid";
        }

        //kiểm tra ngày có available hay không
        Set<RoomDatesEntity> roomDatesEntitySet = roomEntity.getRoomDatesEntitySet();
        if (!checkRoomAvailable(formatDate(checkIn), formatDate(checkOut), roomDatesEntitySet)) {
            return " - room is not available";
        }

        //tính total price
        int totalDay = calculateTotalDay(checkIn, checkOut);
        float price = roomEntity.getPrice();
        float totalPrice = bookingEntity.getTotalPrice();
        totalPrice += (price * totalDay);

        //tạo booking
        bookingEntity.setId(0);
        bookingEntity.setBookingStatus("open");
        bookingEntity.setTotalPrice(totalPrice);
        bookingEntity.setPaidDate(new Date());
        bookingEntity.setUsers(usersEntity);
        bookingRepository.save(bookingEntity);

        //tạo booking_room
        BookingRoomEntity bookingRoomEntity = new BookingRoomEntity();
        bookingRoomEntity.setBooking(bookingEntity);
        bookingRoomEntity.setRoom(roomEntity);
        bookingRoomRepository.save(bookingRoomEntity);

        //cập nhật status trong room_dates
        updateRoomStatus(formatDate(checkIn), formatDate(checkOut), roomDatesEntitySet);
        roomRepository.save(roomEntity);

        return null;
    }

    private boolean checkRoomAvailable(Date checkIn, Date checkOut, Set<RoomDatesEntity> roomDatesEntitySet) {
        for (RoomDatesEntity roomDatesEntity : roomDatesEntitySet) {
            Date date = roomDatesEntity.getCalendarEntity().getDt();
            if ((date.compareTo(checkIn) >= 0) && (date.compareTo(checkOut) < 0)) {
                if (roomDatesEntity.getRoomStatus() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateRoomStatus(Date checkIn, Date checkOut, Set<RoomDatesEntity> roomDatesEntitySet) {
        for (RoomDatesEntity roomDatesEntity : roomDatesEntitySet) {
            Date date = roomDatesEntity.getCalendarEntity().getDt();
            if ((date.compareTo(checkIn) >= 0) && (date.compareTo(checkOut) < 0)) {
                roomDatesEntity.setRoomStatus(0);
            }
        }
    }

    private int calculateTotalDay(Date checkIn, Date checkOut) {
        long checkInMilisec = checkIn.getTime();
        long checkOutMilisec = checkOut.getTime();
        long totalDayMilisec = checkOutMilisec - checkInMilisec;

        return (int) (totalDayMilisec / (24 * 60 * 60 * 1000));
    }

    private Date formatDate(Date date) {
        long dateMilisec = date.getTime();
        dateMilisec -= (7 * 60 * 60 * 1000);

        return new Date(dateMilisec);//convert '2023-01-01 07:00:00' into '2023-01-01 00:00:00'
    }
}