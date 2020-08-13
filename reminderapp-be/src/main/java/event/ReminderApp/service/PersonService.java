package event.ReminderApp.service;

import event.ReminderApp.dao.PersonInterface;
import event.ReminderApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    public final PersonInterface personInterface;

    @Autowired
    public PersonService(@Qualifier("FakePerson") PersonInterface personInterface) {
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
