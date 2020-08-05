package de.onenightcar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController extends HttpServlet {


    @PostMapping("/logout")
    public String logoutSubmit(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie[] cookies = request.getCookies();

        if(cookies != null)
        {
            Cookie cookie = new Cookie("userId", null);
            cookie.setMaxAge(0);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return "login";
    }
}
