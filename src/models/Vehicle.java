package models;

public class Vehicle {

    String plateNumber;
    String color;
    int year;
    Owner owner;
    String model;
    String carName;

    public Vehicle(String plateNumber){
        this.plateNumber = plateNumber;
    }


    @Override
    public String toString() {
        return plateNumber;
    }


}
