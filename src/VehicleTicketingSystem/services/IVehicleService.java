import dtos.reponses.RegisterVehicleResponse;
import dtos.requests.RegisterVehicleRequest;

public interface IVehicleService {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
