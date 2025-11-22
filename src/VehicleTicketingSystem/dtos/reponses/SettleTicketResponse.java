package dtos.reponses;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
public class SettleTicketResponse {
    private String ticketId;
    private int amountPaid;
    private String paymentDate;
    private String hasPaid;
}
