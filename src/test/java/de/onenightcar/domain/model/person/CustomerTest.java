package de.onenightcar.domain.model.person;

import de.onenightcar.domain.model.car.Car;
import de.onenightcar.domain.model.car.CombustionCar;
import de.onenightcar.domain.model.car.ElectricCar;
import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.rental.ElectricRental;
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
        Customer max = new Customer();

        max.setCustomerLevel(Customer.CustomerLevel.SUPERUSER);

        assertEquals(Customer.CustomerLevel.SUPERUSER, max.getCustomerLevel());
    }

    @Test
    void the_payment_method_may_be_changed() {
        Customer max = new Customer();
        GregorianCalendar testCalendar = new GregorianCalendar(2025,GregorianCalendar.FEBRUARY,20);
        PaymentMethod paymentMethod = new PaymentMethod("0000 1111 2222 3333", PaymentMethod.CardType.DEBIT, testCalendar, "123");

        max.setPaymentMethod(paymentMethod);

        assertEquals("0000 1111 2222 3333", max.getPaymentMethod().getCardNumber());
        assertEquals(PaymentMethod.CardType.DEBIT, max.getPaymentMethod().getCardType());
        assertEquals("123", max.getPaymentMethod().getCCV());
    }

    @Test
    void the_customer_should_be_helped(){
        Customer max = new Customer();
        Employee peter = new Employee();

        assertEquals(true, max.customerNeedHelp(peter));
    }

    @Test
    void the_right_index_should_be_returned_with_the_given_car () {
        Customer max = new Customer();



        ElectricParkingArea Area1 = new ElectricParkingArea();

        ElectricCar car1 = new ElectricCar(Area1);
        ElectricCar car2 = new ElectricCar(Area1);
        ElectricCar car3 = new ElectricCar(Area1);

        ElectricRental testRental1 = new ElectricRental( max.getCustomerID(), car1);
        ElectricRental testRental2 = new ElectricRental( max.getCustomerID(), car2);
        ElectricRental testRental3 = new ElectricRental(max.getCustomerID(), car3);

        max.getElectricRentals().add(testRental1);
        max.getElectricRentals().add(testRental2);
        max.getElectricRentals().add(testRental3);

        assertEquals(0,max.getElectricCarIndexInElectricRentalList(car1));
        assertEquals(1,max.getElectricCarIndexInElectricRentalList(car2));
        assertEquals(2,max.getElectricCarIndexInElectricRentalList(car3));
    }

    @Test
    void a_customer_damages_a_car () {
        Customer max = new Customer();


        ParkingArea parkingArea = new ParkingArea();

        CombustionCar combustionCar = new CombustionCar(parkingArea);

        max.customerDamagesAFuelCar(combustionCar);

        Assertions.assertEquals(Car.State.DAMAGED, combustionCar.getCarState());
    }

    @Test
    void a_customer_is_able_to_rent_a_combustion_car () {
        Customer max = new Customer();


        ParkingArea parkingArea = new ParkingArea();

        CombustionCar combustionCar = new CombustionCar(parkingArea);
        LocalDateTime date = LocalDateTime.now();

        LocalDateTime departure;
        departure = LocalDateTime.of(2020,03,15,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,03,18,00,00);

        max.rentAFuelCar(combustionCar,  date, departure, arrival);

        assertEquals(1, max.getFuelRentals().size());
    }

    @Test
    void a_customer_is_able_to_modify_an_electric_rental () {
        Customer max = new Customer();

        LocalDateTime date = LocalDateTime.now();
        LocalDateTime departure;
        departure = LocalDateTime.of(2020,03,15,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,03,18,00,00);

        ElectricParkingArea Area1 = new ElectricParkingArea();

        ElectricCar car1 = new ElectricCar(Area1);

        max.rentAnElectricCar(car1, date, departure, arrival);


        max.modifyAnElectricRental(max.getElectricRentalWithIndex(0), car1, date, LocalDateTime.of(2020, 3, 16, 00,00),
                LocalDateTime.of(2020, 3, 19, 00,00));

        assertEquals(16, max.electricRentals.get(0).getDepartureTime().getDayOfMonth());
        assertEquals(19, max.electricRentals.get(0).getArrivalTime().getDayOfMonth());
    }

    @Test
    void a_customer_is_able_to_cancel_a_fuel_rental () {
        Customer max = new Customer();

        ParkingArea parkingArea = new ParkingArea();

        LocalDateTime departure;
        departure = LocalDateTime.of(2020,03,15,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,03,18,00,00);

        CombustionCar combustionCar = new CombustionCar(parkingArea);
        LocalDateTime date = LocalDateTime.now();
        max.rentAFuelCar(combustionCar, date, departure, arrival);


        max.cancelFuelRental(max.getFuelRentalWithIndex(0));

        assertEquals(0, max.fuelRentals.size());
    }
}
