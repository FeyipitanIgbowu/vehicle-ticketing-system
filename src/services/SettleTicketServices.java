package services;

import data.models.Ticket;
import data.repository.TicketsRepository;
import dtos.requests.SettleTicketRequest;

import java.time.LocalDateTime;

public class SettleTicketServices implements ISettleTicketServices {

    private final TicketsRepository ticketsRepository;

    public SettleTicketServices(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public void settleTicket(SettleTicketRequest request) {
        Ticket ticket = ticketsRepository.findByID(request.getTicketId());

        if (ticket == null)
            throw new IllegalArgumentException("Ticket not found");

        if (ticket.isHasPaid())
            throw new IllegalArgumentException("Ticket already settled");

        ticket.setHasPaid(true);
        ticket.setDateOfPayment(LocalDateTime.now());
    }
}
