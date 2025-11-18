package mappers;

import data.models.Ticket;
import data.models.Vehicle;
import data.models.Officer;
import dtos.requests.IssueTicketRequest;
import java.time.LocalDateTime;

public class IssueTicketMapper {

    public static Ticket map(IssueTicketRequest request) {
        Ticket ticket = new Ticket();
        Vehicle vehicle = new Vehicle();
        Officer officer = new Officer();

        ticket.setTicketId(request.getTicketId());
        ticket.setVehicle(vehicle);
        ticket.setIssuer(officer);
        ticket.setOffense(request.getOffense());
        ticket.setHasPaid(false);
        ticket.setDateOfBooking(LocalDateTime.now());
        ticket.setDateOfPayment(null);
        return ticket;
    }
}
