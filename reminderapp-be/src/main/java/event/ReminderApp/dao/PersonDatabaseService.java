package event.ReminderApp.dao;

import event.ReminderApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PersonDatabase")
public class PersonDatabaseService implements PersonInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(Person person, UUID id) {
        String sql = "INSERT INTO person(id, name, email, password, observations, role)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                person.getPersonName(),
                person.getPersonEmail(),
                person.getPersonPassword(),
                person.getPersonObservations(),
                person.getPersonRole()
        );
        return 0;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        String sql = "SELECT id, name, email, password, observations, role FROM person WHERE id= ?";
        Person person =  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, i) -> {
                    UUID personId = UUID.fromString(rs.getString("id"));
                    String personName = rs.getString("name");
                    String personEmail = rs.getString("email");
                    String personPassword = rs.getString("password");
                    String personObservations = rs.getString("observations");
                    String personRole = rs.getString("role");
                    return new Person(personId, personName, personEmail, personPassword, personObservations, personRole);
                });
        return Optional.ofNullable(person);
    }

    @Override
    public List<Person> getAllPersons() {
        String sql = "SELECT id, name, email, password, observations, role FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String personName = resultSet.getString("name");
            String personEmail = resultSet.getString("email");
            String personPassword = resultSet.getString("password");
            String personObservations = resultSet.getString("observations");
            String personRole = resultSet.getString("role");
            return new Person(personId, personName, personEmail, personPassword, personObservations, personRole);
        });
    }

    @Override
    public int updatePerson(Person person, UUID id) {
        String sql = "UPDATE person SET name = ? email = ?, password = ?, observations = ?, role = ? WHERE id = ?";
        jdbcTemplate.update(
                sql,
                person.getPersonName(),
                person.getPersonEmail(),
                person.getPersonPassword(),
                person.getPersonObservations(),
                person.getPersonRole(), id);
        return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        String sql = "DELETE person WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }
}
