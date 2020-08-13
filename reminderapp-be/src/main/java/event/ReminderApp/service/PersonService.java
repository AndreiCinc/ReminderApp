package event.ReminderApp.service;

import event.ReminderApp.dao.PersonInterface;
import event.ReminderApp.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonService {

    public final PersonInterface personInterface;

    public PersonService(PersonInterface personInterface) {
        this.personInterface = personInterface;
    }

    public int insertPerson(Person person) {
        return personInterface.insertPerson(person);
    }

    public Optional<Person> getPersonById(UUID id) {
        return personInterface.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personInterface.getAllPersons();
    }

    public int updatePerson(Person person, UUID id) {
        return personInterface.updatePerson(person, id);
    }

    public int deletePerson(UUID id) {
        return personInterface.deletePerson(id);
    }
}
