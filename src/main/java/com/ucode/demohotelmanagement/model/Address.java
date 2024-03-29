package com.ucode.demohotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String country;
    private String city;
    private String street;
    private int number;
    private String postalCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate currentDate;

}

