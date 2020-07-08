package de.onenightcar.controller;

import de.onenightcar.model.person.Customer;
import de.onenightcar.repositories.personRepository.CustomerRepository;
import de.onenightcar.repositories.personRepository.PaymentMethodRepository;
import de.onenightcar.repositories.personRepository.PersonAddressRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class SignUpController {
    @Autowired

    private final CustomerRepository customerRepository;
    private final PersonAddressRepository personAddressRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public SignUpController (CustomerRepository customerRepository, PersonAddressRepository personAddressRepository, PaymentMethodRepository paymentMethodRepository)
    {
        this.customerRepository = customerRepository;
        this.personAddressRepository = personAddressRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @PostMapping(path="/signUp")
    public String addCustomer(Customer customer, BindingResult result, Model model)
    {
        if(result.hasErrors()){
            return "add-User";
        }
        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());

        return "redirect:/index";

    }






}
