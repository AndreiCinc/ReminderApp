package event.ReminderApp.dao;

import event.ReminderApp.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakePerson")
public class PersonFakeAccess implements PersonInterface{

    List<Person> persons = new ArrayList<>();

    @Override
    public int insertPerson(Person person, UUID id) {
        persons.add(new Person(
                id,
                person.getPersonName(),
                person.getPersonEmail(),
                person.getPersonPassword(),
                person.getPersonObservations(),
                person.getPersonRole()
        ));
        return 0;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
       return persons.stream().filter(person -> person.getPersonId().equals(id))
                .findFirst();
    }

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }


    @Override
    public int updatePerson(Person person, UUID id) {
       getPersonById(id).map(p -> {
           if (p.getPersonId().equals(id)) {
               persons.set(persons.indexOf(p), person);
           }
           return 0;
       });
       return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        persons.removeIf(p -> p.getPersonId().equals(id));
    return 0;
    }
}
