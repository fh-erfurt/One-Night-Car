package de.onenightcar.controller;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.person.PaymentMethod;
import de.onenightcar.repositories.personRepository.*;
import de.onenightcar.repositories.rentalRepository.ElectricRentalRepository;
import de.onenightcar.repositories.rentalRepository.FuelRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.SimpleAttributeSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class LoginController {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;


    public LoginController(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/login")
    public  String getLoginForm(){
        return "login";
    }

    @PostMapping(path="/login")
    public String login(@ModelAttribute(name="loginForm") Customer customer, Model model) {
        String userName = customer.getMail();
        String userPassword = customer.getUserPassword();
        final boolean[] test = {false};

        customerRepository.findAll().forEach(customer1 -> {
            if (customer1.getMail() == userName && customer1.getUserPassword() == userPassword) {
                test[0] = true;
                return;
            }
        });
        if (test[0]) {
            return "index";
        }

        return "login";
    }
}

       /*
        if("admin".equals(userName) && "12345678".equals(userPassword)){
            return "index";
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }*/


/*
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;


    public LoginController(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path="/login")
    public String getLogin(Model model){
        model.addAttribute("customers", customerRepository.findAll());


        Iterable<Customer>  customersInList = customerRepository.findAll();


        // Create an empty list
        List<Customer> list = new ArrayList<>();

        // Add each element of iterator to the List
        customersInList.forEach(list::add);



        list.forEach(allCustomers -> {
           if(allCustomers.getName() == allCustomers.getName()){}
        } );
        return "login";
    }

    @PostMapping(path = "/login")
    public String getLoginFormData(@ModelAttribute CustomerRepository customer){
        customer.getByName("Ahmad");
        customer.getByLastName("hello");
        return "result";
    }
*/

