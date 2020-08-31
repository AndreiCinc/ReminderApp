package event.ReminderApp.service;

import event.ReminderApp.dao.UserInterface;
import event.ReminderApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    public final UserInterface userInterface;

    @Autowired
    public UserService(@Qualifier("PersonDatabase") UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public int insertUser(User user) {
        String password = passwordEncoder().encode(user.getUserPassword());
        return userInterface.insertUser(
                new User(
                        user.getUserId(),
                        user.getUserName(),
                        user.getUserEmail(),
                        password,
                        user.getUserObservations(),
                        user.getUserRole()
                )
        );
    }

    public Optional<User> getUserById(UUID id) {
        return userInterface.getUserById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userInterface.getUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userInterface.getAllUsers();
    }

    public int updateUser(User person, UUID id) {
        return userInterface.updateUser(person, id);
    }

    public int deleteUser(UUID id) {
        return userInterface.deleteUser(id);
    }
}
