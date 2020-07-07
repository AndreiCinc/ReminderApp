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
    public int updateEventById(UUID id, Event event) {
        selectEventById(id).map(e -> {
            if (e.getId().equals(id)) {
                int indexOfEvent = events.indexOf(e);
                events.set(indexOfEvent, new Event(
                        id,
                        event.getName(),
                        event.getStartDate(),
                        event.getDuration(),
                        event.getDetails()
                ));
                return 1;
            }
            return 0;
        })
                .orElse(0);
        return 0;
    }

    @Override
    public int deleteEventById(UUID id) {
        events.removeIf(e -> e.getId().equals(id));
        return 1;
    }
}
