package Test;

import data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;

public class VehicleTest {

    @BeforeEach
    public void setUp() {
        Vehicle vehicle = new Vehicle("plateNumber");
    }

}
