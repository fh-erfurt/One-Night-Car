package de.onenightcar.controller;

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
import java.util.List;

@Controller
@RequestMapping(path = "/login", method = RequestMethod.GET)
public class loginController {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private Object Iterable;
    private Object Model;

    public loginController(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }



    public String getCustomers(Model model) {

        model.addAttribute("customers", customerRepository.findAll());

        return "login";
    }


    public String  getLoginForm() {
        // return html Page name
        return "login";
    }

}
