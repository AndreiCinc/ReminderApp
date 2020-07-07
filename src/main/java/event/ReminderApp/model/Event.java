package event.ReminderApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Event {
    private final UUID id;
    private final String name;
    private final String startDate;
    private final String duration;
    private final String details;

    public Event(@JsonProperty("id") UUID id, 
                 @JsonProperty("name") String name,
                 @JsonProperty("startDate") String startDate,
                 @JsonProperty("duration") String duration,
                 @JsonProperty("details") String details) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.details = details;
    }

    public UUID getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getDuration() {
        return duration;
    }
    public String getDetails() {
        return details;
    }

}
