package data.models;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Vehicle {
    private String name;
    private String plateNumber;
    private String model;
    private int year;
    private int vehicleId;
    private String colour;

    @DBRef
    private Owner owner;
    private String chasisNumber;



}

