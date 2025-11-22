package dtos.requests;


import data.models.Officer;
import data.models.Vehicle;
import lombok.Data;

@Data
public class SettleTicketRequest {

    private String ticketId;
    private boolean hasPaid;
    private Vehicle vehicle;
}
