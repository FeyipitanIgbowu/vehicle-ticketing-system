package services;

import data.models.Vehicle;
import data.repository.Vehicles;
import data.repository.VehiclesRepository;
import dtos.reponses.RegisterVehicleResponse;
import dtos.requests.RegisterVehicleRequest;

import static utils.VehicleMapper.map;

public class VehicleServices  implements IVehicleServices {
    private VehiclesRepository vehicles = new Vehicles();
    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        if(vehicles.findByChasisNumber(request.getChasisNumber()) != null){
            throw new IllegalArgumentException("Vehicle already exists");
        }
        Vehicle vehicle = map(request);
        vehicles.save(vehicle);
        return new RegisterVehicleResponse();


    }
}