package com.sun.travels.backend.controller;

import com.sun.travels.backend.model.Contract;
import com.sun.travels.backend.request.ContractRequest;
import com.sun.travels.backend.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/create-contract")
    public ResponseEntity<Contract> createContract(@RequestBody ContractRequest contractRequest){
        return contractService.createContract(contractRequest);
    }
    @GetMapping("/get-contract-by-cid/{cid}")
    public ResponseEntity<Contract> getContractByID(@PathVariable int cid){
        return contractService.getContractByID(cid);
    }
    @GetMapping("/get-all-contracts")
    public ResponseEntity<List<Contract>> getAllContracts(){
        return contractService.getAllContracts();
    }
    @PutMapping("update-contract/{cid}")
    public String updateContract(@PathVariable int cid, @RequestBody ContractRequest contractRequest){
        return contractService.updateContract(cid,contractRequest);
    }
    @DeleteMapping("/delete-contract/{cid}")
    public String deleteContract(int cid){
        return contractService.deleteContract(cid);
    }
}
