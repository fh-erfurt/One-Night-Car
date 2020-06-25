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
        PaymentMethod pm3 = new PaymentMethod("2222 2222 2222 2222", PaymentMethod.CardType.CREDIT, validTrough, "225");

        try{
            paymentMethodRepository.save(pm1);
            paymentMethodRepository.save(pm2);
            paymentMethodRepository.save(pm3);

        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Payment Methods added: " + paymentMethodRepository.count());

        //Person Address

        PersonAddress pa1 = new PersonAddress("99084", "Erfurt", "Hirschlachufer", "3");
        PersonAddress pa2 = new PersonAddress("07743", "Jena", "Bibliotheksweg", "11");
        PersonAddress pa3 = new PersonAddress("99423", "Weimar", "Eckenerstraße", "19");

        try{
            personAddressRepository.save(pa1);
            personAddressRepository.save(pa2);
            personAddressRepository.save(pa3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Addresses added: " + personAddressRepository.count());

        //Customer

        LocalDateTime customer1DOB = LocalDateTime.of(1988, 02, 29,00,00);
        LocalDateTime customer2DOB = LocalDateTime.of(1992, 02, 29,00,00);
        LocalDateTime customer3DOB = LocalDateTime.of(1990, 12, 31,00,00);

        Customer customer1 = new Customer("Max", "Musterman", customer1DOB, pa1, Customer.CustomerLevel.NEWUSER, pm1);
        Customer customer2 = new Customer("Maria", "Musterfrau", customer2DOB, pa2, Customer.CustomerLevel.REGULARUSER, pm2);
        Customer customer3 = new Customer("Sher", "Lock", customer3DOB, pa3, Customer.CustomerLevel.SUPERUSER, pm3);

        try{
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Customers added: " + customerRepository.count());


        //Employee

        LocalDateTime employee1DOB = LocalDateTime.of(1970, 3, 31,00,00);
        LocalDateTime employee2DOB = LocalDateTime.of(1965, 07, 17,00,00);
        LocalDateTime employee3DOB = LocalDateTime.of(1992, 12, 31,00,00);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee("John", "Doe", employee1DOB, pa1, 1600.00f, Employee.TypeOfActivity.CUSTOMERSUPPORT);
        Employee employee3 = new Employee("Pepito", "Perez", employee2DOB, pa2, 1800.00f, Employee.TypeOfActivity.MAINTAINER);

        try{
            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Employees added: " + employeeRepository.count());

        //Admin
        // TODO
      /*  LocalDateTime adminDOB = LocalDateTime.of(1986, 9, 30,00,00);
        PersonAddress adminAddress = new PersonAddress("99084", "Erfurt", "Stotternheimstrasse", "52");


        Admin admin = new Employee("Administrator","Admin", adminDOB, adminAddress, 1999.00f, Employee.TypeOfActivity.CUSTOMERSUPPORT);

        try{
            adminRepository.save(admin);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Admins added: " + adminRepository.count());*/



        ///////ParkingArea Package///////

        //Parking Area Address

        ParkingAreaAddress parkingAreaAddress1 = new ParkingAreaAddress();
        ParkingAreaAddress parkingAreaAddress2 = new ParkingAreaAddress("99084", "Erfurt", "Hirschlachufer", "3");
        ParkingAreaAddress parkingAreaAddress3 = new ParkingAreaAddress("99423", "Weimar", "Eckenerstraße", "19");



        try{
            parkingAreaAddressRepository.save(parkingAreaAddress1);
            parkingAreaAddressRepository.save(parkingAreaAddress2);
            parkingAreaAddressRepository.save(parkingAreaAddress3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Parking Area's Addresses added: " + parkingAreaAddressRepository.count());


        //Parking Area

        ParkingArea parkingArea1 = new ParkingArea(parkingAreaAddress1, 200);
        ParkingArea parkingArea2 = new ParkingArea(parkingAreaAddress2, 300);

        try{
            parkingAreaRepository.save(parkingArea1);
            parkingAreaRepository.save(parkingArea2);
        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Parking Areas added: " + parkingAreaRepository.count() );

        //Electric Parking Area

        ElectricParkingArea electricParkingArea1 = new ElectricParkingArea(parkingAreaAddress3, 300, 50);
        try{
            electricParkingAreaRepository.save(electricParkingArea1);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Electric Parking Areas added: " + electricParkingAreaRepository.count() );

        ///////Car Package///////

        //Car Location

        CarLocation carLocation1 = new CarLocation(50.978075, 11.037416);
        CarLocation carLocation2 = new CarLocation(50.973211, 11.030760);
        CarLocation carLocation3 = new CarLocation(50.976163, 11.024549);


        try{
            carLocationRepository.save(carLocation1);
            carLocationRepository.save(carLocation2);
            carLocationRepository.save(carLocation3);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Car Locations added: " + carLocationRepository.count() );


        //Combustion Car

        CombustionCar combustionCar1 = new CombustionCar(Car.Type.MIDDLE, "Opel", "Insignia", Car.State.OK,
                                                    50.978075, 11.037416, 67000, Customer.CustomerLevel.NEWUSER,
                                                    49.99f, 40, 100, 3.46, CombustionCar.Transmission.AUTOMATIC,
                                                    CombustionCar.FuelType.PETROL, parkingArea1);

        CombustionCar combustionCar2 = new CombustionCar(parkingArea2);
        CombustionCar combustionCar3 = new CombustionCar(parkingArea1);

        try{
            combustionCarRepository.save(combustionCar1);
            combustionCarRepository.save(combustionCar2);
            combustionCarRepository.save(combustionCar3);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Cars added: " + combustionCarRepository.count() );

        //Electric Car

        ElectricCar electricCar1 = new ElectricCar(Car.Type.MINI, "BMW", "i3s", Car.State.PERFECT, 39000, 50.973211, 11.030760, Customer.CustomerLevel.REGULARUSER, 59.99f,
                220, 100, electricParkingArea1);
        ElectricCar electricCar2 = new ElectricCar(electricParkingArea1);

        try{
            electricCarRepository.save(electricCar1);
            electricCarRepository.save(electricCar2);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Electric Cars added: " + electricCarRepository.count() );



        ///////RentalPackage///////

        //Fuel Rental

        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime departure1 = LocalDateTime.of(2020, 9, 8 , 10,10);
        LocalDateTime arrival1 = LocalDateTime.of(2020, 9, 11 , 10,10);

        LocalDateTime departure2 = LocalDateTime.of(2020, 12, 23 , 10,10);
        LocalDateTime arrival2 = LocalDateTime.of(2021, 1, 7 , 10,10);


        FuelRental fuelRental1 = new FuelRental(combustionCar1, timeNow, departure1, arrival1, customer3);
        FuelRental fuelRental2 = new FuelRental(combustionCar2, timeNow, departure2, arrival2, customer1);

        try{
            fuelRentalRepository.save(fuelRental1);
            fuelRentalRepository.save(fuelRental2);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Rentals added: " + fuelRentalRepository.count() );

        //Electric Rental
        ElectricRental electricRental1 = new ElectricRental(electricCar1, customer1);
        ElectricRental electricRental2 = new ElectricRental(electricCar2, customer2);

        try{
            electricRentalRepository.save(electricRental1);
            electricRentalRepository.save(electricRental2);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Electric Rentals added: " + electricRentalRepository.count() );


    }
}
