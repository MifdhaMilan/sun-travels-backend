package com.sun.travels.backend.repository;

import com.sun.travels.backend.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
