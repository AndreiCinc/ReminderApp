package event.ReminderApp.api;

import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import event.ReminderApp.service.EventService;

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
    public void addEvent(@RequestBody Event event) {
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

    @PutMapping
    public int updateEvent(@RequestBody Event eventToUpdate) {
        return eventService.updateEvent(eventToUpdate);
    }

    @DeleteMapping
    public Event deleteEvent(@RequestBody Event eventDelete) {
        return eventService.deleteEvent(eventDelete);
    }

}
