package Test;

import data.repository.Vehicles;
import data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.Exception.VehicleAlreadyParkedException;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private Vehicles parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new Vehicles();
    }

    @Test
    public void testParkingLotIsEmpty() {
        assertTrue(parkingLot.isEmpty());
    }

    @Test
    public void testYouAddCarToParkingLot() {
        Vehicles parkingLot = new Vehicles();
        Vehicle vehicle = new Vehicle("plateNumber");
        parkingLot.addCar(vehicle);
        assertEquals(1, parkingLot.size());
    }

    @Test
    public void testThatYouCanRemoveCarFromParkingLot() {
        Vehicle vehicle = new Vehicle("plateNumber");
        parkingLot.addCar(vehicle);
        parkingLot.removeCar(vehicle);

        assertEquals(0, parkingLot.size());
    }

    @Test
    public void testThatYouCannotAddAParticularCarTwice() {
        Vehicle vehicle = new Vehicle("plateNumber");

        parkingLot.addCar(vehicle);

        assertThrows(VehicleAlreadyParkedException.class, () -> parkingLot.addCar(vehicle));
    }

    @Test
    public void testThatYouCanAddACarTwice() {
        Vehicle vehicle = new Vehicle("plateNumber");
        Vehicle vehicle2 = new Vehicle("plateNumber2");

        parkingLot.addCar(vehicle);
        parkingLot.addCar(vehicle2);

        assertEquals(2, parkingLot.size());
    }

    @Test
    public void testThatYouCanSeeAllVehiclesInParkingLot() {
        Vehicle vehicle = new Vehicle("plateNumber");
        Vehicle vehicle2 = new Vehicle("plateNumber2");

        parkingLot.addCar(vehicle);
        parkingLot.addCar(vehicle2);

        assertEquals("[plateNumber, plateNumber2]", parkingLot.toString());
    }

}
