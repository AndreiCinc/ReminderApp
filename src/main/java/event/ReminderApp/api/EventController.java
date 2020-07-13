package event.ReminderApp.api;

import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import event.ReminderApp.service.EventService;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RequestMapping("event/ReminderApp/api/v1/event")
@RestController
public class EventController {

    public final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void addEvent(@RequestBody Event event) throws ParseException {
        eventService.addEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{id}")
    public Event getEventById(@PathVariable("id") UUID id) {
        return eventService.getEventById(id)
                .orElse(null);
    }

    @PutMapping("{id}")
    public void updateEvent(@PathVariable("id") UUID id, @RequestBody Event eventToUpdate) {
        eventService.updateEvent(id, eventToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable("id") UUID id) {
         eventService.deleteEvent(id);
    }
}
