package event.ReminderApp.api;

import event.ReminderApp.Exceptions.ApiException;
import event.ReminderApp.Exceptions.ApiExceptionHandler;
import event.ReminderApp.Exceptions.ApiRequestException;
import event.ReminderApp.model.Person;
import event.ReminderApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("person/")
public class PersonController {

    public final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin
    @PostMapping
    public int insertPerson(@RequestBody Person person) {
        try{
           return  personService.insertPerson(person);
       }catch (DataIntegrityViolationException e) {
           if (e.getMostSpecificCause().getClass().getName().equals("org.postgresql.util.PSQLException") && ((SQLException) e.getMostSpecificCause()).getSQLState().equals("23505"))
                throw new ApiRequestException("Dublicate email, you may have already registered!", e.getMostSpecificCause());
            throw e;
        }
    }

    @CrossOrigin
    @GetMapping("personId/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }
    @CrossOrigin
    @GetMapping("email/{email}")
    public Optional<Person> getPersonByEmail(@PathVariable("email")String email) {
        try{
            return personService.getPersonByEmail(email);
        }catch (EmptyResultDataAccessException e) {
            throw new ApiRequestException("Email not found", e.getCause());
        }
    }


    @CrossOrigin
    @GetMapping("getAll/")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @CrossOrigin
    @PutMapping("{id}")
    public int updatePerson(@NotNull @Valid @RequestBody Person person, @PathVariable("id") UUID id) {
        return personService.updatePerson(person, id);
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public int deletePerson(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }
}
