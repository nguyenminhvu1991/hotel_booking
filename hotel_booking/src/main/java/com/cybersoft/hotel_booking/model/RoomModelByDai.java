package com.cybersoft.hotel_booking.model;

import com.cybersoft.hotel_booking.entity.RoomDatesEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class RoomModelByDai {
    private int id;
    private String roomName;
    private int maxOccupyAdult;
    private int maxOccupyChild;
    private float price;
    List<RoomDatesModel> roomDatesModels;

}
