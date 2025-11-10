package data.services;

import data.models.Officer;
import java.util.HashMap;
import java.util.Map;
import data.Exception.InvalidOfficerValidationException;

public class OfficerRegistry {

    private final Map<String, Officer> officers = new HashMap<>();

    public OfficerRegistry() {
        addOfficer(new Officer(1, "Chiamie", "Sergeant", "chibaby", "123"));
        addOfficer(new Officer(2, "Onoja", "Inspector", "badfather01", "456"));
        addOfficer(new Officer(3, "Eloka", "Corporal", "rebel", "789"));
    }

    public void addOfficer(Officer officer) {
        officers.put(officer.getUsername(), officer);
    }

    public Officer authenticate(String username, String password) {
        Officer officer = officers.get(username);
        if (officer != null && officer.getPassword().equals(password)) {
            return officer;
        }
        throw new InvalidOfficerValidationException("Invalid username or password");
    }
}
