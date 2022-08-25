package com.sun.travels.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private Date start_date;
    private Date end_date;
    private Boolean isValid;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "contract")
    @JsonIgnore
    private List<RoomContract> roomContracts;

}
