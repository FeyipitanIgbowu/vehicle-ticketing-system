package Test;

import models.Offense;
import models.Officer;
import models.Ticket;
import models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.IncorrectTicketIdException;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    private Vehicle vehicle;
    private Ticket ticket;
    private Officer officer;
    private Offense offense;


    @BeforeEach
    public void setUp() {
        vehicle = new Vehicle("PlateNumber");
        ticket = new Ticket(vehicle, Offense.DRUNK_DRIVING , officer, 12);
    }

    @Test
    public void testThatYouCanViewFine(){
        assertEquals(50000, ticket.viewFine());
    }

    @Test
    public void testThatYouCanPayFineWithCorrectTicketId(){
        ticket.payFine(12);
        assertTrue(ticket.hasPaid());
        assertNotNull(ticket.getDateOfPayment());
    }

    @Test
    public void testThatYouCannotPayFineWithWrongTicketId(){
        assertThrows(IncorrectTicketIdException.class, () -> ticket.payFine(0));
        assertFalse(ticket.hasPaid());
        assertNull(ticket.getDateOfPayment());

    }

    @Test
    public void testThatYouCanReturnTicketID(){
        ticket.getTicketId();
    }
}
