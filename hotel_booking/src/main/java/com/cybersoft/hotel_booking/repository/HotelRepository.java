package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cybersoft.hotel_booking.entity.AttractionEntity;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

    public HotelEntity findByHotelName(String hotelName); //copy tu Mr. Dai 01.13.23

//    @Query("select h from hotel h where h.cityId =?1") //Hưng
//    List<HotelEntity> findHotelEntitiesByCityId(int cityId);

    @Query(value = "SELECT * FROM hotel WHERE city_id =?1" , nativeQuery=true) //Vũ sửa từ Hưng
    List<AttractionEntity> findAttractionsByHotelId (int cityId);

}
