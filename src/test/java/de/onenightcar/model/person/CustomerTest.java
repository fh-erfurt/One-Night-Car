package de.onenightcar.model.person;

import de.onenightcar.model.car.Car;
import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.parkingArea.ElectricParkingArea;
import de.onenightcar.model.parkingArea.ParkingArea;
import de.onenightcar.model.rental.ElectricRental;
import de.onenightcar.model.rental.RentalTimeSlot;
import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    private List<RentalTimeSlot> rentalTimeSlotList;

    @BeforeEach
    public void init() {
        LocalDate date = LocalDate.of(2020, 07, 11);

        RentalTimeSlot rentalTimeSlot1 = new RentalTimeSlot(LocalTime.of(8,0), LocalTime.of(9,0));
        RentalTimeSlot rentalTimeSlot2 = new RentalTimeSlot(LocalTime.of(9,0), LocalTime.of(10,0));

        this.rentalTimeSlotList = new ArrayList<>();

        rentalTimeSlotList.add(rentalTimeSlot1);
        rentalTimeSlotList.add(rentalTimeSlot2);
    }

    @Test
    void the_customer_level_may_be_changed() {
        Customer max = new Customer();

        max.setCustomerLevel(Customer.CustomerLevel.SUPERUSER);

        assertEquals(Customer.CustomerLevel.SUPERUSER, max.getCustomerLevel());
    }

    @Test
    void the_payment_method_may_be_changed() {
        Customer max = new Customer();
        LocalDate testCalendar = LocalDate.of(2025,2,20);
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

        ElectricParkingArea area1 = new ElectricParkingArea();

        LocalDate ld = LocalDate.of(2020,07,12);

        ElectricCar car1 = new ElectricCar(area1);
        ElectricCar car2 = new ElectricCar(area1);
        ElectricCar car3 = new ElectricCar(area1);


        max.rentAnElectricCar(car1, ld, rentalTimeSlotList);
        max.rentAnElectricCar(car2, ld, rentalTimeSlotList);
        max.rentAnElectricCar(car3, ld, rentalTimeSlotList);

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

        LocalDate date = LocalDate.of(2020,07,12);

        max.rentAFuelCar(combustionCar, date, rentalTimeSlotList);

        assertEquals(1, max.getFuelRentals().size());
    }

    @Test
    void a_customer_is_able_to_modify_an_electric_rental () {
        Customer max = new Customer();

        LocalDate date = LocalDate.now();

        ElectricParkingArea Area1 = new ElectricParkingArea();

        ElectricCar car1 = new ElectricCar(Area1);

        max.rentAnElectricCar(car1, date, rentalTimeSlotList);

        max.modifyAnElectricRental(max.getElectricRentalWithIndex(0), car1, date, rentalTimeSlotList);

        LocalTime lt = LocalTime.of(8,0);
        LocalDate ld = LocalDate.of(2020, 8, 3);

        assertEquals(lt, max.electricRentals.get(0).getTimeSlotsList().get(0).getDepartureTime());
        assertEquals(ld, max.electricRentals.get(0).getRentalDate());
    }

    @Test
    void a_customer_is_able_to_cancel_a_fuel_rental () {
        Customer max = new Customer();

        ParkingArea parkingArea = new ParkingArea();

        CombustionCar combustionCar = new CombustionCar(parkingArea);
        LocalDate date = LocalDate.now();
        max.rentAFuelCar(combustionCar, date, rentalTimeSlotList);

        max.cancelFuelRental(max.getFuelRentalWithIndex(0));

        assertEquals(0, max.fuelRentals.size());
    }
}
