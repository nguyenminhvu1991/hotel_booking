package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.AttractionEntity;
import com.cybersoft.hotel_booking.entity.RoomEntity;
import com.cybersoft.hotel_booking.model.AttractionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity,Integer> {
//    @Query("select a from attraction a where a.hotel_id =?1")
//    List<AttractionEntity> findAttractionsByHotelId (int hotel_id);

    @Query(value = "SELECT * FROM attraction WHERE hotel_id =?1" , nativeQuery=true) //Vũ sửa từ Hưng
    List<AttractionEntity> findAttractionsByHotelId (int id);
    }