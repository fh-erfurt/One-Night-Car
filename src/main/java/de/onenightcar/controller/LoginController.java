package de.onenightcar.controller;

import de.onenightcar.bootstrap.BootStrapData;
import de.onenightcar.controller.formValidators.LoginForm;
import de.onenightcar.model.person.Customer;
import de.onenightcar.repositories.personRepository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;



@Controller
public class LoginController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);


    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;


    public LoginController(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView loginForm() {

        ModelAndView mav = new ModelAndView("login");

        mav.addObject("loginForm", new LoginForm());

        return mav;
    }

    // receives the Form object that was populated by the form.
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView loginSubmit(@ModelAttribute LoginForm loginForm, HttpSession session) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        System.out.println("data From the Form: " + email + " " + password);
        ModelAndView mav = new ModelAndView("login");
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        customers.forEach(customer -> {
            if(email.equals(customer.getMail()) && password.equals(customer.getUserPassword()))
            {
                session.setAttribute("username", email);
                mav.setViewName("index");
                return;
            }
        });
        System.out.println(mav);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        if(session.getAttribute("username") == null || session.getAttribute("username").equals(""))
        {
            session.removeAttribute("username");
        }
        return "login";
    }

}
