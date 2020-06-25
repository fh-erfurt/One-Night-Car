package de.onenightcar.controller;

import de.onenightcar.repositories.personRepository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private final PaymentMethodRepository paymentMethodRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final PersonAddressRepository personAddressRepository;
    private final AdminRepository adminRepository;

    public PersonController(PaymentMethodRepository paymentMethodRepository,
                            CustomerRepository customerRepository,
                            EmployeeRepository employeeRepository,
                            PersonAddressRepository personAddressRepository,
                            AdminRepository adminRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.personAddressRepository = personAddressRepository;
        this.adminRepository = adminRepository;
    }

    @RequestMapping(path = "/paymentMethods")
    public String getPaymentMethods(Model model) {

        model.addAttribute("paymentMethods", paymentMethodRepository.findAll());

        return "person/paymentMethod";
    }
}
