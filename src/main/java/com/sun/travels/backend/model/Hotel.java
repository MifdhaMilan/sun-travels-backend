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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hid;
    private String name;
    @Lob
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "aid")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
    @JsonIgnore
    private List<Room> rooms;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
    @JsonIgnore
    private List<Contract> contracts;


}
