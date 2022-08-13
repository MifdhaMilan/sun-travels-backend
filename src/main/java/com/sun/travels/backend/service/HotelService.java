package com.sun.travels.backend.service;

import com.sun.travels.backend.model.Address;
import com.sun.travels.backend.model.Hotel;
import com.sun.travels.backend.repository.AddressRepository;
import com.sun.travels.backend.repository.HotelRepository;
import com.sun.travels.backend.request.HotelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<Hotel> createHotel(HotelRequest hotelRequest){
        Address address = new Address();
        address.setNo(hotelRequest.getAddressRequest().getNo());
        address.setStreet(hotelRequest.getAddressRequest().getStreet());
        address.setCity(hotelRequest.getAddressRequest().getCity());
        address.setCountry(hotelRequest.getAddressRequest().getCountry());
        addressRepository.save(address);

        Hotel hotel = new Hotel();
        hotel.setName(hotelRequest.getName());
        hotel.setImage(hotelRequest.getImage());
        hotel.setAddress(address);
        return ResponseEntity.ok(hotelRepository.save(hotel));
    }
}
