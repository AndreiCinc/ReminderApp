package event.ReminderApp.service.ReminderApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Reminder {
    private final UUID id;
    @NotBlank
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final String details;

    public Reminder(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("startDate") Date startDate,
                    @JsonProperty("endDate") Date endDate,
                    @JsonProperty("details") String details) {

        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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
    public Date getEndDate() {
        return endDate;
    }
    public String getDetails() {
        return details;
    }

}
