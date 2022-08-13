package com.sun.travels.backend.controller;

import com.sun.travels.backend.model.Hotel;
import com.sun.travels.backend.request.HotelRequest;
import com.sun.travels.backend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/create-hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelRequest hotelRequest){
        return hotelService.createHotel(hotelRequest);
    }
}
