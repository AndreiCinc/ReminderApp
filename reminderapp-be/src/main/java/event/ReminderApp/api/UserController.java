package event.ReminderApp.api;

import event.ReminderApp.Exceptions.ApiRequestException;
import event.ReminderApp.model.User;
import event.ReminderApp.service.AuthenticationService;
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
    public final AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService,
                          AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @CrossOrigin
    @PostMapping("create/")
    public int insertUser(@RequestBody User user) {
        try{
            return userService.insertUser(user);
        }catch (DataIntegrityViolationException e) {
            if (e.getMostSpecificCause().getClass().getName().equals("org.postgresql.util.PSQLException") && ((SQLException) e.getMostSpecificCause()).getSQLState().equals("23505"))
                throw new ApiRequestException("Dublicate email, you may have already registered!", e.getMostSpecificCause());
            throw e;
        }
    }

    @CrossOrigin
    @GetMapping("{id}/select")
    public Optional<User> getUserById(@PathVariable("id") UUID id,
                                      @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        return userService.getUserById(id);
    }

    @CrossOrigin
    @GetMapping("{email}/select")
    public Optional<User> getUserByEmail(@PathVariable("email")String email,
                                         @RequestHeader("person") String jwt) {
        try{
            return userService.getUserByEmail(email);
        }catch (EmptyResultDataAccessException e) {
            throw new ApiRequestException("Email not found", e.getCause());
        }
    }

    @CrossOrigin
    @GetMapping("all/")
    public List<User> getAllUsers(@RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        return userService.getAllUsers();
    }

    @CrossOrigin
    @PutMapping("{id}/update/")
    public int updateUser(@NotNull @Valid @RequestBody User user,
                          @PathVariable("id") UUID id,
                          @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        return userService.updateUser(user, id);
    }

    @CrossOrigin
    @DeleteMapping("{id}/delete")
    public int deleteUser(@PathVariable("id") UUID id,
                          @RequestHeader("person") String jwt) {
        try {
            authenticationService.decodeJWT(jwt);
        } catch (Exception e) {
            throw new ApiRequestException("Invalid token", e.getCause());
        }
        return userService.deleteUser(id);
    }
}