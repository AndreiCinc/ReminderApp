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

    @Autowired
    public EventService(@Qualifier("bam") EventInterface eventInterface) {
        this.eventInterface = eventInterface;
    }

    public int addEvent(Event event) {
        return eventInterface.insertEvent(event);
    }

    public Optional<Event> getEventById(UUID id) {
        return eventInterface.selectEventById(id);
    }

    public List<Event> getAllEvents() {
        return eventInterface.selectAllEvents();
    }

    public int updateEvent(UUID id, Event event){
        return eventInterface.updateEventById(id, event);
    }

    public int deleteEvent(UUID id) {
        return eventInterface.deleteEventById(id);
    }
}
