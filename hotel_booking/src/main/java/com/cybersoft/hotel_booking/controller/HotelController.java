package com.cybersoft.hotel_booking.controller;
//package com.cybersoft.hotel_booking.API;

import com.cybersoft.hotel_booking.DTO.CityHotelDTO;
import com.cybersoft.hotel_booking.DTO.HotelDetailDTO;
import com.cybersoft.hotel_booking.DTO.RoomDetailDTO;
import com.cybersoft.hotel_booking.entity.CityEntity;
import com.cybersoft.hotel_booking.entity.HotelEntity;
import com.cybersoft.hotel_booking.model.AttractionModel;
import com.cybersoft.hotel_booking.payload.request.SearchRequest;
import com.cybersoft.hotel_booking.payload.response.DataResponse;
import com.cybersoft.hotel_booking.repository.CityRepository;
import com.cybersoft.hotel_booking.repository.ReviewHotelRepository;
import com.cybersoft.hotel_booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cybersoft.hotel_booking.repository.HotelRepository;
import com.cybersoft.hotel_booking.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @Autowired
    AttractionService attractionService;
    @Autowired
    ReviewHotelService reviewHotelService;

//    @Autowired
    //@Qualifier("city")//Vũ comment từ Hưng
//    CityService cityService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    HotelServiceService hotelServiceService;
    @Autowired
    RoomService roomService;
    @Autowired
    CityRepository cityRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    ReviewHotelRepository reviewHotelRepository;


    @PostMapping("/findall") //Still keep this for Mr. Dai
    public List<HotelEntity> findall() {
        return hotelRepository.findAll();
    }

    @GetMapping("/detail") //hotel detail api by Hưng
    public ResponseEntity<?> getHotel(@RequestParam("id") int id){
        System.out.println("pass running 1");
        DataResponse dataResponse = new DataResponse();
        Optional<HotelEntity> hotelEntity = hotelService.findById(id);
        if(!hotelEntity.isPresent()){
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());
            dataResponse.setSuccess(false);
            dataResponse.setDesc("Tìm Hotel thất bại ");
            dataResponse.setData(null);
            return new ResponseEntity<>(dataResponse,HttpStatus.NOT_FOUND);
        }else {
            System.out.println("pass running 2");
            HotelDetailDTO hotelDetailDTO = new HotelDetailDTO();
            hotelDetailDTO.setId(hotelEntity.get().getId());
            hotelDetailDTO.setHotelName(hotelEntity.get().getHotelName());
            hotelDetailDTO.setAddress(hotelEntity.get().getAddress());
            hotelDetailDTO.setEmail(hotelEntity.get().getEmail());
            hotelDetailDTO.setPhone(hotelEntity.get().getPhone());
            hotelDetailDTO.setDescription(hotelEntity.get().getDescription());
            hotelDetailDTO.setImage(hotelEntity.get().getImage());
            hotelDetailDTO.setHotelRank(hotelEntity.get().getHotelRank());
            hotelDetailDTO.setAvgRate(reviewHotelService.findAvgRateByHotelId(id));
            hotelDetailDTO.setRateCount(reviewHotelService.findReviewsByHotelId(id).size());
            //hotelDetailDTO.setCityId(hotelEntity.get().getCityId());
            //hotelDetailDTO.setCityId(hotelEntity.get().getCity().getId());
            hotelDetailDTO.setCity(hotelEntity.get().getCity().getCity());
            //hotelDetailDTO.setCityDetailDTO(cityService.findByCityId(hotelEntity.get().getCityId())); //Vũ comment từ Hưng
            //hotelDetailDTO.setCityDetailDTO(cityService.findByCityId(hotelEntity.get().getCity().getId())); //Vũ comment từ Hưng
            //hotelDetailDTO.setServiceModelList(serviceOfHotelService.findServiceByHotelId(id));
            hotelDetailDTO.setServiceModelList(hotelServiceService.findServiceByHotelId(id));
            hotelDetailDTO.setAttractionModelList(attractionService.findAttractionsByHotelId(id));
            hotelDetailDTO.setReviewHotelModelList(reviewHotelService.findReviewsByHotelId(id));
            hotelDetailDTO.setRoomDetailDTOList(roomService.findRoomsByHotelId(id));
            hotelDetailDTO.setMinPriceRoomDetailDTO(roomService.findRoomsByHotelId(id).stream().min(Comparator.comparingDouble(RoomDetailDTO::getPrice)).get());


            dataResponse.setStatus(HttpStatus.OK.value());
            dataResponse.setSuccess(true);
            dataResponse.setDesc("Tìm Hotel thành công ");
            dataResponse.setData(hotelDetailDTO);
            return new ResponseEntity<>(dataResponse,HttpStatus.OK);
        }
    }

    @PostMapping("/detail/search") //getDetailHotelByHotelIdAndSearchRequest api by Đại
    public ResponseEntity<?> getDetailHotelByHotelIdAndSearchRequest(@RequestParam("id") int id,@RequestBody SearchRequest searchRequest){
        Optional<HotelEntity> hotelEntity = hotelService.findById(id);
            HotelDetailDTO hotelDetailDTO = new HotelDetailDTO();
            hotelDetailDTO.setId(hotelEntity.get().getId());
            hotelDetailDTO.setHotelName(hotelEntity.get().getHotelName());
            hotelDetailDTO.setAddress(hotelEntity.get().getAddress());
            hotelDetailDTO.setEmail(hotelEntity.get().getEmail());
            hotelDetailDTO.setPhone(hotelEntity.get().getPhone());
            hotelDetailDTO.setDescription(hotelEntity.get().getDescription());
            hotelDetailDTO.setImage(hotelEntity.get().getImage());
            hotelDetailDTO.setHotelRank(hotelEntity.get().getHotelRank());
            hotelDetailDTO.setAvgRate(reviewHotelService.findAvgRateByHotelId(id));
            hotelDetailDTO.setRateCount(reviewHotelService.findReviewsByHotelId(id).size());
            hotelDetailDTO.setCity(hotelEntity.get().getCity().getCity());
            hotelDetailDTO.setServiceModelList(hotelServiceService.findServiceByHotelId(id));
            hotelDetailDTO.setAttractionModelList(attractionService.findAttractionsByHotelId(id));
            hotelDetailDTO.setReviewHotelModelList(reviewHotelService.findReviewsByHotelId(id));

            hotelDetailDTO.setRoomDetailDTOList(roomService.findRoomsByHotelIdAndSearchRequest(id,searchRequest));
            hotelDetailDTO.setMinPriceRoomDetailDTO(roomService.findRoomsByHotelIdAndSearchRequest(id,searchRequest).stream().min(Comparator.comparingDouble(RoomDetailDTO::getPrice)).get());
        return ResponseEntity.ok(hotelDetailDTO);
    }


    //CRUD
    @PostMapping("/{cityId}")
    public ResponseEntity<?> addHotel(@PathVariable("cityId") int cityId, @RequestBody HotelEntity hotelEntity, BindingResult bindingResult) {
        DataResponse dataResponse = new DataResponse();

        if (bindingResult.hasErrors()) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());//BAD REQUEST
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }
        hotelEntity.setCity(cityRepository.findById(cityId).get());
        HotelEntity hotelEntityAdded = hotelService.addHotel(hotelEntity);
        dataResponse.setStatus(HttpStatus.CREATED.value());//201
        dataResponse.setDesc(HttpStatus.CREATED.getReasonPhrase());//CREATED
        dataResponse.setSuccess(true);
        dataResponse.setData(hotelEntityAdded);

        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("")
    public ResponseEntity<?> findAllHotel() {
        DataResponse dataResponse = new DataResponse();

        List<HotelEntity> hotelEntityList = hotelService.findAllHotel();

        if (hotelEntityList.isEmpty()) {//NO CONTENT
            dataResponse.setStatus(HttpStatus.NO_CONTENT.value());//204
            dataResponse.setDesc(HttpStatus.NO_CONTENT.getReasonPhrase());//NO CONTENT
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(hotelEntityList);

        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findHotelById(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();

        HotelEntity hotelEntity = hotelService.findHotelById(id);

        if (hotelEntity == null) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(hotelEntity);

        return ResponseEntity.ok(dataResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable("id") Integer id, @RequestBody HotelEntity hotelEntity, BindingResult bindingResult) {
        DataResponse dataResponse = new DataResponse();

        if (bindingResult.hasErrors()) {//BAD REQUEST
            dataResponse.setStatus(HttpStatus.BAD_REQUEST.value());//400
            dataResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());//BAD REQUEST
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        hotelEntity.setCity(cityRepository.findById(hotelRepository.findById(id).get().getCity().getId()).get());//added by Vu to keep city id
        HotelEntity hotelEntityUpdated = hotelService.updateHotel(id, hotelEntity);


        if (hotelEntityUpdated == null) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData(hotelEntityUpdated);

        return ResponseEntity.ok(dataResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable("id") Integer id) {
        DataResponse dataResponse = new DataResponse();

        boolean success = hotelService.deleteHotelById(id);

        if (!success) {//NOT FOUND
            dataResponse.setStatus(HttpStatus.NOT_FOUND.value());//404
            dataResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());//NOT FOUND
            dataResponse.setSuccess(false);
            dataResponse.setData("");

            return ResponseEntity.ok(dataResponse);
        }

        dataResponse.setStatus(HttpStatus.OK.value());//200
        dataResponse.setDesc(HttpStatus.OK.getReasonPhrase());//OK
        dataResponse.setSuccess(true);
        dataResponse.setData("");

        return ResponseEntity.ok(dataResponse);
    }
}
