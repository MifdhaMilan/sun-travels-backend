package com.sun.travels.backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
    private String name;
    @Lob
    private byte[] image;
    private AddressRequest addressRequest;
}
