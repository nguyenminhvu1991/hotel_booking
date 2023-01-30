package com.cybersoft.hotel_booking.DTO;

import com.cybersoft.hotel_booking.model.AttractionModel;
import com.cybersoft.hotel_booking.model.ReviewHotelModel;
import com.cybersoft.hotel_booking.model.ServiceModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelDetailDTO {
    private int id;
    private String hotelName;
    private String address;
    private String phone;
    private String email;
    private int hotelRank;
    private float avgRate;
    private int rateCount;
    private String description;
    private String image;

    private String city;
//    private int cityId;//Vũ comment từ Hưng
//    private CityProvinceDTO cityProvinceDTO; //Vũ comment từ Hưng
//    private ServiceModel serviceModel; //Vũ comment từ Hưng
    private List<AttractionModel> attractionModelList;

    private List<ReviewHotelModel> reviewHotelModelList;

    private List<ServiceModel> serviceModelList;

    private List<RoomDetailDTO> roomDetailDTOList;

    private RoomDetailDTO minPriceRoomDetailDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHotelRank() {
        return hotelRank;
    }

    public void setHotelRank(int hotelRank) {
        this.hotelRank = hotelRank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<AttractionModel> getAttractionModelList() {
        return attractionModelList;
    }

    public void setAttractionModelList(List<AttractionModel> attractionModelList) {
        this.attractionModelList = attractionModelList;
    }

//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }

//    public CityProvinceDTO getCityDetailDTO() {
//        return cityProvinceDTO;
//    }
//
//    public void setCityDetailDTO(CityProvinceDTO cityProvinceDTO) {
//        this.cityProvinceDTO = cityProvinceDTO;
//    }

    public List<ReviewHotelModel> getReviewHotelModelList() {
        return reviewHotelModelList;
    }

    public void setReviewHotelModelList(List<ReviewHotelModel> reviewHotelModelList) {
        this.reviewHotelModelList = reviewHotelModelList;
    }


    public List<ServiceModel> getServiceModelList() {
        return serviceModelList;
    }

    public void setServiceModelList(List<ServiceModel> serviceModelList) {
        this.serviceModelList = serviceModelList;
    }

    public List<RoomDetailDTO> getRoomDetailDTOList() {
        return roomDetailDTOList;
    }

    public void setRoomDetailDTOList(List<RoomDetailDTO> roomDetailDTOList) {
        this.roomDetailDTOList = roomDetailDTOList;
    }

    public float getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(float avgRate) {
        this.avgRate = avgRate;
    }

//    public CityProvinceDTO getCityProvinceDTO() {
//        return cityProvinceDTO;
//    }
//
//    public void setCityProvinceDTO(CityProvinceDTO cityProvinceDTO) {
//        this.cityProvinceDTO = cityProvinceDTO;
//    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public RoomDetailDTO getMinPriceRoomDetailDTO() {
        return minPriceRoomDetailDTO;
    }

    public void setMinPriceRoomDetailDTO(RoomDetailDTO minPriceRoomDetailDTO) {
        this.minPriceRoomDetailDTO = minPriceRoomDetailDTO;
    }
}