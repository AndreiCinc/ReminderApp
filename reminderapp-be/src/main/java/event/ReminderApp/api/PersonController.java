package event.ReminderApp.api;

import event.ReminderApp.Exceptions.ApiRequestException;
import event.ReminderApp.model.Person;
import event.ReminderApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("user/")
public class PersonController {

    public final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin
    @PostMapping("create/")
    public int insertPerson(@RequestBody Person person) {
        try{
           return personService.insertPerson(person);
       }catch (DataIntegrityViolationException e) {
           if (e.getMostSpecificCause().getClass().getName().equals("org.postgresql.util.PSQLException") && ((SQLException) e.getMostSpecificCause()).getSQLState().equals("23505"))
                throw new ApiRequestException("Dublicate email, you may have already registered!", e.getMostSpecificCause());
            throw e;
        }
    }

    @CrossOrigin
    @GetMapping("{id}/select")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }
    @CrossOrigin
    @GetMapping("{email}/select")
    public Optional<Person> getPersonByEmail(@PathVariable("email")String email) {
        try{
            return personService.getPersonByEmail(email);
        }catch (EmptyResultDataAccessException e) {
            throw new ApiRequestException("Email not found", e.getCause());
        }
    }

    @CrossOrigin
    @GetMapping("all/")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @CrossOrigin
    @PutMapping("{id}/update")
    public int updatePerson(@NotNull @Valid @RequestBody Person person, @PathVariable("id") UUID id) {
        return personService.updatePerson(person, id);
    }

    @CrossOrigin
    @DeleteMapping("{id}/delete")
    public int deletePerson(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }
}
