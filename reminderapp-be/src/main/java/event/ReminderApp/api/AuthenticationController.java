package event.ReminderApp.api;

import event.ReminderApp.Exceptions.ApiRequestException;
import event.ReminderApp.model.User;
import event.ReminderApp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication/")
public class AuthenticationController {

    public final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @CrossOrigin
    @PostMapping("authenticate/")
    public String authenticate(@RequestBody User user) {
        try{
            return authenticationService.Authenticate(user);
        }catch (Exception e) {
           throw new ApiRequestException("Failed to authenticate" + e.getMessage(), e.getCause());
        }
    }
}

