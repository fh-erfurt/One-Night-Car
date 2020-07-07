package de.onenightcar.controller;

import org.springframework.web.bind.annotation.*;


@RestController // This means that this class is a Controller
@RequestMapping(path = "/")
public class MainController {

    protected static final String HEALTH_RESPONSE = "Yep, I'am here!";

    @GetMapping("") //Index
    public String welcome() {
        return "Welcome To One Night Car";
    }

    @GetMapping("/health") //Index
    public String areYouAlive() {
        return HEALTH_RESPONSE;
    }


}
