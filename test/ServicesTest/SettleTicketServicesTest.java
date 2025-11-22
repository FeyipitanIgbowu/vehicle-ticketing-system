package Test.ServicesTest;

import VehicleTicketingSysytem.controllers.data.models.Offense;
import VehicleTicketingSysytem.controllers.data.models.Ticket;
import VehicleTicketingSysytem.controllers.data.repository.Tickets;
import VehicleTicketingSysytem.controllers.dtos.requests.IssueTicketRequest;
import VehicleTicketingSysytem.controllers.dtos.requests.SettleTicketRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import VehicleTicketingSysytem.controllers.services.IssueTicketServices;
import VehicleTicketingSysytem.controllers.services.SettleTicketServices;

import static org.junit.jupiter.api.Assertions.*;

class SettleTicketServicesTest {

    private Tickets tickets;
    private IssueTicketServices issueTicketServices;
    private SettleTicketServices settleTicketServices;

    @BeforeEach
    void setUp() {
        tickets = new Tickets();
        issueTicketServices = new IssueTicketServices(tickets);
        settleTicketServices = new SettleTicketServices(tickets);
    }

    @Test
    void settleTicketMarksTicketAsPaid() {
        IssueTicketRequest issueRequest = new IssueTicketRequest();
        issueRequest.setTicketId(1);
        issueRequest.setOffense(Offense.ONE_WAY);

        issueTicketServices.issueTicket(issueRequest);

        SettleTicketRequest settleRequest = new SettleTicketRequest();
        settleRequest.setTicketId(1);

        settleTicketServices.settleTicket(settleRequest);

        Ticket ticket = tickets.findByID(1);
        assertTrue(ticket.isHasPaid());
    }

    @Test
    void cannotSettleSameTicketTwice() {
        IssueTicketRequest issueRequest = new IssueTicketRequest();
        issueRequest.setTicketId(1);
        issueRequest.setOffense(Offense.ONE_WAY);

        issueTicketServices.issueTicket(issueRequest);

        SettleTicketRequest settleRequest = new SettleTicketRequest();
        settleRequest.setTicketId(1);

        settleTicketServices.settleTicket(settleRequest);

        assertThrows(IllegalArgumentException.class,
                () -> settleTicketServices.settleTicket(settleRequest));
    }
}
