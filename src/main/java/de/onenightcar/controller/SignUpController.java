package de.onenightcar.controller;

import de.onenightcar.controller.formValidators.SignUpForm;
import de.onenightcar.model.person.Customer;
import de.onenightcar.model.person.PaymentMethod;
import de.onenightcar.model.person.PersonAddress;
import de.onenightcar.repositories.personRepository.CustomerRepository;
import de.onenightcar.repositories.personRepository.PaymentMethodRepository;
import de.onenightcar.repositories.personRepository.PersonAddressRepository;
import org.dom4j.rule.Mode;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
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

    @GetMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView signUpForm()
    {
        ModelAndView mav = new ModelAndView("signup");
        mav.addObject("signUpForm", new SignUpForm());

        return mav;
    }

    @PostMapping(path="/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView addCustomer(@ModelAttribute SignUpForm signUpForm)
    {
        //********** retrieve the data from the Form
        // Customer Information
        String firstName= signUpForm.getFirstName();
        String lastName = signUpForm.getLastName();
        String email = signUpForm.getEmail();
        String password = signUpForm.getPassword();
        LocalDate DOB = signUpForm.getDateOfBirth();

        //payment Method Information
        String cardNumber = signUpForm.getCardNumber();
        int cardTypeInt = signUpForm.getCardType();
        PaymentMethod.CardType cardType = PaymentMethod.CardType.DEBIT;
        LocalDate expireDate = signUpForm.getExpiredDate();
        String CCV = signUpForm.getCCV();

        // Address Information
        String ZIP = signUpForm.getZIP();
        String city = signUpForm.getCity();
        String street = signUpForm.getStreet();
        String streetNumber = signUpForm.getStreetNumber();

        ModelAndView mav = new ModelAndView("signup");


        if(firstName != null && lastName != null && email != null && password != null
        && DOB != null && cardNumber != null && expireDate != null && CCV != null
        && ZIP != null && city != null && street != null && streetNumber != null)
        {
            if(cardTypeInt == 1){
                cardType = PaymentMethod.CardType.CREDIT;
            }

            PaymentMethod newPaymentMethod = new PaymentMethod(cardNumber, cardType, expireDate, CCV);
            PersonAddress newPersonAddress = new PersonAddress(ZIP, city, street, streetNumber);
            Customer newCustomer = new Customer(firstName, lastName, DOB, email, password, newPersonAddress, Customer.CustomerLevel.NEWUSER, newPaymentMethod);

            paymentMethodRepository.save(newPaymentMethod);
            personAddressRepository.save(newPersonAddress);
            customerRepository.save(newCustomer);

            mav.setViewName("index");
        }else{
            mav.addObject("error", true);
            mav.addObject("errorMessage", "all Fields must be filled");
        }

        return mav;
    }






}
