package services;

import data.models.Vehicle;
import data.repository.VehiclesRepository;
import dtos.reponses.RegisterVehicleResponse;
import dtos.requests.RegisterVehicleRequest;
import static utils.Mapper.mapVehicle;


public class VehicleServices implements IVehicleService{

    private VehiclesRepository vehiclesRepository;

    public VehicleServices(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {

        if (vehiclesRepository.findByChasisNumber(request.getChasisNumber()) != null) {
            throw new IllegalArgumentException("Vehicle already exists");
        }

        Vehicle vehicle = mapVehicle(request);
        vehiclesRepository.save(vehicle);

        RegisterVehicleResponse response = new RegisterVehicleResponse();
        response.setMessage("Vehicle registered successfully");
        response.setChasisNumber(vehicle.getChasisNumber());

        response.setVehicleId(String.valueOf(vehicle.getVehicleId()));

        return response;
    }
}
