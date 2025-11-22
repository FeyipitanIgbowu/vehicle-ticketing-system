package dtos.requests;

import data.models.Offense;
import data.models.Officer;
import data.models.Vehicle;
import lombok.*;

@Data
public class IssueTicketRequest {
    private String vehicleId;
    private Offense offense;
    private Officer issuer;
    private String ticketId;
    private Vehicle vehicle;
}