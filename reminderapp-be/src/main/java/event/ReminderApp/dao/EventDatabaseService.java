package event.ReminderApp.dao;

import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class EventDatabaseService implements EventInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEvent(UUID id, Event event) {
        final String sql = "" +
                "INSERT INTO event (id, eventName, startdate, enddate, reminderDate, details, personId) " +
                "VALUES ( ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                event.getName(),
                event.getStartDate(),
                event.getEndDate(),
                event.getReminderDate(),
                event.getDetails(),
                event.getPersonId()
        );
        return 0;
    }

    @Override
    public List<Event> selectAllEvents() {
        String sql = "SELECT id, eventName, startdate, enddate, reminderDate, details FROM event";
        return jdbcTemplate.query(sql, (resultSet, i )-> {
            UUID eventId =  UUID.fromString(resultSet.getString("id"));
            String eventName = resultSet.getString("eventName");
            Date startDate = new Date(resultSet.getTimestamp("startDate").getTime());
            Date endDate = new Date(resultSet.getTimestamp("endDate").getTime());
            Date reminderDate = new Date(resultSet.getTimestamp("reminderDate").getTime());
            String details = resultSet.getString("details");
            UUID personId =  UUID.fromString(resultSet.getString("personId"));
            return new Event(eventId, eventName, startDate, endDate, reminderDate, details, personId);
        });
    }

    @Override
    public Optional<Event> selectEventById(UUID id) {
        final String sql = "SELECT id, eventName, startdate, enddate, reminderDate, details FROM event WHERE id = ?";
        Event event = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                ((resultSet, i) -> {
                    UUID eventId =  UUID.fromString(resultSet.getString("id"));
                    String eventName = resultSet.getString("eventName");
                    Date startDate = new Date(resultSet.getTimestamp("startDate").getTime());
                    Date endDate = new Date(resultSet.getTimestamp("endDate").getTime());
                    Date reminderDate = new Date(resultSet.getTimestamp("reminderDate").getTime());
                    String details = resultSet.getString("details");
                    UUID personId =  UUID.fromString(resultSet.getString("personId"));
                    return new Event( eventId, eventName, startDate, endDate, reminderDate, details, personId);
                 })
        );
        return Optional.ofNullable(event);
    }

    @Override
    public int updateEventById(UUID id, Event event) {
        final String sql = "UPDATE event SET " +
                "eventName = ?, " +
                "startdate = ?, " +
                "enddate = ?, " +
                "reminderDate = ?, " +
                "details = ?, " +
                "personId = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(
                sql,
                event.getName(),
                event.getStartDate(),
                event.getEndDate(),
                event.getReminderDate(),
                event.getDetails(),
                event.getPersonId(),
                id);
        return 0;
    }

    @Override
    public int deleteEventById(UUID id) {
        final String sql = "DELETE FROM event WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return 5;
    }
}
