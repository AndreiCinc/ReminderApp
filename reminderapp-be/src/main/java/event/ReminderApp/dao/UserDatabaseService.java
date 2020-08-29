package event.ReminderApp.dao;

import event.ReminderApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PersonDatabase")
public class UserDatabaseService implements UserInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(User user, UUID id) {
        String sql = "INSERT INTO person(id, personName, email, password, observations, role)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id,
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserObservations(),
                user.getUserRole()
        );
        return 0;
    }


    @Override
    public Optional<User> getUserByEmail(String email) {
        String sql = "SELECT id, personName, email, password, observations, role FROM person WHERE email= ?";
        User user =  jdbcTemplate.queryForObject(
                sql,
                new Object[]{email},
                (rs, i) -> {
                    UUID personId = UUID.fromString(rs.getString("id"));
                    String personName = rs.getString("personName");
                    String personEmail = rs.getString("email");
                    String personPassword = rs.getString("password");
                    String personObservations = rs.getString("observations");
                    String personRole = rs.getString("role");
                    return new User(personId, personName, personEmail, personPassword, personObservations, personRole);
                });
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        String sql = "SELECT id, personName, email, password, observations, role FROM person WHERE id= ?";
        User user =  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, i) -> {
                    UUID personId = UUID.fromString(rs.getString("id"));
                    String personName = rs.getString("personName");
                    String personEmail = rs.getString("email");
                    String personPassword = rs.getString("password");
                    String personObservations = rs.getString("observations");
                    String personRole = rs.getString("role");
                    return new User(personId, personName, personEmail, personPassword, personObservations, personRole);
                });
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT id, personName, email, password, observations, role FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("id"));
            String userName = resultSet.getString("personName");
            String userEmail = resultSet.getString("email");
            String userPassword = resultSet.getString("password");
            String userObservations = resultSet.getString("observations");
            String userRole = resultSet.getString("role");
            return new User(userId, userName, userEmail, userPassword, userObservations, userRole);
        });
    }

    @Override
    public int updateUser(User user, UUID id) {
        String sql = "UPDATE person " +
                "SET personName = ?, " +
                "email = ?, " +
                "password = ?, " +
                "observations = ?, " +
                "role = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(
                sql,
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserObservations(),
                user.getUserRole(),
                id
        );
        return 0;
    }

    @Override
    public int deleteUser(UUID id) {
        String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }
}
