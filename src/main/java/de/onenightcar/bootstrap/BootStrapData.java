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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    private final RentalTimeSlotRepository rentalTimeSlotRepository;
    private final ElectricRentalRepository electricRentalRepository;
    private final FuelRentalRepository fuelRentalRepository;

    public BootStrapData(PaymentMethodRepository paymentMethodRepository, CustomerRepository customerRepository,
                         EmployeeRepository employeeRepository, PersonAddressRepository personAddressRepository,
                         AdminRepository adminRepository, ElectricParkingAreaRepository electricParkingAreaRepository,
                         ParkingAreaRepository parkingAreaRepository, ParkingAreaAddressRepository parkingAreaAddressRepository,
                         CarLocationRepository carLocationRepository, CombustionCarRepository combustionCarRepository,
                         ElectricCarRepository electricCarRepository, RentalTimeSlotRepository rentalTimeSlotRepository,
                         ElectricRentalRepository electricRentalRepository, FuelRentalRepository fuelRentalRepository) {
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
        this.rentalTimeSlotRepository = rentalTimeSlotRepository;
        this.electricRentalRepository = electricRentalRepository;
        this.fuelRentalRepository = fuelRentalRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Started in Bootstrap");

        ///////Person Package///////

        //Payment Method

        PaymentMethod pm1 = new PaymentMethod();
        LocalDate validTrough = LocalDate.of(2021, 2,20);
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

        //Person Address (Customer)

        PersonAddress pa1 = new PersonAddress("99084", "Erfurt", "Hirschlachufer", "3");
        PersonAddress pa2 = new PersonAddress("07743", "Jena", "Bibliotheksweg", "11");
        PersonAddress pa3 = new PersonAddress("99423", "Weimar", "Eckenerstraße", "19");
        PersonAddress ea1 = new PersonAddress("07743", "Jena", "Am Planetarium", "38");
        PersonAddress ea2 = new PersonAddress("99423", "Weimar", "Goethestraße", "22");
        PersonAddress ea3 = new PersonAddress("69126", "Heidelberg", "Holbeinring", "17");

        try{
            personAddressRepository.save(pa1);
            personAddressRepository.save(pa2);
            personAddressRepository.save(pa3);
            personAddressRepository.save(ea1);
            personAddressRepository.save(ea2);
            personAddressRepository.save(ea3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Addresses added: " + personAddressRepository.count());

        //Customer

        LocalDate customer1DOB = LocalDate.of(1988, 2, 29);
        LocalDate customer2DOB = LocalDate.of(1992, 2, 29);
        LocalDate customer3DOB = LocalDate.of(1990, 12, 31);

        Customer customer1 = new Customer("Max", "Musterman", customer1DOB, "Max@gmail.com", "12345678", pa1, Customer.CustomerLevel.NEWUSER, pm1);
        Customer customer2 = new Customer("Maria", "Musterfrau", customer2DOB, "maria@gmail.com", "12345678", pa2, Customer.CustomerLevel.REGULARUSER, pm2);
        Customer customer3 = new Customer("Sher", "Lock", customer3DOB, "sher@gmail.com", "12345678", pa3, Customer.CustomerLevel.SUPERUSER, pm3);

        try{
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Customers added: " + customerRepository.count());


        //Employee

        LocalDate employee1DOB = LocalDate.of(1970, 3, 31);
        LocalDate employee2DOB = LocalDate.of(1965, 7, 17);
        LocalDate employee3DOB = LocalDate.of(1992, 12, 31);

        Employee employee1 = new Employee("John", "Doe", employee1DOB, "john@gmail.com", "12345678", ea1, 1600.00f, Employee.TypeOfActivity.CUSTOMERSUPPORT);
        Employee employee2 = new Employee("Pepito", "Perez", employee2DOB, "Pepito@gmail.com", "12345678", ea2, 1800.00f, Employee.TypeOfActivity.MAINTAINER);
        Employee employee3 = new Employee("Mike", "Bossman", employee3DOB, "mike@gmail.com", "12345678", ea3, 1800.00f, Employee.TypeOfActivity.BOSS);

        try{
            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Employees added: " + employeeRepository.count());

        //Admin

        LocalDate adminDOB = LocalDate.of(1986, 9, 30);
        PersonAddress adminAddress = new PersonAddress("99084", "Erfurt", "Stotternheimstrasse", "52");


        Admin admin = new Admin("Administrator","Admin", adminDOB, "admin@gmail.com", "12345678", adminAddress, 1999.00f, Employee.TypeOfActivity.CUSTOMERSUPPORT);

        try{
            personAddressRepository.save(admin.getPersonAddress());
            adminRepository.save(admin);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Admins added: " + adminRepository.count());



        ///////ParkingArea Package///////

        //Parking Area Address

        ParkingAreaAddress parkingAreaAddress1 = new ParkingAreaAddress();
        ParkingAreaAddress parkingAreaAddress2 = new ParkingAreaAddress("99084", "Erfurt", "Hirschlachufer", "3");
        ParkingAreaAddress parkingAreaAddress3 = new ParkingAreaAddress("99423", "Weimar", "Eckenerstraße", "19");
        ParkingAreaAddress parkingAreaAddress4 = new ParkingAreaAddress("99423", "Weimar", "Eckenerstraße", "20");
        ParkingAreaAddress parkingAreaAddress5 = new ParkingAreaAddress("99423", "Weimar", "Goethestraße 2", "20");
        ParkingAreaAddress parkingAreaAddress6 = new ParkingAreaAddress("99084", "Erfurt", "Hirschlachufer", "5");
        ParkingAreaAddress parkingAreaAddress7 = new ParkingAreaAddress("07745", "Jena", "West Bahnhof", "2");

        try{
            parkingAreaAddressRepository.save(parkingAreaAddress1);
            parkingAreaAddressRepository.save(parkingAreaAddress2);
            parkingAreaAddressRepository.save(parkingAreaAddress3);
            parkingAreaAddressRepository.save(parkingAreaAddress4);
            parkingAreaAddressRepository.save(parkingAreaAddress5);
            parkingAreaAddressRepository.save(parkingAreaAddress6);
            parkingAreaAddressRepository.save(parkingAreaAddress7);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Parking Area's Addresses added: " + parkingAreaAddressRepository.count());


        //Parking Area

        ParkingArea parkingArea1 = new ParkingArea(parkingAreaAddress1, 20, parkingAreaAddress1.getStreet() + " station");
        ParkingArea parkingArea2 = new ParkingArea(parkingAreaAddress2, 30, parkingAreaAddress2.getStreet() + " station");
        ParkingArea parkingArea3 = new ParkingArea(parkingAreaAddress5, 10, parkingAreaAddress5.getStreet() + " station");

        try{
            parkingAreaRepository.save(parkingArea1);
            parkingAreaRepository.save(parkingArea2);
            parkingAreaRepository.save(parkingArea3);
        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Parking Areas added: " + parkingAreaRepository.count() );

        //Electric Parking Area

        ElectricParkingArea electricParkingArea1 = new ElectricParkingArea(parkingAreaAddress3, 300, 50, parkingAreaAddress3.getStreet() + " station");
        ElectricParkingArea electricParkingArea2 = new ElectricParkingArea(parkingAreaAddress4, 10, 10, parkingAreaAddress4.getStreet() + " station");
        ElectricParkingArea electricParkingArea3 = new ElectricParkingArea(parkingAreaAddress6, 10, 10, parkingAreaAddress6.getStreet() + " station");
        ElectricParkingArea electricParkingArea4 = new ElectricParkingArea(parkingAreaAddress7, 10, 10, parkingAreaAddress7.getStreet() + " station");

        try{
            electricParkingAreaRepository.save(electricParkingArea1);
            electricParkingAreaRepository.save(electricParkingArea2);
            electricParkingAreaRepository.save(electricParkingArea3);
            electricParkingAreaRepository.save(electricParkingArea4);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Electric Parking Areas added: " + electricParkingAreaRepository.count() );

        ///////Car Package///////

        //Car Location

        CarLocation carLocation1 = new CarLocation(50.978075, 11.037416);
        CarLocation carLocation2 = new CarLocation(50.973211, 11.030760);
        CarLocation carLocation3 = new CarLocation(50.976163, 11.024549);
        CarLocation carLocation4 = new CarLocation(50.976163, 11.024549);
        CarLocation carLocation5 = new CarLocation(50.976163, 11.024549);
        CarLocation carLocation6 = new CarLocation(50.976163, 11.024549);


        try{
            carLocationRepository.save(carLocation1);
            carLocationRepository.save(carLocation2);
            carLocationRepository.save(carLocation3);
            carLocationRepository.save(carLocation4);
            carLocationRepository.save(carLocation5);
            carLocationRepository.save(carLocation6);

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
        CombustionCar combustionCar4 = new CombustionCar(Car.Type.MINI, "Volkswagen", "Up", Car.State.PERFECT,
                                                        carLocation4.getGPSLatitude(), carLocation4.getGPSLongitude(), 10000, Customer.CustomerLevel.NEWUSER,
                                                        19.99f, 30, 85, 8.9, CombustionCar.Transmission.AUTOMATIC, CombustionCar.FuelType.DIESEL, parkingArea3);
        CombustionCar combustionCar5 = new CombustionCar(Car.Type.MINI, "Volkswagen", "Up", Car.State.DAMAGED,
                                                        carLocation4.getGPSLatitude(), carLocation4.getGPSLongitude(), 100000, Customer.CustomerLevel.NEWUSER,
                                                        19.99f, 30, 85, 8.9, CombustionCar.Transmission.MANUAL, CombustionCar.FuelType.PETROL, parkingArea3);
        CombustionCar combustionCar6 = new CombustionCar(Car.Type.MIDDLE, "Opel", "Insignia", Car.State.PERFECT,
                                                50.978075, 11.037416, 67000, Customer.CustomerLevel.SUPERUSER,
                                                    49.99f, 40, 100, 3.46, CombustionCar.Transmission.AUTOMATIC,
                                                        CombustionCar.FuelType.PETROL, parkingArea1);
        try{
            carLocationRepository.save(combustionCar1.getCarLocation());
            combustionCarRepository.save(combustionCar1);
            carLocationRepository.save(combustionCar2.getCarLocation());
            combustionCarRepository.save(combustionCar2);
            carLocationRepository.save(combustionCar3.getCarLocation());
            combustionCarRepository.save(combustionCar3);
            carLocationRepository.save(combustionCar4.getCarLocation());
            combustionCarRepository.save(combustionCar4);
            carLocationRepository.save(combustionCar5.getCarLocation());
            combustionCarRepository.save(combustionCar5);
            carLocationRepository.save(combustionCar6.getCarLocation());
            combustionCarRepository.save(combustionCar6);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Fuel Cars added: " + combustionCarRepository.count() );

        //Electric Car

        ElectricCar electricCar1 = new ElectricCar(Car.Type.MINI, "BMW", "i3s", Car.State.PERFECT, 39000, 50.973211, 11.030760, Customer.CustomerLevel.REGULARUSER, 59.99f,
                                                    220, 100, electricParkingArea1);
        ElectricCar electricCar2 = new ElectricCar(electricParkingArea1);
        ElectricCar electricCar3 = new ElectricCar(Car.Type.SUV, "Tesla", "Model X", Car.State.PERFECT, 10, 50.973211, 11.030760, Customer.CustomerLevel.SUPERUSER, 99.99f,
                                220, 100, electricParkingArea2);
        ElectricCar electricCar4 = new ElectricCar(Car.Type.MINI, "BMW", "i3s", Car.State.PERFECT, 39000, 50.973211, 11.030760, Customer.CustomerLevel.REGULARUSER, 59.99f,
                                220, 100, electricParkingArea1);
        ElectricCar electricCar5 = new ElectricCar(Car.Type.SUV, "Tesla", "Model X", Car.State.PERFECT, 10, 50.973211, 11.030760, Customer.CustomerLevel.SUPERUSER, 99.99f,
                220, 100, electricParkingArea3);
        ElectricCar electricCar6 = new ElectricCar(Car.Type.SUV, "Tesla", "Model X", Car.State.PERFECT, 10, 50.973211, 11.030760, Customer.CustomerLevel.SUPERUSER, 99.99f,
                220, 100, electricParkingArea3);
        ElectricCar electricCar7 = new ElectricCar(Car.Type.MINI, "BMW", "i3s", Car.State.PERFECT, 39000, 50.973211, 11.030760, Customer.CustomerLevel.REGULARUSER, 59.99f,
                220, 100, electricParkingArea4);

        try{
            carLocationRepository.save(electricCar1.getCarLocation());
            electricCarRepository.save(electricCar1);
            carLocationRepository.save(electricCar2.getCarLocation());
            electricCarRepository.save(electricCar2);
            carLocationRepository.save(electricCar3.getCarLocation());
            electricCarRepository.save(electricCar3);
            carLocationRepository.save(electricCar4.getCarLocation());
            electricCarRepository.save(electricCar4);
            carLocationRepository.save(electricCar5.getCarLocation());
            electricCarRepository.save(electricCar5);
            carLocationRepository.save(electricCar6.getCarLocation());
            electricCarRepository.save(electricCar6);
            carLocationRepository.save(electricCar7.getCarLocation());
            electricCarRepository.save(electricCar7);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Electric Cars added: " + electricCarRepository.count() );


        ///////RentalPackage///////

        //Rental Time Slots

        LocalTime lt0 = LocalTime.of( 0,0 );
        LocalTime lt1 = LocalTime.of( 1, 0);
        LocalTime lt2 = LocalTime.of( 2,0 );
        LocalTime lt3 = LocalTime.of( 3, 0);
        LocalTime lt4 = LocalTime.of( 4,0 );
        LocalTime lt5 = LocalTime.of( 5, 0);
        LocalTime lt6 = LocalTime.of( 6,0 );
        LocalTime lt7 = LocalTime.of( 7, 0);
        LocalTime lt8 = LocalTime.of( 8,0 );
        LocalTime lt9 = LocalTime.of( 9, 0);
        LocalTime lt10 = LocalTime.of( 10,0 );
        LocalTime lt11 = LocalTime.of( 11, 0);
        LocalTime lt12 = LocalTime.of( 12,0 );
        LocalTime lt13 = LocalTime.of( 13, 0);
        LocalTime lt14 = LocalTime.of( 14,0 );
        LocalTime lt15 = LocalTime.of( 15, 0);
        LocalTime lt16 = LocalTime.of( 16,0 );
        LocalTime lt17 = LocalTime.of( 17, 0);
        LocalTime lt18 = LocalTime.of( 18,0 );
        LocalTime lt19 = LocalTime.of( 19, 0);
        LocalTime lt20 = LocalTime.of( 20,0 );
        LocalTime lt21 = LocalTime.of( 21, 0);
        LocalTime lt22 = LocalTime.of( 22,0 );
        LocalTime lt23 = LocalTime.of( 23, 0);

        RentalTimeSlot rts1 = new RentalTimeSlot(lt0, lt1);
        RentalTimeSlot rts2 = new RentalTimeSlot(lt1, lt2);
        RentalTimeSlot rts3 = new RentalTimeSlot(lt2, lt3);
        RentalTimeSlot rts4 = new RentalTimeSlot(lt3, lt4);
        RentalTimeSlot rts5 = new RentalTimeSlot(lt4, lt5);
        RentalTimeSlot rts6 = new RentalTimeSlot(lt5, lt6);
        RentalTimeSlot rts7 = new RentalTimeSlot(lt6, lt7);
        RentalTimeSlot rts8 = new RentalTimeSlot(lt7, lt8);
        RentalTimeSlot rts9 = new RentalTimeSlot(lt8, lt9);
        RentalTimeSlot rts10 = new RentalTimeSlot(lt9, lt10);
        RentalTimeSlot rts11 = new RentalTimeSlot(lt10, lt11);
        RentalTimeSlot rts12 = new RentalTimeSlot(lt11, lt12);
        RentalTimeSlot rts13 = new RentalTimeSlot(lt12, lt13);
        RentalTimeSlot rts14 = new RentalTimeSlot(lt13, lt14);
        RentalTimeSlot rts15 = new RentalTimeSlot(lt14, lt15);
        RentalTimeSlot rts16 = new RentalTimeSlot(lt15, lt16);
        RentalTimeSlot rts17 = new RentalTimeSlot(lt16, lt17);
        RentalTimeSlot rts18 = new RentalTimeSlot(lt17, lt18);
        RentalTimeSlot rts19 = new RentalTimeSlot(lt18, lt19);
        RentalTimeSlot rts20 = new RentalTimeSlot(lt19, lt20);
        RentalTimeSlot rts21 = new RentalTimeSlot(lt20, lt21);
        RentalTimeSlot rts22 = new RentalTimeSlot(lt21, lt22);
        RentalTimeSlot rts23 = new RentalTimeSlot(lt22, lt23);
        RentalTimeSlot rts24 = new RentalTimeSlot(lt23, lt0);

        rentalTimeSlotRepository.save(rts1);
        rentalTimeSlotRepository.save(rts2);
        rentalTimeSlotRepository.save(rts3);
        rentalTimeSlotRepository.save(rts4);
        rentalTimeSlotRepository.save(rts5);
        rentalTimeSlotRepository.save(rts6);
        rentalTimeSlotRepository.save(rts7);
        rentalTimeSlotRepository.save(rts8);
        rentalTimeSlotRepository.save(rts9);
        rentalTimeSlotRepository.save(rts10);
        rentalTimeSlotRepository.save(rts11);
        rentalTimeSlotRepository.save(rts12);
        rentalTimeSlotRepository.save(rts13);
        rentalTimeSlotRepository.save(rts14);
        rentalTimeSlotRepository.save(rts15);
        rentalTimeSlotRepository.save(rts16);
        rentalTimeSlotRepository.save(rts17);
        rentalTimeSlotRepository.save(rts18);
        rentalTimeSlotRepository.save(rts19);
        rentalTimeSlotRepository.save(rts20);
        rentalTimeSlotRepository.save(rts21);
        rentalTimeSlotRepository.save(rts22);
        rentalTimeSlotRepository.save(rts23);
        rentalTimeSlotRepository.save(rts24);

        log.info("Number of Rentals time slots added: " + rentalTimeSlotRepository.count() );

        //Fuel Rental

        LocalDate rentalTime1 = LocalDate.of(2020,8,10);
        LocalDate rentalTime2 = LocalDate.of(2020,8,11);

        List<RentalTimeSlot> fuelRental1TimeSlots = new ArrayList<>();
        fuelRental1TimeSlots.add(rts8);
        fuelRental1TimeSlots.add(rts9);
        fuelRental1TimeSlots.add(rts10);

        List<RentalTimeSlot> fuelRental2TimeSlots = new ArrayList<>();
        fuelRental2TimeSlots.add(rts13);
        fuelRental2TimeSlots.add(rts14);

        FuelRental fuelRental1 = new FuelRental(combustionCar1, rentalTime1, customer3, fuelRental1TimeSlots);
        FuelRental fuelRental2 = new FuelRental(combustionCar2, rentalTime2, customer1, fuelRental2TimeSlots);

        try{
            fuelRentalRepository.save(fuelRental1);
            fuelRentalRepository.save(fuelRental2);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Rentals added: " + fuelRentalRepository.count() );

        //Electric Rental

        LocalDate rentalTime3 = LocalDate.of(2020,8,10);
        LocalDate rentalTime4 = LocalDate.of(2020,8,8);

        List<RentalTimeSlot> electricRental1TimeSlots = new ArrayList<>();
        electricRental1TimeSlots.add(rts10);
        electricRental1TimeSlots.add(rts11);
        electricRental1TimeSlots.add(rts12);
        electricRental1TimeSlots.add(rts13);
        electricRental1TimeSlots.add(rts14);
        electricRental1TimeSlots.add(rts15);
        electricRental1TimeSlots.add(rts16);

        List<RentalTimeSlot> electricRental2TimeSlots = new ArrayList<>();
        electricRental2TimeSlots.add(rts19);

        ElectricRental electricRental1 = new ElectricRental(electricCar1, rentalTime3, customer1, electricRental1TimeSlots);
        ElectricRental electricRental2 = new ElectricRental(electricCar2, rentalTime4, customer2, electricRental2TimeSlots);

        try{
            electricRentalRepository.save(electricRental1);
            electricRentalRepository.save(electricRental2);

        }catch (Exception e){
            log.debug("Exception" + e);
        }

        log.info("Number of Electric Rentals added: " + electricRentalRepository.count() );


        ///////MixedPackage///////

        //Customer+Rentals//

        customer1.getElectricRentals().add(electricRental1);
        customer1.getFuelRentals().add(fuelRental1);

        customer2.getElectricRentals().add(electricRental2);

        customer3.getFuelRentals().add(fuelRental2);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        log.info("Relation between Rentals and Cars established");

        //ParkingArea+Cars//

        parkingArea1.carsInStation.add(combustionCar1);
        combustionCar1.setParkingArea(parkingArea1);

        parkingArea2.carsInStation.add(combustionCar2);
        combustionCar2.setParkingArea(parkingArea2);

        parkingArea1.carsInStation.add(combustionCar3);
        combustionCar3.setParkingArea(parkingArea1);

        parkingArea3.carsInStation.add(combustionCar4);
        combustionCar4.setParkingArea(parkingArea3);

        parkingArea3.carsInStation.add(combustionCar5);
        combustionCar5.setParkingArea(parkingArea3);

        parkingArea1.carsInStation.add(combustionCar6);
        combustionCar6.setParkingArea(parkingArea1);

        parkingAreaRepository.save(parkingArea1);
        parkingAreaRepository.save(parkingArea2);
        parkingAreaRepository.save(parkingArea3);
        combustionCarRepository.save(combustionCar1);
        combustionCarRepository.save(combustionCar2);
        combustionCarRepository.save(combustionCar3);
        combustionCarRepository.save(combustionCar4);
        combustionCarRepository.save(combustionCar5);
        combustionCarRepository.save(combustionCar6);


        electricParkingArea1.electricCarsInStation.add(electricCar1);
        electricCar1.setElectricParkingArea(electricParkingArea1);

        electricParkingArea1.electricCarsInStation.add(electricCar2);
        electricCar2.setElectricParkingArea(electricParkingArea1);

        electricParkingArea2.electricCarsInStation.add(electricCar3);
        electricCar3.setElectricParkingArea(electricParkingArea2);

        electricParkingArea1.electricCarsInStation.add(electricCar4);
        electricCar4.setElectricParkingArea(electricParkingArea1);

        electricParkingArea3.electricCarsInStation.add(electricCar5);
        electricCar5.setElectricParkingArea(electricParkingArea3);

        electricParkingArea4.electricCarsInStation.add(electricCar6);
        electricCar6.setElectricParkingArea(electricParkingArea4);

        electricParkingArea4.electricCarsInStation.add(electricCar7);
        electricCar7.setElectricParkingArea(electricParkingArea4);

        electricParkingAreaRepository.save(electricParkingArea1);
        electricParkingAreaRepository.save(electricParkingArea2);
        electricParkingAreaRepository.save(electricParkingArea3);
        electricParkingAreaRepository.save(electricParkingArea4);
        electricCarRepository.save(electricCar1);
        electricCarRepository.save(electricCar2);
        electricCarRepository.save(electricCar3);
        electricCarRepository.save(electricCar4);
        electricCarRepository.save(electricCar5);
        electricCarRepository.save(electricCar6);
        electricCarRepository.save(electricCar7);

        log.info("Relation between Parking Areas and Cars established");


        ////////////////////////////////////////////////////////

        log.info("Data Successfully added with BootStrap");
    }
}
