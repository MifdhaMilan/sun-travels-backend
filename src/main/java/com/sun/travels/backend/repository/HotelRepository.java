package com.sun.travels.backend.repository;

import com.sun.travels.backend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
