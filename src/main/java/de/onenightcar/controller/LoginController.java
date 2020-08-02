package de.onenightcar.controller;

import de.onenightcar.bootstrap.BootStrapData;
import de.onenightcar.model.person.Customer;
import de.onenightcar.repositories.personRepository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;





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
    public String loginForm(Model model) {
        model.addAttribute("customers", customerRepository.findAll());

        // just to test
        customerRepository.findAll().forEach(customer -> {
            String mail = customer.getMail();
            String password = customer.getUserPassword();

        });
        return "login";
    }

    // receives the Form object that was populated by the form.
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute   Customer customer,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "index";
    }

}
