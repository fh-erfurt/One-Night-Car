package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.CombustionCar;
import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import de.onenightcar.domain.model.person.Customer;
import de.onenightcar.domain.model.person.PersonManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FuelRentalTest {

    @Test
    void testSetFuelLevelAfter(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        LocalDateTime date = LocalDateTime.now();
        LocalDateTime departure;
        departure = LocalDateTime.of(2020,01,31,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,02,04,00,00);


        CombustionCar CombustionCar = new CombustionCar(carManagementSystem, parkingArea);
        FuelRental rental2 = new FuelRental(rentalManager, CombustionCar, carManagementSystem, customer.getCustomerID(), date, departure, arrival);
        rental2.setOdometerAfter();
        rental2.setFuelLevelAfter(CombustionCar);
        assertEquals(-1, rental2.getFuelLevelAfter(), "The car had to be refueled already in order to drive this far.");
    }

}
