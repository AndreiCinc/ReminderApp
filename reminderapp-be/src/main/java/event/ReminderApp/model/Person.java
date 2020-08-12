package event.ReminderApp.model;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
    private final String observations;
    private final String role;

    public Person(
            UUID id,
            String name,
            String email,
            String password,
            String observations,
            String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.observations = observations;
        this.role = role;
    }

    public UUID getPersonId() {
        return id;
    }
    public String getPersonName() {
        return name;
    }
    public String getPersonEmail() {
        return email;
    }
    public String getPersonPassword() {
        return password;
    }
    public String getPersonObservations() {
        return observations;
    }
    public String getPersonRole() {
        return role;
    }
}
