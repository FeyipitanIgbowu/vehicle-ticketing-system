package Test.ServicesTest;

import VehicleTicketingSysytem.controllers.data.models.Offense;
import VehicleTicketingSysytem.controllers.data.models.Ticket;
import VehicleTicketingSysytem.controllers.data.repository.Tickets;
import VehicleTicketingSysytem.controllers.data.repository.TicketsRepository;
import VehicleTicketingSysytem.controllers.dtos.requests.IssueTicketRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import VehicleTicketingSysytem.controllers.services.IIssueTicketServices;
import VehicleTicketingSysytem.controllers.services.IssueTicketServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IssueTicketServicesTest {

    private Tickets tickets;
    private IIssueTicketServices issueTicketServices;

    @BeforeEach
    void setUp() {
        tickets = new Tickets();
        issueTicketServices = new IssueTicketServices(tickets);
    }

    @Test
    void issueTicketCountIsOne() {
        IssueTicketRequest request = new IssueTicketRequest();
        request.setTicketId(1);
        request.setOffense(Offense.valueOf("ONE_WAY"));

        issueTicketServices.issueTicket(request);

        assertEquals(1, tickets.count());
    }

    @Test
    void testThatIssuingSameTicketTwiceThrowsException() {
        IssueTicketRequest request = new IssueTicketRequest();
        request.setTicketId(1);
        request.setOffense(Offense.valueOf("ONE_WAY"));

        issueTicketServices.issueTicket(request);

        assertThrows(IllegalArgumentException.class, () -> issueTicketServices.issueTicket(request));
        assertEquals(1, tickets.count());
    }
}