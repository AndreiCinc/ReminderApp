package event.ReminderApp.dao;

import event.ReminderApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EventDatabaseService implements EventInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEvent(UUID id, Event Event) {
        return 0;
    }

    @Override
    public int insertEvent(Event Event) {

        return 0;
    }

    @Override
    public List<Event> selectAllEvents() {
        final String sql = "SELECT id, eventName, startdate, enddate, details FROM event";
        return jdbcTemplate.query(sql, (resultSet, i )-> {
            UUID eventId =  UUID.fromString(resultSet.getString("id"));
            String eventName = resultSet.getString("eventName");
            Date startDate = resultSet.getDate("startdate");
            Date endDate = resultSet.getDate("endDate");
            String details = resultSet.getString("details");
            return new Event(eventId, eventName, startDate, endDate, details);
        });
    }

    @Override
    public Optional<Event> selectEventById(UUID id) {
        final String sql = "SELECT id, eventName, startdate, enddate, details FROM event WHERE id = ?";
        Event event = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                ((resultSet, i) -> {
                    UUID eventId =  UUID.fromString(resultSet.getString("id"));
                    String eventName = resultSet.getString("eventName");
                    Date startDate = resultSet.getDate("startdate");
                    Date endDate = resultSet.getDate("endDate");
                    String details = resultSet.getString("details");
                    return new Event( eventId, eventName, startDate, endDate, details);
                 })
        );
        return Optional.ofNullable(event);
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
