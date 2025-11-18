package Test.ServicesTest;

import data.models.Offense;
import data.models.Ticket;
import data.repository.Tickets;
import data.repository.TicketsRepository;
import dtos.requests.IssueTicketRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.IIssueTicketServices;
import services.IssueTicketServices;

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
