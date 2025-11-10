package data.models;

public class Owner {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String gender;
    private String email;

    public Owner(String id, String name, String address, String phone, String gender, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
