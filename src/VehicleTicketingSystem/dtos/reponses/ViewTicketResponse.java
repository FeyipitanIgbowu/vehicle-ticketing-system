package dtos.reponses;

import data.models.Offense;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTicketResponse {
    private String ticketId;
    private String vehiclePlateNumber;
    private String officerName;
    private Offense offense;
    private int fineAmount;
    private Date dateIssued;
    private boolean hasPaid;
}
