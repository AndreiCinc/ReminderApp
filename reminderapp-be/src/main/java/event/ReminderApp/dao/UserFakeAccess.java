/*
package event.ReminderApp.dao;

import event.ReminderApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakePerson")
public class UserFakeAccess implements UserInterface {

    private static List<User> users = new ArrayList<>();

    @Override
    public int insertPerson(User user, UUID id) {
        users.add(new User(
                id,
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserObservations(),
                user.getUserRole()
        ));
        return 0;
    }

    @Override
    public Optional<User> getPersonByEmail(String email) {
        return users.stream().filter(person -> person.getUserEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<User> getPersonById(UUID id) {
       return users.stream().filter(person -> person.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> getAllPersons() {
        return users;
    }


    @Override
    public int updatePerson(User user, UUID id) {
       getPersonById(id).map(p -> {
           if (p.getUserId().equals(id)) {
               users.set(users.indexOf(p),
                       new User(
                               id,
                               user.getUserName(),
                               user.getUserEmail(),
                               user.getUserPassword(),
                               user.getUserObservations(),
                               user.getUserRole()
                       ));
           }
           return 0;
       });
       return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        users.removeIf(p -> p.getUserId().equals(id));
    return 0;
    }
}
*/
