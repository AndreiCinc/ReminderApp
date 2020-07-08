package event.ReminderApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class Event {
    private final UUID id;
    private final String name;
    private final Date startDate;
    private final Date startHour;
    private final Date endDate;
    private final Date endHour;
    private final String details;

    public Event(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name,
                 @JsonProperty("startDate") Date startDate,
                 @JsonProperty("startHour") Date startHour,
                 @JsonProperty("endDate") Date endDate,
                 @JsonProperty("endHour") Date endHour,
                 @JsonProperty("details") String details) {

        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endHour = endHour;
        this.details = details;
    }

    public UUID getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public Date getStartDate() {
        return startDate;
    }

    public Date getStartHour() {
        return startHour;
    }

    public Date getEndDate() {
        return endDate;
    }
    public Date getEndHour() {
        return endHour;
    }
    public String getDetails() {
        return details;
    }

}
