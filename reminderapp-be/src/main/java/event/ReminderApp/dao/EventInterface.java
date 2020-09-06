package event.ReminderApp.dao;

import event.ReminderApp.model.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface EventInterface {

    int insertEvent(Event Event, UUID id);

    default int insertEvent(Event event) {
        UUID id = UUID.randomUUID();
        return insertEvent(event, id);
    }

    List<Event> selectEventsByPersonId(UUID id);

    List<Event> selectAllEvents();

    Optional<Event> selectEventById(UUID id);

    int updateEventById(UUID id, Event Event);

    int deleteEventById(UUID id);

    int deleteEventByPersonId(UUID id);

}
