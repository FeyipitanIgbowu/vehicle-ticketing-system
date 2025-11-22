package dtos.reponses;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterOfficerResponse {

    private String officerId;
    private String officerName;
    private String officerEmail;
}
