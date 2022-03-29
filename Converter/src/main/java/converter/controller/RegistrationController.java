package converter.controller;

import converter.dao.UserRepository;
import converter.entity.Role;
import converter.entity.User;
import converter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

//    @PostMapping("/registration")
//    public boolean addUser(@ModelAttribute("user") User user, @ModelAttribute("role")Role role) {
//        return userService.saveUser(user, role);
//    }

    @PostMapping("")
    public boolean addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
