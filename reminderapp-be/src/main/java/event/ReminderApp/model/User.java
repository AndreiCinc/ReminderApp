package event.ReminderApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String userName;
    private final String email;
    private final String password;
    private final String observations;
    private final String role;

    public User(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String userName,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("observations") String observations,
            @JsonProperty("role") String role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.observations = observations;
        this.role = role;
    }

    public UUID getUserId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserEmail() {
        return email;
    }
    public String getUserPassword() {
        return password;
    }
    public String getUserObservations() {
        return observations;
    }
    public String getUserRole() {
        return role;
    }
}
