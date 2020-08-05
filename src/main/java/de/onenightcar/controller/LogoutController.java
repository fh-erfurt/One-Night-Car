package de.onenightcar.controller;


import de.onenightcar.controller.formValidators.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController extends HttpServlet {

    @GetMapping("/logout")
    public ModelAndView logoutSubmit(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mav = new ModelAndView("login");

        Cookie[] cookies = request.getCookies();

        if(cookies != null)
        {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setValue("");
                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }

        mav.addObject("loginForm", new LoginForm());
        mav.addObject("loggedIn", false);

        return mav;
    }
}
