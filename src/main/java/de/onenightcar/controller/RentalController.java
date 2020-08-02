package de.onenightcar.controller;

import de.onenightcar.bootstrap.BootStrapData;
import de.onenightcar.controller.formValidators.CarSearchForm;
import de.onenightcar.controller.formValidators.ElectricRentalFormValidator;
import de.onenightcar.model.parkingArea.ParkingArea;
import de.onenightcar.model.parkingArea.ParkingAreaAddress;
import de.onenightcar.model.rental.ElectricRental;
import de.onenightcar.model.rental.FuelRental;
import de.onenightcar.model.rental.Rental;
import de.onenightcar.model.rental.RentalTimeSlot;
import de.onenightcar.repositories.carRespository.CarLocationRepository;
import de.onenightcar.repositories.carRespository.CombustionCarRepository;
import de.onenightcar.repositories.carRespository.ElectricCarRepository;
import de.onenightcar.repositories.parkingAreaRepository.ElectricParkingAreaRepository;
import de.onenightcar.repositories.parkingAreaRepository.ParkingAreaAddressRepository;
import de.onenightcar.repositories.parkingAreaRepository.ParkingAreaRepository;
import de.onenightcar.repositories.personRepository.*;
import de.onenightcar.repositories.rentalRepository.ElectricRentalRepository;
import de.onenightcar.repositories.rentalRepository.FuelRentalRepository;
import de.onenightcar.repositories.rentalRepository.RentalTimeSlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/rental")
public class RentalController {

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);

    private final ElectricRentalRepository electricRentalRepository;
    private final FuelRentalRepository fuelRentalRepository;
    private final RentalTimeSlotRepository rentalTimeSlotRepository;

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final AdminRepository adminRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PersonAddressRepository personAddressRepository;

    private final CombustionCarRepository combustionCarRepository;
    private final ElectricCarRepository electricCarRepository;
    private final CarLocationRepository carLocationRepository;

    private final ElectricParkingAreaRepository electricParkingAreaRepository;
    private final ParkingAreaRepository parkingAreaRepository;
    private final ParkingAreaAddressRepository parkingAreaAddressRepository;


    public RentalController(ElectricRentalRepository electricRentalRepository, FuelRentalRepository fuelRentalRepository,
                            RentalTimeSlotRepository rentalTimeSlotRepository, CustomerRepository customerRepository,
                            EmployeeRepository employeeRepository, AdminRepository adminRepository,
                            PaymentMethodRepository paymentMethodRepository, PersonAddressRepository personAddressRepository,
                            CombustionCarRepository combustionCarRepository, ElectricCarRepository electricCarRepository,
                            CarLocationRepository carLocationRepository, ElectricParkingAreaRepository electricParkingAreaRepository,
                            ParkingAreaRepository parkingAreaRepository, ParkingAreaAddressRepository parkingAreaAddressRepository) {
        this.electricRentalRepository = electricRentalRepository;
        this.fuelRentalRepository = fuelRentalRepository;
        this.rentalTimeSlotRepository = rentalTimeSlotRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.adminRepository = adminRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.personAddressRepository = personAddressRepository;
        this.combustionCarRepository = combustionCarRepository;
        this.electricCarRepository = electricCarRepository;
        this.carLocationRepository = carLocationRepository;
        this.electricParkingAreaRepository = electricParkingAreaRepository;
        this.parkingAreaRepository = parkingAreaRepository;
        this.parkingAreaAddressRepository = parkingAreaAddressRepository;
    }

    @RequestMapping(path = "/car-search", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView searchPage() {

        //Get all different cities from the Database
        List<String> parkingAreaCities = parkingAreaAddressRepository.getDistinctCity();

        //Create the Model and View and add the view
        ModelAndView mav = new ModelAndView("rental/carSearch");

        //Add the needed object for the rendering of the view
        //The object that should be popullated in the form of the view
        mav.addObject("carSearchForm", new CarSearchForm());
        mav.addObject("cities", parkingAreaCities);

        return mav;
    }

    @RequestMapping(path = "/search-results", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView searchResults(@ModelAttribute CarSearchForm carSearchForm, Model model) {

        //Create the Model and View and add the view
        ModelAndView mav = new ModelAndView("rental/searchResults");

        //Create the needed objects for the rendering of the view
        List<RentalTimeSlot> rentalTimeSlots = (List<RentalTimeSlot>) rentalTimeSlotRepository.findAll();
        LocalDate date = carSearchForm.getDate();
        int fuelType = carSearchForm.getFuel();
        String city = carSearchForm.getCity();

//        //Search for already occupied rental slots
//        List<FuelRental> dayFuelRentals = fuelRentalRepository.getAllByDate(date);
//        List<ElectricRental> dayElectricRentals = electricRentalRepository.getAllByDate(date);
//
//        //If there are any Rentals already made for the day
//        if(dayElectricRentals.size() > 0 || dayFuelRentals.size() > 0) {
//            if (dayElectricRentals.size() > 0) {
//                for (int i = 0; i < dayElectricRentals.size(); i++) {
//                    dayElectricRentals.get(i).getTimeSlotsList()
//                }
//            }
//            if (dayFuelRentals.size() > 0) {
//
//            }
//        } else {
//            //All possible rental time slot for the day
//            mav.addObject("rentalTimeSlots", rentalTimeSlots);
//        }

        //All possible rental time slot for the day
        mav.addObject("rentalTimeSlots", rentalTimeSlots);

        //Add the objects to the view
        //The wanted date for the rental
        mav.addObject("date", date);
        //TODO: Somehow access to the Customer who is logged in
        mav.addObject("customer", customerRepository.getById(10l));
        //The needed validator for the rental form
        mav.addObject("electricRentalFormValidator", new ElectricRentalFormValidator());


        //Define which parking areas should be shown and add them to the view
        if(fuelType == 0){
            mav.addObject("electricParkingAreas", electricParkingAreaRepository.getAllByParkingAreaAddressCity(city));
            mav.addObject("fuelParkingAreas", parkingAreaRepository.getAllByParkingAreaAddressCity(city));
        }
        else if (fuelType == 1) {
            mav.addObject("fuelParkingAreas", parkingAreaRepository.getAllByParkingAreaAddressCity(city));
        }
        else if (fuelType == 2) {
            mav.addObject("electricParkingAreas", electricParkingAreaRepository.getAllByParkingAreaAddressCity(city));
        }

        return mav;
    }


    @PostMapping("/confirm-rental")
    public ModelAndView checkElectricRental(@ModelAttribute ElectricRentalFormValidator electricRentalFormValidator) {

        log.info(electricRentalFormValidator.toString());
        ModelAndView mav = new ModelAndView("rental/confirmRental");

        mav.addObject("electricRentalFormValidator", electricRentalFormValidator);

        return mav;
    }


}
