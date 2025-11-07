package models;
import Exception.IncorrectTicketIdException;
import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private Vehicle vehicle;
    private Offense offense;
    private boolean hasPaid = false;
    private Officer issuer;
    private LocalDateTime dateOfBooking;
    private LocalDateTime dateOfPayment;


    public Ticket(Vehicle vehicle, Offense offense, Officer issuer, int ticketID) {
        this.vehicle = vehicle;
        this.offense = offense;
        this.issuer = issuer;
        this.ticketId = ticketID;
        this.dateOfBooking = LocalDateTime.now();
    }

    public void payFine(int ticketID) {
        if (this.ticketId == ticketID) {
            this.hasPaid = true;
            dateOfPayment = LocalDateTime.now();

        } else {
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
