package Rental;

import Car.CarManagementSystem;
import Car.ElectricCar;
import Person.Customer;
import Person.PersonManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testElapsedDays(){
        RentalManager Rentals = new RentalManager();
        CarManagementSystem CarManagementSystem = new CarManagementSystem();
        ElectricCar ElectricCar = new ElectricCar(CarManagementSystem);
        PersonManager PersonManager = new PersonManager();
        Customer customer = new Customer(PersonManager);
        ElectricRental TeslaS = new ElectricRental(Rentals, CarManagementSystem, customer, ElectricCar, PersonManager);

        int elapsedDays = TeslaS.calculateElapsedDays();
        assertEquals(7, elapsedDays);
    }

    @Test


}