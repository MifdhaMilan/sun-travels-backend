package com.sun.travels.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String no;
    private String street;
    private String city;
    private String country;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    @JsonIgnore
    private Hotel hotel;
}
