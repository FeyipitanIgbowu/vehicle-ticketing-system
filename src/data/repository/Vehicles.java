package data.repository;
import data.Exception.VehicleAlreadyParkedException;
import data.models.Vehicle;

import java.util.ArrayList;

public class Vehicles {

    private ArrayList<Vehicle> vehicles;
    public Vehicles(){
    vehicles = new ArrayList<>();
    }

    public boolean isEmpty() {
        return vehicles.isEmpty();
    }

    public void addCar(Vehicle vehicle) {
        this.contains(vehicle);
        vehicles.add(vehicle);
    }

    public int size() {
        return vehicles.size();
    }

    public void removeCar(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void contains(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            throw new VehicleAlreadyParkedException("Vehicle is Already Parked");
        }
    }

    @Override
    public String toString() {
        return vehicles.toString();
    }
}
