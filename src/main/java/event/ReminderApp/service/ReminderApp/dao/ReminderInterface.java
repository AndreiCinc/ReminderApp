package event.ReminderApp.service.ReminderApp.dao;

import event.ReminderApp.service.ReminderApp.model.Reminder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReminderInterface {

    int insertReminder(UUID id, Reminder reminder);

    default int insertReminder(Reminder reminder) {
        UUID id = UUID.randomUUID();
        return insertReminder(id, reminder);
    }

    List<Reminder> selectAllReminders();

    Optional<Reminder> selectReminderById(UUID id);

    int updateReminderById(UUID id, Reminder reminder);

    int deleteReminderById(UUID id);

}
