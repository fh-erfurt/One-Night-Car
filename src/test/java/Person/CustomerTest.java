package Person;

import Car.Car;
import Car.CarManagementSystem;
import Car.CombustionCar;
import Car.ElectricCar;
import Rental.ElectricRental;
import Rental.FuelRental;
import Rental.RentalManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

        ElectricCar car1 = new ElectricCar(carManagementSystem);
        ElectricCar car2 = new ElectricCar(carManagementSystem);
        ElectricCar car3 = new ElectricCar(carManagementSystem);

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
        CombustionCar combustionCar = new CombustionCar(carManagementSystem);

        max.customerDamagesAFuelCar(combustionCar);

        assertEquals(Car.State.DAMAGED, combustionCar.getCarState());
    }

    @Test
    void a_customer_is_able_to_rent_a_combustion_car () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        CombustionCar combustionCar = new CombustionCar(carManagementSystem);
        LocalDate date = LocalDate.now();

        max.rentAFuelCar(rentalManager, combustionCar, carManagementSystem, date,
                2020, 03, 15, 2020, 03, 18);

        assertEquals(1, max.getFuelRentals().size());
    }

    @Test
    void a_customer_is_able_to_modify_an_electric_rental () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        LocalDate date = LocalDate.now();
        GregorianCalendar departure = new GregorianCalendar(2020,03,15);
        GregorianCalendar arrival = new GregorianCalendar(2020,03,18);

        ElectricCar car1 = new ElectricCar(carManagementSystem);

        max.rentAnElectricCar(car1, carManagementSystem, date, 2020, 01,
                            1,  2020 ,01, 2, rentalManager);


        max.modifyAnElectricRental(max.getElectricRentalWithIndex(0), car1, carManagementSystem, date, 2020,
                03, 15, 2020, 03, 18, rentalManager);

        assertEquals(departure.get(Calendar.DAY_OF_YEAR), max.electricRentals.get(0).getDepartureTime().get(Calendar.DAY_OF_YEAR));
        assertEquals(arrival.get(Calendar.DAY_OF_YEAR), max.electricRentals.get(0).getArrivalTime().get(Calendar.DAY_OF_YEAR));
    }

    @Test
    void a_customer_is_able_to_cancel_a_fuel_rental () {
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        CombustionCar combustionCar = new CombustionCar(carManagementSystem);
        LocalDate date = LocalDate.now();
        max.rentAFuelCar(rentalManager, combustionCar, carManagementSystem, date,
                2020, 03, 15, 2020, 03, 18);


        max.cancelFuelRental(max.getFuelRentalWithIndex(0));

        assertEquals(0, max.fuelRentals.size());
    }
}
