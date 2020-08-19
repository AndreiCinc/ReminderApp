package event.ReminderApp.dao;

import event.ReminderApp.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonInterface {

    int insertPerson (Person person, UUID id);

    default int insertPerson (Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(person, id);
    }

    Optional<Person> getPersonByEmail(String email);

    Optional<Person> getPersonById(UUID id);

    List<Person> getAllPersons();

    int updatePerson(Person person, UUID id);

    int deletePerson(UUID id);
}
