package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.CombustionCar;
import de.onenightcar.domain.model.person.Customer;
import de.onenightcar.domain.model.person.PersonManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FuelRentalTest {

    @Test
    void testSetFuelLevelAfter(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        CombustionCar CombustionCar = new CombustionCar(carManagementSystem);
        FuelRental rental2 = new FuelRental(rentalManager, CombustionCar, carManagementSystem, customer.getCustomerID(), LocalDate.of(2020, 1, 31),
        2020, 1, 31, 2020, 2, 4);
        rental2.setOdometerAfter();
        rental2.setFuelLevelAfter(CombustionCar);
        assertEquals(-1, rental2.getFuelLevelAfter(), "The car had to be refueled already in order to drive this far.");
    }

}
