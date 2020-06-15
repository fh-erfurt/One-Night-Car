package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CombustionCar;
import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.person.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FuelRentalTest {

    @Test
    void testSetFuelLevelAfter(){
        Customer customer = new Customer();

        ParkingArea parkingArea = new ParkingArea();

        LocalDateTime date = LocalDateTime.now();
        LocalDateTime departure;
        departure = LocalDateTime.of(2020,01,31,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,02,04,00,00);


        CombustionCar CombustionCar = new CombustionCar(parkingArea);
        FuelRental rental2 = new FuelRental( CombustionCar, customer.getCustomerID(), date, departure, arrival);
        rental2.setOdometerAfter();
        rental2.setFuelLevelAfter(CombustionCar);
        assertEquals(-1, rental2.getFuelLevelAfter(), "The car had to be refueled already in order to drive this far.");
    }

}
