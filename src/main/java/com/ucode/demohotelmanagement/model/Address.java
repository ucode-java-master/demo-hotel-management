package com.ucode.demohotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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

