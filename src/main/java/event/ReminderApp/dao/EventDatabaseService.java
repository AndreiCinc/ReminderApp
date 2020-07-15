package event.ReminderApp.dao;

import event.ReminderApp.model.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventDatabaseService implements EventInterface {
    @Override
    public int insertEvent(UUID id, Event Event) {
        return 0;
    }

    @Override
    public List<Event> selectAllEvents() {
        return null;
    }

    @Override
    public Optional<Event> selectEventById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int updateEventById(UUID id, Event Event) {
        return 0;
    }

    @Override
    public int deleteEventById(UUID id) {
        return 0;
    }
}
