package com.sun.travels.backend.controller;

import com.sun.travels.backend.model.Hotel;
import com.sun.travels.backend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/create-hotel")
    public ResponseEntity<Hotel> createHotel(@RequestParam String name, @RequestParam MultipartFile image, @RequestParam String no, @RequestParam String street,@RequestParam String city,@RequestParam String country){
        return hotelService.createHotel(name, image, no, street, city, country);
    }
    @GetMapping("/get-hotel/{hid}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int hid){
        return hotelService.getHotelById(hid);
    }
    @GetMapping("/get-all-hotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return hotelService.getAllHotels();
    }
    @PutMapping("/update-hotel")
    public String updateHotel(@RequestParam int hid,@RequestParam String name,@RequestParam MultipartFile image,@RequestParam String no,  @RequestParam String street,@RequestParam String city, @RequestParam String country){
        return hotelService.updateHotel(hid, name, image, no, street, city, country);
    }

    @DeleteMapping("/delete-hotel/{hid}")
    public String deleteHotel(@PathVariable int hid){
        return hotelService.deleteHotel(hid);
    }
}
