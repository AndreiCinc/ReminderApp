package event.ReminderApp.dao;

import event.ReminderApp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserInterface {

    int insertUser (User user, UUID id);

    default int insertUser (User user) {
        UUID id = UUID.randomUUID();
        return insertUser(user, id);
    }

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(UUID id);

    List<User> getAllUsers();

    int updateUser(User user, UUID id);

    int deleteUser(UUID id);
    
}
