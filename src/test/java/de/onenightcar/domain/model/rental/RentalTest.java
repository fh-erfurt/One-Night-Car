package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.ElectricCar;
import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import de.onenightcar.domain.model.person.Customer;
import de.onenightcar.domain.model.person.PersonManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testElapsedDays(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);

        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, Area1);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        long days = rental1.calculateElapsedDays();

        assertEquals(7, days);
    }

    @Test
    void testSetOdometerAfter(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);

        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);

        ElectricCar electricCar = new ElectricCar(carManagementSystem, Area1);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        rental1.setOdometerAfter();
        long odometer = rental1.getOdometerAfter();
        assertEquals(16375, odometer);
    }


}