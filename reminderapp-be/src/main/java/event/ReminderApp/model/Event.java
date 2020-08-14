package event.ReminderApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class Event {
    private final UUID id;
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final Date reminderDate;
    private final String details;
    private final UUID personId;

    public Event(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name,
                 @JsonProperty("startDate") Date startDate,
                 @JsonProperty("endDate") Date endDate,
                 @JsonProperty("reminderDate") Date reminderDate,
                 @JsonProperty("details") String details,
                 @JsonProperty("personId") UUID personId) {

        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reminderDate = reminderDate;
        this.details = details;
        this.personId = personId;
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
    public Date getEndDate() {
        return endDate;
    }
    public Date getReminderDate() {
        return reminderDate;
    }
    public String getDetails() {
        return details;
    }
    public UUID getPersonId() {
        return personId;
    }

}
