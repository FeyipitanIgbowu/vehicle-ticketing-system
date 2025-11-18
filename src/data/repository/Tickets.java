package data.repository;
import Exception.IncorrectTicketIdException;
import data.models.Ticket;
import data.models.Vehicle;

import java.util.ArrayList;

public class Tickets implements TicketsRepository {
    private ArrayList<Ticket> tickets;
    private int count;

    public Tickets() {
        tickets = new ArrayList<>();
        count = 0;
    }

    @Override
    public Ticket save(Ticket ticket) {
        if (!tickets.contains(ticket)) {
            generateID();
            ticket.setTicketId(count);
            tickets.add(ticket);
        }
        return ticket;
    }

    private void generateID() {
        count++;
    }

    @Override
    public Ticket findByID(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == id) {
                return ticket;
            }
        }
        return null;
    }


    @Override
    public ArrayList<Ticket> findAll() {
        return tickets;
    }

    @Override
    public void deleteById(int id) {
        tickets.removeIf(ticket -> ticket.getTicketId() == id);

    }

    @Override
    public void deleteAll() {
        tickets.clear();

    }

    @Override
    public void delete(Ticket ticket) {
        tickets.remove(ticket);
    }

    @Override
    public long count() {
        return tickets.size();
    }
}
