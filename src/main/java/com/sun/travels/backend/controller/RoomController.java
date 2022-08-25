package com.sun.travels.backend.controller;

import com.sun.travels.backend.model.Room;
import com.sun.travels.backend.request.RoomRequest;
import com.sun.travels.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("create-room")
    public ResponseEntity<Room> createRoom(@RequestBody RoomRequest roomRequest){
        return roomService.createRoom(roomRequest);
    }
    @GetMapping("/get-room-by-rid/{rid}")
    public ResponseEntity<Room> getRoomByID(@PathVariable int rid){
        return roomService.getRoomByID(rid);
    }
    @GetMapping("/get-room-by-hotel/{hid}")
    public ResponseEntity<List<Room>> getRoomByHotel(@PathVariable int hid){
        return roomService.getRoomByHotel(hid);
    }

    @GetMapping("/get-all-rooms")
    public ResponseEntity<List<Room>> getAllRooms(){
        return roomService.getAllRooms();
    }

    @PutMapping("update-room/{rid}")
    public String updateRoom(@PathVariable int rid, @RequestBody RoomRequest roomRequest){
        return roomService.updateRoom(rid,roomRequest);
    }

    @DeleteMapping("/delete-room/{rid}")
    public String deleteRoom(@PathVariable int rid){
        return roomService.deleteRoom(rid);
    }
}
