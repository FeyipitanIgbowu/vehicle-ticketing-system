package services;

import data.repository.TicketsRepository;
import dtos.requests.IssueTicketRequest;
import data.models.Ticket;

import static mappers.IssueTicketMapper.map;


public class IssueTicketServices implements IIssueTicketServices {

    private final TicketsRepository ticketsRepository;

    public IssueTicketServices(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public Ticket issueTicket(IssueTicketRequest request) {
        if (ticketsRepository.findByID(request.getTicketId()) != null) {
            throw new IllegalArgumentException("Ticket with this ID already exists");
        }

        Ticket ticket = map(request);
        ticketsRepository.save(ticket);
        return ticket;
    }


}
