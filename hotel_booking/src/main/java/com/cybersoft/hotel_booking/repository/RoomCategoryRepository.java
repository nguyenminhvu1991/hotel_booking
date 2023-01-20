package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.RoomCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategoryEntity,Integer> {
}