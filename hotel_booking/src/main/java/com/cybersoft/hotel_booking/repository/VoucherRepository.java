package com.cybersoft.hotel_booking.repository;

import com.cybersoft.hotel_booking.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Integer> {

}
