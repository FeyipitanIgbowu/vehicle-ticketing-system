package data.repository;

import data.models.Officer;

import java.util.ArrayList;

public class Officers implements OfficersRepository {

        private ArrayList<Officer> officers;

        public Officers() {
            officers = new ArrayList<>();
        }

        @Override
        public Officers save(Officer officer) {
            if (!officers.contains(officer)) {
                officers.add(officer);
            }
            return this;
        }

        @Override
        public ArrayList<Officer> findByID(int id) {
            ArrayList<Officer> result = new ArrayList<>();
            for (Officer officer : officers) {
                if (officer.getId() == id) {
                    result.add(officer);
                }
            }
            return result;
        }

        @Override
        public ArrayList<Officer> findAll() {
            return officers;
        }

        @Override
        public void deleteById(int id) {
            officers.removeIf(officer -> officer.getId() == id);
        }

        @Override
        public void deleteAll() {
            officers.clear();
        }

        @Override
        public void delete(Officer officer) {
            officers.remove(officer);
        }

        @Override
        public long count() {
            return officers.size();
        }

        public Officer findByEmail(String email) {
        for (Officer officer : officers) {
            if (officer.getEmail() != null && officer.getEmail().equals(email)) {
                return officer;
            }
        }
        return null;
    }
    }


