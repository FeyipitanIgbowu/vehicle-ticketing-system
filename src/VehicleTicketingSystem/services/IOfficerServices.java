package services;

import data.models.Officer;
import dtos.requests.RegisterOfficerRequest;

public interface IOfficerServices {
    Officer registerOfficer(RegisterOfficerRequest request);
}

