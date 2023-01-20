package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.AttractionEntity;
import com.cybersoft.hotel_booking.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ReviewHotelRepository extends JpaRepository<ReviewEntity, Integer> {
//    @Query("select r from review r where r.hotelId = ?1")
//    List<ReviewEntity> findReviewsByHotelId (int hotelId);

//    @Query(value = "SELECT * FROM review WHERE hotel_id = :id;" , nativeQuery=true) //Vũ sửa từ Hưng
//    List<ReviewEntity> findReviewsByHotelId (@Param("id") int id);
    @Query(value = "select * from review where review.hotel_id =?1", nativeQuery=true)
    List<ReviewEntity> findReviewsByHotelId (int id);

    @Query(value = "select avg(rate_score) as \"AvgRates\" from review r where r.hotel_id = :id group by hotel_id",nativeQuery = true)
    Float findAvgRateByHotelId ( int id);

}