package event.ReminderApp.service;

import event.ReminderApp.dao.ReminderList;
import event.ReminderApp.model.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReminderService {

    public final ReminderList eventList;

    @Autowired
    public ReminderService(@Qualifier("bam") ReminderList eventList) {
        this.eventList = eventList;
    }

    public int addEvent(Reminder event) {
        return eventList.insertReminder(event);
    }

    public Optional<Reminder> getEventById(UUID id) {
        return eventList.selectReminderById(id);
    }

    public List<Reminder> getAllEvents() {
        return eventList.selectAllReminders();
    }

    public int updateEvent(UUID id, Reminder event){
        return eventList.updateReminderById(id, event);
    }

    public int deleteEvent(UUID id) {
        return eventList.deleteReminderById(id);
    }
}
