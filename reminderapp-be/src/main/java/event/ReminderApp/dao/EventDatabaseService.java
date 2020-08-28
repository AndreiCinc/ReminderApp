package event.ReminderApp.dao;

import event.ReminderApp.model.Event;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
                "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
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
    public List<Event> selectEventsByPersonId(UUID id) {
        String sql = "SELECT id, eventName, startdate, enddate, reminderDate, details, personId " +
                "FROM event WHERE personId = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new ResultSetExtractor<List<Event>>() {
            @Override
            public List<Event> extractData(@NotNull ResultSet rs) throws SQLException, DataAccessException {
                List<Event> list = new ArrayList<Event>();
                while (rs.next()) {
                        UUID eventId = UUID.fromString(rs.getString("id"));
                        String eventName = rs.getString("eventName");
                        Date startDate = new Date(rs.getTimestamp("startDate").getTime());
                        Date endDate = new Date(rs.getTimestamp("endDate").getTime());
                        Date reminderDate = new Date(rs.getTimestamp("reminderDate").getTime());
                        String details = rs.getString("details");
                        UUID personId = UUID.fromString(rs.getString("personId"));
                        list.add(new Event(eventId, eventName, startDate, endDate, reminderDate, details, personId));
                }
                return list;
            }
        });
    }

    @Override
    public List<Event> selectAllEvents() {
        String sql = "SELECT id, eventName, startdate, enddate, reminderDate, details, personId FROM event";
        return jdbcTemplate.query(sql, (resultSet, i )-> {
            UUID eventId =  UUID.fromString(resultSet.getString("Id"));
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
    public Optional<Event> selectEventById(UUID eventId) {
        final String sql = "SELECT id, eventName, startdate, enddate, reminderDate, details, personId " +
                "FROM event WHERE id = ?";
        Event event = jdbcTemplate.queryForObject(
                sql,
                new Object[]{eventId},
                ((resultSet, i) -> {
                    UUID id =  UUID.fromString(resultSet.getString("id"));
                    String eventName = resultSet.getString("eventName");
                    Date startDate = new Date(resultSet.getTimestamp("startDate").getTime());
                    Date endDate = new Date(resultSet.getTimestamp("endDate").getTime());
                    Date reminderDate = new Date(resultSet.getTimestamp("reminderDate").getTime());
                    String details = resultSet.getString("details");
                    UUID personId =  UUID.fromString(resultSet.getString("personId"));
                    return new Event(id, eventName, startDate, endDate, reminderDate, details, personId);
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
        String sql = "DELETE FROM event WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }

    @Override
    public int deleteEventByPersonId(UUID id) {
        String sql = "DELETE FROM event WHERE personId = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }
}
