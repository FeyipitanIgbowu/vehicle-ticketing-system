package utils;

import data.models.Ticket;
import dtos.requests.IssueTicketRequest;

public class ViewTicketMapper {

    public static IssueTicketRequest map(Ticket ticket){
        IssueTicketRequest request = new IssueTicketRequest();

        request.setTicketId(ticket.getTicketId());
        request.setVehiclePlateNumber(ticket.getVehicle().getPlateNumber());
        request.setOfficerEmail(ticket.getIssuer().getEmail());
        request.setOffense(ticket.getOffense());

        return request;
    }
}
