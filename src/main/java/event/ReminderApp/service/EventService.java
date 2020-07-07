package event.ReminderApp.service;

import event.ReminderApp.dao.EventList;
import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    public final EventList eventList;

    @Autowired
    public EventService(@Qualifier("postgres") EventList eventList) {
        this.eventList = eventList;
    }

    public int addEvent(Event event) {
        return eventList.insertEvent(event);
    }

    public Optional<Event> getEventById(UUID id) {
        return eventList.selectEventById(id);
    }

    public List<Event> getAllEvents() {
        return eventList.selectAllEvents();
    }

    public int updateEvent(Event event){
        return eventList.updateEvent(event);
    }

    public Event deleteEvent(Event event) {
        return eventList.deleteEvent(event);
    }
}
