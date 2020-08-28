package event.ReminderApp.api;

import event.ReminderApp.Exceptions.ApiRequestException;
import event.ReminderApp.model.User;
import event.ReminderApp.service.UserService;
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
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("create/")
    public int insertPerson(@RequestBody User user) {
        try{
           return userService.insertPerson(user);
       }catch (DataIntegrityViolationException e) {
           if (e.getMostSpecificCause().getClass().getName().equals("org.postgresql.util.PSQLException") && ((SQLException) e.getMostSpecificCause()).getSQLState().equals("23505"))
                throw new ApiRequestException("Dublicate email, you may have already registered!", e.getMostSpecificCause());
            throw e;
        }
    }

    @CrossOrigin
    @GetMapping("{id}/select")
    public Optional<User> getPersonById(@PathVariable("id") UUID id) {
        return userService.getPersonById(id);
    }

    @CrossOrigin
    @GetMapping("{email}/select")
    public Optional<User> getPersonByEmail(@PathVariable("email")String email) {
        try{
            return userService.getPersonByEmail(email);
        }catch (EmptyResultDataAccessException e) {
            throw new ApiRequestException("Email not found", e.getCause());
        }
    }

    @CrossOrigin
    @GetMapping("all/")
    public List<User> getAllPersons() {
        return userService.getAllPersons();
    }

    @CrossOrigin
    @PutMapping("{id}/update")
    public int updatePerson(@NotNull @Valid @RequestBody User user, @PathVariable("id") UUID id) {
        return userService.updatePerson(user, id);
    }

    @CrossOrigin
    @DeleteMapping("{id}/delete")
    public int deletePerson(@PathVariable("id") UUID id) {
        return userService.deletePerson(id);
    }
}
