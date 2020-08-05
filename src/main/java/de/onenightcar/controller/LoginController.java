package de.onenightcar.controller;

import de.onenightcar.controller.formValidators.LoginForm;
import de.onenightcar.model.person.Customer;
import de.onenightcar.repositories.personRepository.*;
import de.onenightcar.util.CookieHelper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@Controller
public class LoginController extends HttpServlet {


    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;


    public LoginController(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }



    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView loginForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("login");

        Cookie[] cookies = request.getCookies();

        if(CookieHelper.proveCookieExistence(cookies, "userId")) {
            mav.setViewName("index");
            mav.addObject("error", true);
            mav.addObject("errorText", "You are already Logged in!");
            mav.addObject("loggedIn", false);
        }else{
            mav.addObject("loginForm", new LoginForm());
        }

        return mav;
    }

    // receives the Form object that was populated by the form.
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView loginSubmit(@ModelAttribute LoginForm loginForm, HttpServletResponse response) {
        //Retrieve the Data from the form
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        ModelAndView mav = new ModelAndView("login");

        List<Customer> customers = (List<Customer>) customerRepository.findAll();

        AtomicBoolean foundUser = new AtomicBoolean(false);

        customers.forEach(customer -> {
            if(email.equals(customer.getMail()) && password.equals(customer.getUserPassword()))
            {
                String userId = customer.getId().toString();
                foundUser.set(true);

                Cookie cookie = new Cookie("userId", userId);
                cookie.setMaxAge(24 * 60 * 60);     //one Day

                response.addCookie(cookie);
                System.out.println("cookie Value " + cookie.getValue());
                System.out.println("cookie Domain " + cookie.getDomain());


                mav.setViewName("index");
            }
        });

        if(foundUser.get() == false){
            mav.addObject("error", true);
            mav.addObject("errorMessage", "No user found with that Mail / Wrong Password");
        }



        if(mav.getViewName() == "index") {
            mav.addObject("loggedIn", true);
        }
        else {
            mav.addObject("loggedIn", false);
        }
        return mav;
    }
}