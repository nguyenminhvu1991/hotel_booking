package com.cybersoft.hotel_booking.DTO;

import com.cybersoft.hotel_booking.model.BedCategoryModel;
import com.cybersoft.hotel_booking.model.RoomCategoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDetailDTO { //Hưng
    private int id;
    private String roomName;
    private float price;
    private int hotelId;
    private int maxOccupyAdult;
    private int maxOccupyChild;
    //private int bedCategoryId; //Vũ comment
    private String bedCategory;
    //private BedCategoryModel bedCategoryModel; //Vũ comment
    //private int roomCategoryId; //Vũ comment
    private String roomCategory;
    ///private RoomCategoryModel roomCategoryModel; //Vũ comment

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getRoomName() {
//        return roomName;
//    }
//
//    public void setRoomName(String roomName) {
//        this.roomName = roomName;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public int getHotelId() {
//        return hotelId;
//    }
//
//    public void setHotelId(int hotelId) {
//        this.hotelId = hotelId;
//    }
//
//    public int getMaxOccupyAdult() {
//        return maxOccupyAdult;
//    }
//
//    public void setMaxOccupyAdult(int maxOccupyAdult) {
//        this.maxOccupyAdult = maxOccupyAdult;
//    }
//
//    public int getMaxOccupyChild() {
//        return maxOccupyChild;
//    }
//
//    public void setMaxOccupyChild(int maxOccupyChild) {
//        this.maxOccupyChild = maxOccupyChild;
//    }
//
//    public int getBedCategoryId() {
//        return bedCategoryId;
//    }
//
//    public void setBedCategoryId(int bedCategoryId) {
//        this.bedCategoryId = bedCategoryId;
//    }
//
//    public BedCategoryModel getBedCategoryModel() {
//        return bedCategoryModel;
//    }
//
//    public void setBedCategoryModel(BedCategoryModel bedCategoryModel) {
//        this.bedCategoryModel = bedCategoryModel;
//    }
//
//    public int getRoomCategoryId() {
//        return roomCategoryId;
//    }
//
//    public void setRoomCategoryId(int roomCategoryId) {
//        this.roomCategoryId = roomCategoryId;
//    }
//
//    public RoomCategoryModel getRoomCategoryModel() {
//        return roomCategoryModel;
//    }
//
//    public void setRoomCategoryModel(RoomCategoryModel roomCategoryModel) {
//        this.roomCategoryModel = roomCategoryModel;
//    }
}