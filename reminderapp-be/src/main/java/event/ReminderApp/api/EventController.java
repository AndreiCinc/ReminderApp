package event.ReminderApp.api;

import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
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
    @PostMapping("create/")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @CrossOrigin
    @GetMapping("selectByPerson/")
    public List<Event> getAllEventsByPersonId(@RequestHeader("person") String jwt) {
        return eventService.getAllEventsByPersonId(jwt);
    }

    @GetMapping("{id}/select")
    public Event getEventById(@PathVariable("id") UUID id) {
        return eventService.getEventById(id)
                .orElse(null);
    }

    @CrossOrigin
    @GetMapping("all/")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @CrossOrigin
    @PutMapping("{id}/update")
    public void updateEvent(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Event eventToUpdate) {
        eventService.updateEvent(id, eventToUpdate);
    }

    @CrossOrigin
    @DeleteMapping("{id}/delete")
    public void deleteEvent(@PathVariable("id") UUID id) {
        eventService.deleteEvent(id);
    }

    @CrossOrigin
    @DeleteMapping("{id}/deleteByPerson")
    public void deleteEventByPersonId(@PathVariable("id") UUID id) {
        eventService.deleteEventsByPersonId(id);
    }

}
