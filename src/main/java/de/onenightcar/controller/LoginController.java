package de.onenightcar.controller;

import de.onenightcar.bootstrap.BootStrapData;
import de.onenightcar.controller.formValidators.LoginForm;
import de.onenightcar.model.person.Customer;
import de.onenightcar.repositories.personRepository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@Controller
public class LoginController implements WebMvcConfigurer {
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

        mav.addObject("customers", new LoginForm());

        return mav;
    }

    // receives the Form object that was populated by the form.
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String loginSubmit(@ModelAttribute LoginForm loginForm, Model model) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
         AtomicBoolean valid = new AtomicBoolean(false);
         boolean validate = false;

        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        customers.forEach(customer -> {
            if(customer.getMail() == email && customer.getUserPassword() == password)
            {
               valid.set(true);
            }
        });
        validate = valid.get();

        return validate ? "index" : "login";
    }

}
