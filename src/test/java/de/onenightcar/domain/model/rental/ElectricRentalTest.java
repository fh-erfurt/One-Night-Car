package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.ElectricCar;
import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import de.onenightcar.domain.model.person.Customer;
import de.onenightcar.domain.model.person.PersonManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ElectricRentalTest {

    @Test
    void testSetChargePercentAfter (){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);

        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);

        LocalDateTime date = LocalDateTime.now();
        LocalDateTime departure;
        departure = LocalDateTime.of(2020,01,31,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,02,04,00,00);

        ElectricCar electricCar = new ElectricCar(carManagementSystem, Area1);
        ElectricRental rental1 = new ElectricRental(electricCar, carManagementSystem, customer.getCustomerID(),date, departure, arrival, rentalManager);

        rental1.setOdometerAfter();
        rental1.setChargePercentAfter(electricCar);
        assertEquals(-1, rental1.getChargePercentAfter(), "The car had to be refueled already in order to drive this far.");

    }

}
