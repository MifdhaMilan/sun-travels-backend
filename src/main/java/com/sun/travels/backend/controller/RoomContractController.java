package com.sun.travels.backend.controller;

import com.sun.travels.backend.model.RoomContract;
import com.sun.travels.backend.request.RoomContractRequest;
import com.sun.travels.backend.service.RoomContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-contract")
public class RoomContractController {
    @Autowired
    private RoomContractService roomContractService;

    @PostMapping("/create-room-contract")
    public String createRoomContract(@RequestBody RoomContractRequest roomContractRequest){
        return roomContractService.createRoomContract(roomContractRequest);
    }
    @GetMapping("/get-all-room-contracts")
    public ResponseEntity<List<RoomContract>> getAllRoomContracts(){
        return roomContractService.getAllRoomContracts();
    }
    @GetMapping("/get-all-valid-room-contracts")
    public ResponseEntity<List<RoomContract>> getAllValidRoomContract(){
        return roomContractService.getAllValidRoomContract();
    }
    @PutMapping("/update-room-contract")
    public String updateRoomContract(@RequestBody RoomContractRequest roomContractRequest){
        return roomContractService.updateRoomContract(roomContractRequest);
    }
    @DeleteMapping("/delete-room-contract/{rid}/{cid}")
    public String deleteRoomContract(@PathVariable int rid, @PathVariable int cid){
        return roomContractService.deleteRoomContract(rid,cid);
    }
}
