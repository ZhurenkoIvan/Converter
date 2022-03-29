package converter.controller;

import converter.entity.Role;
import converter.entity.User;
import converter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public User checkUser(@ModelAttribute("user")User user){

        return (User) userService.loadUserByUsername(user.getUsername());
    }

}
