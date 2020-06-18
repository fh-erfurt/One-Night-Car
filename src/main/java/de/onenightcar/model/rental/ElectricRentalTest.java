package de.onenightcar.model.rental;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.parkingArea.ElectricParkingArea;
import de.onenightcar.model.person.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ElectricRentalTest {

    @Test
    void testSetChargePercentAfter (){

        Customer customer = new Customer();

        ElectricParkingArea Area1 = new ElectricParkingArea();

        LocalDateTime date = LocalDateTime.now();
        LocalDateTime departure;
        departure = LocalDateTime.of(2020,01,31,00,00);
        LocalDateTime arrival;
        arrival= LocalDateTime.of(2020,02,04,00,00);

        ElectricCar electricCar = new ElectricCar(Area1);
        ElectricRental rental1 = new ElectricRental(electricCar, date, departure, arrival);

        rental1.setOdometerAfter();
        rental1.setChargePercentAfter(electricCar);
        assertEquals(-1, rental1.getChargePercentAfter(), "The car had to be refueled already in order to drive this far.");

    }

}
