package de.onenightcar.bootstrap;

import de.onenightcar.model.person.*;
import de.onenightcar.model.rental.*;
import de.onenightcar.model.parkingArea.*;
import de.onenightcar.model.car.*;

import de.onenightcar.repositories.carRespository.*;
import de.onenightcar.repositories.parkingAreaRepository.*;
import de.onenightcar.repositories.rentalRepository.*;
import de.onenightcar.repositories.personRepository.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BootStrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);

    //Person Package
    private final PaymentMethodRepository paymentMethodRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final PersonAddressRepository personAddressRepository;
    private final AdminRepository adminRepository;

    //ParkingArea Package
    private final ElectricParkingAreaRepository electricParkingAreaRepository;
    private final ParkingAreaRepository parkingAreaRepository;
    private final ParkingAreaAddressRepository parkingAreaAddressRepository;

    //Car Packages
    private final CarLocationRepository carLocationRepository;
    private final CombustionCarRepository combustionCarRepository;
    private final ElectricCarRepository electricCarRepository;

    //RentalPackage
    private final ElectricRentalRepository electricRentalRepository;
    private final FuelRentalRepository fuelRentalRepository;

    public BootStrapData(PaymentMethodRepository paymentMethodRepository,
                         CustomerRepository customerRepository,
                         EmployeeRepository employeeRepository,
                         PersonAddressRepository personAddressRepository,
                         AdminRepository adminRepository,
                         ElectricParkingAreaRepository electricParkingAreaRepository,
                         ParkingAreaRepository parkingAreaRepository,
                         ParkingAreaAddressRepository parkingAreaAddressRepository,
                         CarLocationRepository carLocationRepository,
                         CombustionCarRepository combustionCarRepository,
                         ElectricCarRepository electricCarRepository,
                         ElectricRentalRepository electricRentalRepository,
                         FuelRentalRepository fuelRentalRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.personAddressRepository = personAddressRepository;
        this.adminRepository = adminRepository;
        this.electricParkingAreaRepository = electricParkingAreaRepository;
        this.parkingAreaRepository = parkingAreaRepository;
        this.parkingAreaAddressRepository = parkingAreaAddressRepository;
        this.carLocationRepository = carLocationRepository;
        this.combustionCarRepository = combustionCarRepository;
        this.electricCarRepository = electricCarRepository;
        this.electricRentalRepository = electricRentalRepository;
        this.fuelRentalRepository = fuelRentalRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Started in Bootstrap");

        ///////Person Package///////

        //Payment Method

        PaymentMethod pm1 = new PaymentMethod();
        LocalDateTime validTrough = LocalDateTime.of(2021,02,20,10,10);
        PaymentMethod pm2 = new PaymentMethod("1111 1111 1111 1111", PaymentMethod.CardType.DEBIT, validTrough, "225");

        try{
            paymentMethodRepository.save(pm1);
            paymentMethodRepository.save(pm2);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Payment Methods added: " + paymentMethodRepository.count());

        //Person Address

        //Customer

        //Employee

        //Admin

        ///////ParkingArea Package///////

        //Parking Area Address

        //Parking Area

        //Electric Parking Area

        ///////Car Package///////

        //Car Location

        //Combustion Car

        //Electric Car

        ///////RentalPackage///////

        //Fuel Rental

        //Electric Rental

    }
}
