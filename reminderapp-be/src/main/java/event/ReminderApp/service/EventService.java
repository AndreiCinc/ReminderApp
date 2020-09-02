package event.ReminderApp.service;

import event.ReminderApp.dao.EventInterface;
import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    public final EventInterface eventInterface;
    public final AuthenticationService authenticationService;

    @Autowired
    public EventService(@Qualifier("postgres") EventInterface eventInterface,
                        AuthenticationService authenticationService) {
        this.eventInterface = eventInterface;
        this.authenticationService = authenticationService;
    }


    public int addEvent(Event event, String jwt) {
        UUID id = UUID.fromString(authenticationService.decodeJWT(jwt).getId());
        return eventInterface.insertEvent(new Event(
                event.getId(),
                event.getName(),
                event.getStartDate(),
                event.getEndDate(),
                event.getReminderDate(),
                event.getDetails(),
                id));
    }

    public Optional<Event> getEventById(UUID id) {
        return eventInterface.selectEventById(id);
    }

    public List<Event> getAllEventsByPersonId(String jwt) {
        UUID id = UUID.fromString(authenticationService.decodeJWT(jwt).getId());
        return eventInterface.selectEventsByPersonId(id);
    }

    public List<Event> getAllEvents() {
        return eventInterface.selectAllEvents();
    }

    public void updateEvent(UUID id, Event event){
        eventInterface.updateEventById(id, event);
    }

    public void deleteEvent(UUID id) {
        eventInterface.deleteEventById(id);
    }

    public void deleteEventsByPersonId(UUID id) {
        eventInterface.deleteEventByPersonId(id);
    }

}
