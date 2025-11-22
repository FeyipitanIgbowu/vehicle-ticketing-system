package services;

import data.models.Officer;
import data.repository.OfficersRepository;
import dtos.requests.RegisterOfficerRequest;

import static utils.Mapper.mapOfficer;

public class OfficerServices implements IOfficerServices {

    private final OfficersRepository officers;

    public OfficerServices(OfficersRepository officers) {
        if (officers == null) {
            throw new IllegalArgumentException("OfficersRepository cannot be null");
        }
        this.officers = officers;
    }

    @Override
    public Officer registerOfficer(RegisterOfficerRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("RegisterOfficerRequest cannot be null");
        }

        String email = request.getOfficerEmail();

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (officers.findByEmail(email) != null) {
            throw new IllegalStateException("Officer already exists with this email");
        }

        Officer officer = mapOfficer(request);
        officers.save(officer);
        return officer;
    }
}
