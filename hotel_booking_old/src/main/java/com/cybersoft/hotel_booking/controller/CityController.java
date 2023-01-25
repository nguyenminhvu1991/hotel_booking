package com.cybersoft.hotel_booking.controller;

import com.cybersoft.hotel_booking.payload.request.SearchRequest;
import com.cybersoft.hotel_booking.repository.*;
import com.cybersoft.hotel_booking.service.CityProvinceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@CrossOrigin
@RequestMapping("/{typecity}")
public class CityController {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CityProvinceServiceImp cityProvinceServiceImp;
    @PostMapping("/cancelbooking/{id}")
    public ResponseEntity<?> cancel(@PathVariable("id") int id) {
        return ResponseEntity.ok(cityProvinceServiceImp.cancel(id));
    }
    @PostMapping("/search")
    public ResponseEntity<?> search(@PathVariable("typecity") String typeCity, @RequestBody SearchRequest searchRequest) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.findAllByType(typeCity,searchRequest));
    }
    @PostMapping("/{name}/search")
    public ResponseEntity<?> searchName(@PathVariable("typecity") String typeCity, @PathVariable("name") String name, @RequestBody SearchRequest searchRequest) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.findAllByTypeAndName(typeCity,name,searchRequest));
    }
    @PostMapping("/search/sort/{sort}")
    public ResponseEntity<?> sort(@PathVariable("typecity") String typeCity, @RequestBody SearchRequest searchRequest, @PathVariable("sort") String sort) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.sort(typeCity,sort,searchRequest));
    }
    @PostMapping("/search/{name}/sort/{sort}")
    public ResponseEntity<?> sortName(@PathVariable("typecity") String typeCity, @RequestBody SearchRequest searchRequest,@PathVariable("name") String name, @PathVariable("sort") String sort) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.sortName(typeCity,name,sort,searchRequest));
    }
    @PostMapping("/{name}")
    public ResponseEntity<?> findAllAccommodationByTypeAndName(@PathVariable("typecity") String typeCity, @PathVariable("name") String name) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.findAllAccommodationByTypeAndName(typeCity,name,null));
    }
    @PostMapping("")
    public ResponseEntity<?> findAllAccommodationByType(@PathVariable("typecity") String typeCity) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.findAllAccommodationByType(typeCity,null)) ;
    }
    @PostMapping("/findall")
    public ResponseEntity<?> findall(@PathVariable("typecity") String typeCity) {
        if (typeCity.equals("city")){
            return ResponseEntity.ok(cityRepository.findAll());
        }
        else if (typeCity.equals("province"))
            return ResponseEntity.ok(provinceRepository.findAll());
        else
            return ResponseEntity.ok("ok");
    }

}
