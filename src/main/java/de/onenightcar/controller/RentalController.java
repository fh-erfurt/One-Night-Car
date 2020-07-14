package de.onenightcar.controller;

import de.onenightcar.bootstrap.BootStrapData;
import de.onenightcar.controller.formValidators.ElectricRentalFormValidator;
import de.onenightcar.model.parkingArea.ParkingArea;
import de.onenightcar.model.rental.ElectricRental;
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

    //Fuel Type: 0->Any // 1-> Combustion // 2->Electric
    //Date: Integer: day of the year (1-365) to simplify things (Should be calculated on last page)
    @RequestMapping(path = "/search-results/{city}/{date}/{fuel-type}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView searchResultsFuel(@PathVariable("city") String city, @PathVariable("date") int date,
                                          @PathVariable("fuel-type") int fuelType) {

        List<RentalTimeSlot> rentalTimeSlots = (List<RentalTimeSlot>) rentalTimeSlotRepository.findAll();

        ModelAndView mav = new ModelAndView("rental/searchResults");

        mav.addObject("date", LocalDate.of(2020, 07, 02));
        mav.addObject("customer", customerRepository.getById(10l));
        mav.addObject("mdate", date);
        mav.addObject("rentalTimeSlots", rentalTimeSlots);

        if(fuelType == 0){
            mav.addObject("electricParkingAreas", electricParkingAreaRepository.getAllByParkingAreaAddressCity(city));
            mav.addObject("fuelParkingAreas", parkingAreaRepository.getAllByParkingAreaAddressCity(city));
            //TODO: After doing the needed change in the Repository - reEnable
//            model.addAttribute("not-available-electric-rentals", electricRentalRepository.getAllByDate_DayOfYear(date));
//            model.addAttribute("not-available-fuel-rentals", fuelRentalRepository.getAllByDate_DayOfYear(date));
        }
        else if (fuelType == 1) {
            mav.addObject("fuelParkingAreas", parkingAreaRepository.getAllByParkingAreaAddressCity(city));
            //TODO: After doing the needed change in the Repository - reEnable
//            model.addAttribute("not-available-fuel-rentals", fuelRentalRepository.getAllByDate_DayOfYear(date));
        }
        else if (fuelType == 2) {
            mav.addObject("electricParkingAreas", electricParkingAreaRepository.getAllByParkingAreaAddressCity(city));
            //TODO: After doing the needed change in the Repository - reEnable
//            model.addAttribute("not-available-electric-rentals", electricRentalRepository.getAllByDate_DayOfYear(date));
        }

        return mav;
    }


    @PostMapping("/rentACar")
    public String checkElectricRental(@ModelAttribute ElectricRental electricRental) {

        System.out.println(electricRental);
        return "/";
    }


}
