package data.repository;

import data.models.Officer;

import java.util.ArrayList;

public interface OfficersRepository {

    Officers save(Officer officer);

    ArrayList<Officer> findByID(int id);

    ArrayList<Officer> findAll();

    void deleteById(int id);

    void deleteAll();

    void delete(Officer officer);

    long count();

    Officer findByEmail(String email);




}
