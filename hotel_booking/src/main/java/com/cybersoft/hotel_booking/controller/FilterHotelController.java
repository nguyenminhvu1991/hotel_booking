package com.cybersoft.hotel_booking.controller;

import com.cybersoft.hotel_booking.payload.request.SearchRequest;
import com.cybersoft.hotel_booking.service.CityProvinceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/{typecity}/filter")
public class FilterHotelController {

    @Autowired
    private CityProvinceServiceImp cityProvinceServiceImp;
    @PostMapping("")
    public ResponseEntity<?> filter(@PathVariable("typecity") String typeCity
            ,@RequestParam(name = "price") String price
            ,@RequestParam(name = "rate") String rate
            ,@RequestParam(name = "rank") String rank
            ,@RequestBody SearchRequest searchRequest) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.filter(typeCity
                ,price
                ,rate
                ,rank
                ,searchRequest));
    }
    @PostMapping("/{name}")
    public ResponseEntity<?> filter(@PathVariable("typecity") String typeCity
            ,@PathVariable("name") String name
            ,@RequestParam(name = "price") String price
            ,@RequestParam(name = "rate") String rate
            ,@RequestParam(name = "rank") String rank
            ,@RequestBody SearchRequest searchRequest) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.filterName(typeCity
                ,name
                ,price
                ,rate
                ,rank
                ,searchRequest));
    }
    @PostMapping("/sort/{sort}")
    public ResponseEntity<?> sort(@PathVariable("typecity") String typeCity
            ,@RequestParam(name = "price") String price
            ,@RequestParam(name = "rate") String rate
            ,@RequestParam(name = "rank") String rank
            ,@RequestBody SearchRequest searchRequest, @PathVariable("sort") String sort) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.sortFilter(typeCity
                , sort
                , price
                , rate
                , rank
                ,searchRequest));
    }
    @PostMapping("/{name}/sort/{sort}")
    public ResponseEntity<?> sortName(@PathVariable("typecity") String typeCity
            ,@RequestParam(name = "price") String price
            ,@RequestParam(name = "rate") String rate
            ,@RequestParam(name = "rank") String rank
            ,@RequestBody SearchRequest searchRequest,@PathVariable("name") String name, @PathVariable("sort") String sort) throws ParseException {
        return ResponseEntity.ok(cityProvinceServiceImp.sortFilterName(typeCity
                , name
                , sort
                , price
                , rate
                , rank
                ,searchRequest));
    }
}