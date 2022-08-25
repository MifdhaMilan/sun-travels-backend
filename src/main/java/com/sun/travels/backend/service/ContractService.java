package com.sun.travels.backend.service;

import com.sun.travels.backend.model.Contract;
import com.sun.travels.backend.repository.ContractRepository;
import com.sun.travels.backend.request.ContractRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private HotelService hotelService;

    public ResponseEntity<Contract> createContract(ContractRequest contractRequest){
        Contract contract = new Contract();
        contract.setHotel(hotelService.getHotelById(contractRequest.getHid()).getBody());
        contract.setStart_date(contractRequest.getStart_date());
        contract.setEnd_date(contractRequest.getEnd_date());
        contract.setIsValid(contractRequest.getIsValid());
        return ResponseEntity.ok(contractRepository.save(contract));
    }
    public ResponseEntity<Contract> getContractByID(int cid){
        return ResponseEntity.ok(contractRepository.findById(cid).orElse(null));
    }
    public ResponseEntity<List<Contract>> getAllContracts(){
        return ResponseEntity.ok(contractRepository.findAll());
    }
    public String updateContract(int cid, ContractRequest contractRequest){
        Contract contract = getContractByID(cid).getBody();
        if(contract!=null){
            contract.setHotel(hotelService.getHotelById(contractRequest.getHid()).getBody());
            contract.setStart_date(contractRequest.getStart_date());
            contract.setEnd_date(contractRequest.getEnd_date());
            contract.setIsValid(contractRequest.getIsValid());
            contractRepository.save(contract);
            return "contract updated successfully";
        }else{
            return "contract doesn't exit with the given cid";
        }
    }
    public String deleteContract(int cid){
        contractRepository.deleteById(cid);
        return "contract deleted successfully";
    }
}
