package event.ReminderApp.api;

import event.ReminderApp.model.Person;
import event.ReminderApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    public final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin
    @PostMapping
    public int insertPerson(@RequestBody Person person) {
        return personService.insertPerson(person);
    }

    @CrossOrigin
    @GetMapping("{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }

    @CrossOrigin
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @CrossOrigin
    @PutMapping({"id"})
    public int updatePerson(@RequestBody Person person, @PathVariable("id") UUID id) {
        return personService.updatePerson(person, id);
    }

    @CrossOrigin
    @DeleteMapping({"id"})
    public int deletePerson(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }
}