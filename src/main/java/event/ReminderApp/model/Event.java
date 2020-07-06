package event.ReminderApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    private final String name;
    private final String startDate;
    private final String duration;
    private final String details;

    public Event(@JsonProperty("name") String name,
                 @JsonProperty("startDate") String startDate,
                 @JsonProperty("duration") String duration,
                 @JsonProperty("details") String details) {
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.details = details;
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
