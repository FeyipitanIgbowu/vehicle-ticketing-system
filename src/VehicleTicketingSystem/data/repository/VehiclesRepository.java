package data.repository;
import data.models.Vehicle;

import java.util.ArrayList;

public interface VehiclesRepository {

        Vehicle save(Vehicle vehicle);

        Vehicle findByID(int id);

        ArrayList<Vehicle> findAll();

        void deleteById(int id);

        void deleteAll();

        void delete(Vehicle vehicle);

        long count();

        Vehicle findByChasisNumber(String chasisNumber);

}
