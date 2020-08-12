package event.ReminderApp.dao;

import event.ReminderApp.model.Person;

import java.util.ArrayList;
import java.util.UUID;

public interface PersonInterface {

    int insertPerson (Person person, UUID id);

    default int insertPerson (Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(person, id);
    }
    
    public ArrayList<Person> getAllPersons();

    Person getPersonById(UUID id);

    void updatePerson(Person person, UUID id);

    void deletePerson(UUID id);
}
