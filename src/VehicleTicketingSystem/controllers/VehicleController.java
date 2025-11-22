package controllers;

import dtos.reponses.RegisterVehicleResponse;
import dtos.requests.RegisterVehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.VehicleServices;
import services.I

@RestController
public class VehicleController {

    @Autowired
    private IVehicleServices vehicleServices;

    public VehicleController(IVehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }
    @PostMapping("/vehicles/register")
    public RegisterVehicleResponse vehicleResponse(RegisterVehicleRequest request) {
        return vehicleServices.registerVehicle(request);
    }
}
