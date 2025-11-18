package services;

import data.models.Officer;
import data.repository.OfficersRepository;
import dtos.requests.RegisterOfficerRequest;

import static utils.OfficerMapper.map;

public class OfficerServices implements IOfficerServices {
    private OfficersRepository officers;

    public OfficerServices(OfficersRepository officers) {
        this.officers = officers;
    }

    @Override
    public Officer registerOfficer(RegisterOfficerRequest request) {
        if (officers.findByEmail(request.getEmail()) != null) {
            throw new IllegalArgumentException("Officer already exists");
        }

        Officer officer = map(request);
        officers.save(officer);
        return officer;
    }
}
