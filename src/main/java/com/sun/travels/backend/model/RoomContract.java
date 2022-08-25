package com.sun.travels.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomContract {
    @EmbeddedId
    private RoomContractKey id = new RoomContractKey();

    @ManyToOne
    @MapsId("rid")
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @MapsId("cid")
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private double price;
    private int noOfRooms;



}
