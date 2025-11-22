package dtos.requests;

import lombok.Data;

@Data
public class RegisterOfficerRequest {
    private String officerId;
    private String officerEmail;

}
