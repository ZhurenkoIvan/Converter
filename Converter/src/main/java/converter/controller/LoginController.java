package converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @GetMapping("/api/login")
    public String loginPage(){

        return "index";
    }

}
