package event.ReminderApp.dao;

import event.ReminderApp.model.Event;

import java.util.List;

public interface EventInterface {

    int insertEvent(Event event);

    List<Event> selectAllEvents();

    int updateEvent(Event event);

    Event deleteEvent(Event event);

}
