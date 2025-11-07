package models;

public class Officer {
    private int id;
    private String name;
    private String rank;
    private String username;
    private String password;

    public Officer(int id, String name, String rank, String username, String password) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
