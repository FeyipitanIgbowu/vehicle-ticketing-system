package data.repository;

import data.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface TicketsRepository extends MongoRepository<Ticket, String> {

        Ticket save(Ticket ticket);

        Ticket findByID(int id);

        ArrayList<Ticket> findAll();

        void deleteById(int id);

        void deleteAll();

        void delete(Ticket ticket);

        long count();

}
