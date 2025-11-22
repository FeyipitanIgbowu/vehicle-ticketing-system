package data.repository;

import data.models.Officer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface OfficersRepository extends MongoRepository<Officer, String> {
    Officer save(Officer officer);
    Optional<Officer> findById(String id);
    ArrayList<Officer> findAll();
    void deleteById(String id);
    void delete(Officer officer);
    void deleteAll();
    long count();
    Officer findByEmail(String email);
}
