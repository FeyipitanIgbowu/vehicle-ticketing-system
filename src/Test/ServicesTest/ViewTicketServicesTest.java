package Test.ServicesTest;

import data.models.Ticket;
import data.repository.Tickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.IViewTicketServices;
import services.ViewTicketServices;

import static org.junit.jupiter.api.Assertions.*;

class ViewTicketServicesTest {

    private Tickets tickets;
    private IViewTicketServices viewTicketServices;

    @BeforeEach
    void setUp() {
        tickets = new Tickets();
        viewTicketServices = new ViewTicketServices(tickets);

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        tickets.save(ticket);
    }

    @Test
    void testThatExistingTicketReturnsTicket() {
        Ticket ticket = viewTicketServices.viewTicket(1);
        assertNotNull(ticket);
        assertEquals(1, ticket.getTicketId());
    }

    @Test
    void testThatInvalidTicketThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> viewTicketServices.viewTicket(100));
    }
}
