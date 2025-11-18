package utils;

import data.models.Officer;
import dtos.requests.RegisterOfficerRequest;

public class OfficerMapper {

    public static Officer map(RegisterOfficerRequest request) {
        Officer officer = new Officer();
        officer.setId(request.getOfficerId());
        officer.setName(request.getOfficerName());
        officer.setRank(request.getOfficerRank());
        officer.setEmail(request.getEmail());
        return officer;
    }
}
