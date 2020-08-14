package event.ReminderApp.api;

import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import event.ReminderApp.service.EventService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("event/")
public class EventController {

    public final EventService eventService;
    
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @CrossOrigin
    @PostMapping
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @CrossOrigin
    @GetMapping("getEvent/personId/{id}")
    public List<Event> getAllEventsByPersonId(@PathVariable("id") UUID id) {
        return eventService.getAllEventsByPersonId(id);
    }
    @CrossOrigin
    @GetMapping("getAll/")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("getEvent/eventId/{id}")
    public Event getEventById(@PathVariable("id") UUID id) {
        return eventService.getEventById(id)
                .orElse(null);
    }

    @CrossOrigin
    @PutMapping("putEvent/eventId/{id}")
    public void updateEvent(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Event eventToUpdate) {
        eventService.updateEvent(id, eventToUpdate);
    }

    @CrossOrigin
    @DeleteMapping("deleteEvent/eventId/{id}")
    public void deleteEvent(@PathVariable("id") UUID id) {
        eventService.deleteEvent(id);
    }

    @CrossOrigin
    @DeleteMapping("deleteEvent/personId/{id}")
    public void deleteEventByPersonId(@PathVariable("id") UUID id) {
        eventService.deleteEventsByPersonId(id);
    }

}
