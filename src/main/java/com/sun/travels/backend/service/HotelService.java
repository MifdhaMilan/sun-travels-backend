package com.sun.travels.backend.service;

import com.sun.travels.backend.model.Address;
import com.sun.travels.backend.model.Hotel;
import com.sun.travels.backend.repository.AddressRepository;
import com.sun.travels.backend.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<Hotel> createHotel(String name,MultipartFile image,String no,  String street,String city, String country){
        Address address = new Address();
        address.setNo(no);
        address.setStreet(street);
        address.setCity(city);
        address.setCountry(country);
        addressRepository.save(address);

        Hotel hotel = new Hotel();
        hotel.setName(name);
        try{
            hotel.setImage(image.getBytes());
        }
        catch(Exception e){
            System.out.println(e);
        }
        hotel.setAddress(address);
        return ResponseEntity.ok(hotelRepository.save(hotel));
    }
    public ResponseEntity<Hotel> getHotelById(int hid){
        return ResponseEntity.ok(hotelRepository.findById(hid).orElse(null));
    }

    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelRepository.findAll());
    }

    public String updateHotel(int hid,String name,MultipartFile image,String no,  String street,String city, String country){
        Hotel existingHotel = getHotelById(hid).getBody();
        if(existingHotel != null){
            try{
                Address existingAddress = addressRepository.findById(existingHotel.getAddress().getAid()).orElse(null);
                existingAddress.setNo(no);
                existingAddress.setStreet(street);
                existingAddress.setCity(city);
                existingAddress.setCountry(country);
                addressRepository.save(existingAddress);
                existingHotel.setName(name);
                existingHotel.setImage(image.getBytes());
                existingHotel.setAddress(existingAddress);
                hotelRepository.save(existingHotel);
            }catch(Exception e){
                System.out.println(e);
            }
            return "hotel updated successfully";

        }else{
            return "a hotel doesn't exist with this id";
        }
    }

    public String deleteHotel(int hid){
        hotelRepository.deleteById(hid);
        return "hotel deleted successfully";
    }
}
