package de.onenightcar.model.rental;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.parkingArea.ElectricParkingArea;
import de.onenightcar.model.person.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testElapsedDays(){
        Customer customer = new Customer();

        ElectricParkingArea Area1 = new ElectricParkingArea();
        ElectricCar electricCar = new ElectricCar(Area1);
        ElectricRental rental1 = new ElectricRental(electricCar);

        long days = rental1.calculateElapsedDays();

        assertEquals(7, days);
    }

    @Test
    void testSetOdometerAfter(){
        Customer customer = new Customer();

        ElectricParkingArea Area1 = new ElectricParkingArea();

        ElectricCar electricCar = new ElectricCar(Area1);
        ElectricRental rental1 = new ElectricRental(electricCar);

        rental1.setOdometerAfter();
        long odometer = rental1.getOdometerAfter();
        assertEquals(16375, odometer);
    }


}