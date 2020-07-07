package event.ReminderApp.dao;

import event.ReminderApp.model.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventInterface<Obtional> {

    int insertEvent(UUID id, Event event);

    default int insertEvent(Event event) {
        UUID id = UUID.randomUUID();
        return insertEvent(id, event);
    }

    List<Event> selectAllEvents();

    Optional<Event> selectEventById(UUID id);

    int updateEventById(UUID id, Event event);

    int deleteEventById(UUID id);

}
