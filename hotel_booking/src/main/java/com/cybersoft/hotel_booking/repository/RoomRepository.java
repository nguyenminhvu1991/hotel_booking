package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

}