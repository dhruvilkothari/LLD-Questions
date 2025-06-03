package Passenger;

import java.rmi.server.UID;
import java.util.UUID;

public class Passenger {
    private final String id;
    private final String name;
    private final String email;

    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
        id = UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

}
