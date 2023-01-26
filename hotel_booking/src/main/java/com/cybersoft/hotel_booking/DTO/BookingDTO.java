package com.cybersoft.hotel_booking.DTO;


import lombok.*;

import java.util.Date;

public interface BookingDTO {

    int getId();

    int getUsers_id();

    Date getCheck_in();

    Date getCheck_out();

    int getAdult_number();

    int getChild_number();

    Integer getVoucher_id();

//    Date getIssued_date();

    Date getPaid_date();

    Date getCancel_date();

    String getBooking_status();

    double getTotal_price();

    String getPayment_method();

    String getRoom_name();

    String getHotel_name();

    String getHotel_address();

    String getHotel_email();

    String getHotel_phone();

}