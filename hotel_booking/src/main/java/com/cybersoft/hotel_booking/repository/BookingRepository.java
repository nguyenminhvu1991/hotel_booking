package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
    List<BookingEntity> findById(int bookingId);
}
