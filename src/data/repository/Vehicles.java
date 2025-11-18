package data.repository;
import Exception.IncorrectVehicleIdException;
import data.models.Vehicle;
import java.util.ArrayList;

public class Vehicles implements VehiclesRepository {

    private static ArrayList<Vehicle> vehicles;
    private static int count;

    public Vehicles() {
        vehicles = new ArrayList<>();
        count = 0;
    }

    public Vehicle save(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            generateID();
            vehicle.setId(count);
            vehicles.add(vehicle);
        }
        return vehicle;
    }

    public Vehicle findByID(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                vehicles.add(vehicle);
                return vehicle;
            }
        }
        return null;
    }

    public ArrayList<Vehicle> findAll() {
        return vehicles;
    }

    public void deleteById(int id) {
        vehicles.removeIf(vehicle -> vehicle.getId() == id);
    }

    public void deleteAll() {
        vehicles.clear();
    }

    public void delete(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public long count() {
        return vehicles.size();
    }

    public void generateID(){
        count++;
    }

    public Vehicle findByChasisNumber(String chasisNumber){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getChasisNumber().equals(chasisNumber)) {
                return vehicle;
            }
        }
        return null;
    }
}
