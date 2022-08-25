package com.sun.travels.backend.repository;

import com.sun.travels.backend.model.Hotel;
import com.sun.travels.backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
List<Room> findByHotel(Hotel hotel);
}
