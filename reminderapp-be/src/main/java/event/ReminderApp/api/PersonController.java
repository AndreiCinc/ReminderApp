package event.ReminderApp.api;

import event.ReminderApp.model.Person;
import event.ReminderApp.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonController {

    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public int insertPerson(Person person) {
        return personService.insertPerson(person);
    }

    public Optional<Person> getPersonById(UUID id) {
        return personService.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    public int updatePerson(Person person, UUID id) {
        return personService.updatePerson(person, id);
    }

    public int deletePerson(UUID id) {
        return personService.deletePerson(id);
    }
}
