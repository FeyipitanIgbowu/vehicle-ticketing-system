package dtos.reponses;

import data.models.Offense;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueTicketResponse {

    private String ticketId;
    private String vehiclePlateNumber;
    private String officerEmail;
    private Offense offense;
    private int fineAmount;
    private String dateIssued;
    private String status;
    private String message;
}
