package dtos.requests;

import data.models.Offense;
import data.models.Vehicle;
import lombok.Data;

@Data
public class ViewTicketsRequest {
    private String ticketId;
    private Offense offense;
    private Vehicle vehicle;
    private boolean hasPaid;

}
