package event.ReminderApp.dao;

import event.ReminderApp.model.Person;

import java.util.ArrayList;
import java.util.UUID;

public class PersonFakeAccess implements PersonInterface{

    ArrayList<Person> persons = new ArrayList<>();

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
    public ArrayList<Person> getAllPersons() {
        return persons;
    }

    @Override
    public Person getPersonById(UUID id) {
        for (Person p: persons) {
            if (p.getPersonId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void updatePerson(Person person, UUID id) {

    }

    @Override
    public void deletePerson(UUID id) {

    }
}
