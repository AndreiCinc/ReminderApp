package event.ReminderApp.api;

import event.ReminderApp.Exceptions.ApiException;
import event.ReminderApp.Exceptions.ApiExceptionHandler;
import event.ReminderApp.Exceptions.ApiRequestException;
import event.ReminderApp.model.Event;
import event.ReminderApp.service.AuthenticationService;
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
    public final AuthenticationService authenticationService;
    @Autowired
    public EventController(EventService eventService, AuthenticationService authenticationService) {
        this.eventService = eventService;
        this.authenticationService = authenticationService;
    }

    @CrossOrigin
    @PostMapping("create/")
    public void addEvent(@RequestBody Event event,
                         @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        eventService.addEvent(event, jwt);
    }

    @CrossOrigin
    @GetMapping("selectByPerson/")
    public List<Event> getAllEventsByPersonId(@RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        return eventService.getAllEventsByPersonId(jwt);
    }

    @GetMapping("{id}/select")
    public Event getEventById(@PathVariable("id") UUID id,
                              @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        return eventService.getEventById(id)
                .orElse(null);
    }

    @CrossOrigin
    @GetMapping("all/")
    public List<Event> getAllEvents(@RequestHeader("person") String jwt) {
            try {
                authenticationService.decodeJWT(jwt);
            } catch (Exception e) {
                throw new ApiRequestException("Invalid token", e.getCause());
            }
        return eventService.getAllEvents();
    }

    @CrossOrigin
    @PutMapping("{id}/update")
    public void updateEvent(@PathVariable("id") UUID id,
                            @Valid @NotNull
                            @RequestBody Event eventToUpdate,
                            @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        eventService.updateEvent(id, eventToUpdate);
    }

    @CrossOrigin
    @DeleteMapping("{id}/delete")
    public void deleteEvent(@PathVariable("id") UUID id,
                            @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        eventService.deleteEvent(id);
    }

    @CrossOrigin
    @DeleteMapping("{id}/deleteByPerson")
    public void deleteEventByPersonId(@PathVariable("id") UUID id,
                                      @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        eventService.deleteEventsByPersonId(id);
    }

}
