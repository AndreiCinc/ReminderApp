package event.ReminderApp.service;

import event.ReminderApp.dao.UserInterface;
import event.ReminderApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> refactor
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

<<<<<<< HEAD
    public final UserInterface userInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(@Qualifier("PersonDatabase") UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public int insertPerson(User user) {
        return userInterface.insertUser(
                new User(
                        user.getUserId(),
                        user.getUserName(),
                        user.getUserEmail(),
                        passwordEncoder.encode(user.getUserPassword()),
                        user.getUserObservations(),
                        user.getUserRole()
        ));
    }

    public Optional<User> getPersonById(UUID id) {
        return userInterface.getUserById(id);
    }

    public Optional<User> getPersonByEmail(String email) {
        return userInterface.getUserByEmail(email);
    }

    public List<User> getAllPersons() {
        return userInterface.getAllUsers();
    }

    public int updatePerson(User user, UUID id) {
        return userInterface.updateUser(user, id);
    }

    public int deletePerson(UUID id) {
        return userInterface.deleteUser(id);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
=======
    public final UserInterface personInterface;

    @Autowired
    public UserService(@Qualifier("PersonDatabase") UserInterface personInterface) {
        this.personInterface = personInterface;
    }

    public int insertUser(User user) {
        return personInterface.insertUser(user);
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
>>>>>>> refactor
    }
}
