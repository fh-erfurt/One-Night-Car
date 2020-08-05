package de.onenightcar.controller;

import de.onenightcar.util.CookieHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/")
public class MainController {

    protected static final String HEALTH_RESPONSE = "Yep, I'am here!";

    @GetMapping("") //Index
    public ModelAndView welcome(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        ModelAndView mav = new ModelAndView("index");

        if(CookieHelper.proveCookieExistence(cookies, "userId")) {
            mav.addObject("loggedIn", true);
        }
        else {
            mav.addObject("loggedIn", false);
        }
        return mav;
    }

    @GetMapping("/health") //Index
    public String areYouAlive() {
        return HEALTH_RESPONSE;
    }
}
