package com.sun.travels.backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomContractRequest {
    private int rid;
    private int cid;
    private double price;
    private int noOfRooms;
}
