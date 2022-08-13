package com.sun.travels.backend.repository;

import com.sun.travels.backend.model.RoomContract;
import com.sun.travels.backend.model.RoomContractKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomContractRepository extends JpaRepository<RoomContract, RoomContractKey> {
}
