package Test;

import models.Offense;
import models.Officer;
import models.Ticket;
import models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketTest {
    private Vehicle vehicle;
    private Ticket ticket;
    private Officer officer;
    private Offense offense;


    @BeforeEach
    public void setUp() {
        vehicle = new Vehicle("PlateNumber");
        ticket = new Ticket(vehicle, Offense.DRUNK_DRIVING , officer, 12);
        officer = new Officer(12, "Name", "rank");
    }

    @Test
    public void testThatYouCanPayFine(){
        ticket.payFine(12);
        ticket.viewFines(12);
    }
}
