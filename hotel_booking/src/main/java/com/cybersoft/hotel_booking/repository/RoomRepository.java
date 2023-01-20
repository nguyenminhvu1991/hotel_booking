package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

//Hưng bổ sung , repo này tạo bởi Trường cho Crud Room
    @Query(value = "SELECT * FROM room WHERE hotel_id =?1" , nativeQuery=true)
    List<RoomEntity> findRoomEntitiesByHotelId (int id);

}