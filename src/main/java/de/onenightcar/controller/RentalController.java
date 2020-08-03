package de.onenightcar.controller;

import de.onenightcar.bootstrap.BootStrapData;
import de.onenightcar.controller.formValidators.CarSearchForm;
import de.onenightcar.controller.formValidators.ElectricRentalFormValidator;
import de.onenightcar.controller.formValidators.FuelRentalFormValidator;
import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.car.ElectricCar;
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
import java.sql.Struct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
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
        //The object that should be populated in the form of the view
        mav.addObject("carSearchForm", new CarSearchForm());
        mav.addObject("cities", parkingAreaCities);

        return mav;
    }

    @RequestMapping(path = "/search-results", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView searchResults(@ModelAttribute CarSearchForm carSearchForm, Model model) {

        //////Values received from the form in car search page//////
        int fuelType = carSearchForm.getFuel();
        String city = carSearchForm.getCity();

        //////Create the Model and View and add the view//////
        ModelAndView mav = new ModelAndView("rental/searchResults");

        //////Create the needed objects for the rendering of the view and add them//////
            List<RentalTimeSlot> rentalTimeSlots = (List<RentalTimeSlot>) rentalTimeSlotRepository.findAll();
            //All possible rental time slot for the day
            mav.addObject("rentalTimeSlots", rentalTimeSlots);

            LocalDate date = carSearchForm.getDate();
            //The wanted date for the rental
            mav.addObject("date", date);

            //TODO: Somehow access to the Customer who is logged in
            mav.addObject("customer", customerRepository.getById(10l));

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

        //////Prepare all the Values for the Fuel Rentals//////

            //The needed validator for the rental form
            mav.addObject("fuelRentalFormValidator", new FuelRentalFormValidator());

            List<FuelRental> dayFuelRentals = fuelRentalRepository.getAllByDate(date);

            //If there are any Electric Rentals already made for the day
            if(dayFuelRentals.size() > 0) {

                //Create a hashtable for the day with the booked cars and the booked timeslots
                Hashtable<CombustionCar, List<RentalTimeSlot>> hashtable =
                        new Hashtable<CombustionCar, List<RentalTimeSlot>>();

                for (int i = 0; i < dayFuelRentals.size(); i++) {

                    //Needed for the key value
                    CombustionCar cc = dayFuelRentals.get(i).getCombustionCar();

                    //Create the List of all the timeslots
                    List<RentalTimeSlot> list = (List<RentalTimeSlot>) rentalTimeSlotRepository.findAll();

                    //Loop through each Rental and remove the not available timeslots
                    for (int j = 0; j < dayFuelRentals.get(i).getTimeSlotsList().size(); j++) {
                        for (int k = 0; k < list.size(); k++) {
                            if(list.get(k).getDepartureTime() == dayFuelRentals.get(i).getTimeSlotsList().get(j).getDepartureTime()){
                                list.remove(k);
                            }
                        }
                    }

                    //Finally add the key and the Value to the Hashtable
                    hashtable.put(cc, list);

                    //Connect the hashtable to the view
                    mav.addObject("notAvailableFuelTimes", hashtable);
                }
            }

        //////Prepare all the Values for the Electric Rentals//////

            //The needed validator for the rental form
            mav.addObject("electricRentalFormValidator", new ElectricRentalFormValidator());

            List<ElectricRental> dayElectricRentals = electricRentalRepository.getAllByDate(date);

            //If there are any Electric Rentals already made for the day
            if(dayElectricRentals.size() > 0) {

                //Create a hashtable for the day with the booked cars and the booked timeslots
                Hashtable<ElectricCar, List<RentalTimeSlot>> hashtable =
                        new Hashtable<ElectricCar, List<RentalTimeSlot>>();

                for (int i = 0; i < dayElectricRentals.size(); i++) {

                    //Needed for the key value
                    ElectricCar ec = dayElectricRentals.get(i).getElectricCar();

                    //Create the List of all the timeslots
                    List<RentalTimeSlot> list = (List<RentalTimeSlot>) rentalTimeSlotRepository.findAll();

                    //Loop through each Rental and remove the not available timeslots
                    for (int j = 0; j < dayElectricRentals.get(i).getTimeSlotsList().size(); j++) {
                        for (int k = 0; k < list.size(); k++) {
                            if(list.get(k).getDepartureTime() == dayElectricRentals.get(i).getTimeSlotsList().get(j).getDepartureTime()){
                                list.remove(k);
                            }
                        }
                    }

                    //Finally add the key and the Value to the Hashtable
                    hashtable.put(ec, list);

                    //Connect the hashtable to the view
                    mav.addObject("notAvailableElectricTimes", hashtable);
                }
            }

        return mav;
    }


    @PostMapping("/confirm-e-rental")
    public ModelAndView checkElectricRental(@ModelAttribute ElectricRentalFormValidator electricRentalFormValidator) {

        log.info(electricRentalFormValidator.toString());
        ModelAndView mav = new ModelAndView("rental/confirmRental");

        mav.addObject("electricRentalFormValidator", electricRentalFormValidator);

        return mav;
    }

    @PostMapping("/confirm-c-rental")
    public ModelAndView checkFuelRental(@ModelAttribute FuelRentalFormValidator fuelRentalFormValidator) {

        log.info(fuelRentalFormValidator.toString());
        ModelAndView mav = new ModelAndView("rental/confirmRental");

        mav.addObject("fuelRentalFormValidator", fuelRentalFormValidator);

        return mav;
    }


}
