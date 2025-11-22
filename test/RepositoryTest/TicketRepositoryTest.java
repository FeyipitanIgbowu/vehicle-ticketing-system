package Test.RepositoryTest;

import VehicleTicketingSysytem.controllers.data.models.Ticket;
import VehicleTicketingSysytem.controllers.data.repository.Tickets;
import VehicleTicketingSysytem.controllers.data.repository.TicketsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    private Ticket ticket;
    private Tickets tickets;
    private TicketsRepository ticketsRepository;

    @BeforeEach
    public void setup() {
        ticket = new Ticket();
        tickets = new Tickets();
    }

    @Test
    void testThatYouCanSaveTicket() {
        tickets.save(ticket);

        assertEquals(1, tickets.count());
    }

    @Test
    void testThatYouCanSaveATicketTwiceAndItRemainsOneTicket(){
        tickets.save(ticket);
        tickets.save(ticket);

        assertEquals(1, tickets.count());
    }
//
//    @Test
//    void testThatYouCanFindTicketById() {
//        ticket.setTicketId(1);
//        tickets.save(ticket);
//
//        assertTrue(tickets.findByID(1).contains(ticket));
//    }

    @Test
    void testThatYouCanDeleteTicketById() {
        ticket.setTicketId(1);
        tickets.save(ticket);

        tickets.delete(ticket);

        assertEquals(0, tickets.count());
    }

    @Test
    void testThatYouCanFindAllTickets() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();

        tickets.save(ticket);
        tickets.save(ticket1);
        tickets.save(ticket2);

        assertEquals(3, tickets.count());
    }

    @Test
    void testThatYouCanDeleteAllTickets() {
        Ticket ticket1 = new Ticket();
        tickets.save(ticket);
        tickets.save(ticket1);

        tickets.deleteAll();
        assertEquals(0, tickets.count());
    }

    @Test
    void testThatYouCanCountAllTickets() {
        Ticket ticket1 = new Ticket();
        tickets.save(ticket);
        tickets.save(ticket1);

        assertEquals(2, tickets.count());
    }
}
