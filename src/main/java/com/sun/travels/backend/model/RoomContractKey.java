package com.sun.travels.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomContractKey implements Serializable {
    @Column(name = "room_id")
    private int rid;
    @Column(name = "contract_id")
    private int cid;

}
