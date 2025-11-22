package Test.RepositoryTest;
import VehicleTicketingSysytem.controllers.data.repository.Vehicles;
import VehicleTicketingSysytem.controllers.data.models.Vehicle;
import VehicleTicketingSysytem.controllers.data.repository.VehiclesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import VehicleTicketingSysytem.controllers.Exception.IncorrectTicketIdException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryTest {

    private Vehicles vehicles;
    private VehiclesRepository vehicleRepo;
    private Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        vehicles = new Vehicles();
        vehicle = new Vehicle();
    }

    @Test
    void testThatYouCanAddToVehicles(){
        vehicles.save(vehicle);
        assertEquals(1, vehicles.count());
    }

    @Test
    void testThatYouCanAddThesameVehicleTwiceAndItStillCountsAsOne() {
        vehicles.save(vehicle);
        vehicles.save(vehicle);

        assertEquals(1, vehicles.count());
    }

    @Test
    void testThatYouCanFindTheVehicleById() {
        vehicle.setId(1);
        vehicles.save(vehicle);

      assertEquals(1, vehicles.count());
    }

    @Test
    void testThatYouCannotFindVehicleWithIncorrectId(){
        vehicle.setId(1);
        vehicles.save(vehicle);

        assertNull( vehicles.findByID(2));
    }

    @Test
    void testThatYouCanDeleteById() {
        vehicle.setId(1);
        vehicles.save(vehicle);
        vehicles.delete(vehicle);

        assertEquals(0, vehicles.count());
    }

    @Test
    void testThatYouCannotDeleteAnInexistentVehicle() {
        vehicle.getId();
        vehicles.save(vehicle);
        vehicles.delete(vehicle);

        assertNull(vehicles.findByID(1));
    }

    @Test
    void testThatYouCanDeleteAllVehicles() {
        vehicles.save(vehicle);
        vehicles.deleteAll();

        assertEquals(0, vehicles.count());
    }
}
