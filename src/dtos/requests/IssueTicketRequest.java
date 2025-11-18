package dtos.requests;

import data.models.Offense;

public class IssueTicketRequest {
    private int ticketId;
    private String vehiclePlateNumber;
    private String officerEmail;
    private Offense offense;

    public int getTicketId() { return ticketId; }

    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public String getVehiclePlateNumber() { return vehiclePlateNumber; }

    public void setVehiclePlateNumber(String vehiclePlateNumber) { this.vehiclePlateNumber = vehiclePlateNumber; }

    public String getOfficerEmail() { return officerEmail; }

    public void setOfficerEmail(String officerEmail) { this.officerEmail = officerEmail; }

    public Offense getOffense() { return offense; }

    public void setOffense(Offense offense) { this.offense = offense; }

    public int getFineAmount() { return offense.getFineAmount();}

}
