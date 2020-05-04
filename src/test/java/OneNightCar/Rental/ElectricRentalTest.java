package OneNightCar.Rental;

import OneNightCar.Car.CarManagementSystem;
import OneNightCar.Car.ElectricCar;
import OneNightCar.Person.Customer;
import OneNightCar.Person.PersonManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ElectricRentalTest {

    @Test
    void testSetChargePercentAfter (){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem);
        ElectricRental rental1 = new ElectricRental(electricCar, carManagementSystem, customer.getCustomerID(), LocalDate.of(2020, 1, 31), 2020, 1, 31, 2020 , 2, 4, rentalManager);

        rental1.setOdometerAfter();
        rental1.setChargePercentAfter(electricCar);
        assertEquals(-1, rental1.getChargePercentAfter(), "The car had to be refueled already in order to drive this far.");

    }

}
