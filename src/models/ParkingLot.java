package models;
import Exception.VehicleAlreadyParkedException;
import java.util.ArrayList;

public class ParkingLot {

    private ArrayList<Vehicle> parkingLot;
    public ParkingLot() {
        parkingLot = new ArrayList<>();
    }

    public boolean isEmpty() {
        return parkingLot.isEmpty();
    }

    public void addCar(Vehicle vehicle) {
        this.contains(vehicle);
        parkingLot.add(vehicle);
    }

    public int size() {
        return parkingLot.size();
    }

    public void removeCar(Vehicle vehicle) {
        parkingLot.remove(vehicle);
    }

    public void contains(Vehicle vehicle) {
        if (parkingLot.contains(vehicle)) {
            throw new VehicleAlreadyParkedException("Vehicle is Already Parked");
        }
    }

    @Override
    public String toString() {
        return parkingLot.toString();
    }
}
