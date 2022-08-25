package com.sun.travels.backend.service;

import com.sun.travels.backend.model.Hotel;
import com.sun.travels.backend.model.Room;
import com.sun.travels.backend.repository.RoomRepository;
import com.sun.travels.backend.request.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelService hotelService;

    public ResponseEntity<Room> createRoom(RoomRequest roomRequest){
        Room room = new Room();
        room.setMax_adults(roomRequest.getMax_adults());
        room.setType(roomRequest.getType());
        room.setHotel(hotelService.getHotelById(roomRequest.getHid()).getBody());
        return ResponseEntity.ok(roomRepository.save(room));
    }
    public ResponseEntity<Room> getRoomByID(int rid){
        return ResponseEntity.ok(roomRepository.findById(rid).orElse(null));
    }
    public ResponseEntity<List<Room>> getRoomByHotel(int hid){
        Hotel hotel = hotelService.getHotelById(hid).getBody();
        return ResponseEntity.ok(roomRepository.findByHotel(hotel));
    }

    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.ok(roomRepository.findAll());
    }

    public String updateRoom(int rid, RoomRequest roomRequest){
        Room room = getRoomByID(rid).getBody();
        if(room != null){
            room.setType(roomRequest.getType());
            room.setMax_adults(roomRequest.getMax_adults());
            roomRepository.save(room);
            return "room updated successfully";
        }else{
            return "room doesn't exit with the given rid";
        }
    }

    public String deleteRoom(int rid){
        roomRepository.deleteById(rid);
        return "room deleted successfully";
    }
}
