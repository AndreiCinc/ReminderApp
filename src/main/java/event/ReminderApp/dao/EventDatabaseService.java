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
                "INSERT INTO event (id, eventName, startdate, enddate, details) " +
                "VALUES ( ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                event.getName(),
                event.getStartDate(),
                event.getEndDate(),
                event.getDetails()
        );
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
    public int updateEventById(UUID id, Event event) {
        System.out.println("aici");
        final String sql = "UPDATE event SET eventName = ?, startdate = ?, enddate = ?, details = ? WHERE id = ?";
        jdbcTemplate.update(sql, event.getName(), event.getStartDate(), event.getEndDate(), event.getDetails(), id);
        return 0;
    }

    @Override
    public int deleteEventById(UUID id) {
        final String sql = "DELETE FROM event WHERE id = ?";
        final Object[] eventId = new Object[]{id};
        jdbcTemplate.update(sql, eventId);
        return 5;
    }
}
