package de.onenightcar.domain.model.person;

import de.onenightcar.domain.model.car.Car;
import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.CombustionCar;
import de.onenightcar.domain.model.car.ElectricCar;
import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import de.onenightcar.domain.model.rental.ElectricRental;
import de.onenightcar.domain.model.rental.RentalManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void the_customer_level_may_be_changed() {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);

        max.setCustomerLevel(Customer.CustomerLevel.SUPERUSER);

        assertEquals(Customer.CustomerLevel.SUPERUSER, max.getCustomerLevel());
    }

    @Test
    void the_payment_method_may_be_changed() {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        GregorianCalendar testCalendar = new GregorianCalendar(2025,GregorianCalendar.FEBRUARY,20);
        PaymentMethod paymentMethod = new PaymentMethod("0000 1111 2222 3333", PaymentMethod.CardType.DEBIT, testCalendar, "123");

        max.setPaymentMethod(paymentMethod);

        assertEquals("0000 1111 2222 3333", max.getPaymentMethod().getCardNumber());
        assertEquals(PaymentMethod.CardType.DEBIT, max.getPaymentMethod().getCardType());
        assertEquals("123", max.getPaymentMethod().getCCV());
    }

    @Test
    void the_customer_should_be_helped(){
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        Employee peter = new Employee(list);

        assertEquals(true, max.customerNeedHelp(peter));
    }

    @Test
    void the_right_index_should_be_returned_with_the_given_car () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();


        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);

        ElectricCar car1 = new ElectricCar(carManagementSystem, Area1);
        ElectricCar car2 = new ElectricCar(carManagementSystem, Area1);
        ElectricCar car3 = new ElectricCar(carManagementSystem, Area1);

        ElectricRental testRental1 = new ElectricRental(rentalManager, carManagementSystem, max.getCustomerID(), car1);
        ElectricRental testRental2 = new ElectricRental(rentalManager, carManagementSystem, max.getCustomerID(), car2);
        ElectricRental testRental3 = new ElectricRental(rentalManager, carManagementSystem, max.getCustomerID(), car3);

        max.getElectricRentals().add(testRental1);
        max.getElectricRentals().add(testRental2);
        max.getElectricRentals().add(testRental3);

        assertEquals(0,max.getElectricCarIndexInElectricRentalList(car1));
        assertEquals(1,max.getElectricCarIndexInElectricRentalList(car2));
        assertEquals(2,max.getElectricCarIndexInElectricRentalList(car3));
    }

    @Test
    void a_customer_damages_a_car () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        CombustionCar combustionCar = new CombustionCar(carManagementSystem, parkingArea);

        max.customerDamagesAFuelCar(combustionCar);

        Assertions.assertEquals(Car.State.DAMAGED, combustionCar.getCarState());
    }

    @Test
    void a_customer_is_able_to_rent_a_combustion_car () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        CombustionCar combustionCar = new CombustionCar(carManagementSystem, parkingArea);
        LocalDateTime date = LocalDateTime.now();

        LocalDateTime departure;
        departure = LocalDateTime.of(2020,03,15,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,03,18,00,00);

        max.rentAFuelCar(rentalManager, combustionCar, carManagementSystem, date, departure, arrival);

        assertEquals(1, max.getFuelRentals().size());
    }

    @Test
    void a_customer_is_able_to_modify_an_electric_rental () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime departure;
        departure = LocalDateTime.of(2020,03,15,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,03,18,00,00);

        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);

        ElectricCar car1 = new ElectricCar(carManagementSystem, Area1);

        max.rentAnElectricCar(car1, carManagementSystem, date, departure, arrival, rentalManager);


        max.modifyAnElectricRental(max.getElectricRentalWithIndex(0), car1, carManagementSystem, date, LocalDateTime.of(2020, 3, 16, 00,00),
                LocalDateTime.of(2020, 3, 19, 00,00), rentalManager);

        assertEquals(16, max.electricRentals.get(0).getDepartureTime().getDayOfMonth());
        assertEquals(19, max.electricRentals.get(0).getArrivalTime().getDayOfMonth());
    }

    @Test
    void a_customer_is_able_to_cancel_a_fuel_rental () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        LocalDateTime departure;
        departure = LocalDateTime.of(2020,03,15,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,03,18,00,00);

        CombustionCar combustionCar = new CombustionCar(carManagementSystem, parkingArea);
        LocalDateTime date = LocalDateTime.now();
        max.rentAFuelCar(rentalManager, combustionCar, carManagementSystem, date, departure, arrival);


        max.cancelFuelRental(max.getFuelRentalWithIndex(0));

        assertEquals(0, max.fuelRentals.size());
    }
}
