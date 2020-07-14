package event.ReminderApp.api;

import event.ReminderApp.model.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import event.ReminderApp.service.ReminderService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("event/ReminderApp/api/v1/event")
@RestController
public class ReminderController {

    public final ReminderService eventService;
    
    @Autowired
    public ReminderController(ReminderService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void addEvent(@Valid @NotNull @RequestBody Reminder event)  {
        eventService.addEvent(event);
    }

    @GetMapping
    public List<Reminder> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{id}")
    public Reminder getEventById(@PathVariable("id") UUID id) {
        return eventService.getEventById(id)
                .orElse(null);
    }

    @PutMapping("{id}")
    public void updateEvent(@NotNull @PathVariable("id") UUID id, @Valid @NotNull @RequestBody Reminder eventToUpdate) {
        eventService.updateEvent(id, eventToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable("id") UUID id) {
         eventService.deleteEvent(id);
    }
}
