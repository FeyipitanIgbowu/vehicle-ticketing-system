package Test;

import models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    @BeforeEach
    public void setUp() {
        Vehicle vehicle = new Vehicle("plateNumber");
    }

}
