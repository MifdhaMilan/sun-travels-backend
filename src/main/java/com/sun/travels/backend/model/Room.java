package com.sun.travels.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String type;
    private int max_adults;

    @ManyToOne
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "room")
    @JsonIgnore
    private List<RoomContract> roomContracts;



}
