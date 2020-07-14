package event.ReminderApp.service.ReminderApp.dao;

import event.ReminderApp.service.ReminderApp.model.Reminder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("bam")
public class ReminderList implements ReminderInterface {

    private static final List<Reminder> reminders = new ArrayList<>();

    @Override
    public int insertReminder(UUID id, Reminder reminder) {
        reminders.add(new Reminder(
                id,
                reminder.getName(),
                reminder.getStartDate(),
                reminder.getEndDate(),
                reminder.getDetails())
        );
        return 0;
    }

    @Override
    public List<Reminder> selectAllReminders() {
        return reminders;
    }

    @Override
    public Optional<Reminder> selectReminderById(UUID id) {
        return reminders.stream()
                .filter(reminder -> reminder.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateReminderById(UUID id, Reminder reminder) {
        selectReminderById(id).map(r -> {
            if (r.getId().equals(id)) {
                int indexOfEvent = reminders.indexOf(r);
                reminders.set(indexOfEvent, new Reminder(
                        id,
                        reminder.getName(),
                        reminder.getStartDate(),
                        reminder.getEndDate(),
                        reminder.getDetails()
                ));
                return 1;
            }
            return 0;
        });
        return 0;
    }

    @Override
    public int deleteReminderById(UUID id) {
        reminders.removeIf(r -> r.getId().equals(id));
        return 1;
    }
}
