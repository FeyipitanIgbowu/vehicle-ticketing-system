package models;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private String plateNumber;
    private String model;
    private int year;
    private String colour;
    private Owner owner;
    private List<Ticket> tickets = new ArrayList<>();

    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void assignOwner(Owner owner) {
        this.owner = owner;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}

