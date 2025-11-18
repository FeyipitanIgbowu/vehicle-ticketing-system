package Test.ServicesTest;

import data.models.Officer;
import data.repository.Officers;
import data.repository.OfficersRepository;
import dtos.requests.RegisterOfficerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.IOfficerServices;
import services.OfficerServices;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServicesTest {

    private OfficersRepository officers;
    private IOfficerServices officerServices;

    @BeforeEach
    void setUp() {
        officers = new Officers();
        officerServices = new OfficerServices(officers);
    }

    @Test
    void registerOfficerCountIsOne() {
        RegisterOfficerRequest request = new RegisterOfficerRequest();
        request.setEmail("feyi@gmail.com");
        request.setOfficerName("Feyi");

        Officer officer = officerServices.registerOfficer(request);

        assertNotNull(officer);
        assertEquals(1, officers.count());
    }

    @Test
    void testRegisteringSameOfficerTwiceThrowsException() {
        RegisterOfficerRequest request = new RegisterOfficerRequest();
        request.setEmail("feyi@gmail.com");
        request.setOfficerName("Feyi");

        officerServices.registerOfficer(request);

        assertThrows(IllegalArgumentException.class, () -> officerServices.registerOfficer(request));
        assertEquals(1, officers.count());
    }
}
