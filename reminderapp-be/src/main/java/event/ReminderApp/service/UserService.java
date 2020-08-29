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

    public final UserInterface personInterface;

    @Autowired
    public UserService(@Qualifier("PersonDatabase") UserInterface personInterface) {
        this.personInterface = personInterface;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public int insertUser(User user) {
        String password = passwordEncoder().encode(user.getUserPassword());
        return personInterface.insertUser(
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
        return personInterface.getUserById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return personInterface.getUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return personInterface.getAllUsers();
    }

    public int updateUser(User person, UUID id) {
        return personInterface.updateUser(person, id);
    }

    public int deleteUser(UUID id) {
        return personInterface.deleteUser(id);
    }
}
