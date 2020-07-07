package event.ReminderApp.dao;

import event.ReminderApp.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class EventList implements EventInterface{

    private static final List<Event> events = new ArrayList<>();


    @Override
    public int insertEvent(UUID id, Event event) {
        events.add(new Event(
                id,
                event.getName(),
                event.getStartDate(),
                event.getDuration(),
                event.getDetails()));
        return 0;
    }

    @Override
    public List<Event> selectAllEvents() {
        return events;
    }

    @Override
    public Optional<Event> selectEventById(UUID id) {
        return events.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateEvent(Event event) {
          events.forEach(e -> {
                    if (event.getStartDate().compareTo(e.getStartDate()) == 0) {
                        events.set(events.indexOf(e), event);
                    }
                });
        return 1;
    }

    @Override
    public Event deleteEvent(Event event) {
        events.removeIf(e -> e.getStartDate().compareTo(event.getStartDate()) == 0);
        return null;
    }
}
