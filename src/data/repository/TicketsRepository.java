package data.repository;

import data.models.Ticket;

import java.util.ArrayList;

public interface TicketsRepository {

        Ticket save(Ticket ticket);

        Ticket findByID(int id);

        ArrayList<Ticket> findAll();

        void deleteById(int id);

        void deleteAll();

        void delete(Ticket ticket);

        long count();


}
