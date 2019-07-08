package com.ucode.demohotelmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private int number;
    private String typeOfRoom;
    private String view;
    private String occupiedStatus;
    private double price;

}
