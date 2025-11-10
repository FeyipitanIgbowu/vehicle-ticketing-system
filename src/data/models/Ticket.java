package data.models;
import data.Exception.IncorrectTicketIdException;
import data.repository.Vehicles;

import java.time.LocalDateTime;

public class Ticket {
    int ticketId;
    Vehicle vehicle;
    Vehicles vehicles;
    Offense offense;
    private boolean hasPaid = false;
    Officer issuer;
    private LocalDateTime dateOfBooking;
    private LocalDateTime dateOfPayment;
    private int paidAmount;
    private int balance;


    public Ticket(Vehicle vehicle, Offense offense, Officer issuer, int ticketID) {
        this.vehicle = vehicle;
        this.offense = offense;
        this.issuer = issuer;
        this.ticketId = ticketID;
        this.dateOfBooking = LocalDateTime.now();
        this.paidAmount = paidAmount;
    }

    public void payFine(int ticketID, int paidAmount) {
        if (paidAmount == offense.getFineAmount()) {
            this.hasPaid = true;
            dateOfPayment = LocalDateTime.now();
            vehicles.removeCar(vehicle);
        }else if(paidAmount > offense.getFineAmount()) {
            this.hasPaid = true;
            dateOfPayment = LocalDateTime.now();
            this.balance = paidAmount - offense.getFineAmount();
        }
         else {
            throw new IncorrectTicketIdException("Incorrect ticket id");
        }
    }

    public int viewFine() {
        return offense.getFineAmount();
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public int getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                "\nOffense: " + offense.getName() +
                "\nFine: " + offense.getFineAmount() +
                "\nIssued by: " + issuer.getName() +
                "\nBooking date: " + dateOfBooking +
                "\nPaid: " + hasPaid +
                (hasPaid ? "\nPayment date: " + dateOfPayment : "");
    }

}
