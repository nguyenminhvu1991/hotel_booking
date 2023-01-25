package com.cybersoft.hotel_booking.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomModel { //HƯNG
    private int id = 0;
    private int hotelID = 0;
    private int roomCategoryID = 0;
    private int maxOccupyAdult = 0;
    private int maxOccupyChild = 0;
    private int bedCategoryID = 0;
    private float price = 0;
    private String name = "";
}
