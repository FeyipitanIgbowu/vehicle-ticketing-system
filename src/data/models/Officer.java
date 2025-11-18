package data.models;

import java.util.HashMap;

public class Officer {
    private int id;
    private String name;
    private String rank;
    private String username;
    private String password;
    private String email;
    private HashMap<String, String> officer;

    public HashMap<String, String> getOfficer() {
        return officer;
    }

    public void setOfficer(HashMap<String, String> officer) {
        this.officer = officer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



