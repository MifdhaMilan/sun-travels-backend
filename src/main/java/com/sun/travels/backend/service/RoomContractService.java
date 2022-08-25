package com.sun.travels.backend.service;

import com.sun.travels.backend.model.RoomContract;
import com.sun.travels.backend.model.RoomContractKey;
import com.sun.travels.backend.repository.RoomContractRepository;
import com.sun.travels.backend.request.RoomContractRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomContractService {
    @Autowired
    private RoomContractRepository roomContractRepository;

    @Autowired
    private ContractService contractService;

    @Autowired
    private RoomService roomService;

    public String createRoomContract(RoomContractRequest roomContractRequest) {
        try {
            RoomContract roomContract = new RoomContract();
            roomContract.setContract(contractService.getContractByID(roomContractRequest.getCid()).getBody());
            roomContract.setRoom(roomService.getRoomByID(roomContractRequest.getRid()).getBody());
            roomContract.setNoOfRooms(roomContractRequest.getNoOfRooms());
            roomContract.setPrice(roomContractRequest.getPrice());
            roomContractRepository.save(roomContract);
            return "success";

        } catch (Exception e) {
            System.out.println(e);
            return "failed";
        }

    }

    public ResponseEntity<List<RoomContract>> getAllRoomContracts() {
        return ResponseEntity.ok(roomContractRepository.findAll());
    }
    public ResponseEntity<List<RoomContract>> getAllValidRoomContract(){
        List<RoomContract> roomContract = getAllRoomContracts().getBody();
        List<RoomContract> validRoomContract = new ArrayList<>();
        for(int i=0;i< roomContract.size();i++){
            if(roomContract.get(i).getContract().getIsValid()){
                validRoomContract.add(roomContract.get(i));
            }
        }
        return ResponseEntity.ok(validRoomContract);
    }
    public String updateRoomContract(RoomContractRequest roomContractRequest){
        RoomContract roomContract = roomContractRepository.findById(new RoomContractKey(roomContractRequest.getRid(),roomContractRequest.getCid())).orElse(null);
        try{
            roomContract.setContract(contractService.getContractByID(roomContractRequest.getCid()).getBody());
            roomContract.setRoom(roomService.getRoomByID(roomContractRequest.getRid()).getBody());
            roomContract.setNoOfRooms(roomContractRequest.getNoOfRooms());
            roomContract.setPrice(roomContractRequest.getPrice());
            roomContractRepository.save(roomContract);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "failed";
        }

    }
    public String deleteRoomContract(int rid, int cid){
        roomContractRepository.deleteById(new RoomContractKey(rid,cid));
        return "room contract deleted successfully";
    }
}
