package models;
import Exception.IncorrectTicketIdException;
import java.time.LocalDateTime;

public class Ticket {
    int ticketId;
    Vehicle vehicle;
    Offense offense;
    boolean hasPaid = false;
    Officer issuer;
    LocalDateTime dateOfBooking;
    LocalDateTime dateOfPayment;


    public Ticket(Vehicle vehicle,  Offense offense, Officer issuer, int ticketID){
        this.vehicle = vehicle;
        this.offense = offense;
        this.issuer = issuer;
        this.ticketId = ticketID;
    }

    public void payFine(int ticketID){
        if(this.ticketId == ticketID){
            this.hasPaid = true;
            dateOfPayment = LocalDateTime.now();
        }
        throw new IncorrectTicketIdException("Incorrect ticket id");
    }

    public int viewFine(Offense offense) {
        return offense.getFineAmount();
    }

}
