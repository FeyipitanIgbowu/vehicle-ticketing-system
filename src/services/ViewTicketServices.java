package services;

import data.models.Ticket;
import data.repository.TicketsRepository;

public class ViewTicketServices implements IViewTicketServices {

    private final TicketsRepository ticketsRepository;

    public ViewTicketServices(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public Ticket viewTicket(int ticketId) {
        Ticket ticket = ticketsRepository.findByID(ticketId);

        if (ticket == null)
            throw new IllegalArgumentException("Ticket not found");

        return ticket;
    }
}
